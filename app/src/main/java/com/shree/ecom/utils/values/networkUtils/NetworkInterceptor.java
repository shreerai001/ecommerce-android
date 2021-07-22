package com.shree.ecom.utils.values.networkUtils;

import android.content.Context;

import com.shree.ecom.utils.values.NetworkUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkInterceptor implements Interceptor {
    private Context context;
    private NetworkEvent networkEvent;

    public NetworkInterceptor(Context context) {
        this.context = context;
        this.networkEvent = NetworkEvent.getInstance();
    }


    @Override
    public Response intercept(Chain chain) {
        Request request = chain.request();
        if (!NetworkUtils.isNetworkConnected(context)) {
            networkEvent.publish(NetworkState.NO_INTERNET);

        } else {
            try {
                Response response = chain.proceed(request);
                switch (response.code()) {
                    case 401:
                        networkEvent.publish(NetworkState.UNAUTHORISED);
                        break;
                    case 503:
                        networkEvent.publish(NetworkState.NO_RESPONSE);
                        break;
                }
                return response;

            } catch (IOException e) {
                networkEvent.publish(NetworkState.NO_RESPONSE);
            }
        }
        return null;
    }
}
