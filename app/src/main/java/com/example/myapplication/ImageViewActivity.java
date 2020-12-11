package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        imageView = findViewById(R.id.iv_2);
        Glide.with(this).load("https://pics2.baidu.com/feed/a5c27d1ed21b0ef4f0f4fe68f8cc20dd81cb3ef3.jpeg?token=3e929c6acb32869672743d3e5f2694f8")
                .into(imageView);
    }
}