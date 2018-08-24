package com.six.monthtext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PullActivity extends AppCompatActivity {
    TextView textview;
    ImageView imageView;
    //获取用户信息
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);
       textview= findViewById(R.id.textView);
       imageView=findViewById(R.id.imageView);
        textview.setText("");

    }
}
