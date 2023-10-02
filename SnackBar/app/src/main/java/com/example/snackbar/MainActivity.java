package com.example.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button withoutActionBtn,withActionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        withActionBtn = (Button) findViewById(R.id.withActionBtn);
        withoutActionBtn = (Button) findViewById(R.id.withoutActionBtn);

        withoutActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Clicked",Snackbar.LENGTH_SHORT).show();
            }
        });

        withActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Internet connection is not available",Snackbar.LENGTH_LONG).setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view,"Connected to Internet",Snackbar.LENGTH_LONG).setDuration(3000).show();
                    }
                }).show();
            }
        });
    }
}