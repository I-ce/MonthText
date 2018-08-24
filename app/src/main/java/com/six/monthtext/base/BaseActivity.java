package com.six.monthtext.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.six.monthtext.MainActivity;
import com.six.monthtext.R;
import com.six.monthtext.util.Utils;

import java.lang.reflect.Method;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        //if(Utils.hasNotchInScreen(this)){
        initView();
        initData();
        initLinsten();
       // }else{
         //   Toast.makeText(this,"不是流海屏",Toast.LENGTH_SHORT).show();
       // }
    }
    protected abstract void initLinsten();
    protected abstract void initData();
    protected abstract void initView();
}
