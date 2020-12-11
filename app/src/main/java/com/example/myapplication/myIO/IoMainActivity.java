package com.example.myapplication.myIO;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.NotificationActivity;
import com.example.myapplication.R;
import com.example.myapplication.myContentResolver.ContentResolverActivity;
import com.example.myapplication.mySQLite.SqliteActivity;

public class IoMainActivity extends AppCompatActivity {
    private Button mBtnFileIO;
    private Button mBtnSqlite;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=IoMainActivity.this;
        setContentView(R.layout.activity_io_main);
        mBtnFileIO=findViewById(R.id.btn_FileIO);
        mBtnFileIO.setOnClickListener(v -> {
            FileioActivity.actionStart(IoMainActivity.this);
        });
        mBtnSqlite=findViewById(R.id.btn_SQLite);
        mBtnSqlite.setOnClickListener(v -> {
            SqliteActivity.start(mContext);
        });
        Button mBtmContentResolver = findViewById(R.id.btn_contentResolver);
        mBtmContentResolver.setOnClickListener(v -> {
            ContentResolverActivity.start(mContext);
        });

        findViewById(R.id.btn_notify).setOnClickListener(v -> {
            NotificationActivity.start(mContext);
        });
        findViewById(R.id.btn_camera).setOnClickListener(v -> {
            CameraActivity.start(mContext);
        });

        findViewById(R.id.btn_music).setOnClickListener(v -> {
            MusicActivity.start(mContext);
        });
    }

    public static void actionStart(Context context){
        Intent intent = new Intent(context,IoMainActivity.class);
        context.startActivity(intent);
    }
}