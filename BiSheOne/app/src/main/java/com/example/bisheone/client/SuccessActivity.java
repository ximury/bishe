package com.example.bisheone.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.bisheone.R;

/**
 * 无用
 */
public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_success);

        WebView success = findViewById(R.id.success);

        success.getSettings().setJavaScriptEnabled(true);
        success.getSettings().setAppCacheEnabled(true);
        success.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        success.getSettings().setDomStorageEnabled(true);

        success.loadUrl("http://www.yanblog.info/");

        success.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }
}
