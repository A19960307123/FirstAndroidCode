package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.fragment.AFragment;
import com.example.myapplication.fragment.BFragment;

public class FragementActivity extends AppCompatActivity {
    BFragment bFragment;
    AFragment aFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragement);
        aFragment = AFragment.newInstance("old text");
        getSupportFragmentManager().beginTransaction().add(R.id.fragment, aFragment).commitNowAllowingStateLoss();
    }
}