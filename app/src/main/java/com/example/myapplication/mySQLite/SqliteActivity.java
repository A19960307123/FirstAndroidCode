package com.example.myapplication.mySQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

import org.litepal.LitePal;

public class SqliteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        Button createdatabase = findViewById(R.id.btn_create_database);
        createdatabase.setOnClickListener(v -> {
            LitePal.getDatabase();
            Toast.makeText(this, "create database", Toast.LENGTH_SHORT).show();
        });
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, SqliteActivity.class);
        context.startActivity(starter);
    }
}