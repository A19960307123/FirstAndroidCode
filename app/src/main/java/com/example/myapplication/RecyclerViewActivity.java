package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.RecyclerView.HorActivity;
import com.example.myapplication.RecyclerView.LinearRecyclerActivity;

public class RecyclerViewActivity extends AppCompatActivity {
    private Button mBnLinearRecyclerView,mBtnHor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mBnLinearRecyclerView = findViewById(R.id.btn_linear);
        mBtnHor = findViewById(R.id.btn_hor);
        setListeners();
    }
    private void setListeners(){
        OnClick onClick = new OnClick();
        mBnLinearRecyclerView.setOnClickListener(onClick);
        mBtnHor.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_linear:
                    intent = new Intent(RecyclerViewActivity.this, LinearRecyclerActivity.class);
                    break;
                case R.id.btn_hor:
                    intent = new Intent(RecyclerViewActivity.this, HorActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}