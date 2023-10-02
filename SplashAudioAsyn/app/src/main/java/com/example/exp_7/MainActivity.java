package com.example.exp_7;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.img);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        },10000);

    }
}