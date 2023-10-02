package com.example.datapresistence_internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.*;
import java.io.*;

import android.view.View;
import android.widget.*;
import android.content.*;


public class MainActivity2 extends AppCompatActivity {
    TextView welcome;
    Button logout;
    Intent logoutpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        welcome = findViewById(R.id.welcome);
        logout = findViewById(R.id.logoutButton);
        logoutpage = new Intent(MainActivity2.this,MainActivity.class);

        try {
            FileInputStream fstream = openFileInput("user_details");
            StringBuffer buffer = new StringBuffer();
            int i;
            while((i=fstream.read())!=-1)
            {
                buffer.append((char)i);
            }
            fstream.close();

            String []details = buffer.toString().split("\n");

            welcome.setText("Welcome "+details[0]);

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(logoutpage);
            }
        });

    }
}