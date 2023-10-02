package com.example.datapresistence_internalstorage;

import androidx.appcompat.app.AppCompatActivity;
import  java.io.*;
import android.os.*;
import android.view.View;
import android.widget.*;
import android.content.*;


public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button login;
    Intent logintopage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.userEdit);
        password = findViewById(R.id.passEdit);
        logintopage = new Intent(MainActivity.this,MainActivity2.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString()+"\n";
                String pass = password.getText().toString();


                Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_SHORT).show();
                try {
                    FileOutputStream fstream = openFileOutput("user_details",Context.MODE_PRIVATE);
                    fstream.write(user.getBytes());
                    fstream.write(pass.getBytes());
                    fstream.close();
                    Toast.makeText(getApplicationContext(),"Details successfully saved in internal storage",Toast.LENGTH_SHORT).show();
                    startActivity(logintopage);
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }

            }
        });
    }
}