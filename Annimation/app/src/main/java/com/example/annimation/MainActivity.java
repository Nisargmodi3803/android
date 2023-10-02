package com.example.annimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private Button alpha,scale,translate,rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        alpha = findViewById(R.id.alphaBtn);
        scale = findViewById(R.id.scaleBtn);
        translate = findViewById(R.id.translateBtn);
        rotate = findViewById(R.id.RotateBtn);

        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
                tv.startAnimation(ani);
            }
        });

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                tv.startAnimation(ani);
            }
        });

        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate);
                tv.startAnimation(ani);
            }
        });

        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
                tv.startAnimation(ani);
            }
        });
    }
}