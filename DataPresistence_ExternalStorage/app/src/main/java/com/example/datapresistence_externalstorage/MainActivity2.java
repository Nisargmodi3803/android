package com.example.datapresistence_externalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    TextView welcome;
    Button logout;
    Intent logoutpage;
    File f;
    FileInputStream fstream;
    String folder="files";
    String filename = "nisarg.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        welcome = findViewById(R.id.welcome);
        logout = findViewById(R.id.logoutButton);

        try {
            f = new File(getExternalFilesDir(folder),filename);
            fstream = new FileInputStream(f);

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
        catch (IOException e)
        {
            e.printStackTrace();
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutpage = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(logoutpage);
            }
        });
    }
}