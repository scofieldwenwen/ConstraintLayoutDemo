package com.scofieldwenwen.constraintlayoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvTab1 = (TextView) findViewById(R.id.tab1);
        TextView tvTab2 = (TextView) findViewById(R.id.tab2);
        TextView tvTab3 = (TextView) findViewById(R.id.tab3);

        tvTab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ButtonActivity.class));
            }
        });

        tvTab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TabActivity.class));
            }
        });

        tvTab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GuidelineActivity.class));
            }
        });
    }
}
