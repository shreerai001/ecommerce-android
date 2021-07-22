package com.shree.ecom.utils.values.networkUtils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

public class NetworkEvent {
    private static volatile NetworkEvent networkEvent;

    private NetworkEvent() {
        if (networkEvent != null) {
            throw new RuntimeException("Cannot access private constructor");
        }
    }

    public static NetworkEvent getInstance() {
        if (networkEvent == null) {
            synchronized (NetworkEvent.class) {
                if (networkEvent == null) networkEvent = new NetworkEvent();
            }
        }
        return networkEvent;
    }

    private PublishSubject<NetworkState> subject;

    private Map<Object, CompositeDisposable> compositeDisposableMap = new HashMap<>();


    @NonNull
    private PublishSubject<NetworkState> getSubject() {
        if (subject == null) {
            subject = PublishSubject.create();
            subject.subscribeOn(AndroidSchedulers.mainThread());
        }
        return subject;
    }


    @NonNull
    private CompositeDisposable getCompositeSubscription(@NonNull Object object) {
        CompositeDisposable compositeSubscription = compositeDisposableMap.get(object);
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeDisposable();
            compositeDisposableMap.put(object, compositeSubscription);
        }
        return compositeSubscription;
    }


    public void publish(@NonNull final NetworkState networkState) {
        new Handler(Looper.getMainLooper())
                .post(new Runnable() {
                    @Override
                    public void run() {
                        NetworkEvent.this.getSubject().onNext(networkState);
                    }
                });
    }


    public void register(@NonNull Object lifecycle, @NonNull Consumer<NetworkState> action) {
        Disposable disposable = getSubject().subscribe(action);
        getCompositeSubscription(lifecycle).add(disposable);
    }


    public void unregister(Object lifecycle) {
        CompositeDisposable compositeSubscription = compositeDisposableMap.remove(lifecycle);
        if (compositeSubscription != null) {
            compositeSubscription.dispose();
        }
    }
}
