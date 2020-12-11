package com.example.myapplication.web;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;

public class WebMainActivity extends AppCompatActivity {
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_main);
        mContext=WebMainActivity.this;
        findViewById(R.id.btn_webview).setOnClickListener(v -> {
            WebViewActivity.start(mContext);
        });
        findViewById(R.id.btn_httpURL).setOnClickListener(v -> {
            HttpUrlConnectionActivity.start(mContext);
        });
    }
    public static void start(Context context) {
        Intent starter = new Intent(context, WebMainActivity.class);
        context.startActivity(starter);
    }
}