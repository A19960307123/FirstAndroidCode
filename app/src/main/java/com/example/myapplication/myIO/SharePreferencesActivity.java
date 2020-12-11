package com.example.myapplication.myIO;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class SharePreferencesActivity extends AppCompatActivity {

    private EditText username,password;
    private Button login;
    private CheckBox rememberPass;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferences);
        context = SharePreferencesActivity.this;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        username=findViewById(R.id.io_username_text);
        password=findViewById(R.id.io_password_text);
        rememberPass = findViewById(R.id.io_remember);
        login=findViewById(R.id.io_login);
        boolean isRememberPass = preferences.getBoolean("remember_password", false);
        if (isRememberPass){
            String account = preferences.getString("account", "");
            String pswd = preferences.getString("pswd", "");
            username.setText(account);
            password.setText(pswd);
            rememberPass.setChecked(true);
            login.setOnClickListener(v -> {
                String  thisAccount = username.getText().toString();
                String  thisPswd = password.getText().toString();
                if (thisAccount.equals("admin") && thisPswd.equals("123456")){
                    editor = preferences.edit();
                    if (rememberPass.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",thisAccount);
                        editor.putString("pswd",thisPswd);
                    }else {
                        editor.clear();
                    }
                    editor.apply();
                    IoMainActivity.actionStart(this);
                }else {
                    Toast.makeText(context, "account or password is invalid", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}