package com.example.android_project_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_project_v3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configure();

        login();
    }

    private void configure() {
        // loginButton = findViewById(R.id.button_login);
        loginButton = binding.buttonLogin;
    }

    public void login() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(MainActivity.this, LessonListActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}