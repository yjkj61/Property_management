package com.yjkj.property_management.java.ui;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.yjkj.property_management.databinding.ActivityWebViewBinding;
import com.yjkj.property_management.java.utils.AndroidBug5497Workaround;
import com.yjkj.property_management.tools.baseFile.BaseActivity;

public class WebView extends BaseActivity<ActivityWebViewBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.onCreate(savedInstanceState);
        AndroidBug5497Workaround.assistActivity(this);
    }


    @Override
    public void initView() {
        super.initView();

        viewBinding.back.setOnClickListener(v -> finish());

        viewBinding.webView.setWebChromeClient(new WebChromeClient());
        viewBinding.webView.setWebViewClient(new WebViewClient());
        viewBinding.webView.loadUrl(getIntent().getStringExtra("msg"));
        WebSettings webSettings = viewBinding.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);


        webSettings.setDisplayZoomControls(false);

        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

    }
}