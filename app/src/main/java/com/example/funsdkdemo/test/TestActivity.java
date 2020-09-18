package com.example.funsdkdemo.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.example.funsdkdemo.R;

/**
 * @author hws
 * @class 测试
 * @time 2019-08-19 17:02
 */
public class TestActivity extends AppCompatActivity {
    private ViewGroup surface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        surface = findViewById(R.id.fl_surface);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
    }

    public void onTest(View view) {

    }

}
