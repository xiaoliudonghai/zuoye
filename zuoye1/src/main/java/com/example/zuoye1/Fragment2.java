package com.example.zuoye1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {


    private View view;
    private WebView mWeb;
    private String rul;

//    public void setRul(String rul) {
//        this.rul = rul;
//        mWeb.setWebViewClient(new WebViewClient());
//        mWeb.loadUrl(rul);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_fragment2, container, false);
        initView(inflate);
        EventBus.getDefault().register(this);
        return inflate;
    }

    private void initView(View inflate) {
        mWeb = (WebView) inflate.findViewById(R.id.web);
    }
    @Subscribe(threadMode = ThreadMode.MAIN )
    public void shou(String url){
        mWeb.setWebViewClient(new WebViewClient());
       mWeb.loadUrl(url);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
