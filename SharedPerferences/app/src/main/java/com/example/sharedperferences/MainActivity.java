package com.example.sharedperferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button login;
    Intent logintopage;
    SharedPreferences pref;
    String user,pass;

    @Override
    protected void onCreate(Bundle Saved)
    {
        super.onCreate(Saved);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.useredit);
        password = findViewById(R.id.passedit);
        login = (Button) findViewById(R.id.loginButton);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        logintopage = new Intent(MainActivity.this,MainActivity2.class);

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                user = username.getText().toString();
                pass = password.getText().toString();

                if(user.equals("Nisarg") && pass.equals("Modi"))
                {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username",user);
                    editor.putString("password",pass);
                    editor.apply();

                    if(pref.contains("username") && pref.contains("password"))
                    {
                        Toast.makeText(MainActivity.this,"Sucessfull",Toast.LENGTH_SHORT).show();
                        startActivity(logintopage);
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Try again",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}