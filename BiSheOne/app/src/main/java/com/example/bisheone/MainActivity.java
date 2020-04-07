package com.example.bisheone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * 无用
 */
import com.example.bisheone.tabview.MainTabViewActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnMainTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnMainTab=findViewById(R.id.mainTab);

        OnClick onClick=new OnClick();
        mBtnMainTab.setOnClickListener(onClick);
    }
    class OnClick implements View.OnClickListener{
        Intent intent=null;
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.mainTab:
                    intent=new Intent(MainActivity.this, MainTabViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
