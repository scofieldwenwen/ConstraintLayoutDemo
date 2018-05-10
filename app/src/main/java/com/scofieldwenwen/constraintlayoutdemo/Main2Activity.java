package com.scofieldwenwen.constraintlayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.scofieldwenwen.constraintlayoutdemo.systembar.SystemBarTintManager;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SystemBarTintManager.initWindow(this);
    }
}
