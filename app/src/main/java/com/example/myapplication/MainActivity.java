package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.baiduMap.LocationActivity;
import com.example.myapplication.baiduMap.MapMainActivity;
import com.example.myapplication.myIO.IoMainActivity;
import com.example.myapplication.mybroadcast.BroadCastActivity;
import com.example.myapplication.service.SeviceTestActivity;
import com.example.myapplication.web.WebMainActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnRecyclerView;
    private Button mBtnFragment;
    private Button mBtnBroadcast;
    private Button mBtnIO;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnImageView = findViewById(R.id.btn_imageView);
        mBtnListView = findViewById(R.id.btn_ListView);
        mBtnGridView = findViewById(R.id.btn_GridView);
        mBtnRecyclerView = findViewById(R.id.btn_RecyclerView);
        mBtnFragment = findViewById(R.id.btn_Fragment);
        mBtnBroadcast = findViewById(R.id.btn_Broadcast);
        mBtnIO =findViewById(R.id.btn_IO);
        setListeners();
        findViewById(R.id.btn_Web).setOnClickListener(v -> {
            WebMainActivity.start(MainActivity.this);
        });
        findViewById(R.id.btn_Thread).setOnClickListener(v -> {
            SeviceTestActivity.start(MainActivity.this);
        });
        findViewById(R.id.btn_toMap).setOnClickListener(v -> {
            MapMainActivity.start(MainActivity.this);
        });
    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnRecyclerView.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
        mBtnBroadcast.setOnClickListener(onClick);
        mBtnIO.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_imageView:
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_textview:
                    intent = new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_ListView:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_GridView:
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_RecyclerView:
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_Fragment:
                    intent = new Intent(MainActivity.this, FragementActivity.class);
                    break;
                case R.id.btn_Broadcast:
                    intent = new Intent(MainActivity.this, BroadCastActivity.class);
                    break;
                case R.id.btn_IO:
                    intent = new Intent(MainActivity.this, IoMainActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}