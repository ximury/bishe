package com.example.bisheone;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.bisheone.client.LoginActivity;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(StartActivity.this, LoginActivity.class));
                finish();
            }
        };
        timer.schedule(timerTask,2000);
    }
}
