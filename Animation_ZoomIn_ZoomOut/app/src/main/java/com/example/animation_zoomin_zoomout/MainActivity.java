package com.example.animation_zoomin_zoomout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgView;
    private Button zoomInBtn,zoomOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView = (ImageView) findViewById(R.id.imgView);
        zoomInBtn = (Button) findViewById(R.id.zoomInBtn);
        zoomOutBtn = (Button) findViewById(R.id.zoomOutBtn);

        zoomInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation imgAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
                imgView.startAnimation(imgAnim);
            }
        });

        zoomOutBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Animation imgAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
                imgView.startAnimation(imgAnim);
            }
        });

    }
}