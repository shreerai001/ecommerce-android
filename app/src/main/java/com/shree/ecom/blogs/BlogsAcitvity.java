package com.shree.ecom.blogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.shree.ecom.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BlogsAcitvity extends AppCompatActivity {

    @BindView(R.id.blogs)
    WebView blogsWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_buy_sell_launcher);

        ButterKnife.bind(this);
        blogsWebView.loadUrl("http://shreerai.com/blog");
        blogsWebView.getSettings().setJavaScriptEnabled(true);
    }
}

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_buy_sell_launcher, container, false);
//        ButterKnife.bind(this, view);
//        blogsWebView.loadUrl("http://shreerai.com/blog");
//        blogsWebView.getSettings().setJavaScriptEnabled(true);
//        return view;
//    }
//}
