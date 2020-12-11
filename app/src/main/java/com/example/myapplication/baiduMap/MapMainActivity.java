package com.example.myapplication.baiduMap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;

public class MapMainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_main);
        mContext = MapMainActivity.this;
        findViewById(R.id.btn_mainToLocation).setOnClickListener(v -> {
            LocationActivity.start(mContext);
        });
    }
    public static void start(Context context) {
        Intent starter = new Intent(context, MapMainActivity.class);
        context.startActivity(starter);
    }
}