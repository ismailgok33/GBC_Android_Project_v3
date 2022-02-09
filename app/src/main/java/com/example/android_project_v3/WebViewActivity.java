package com.example.android_project_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.android_project_v3.databinding.ActivityMainBinding;
import com.example.android_project_v3.databinding.ActivityWebViewBinding;

public class WebViewActivity extends AppCompatActivity {

    private ActivityWebViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        if(intent != null) {
            // TODO : get this extra name from string resource
            binding.webView.loadUrl(intent.getStringExtra("url"));
        }
    }
}