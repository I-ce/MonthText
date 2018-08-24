package com.six.monthtext;

import android.content.Intent;
import android.webkit.WebView;

import com.six.monthtext.base.BaseActivity;

public class BannerActivity extends BaseActivity {


    private WebView web;

    @Override
    protected void initLinsten() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        web.loadUrl(url);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_banner);
        web = findViewById(R.id.web);
    }
}
