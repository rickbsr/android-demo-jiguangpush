package com.codingbydumbbell.jiguangpushdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codingbydumbbell.jiguangpushdemo.jpush.JPushSettingHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            new JPushSettingHelper(this).initJPush();
    }
}
