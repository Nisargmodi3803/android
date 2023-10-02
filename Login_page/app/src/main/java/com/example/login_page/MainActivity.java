package com.example.login_page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private EditText user_name,pass_word;
    private String u_name,p_word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login_button);
        user_name = findViewById(R.id.username);
        pass_word = findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {
                u_name = user_name.getText().toString();
                p_word = pass_word.getText().toString();

                if(u_name.equals("Admin") && p_word.equals("Admin"))
                {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}