package com.example.sharedperferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView welcome;
    Button logout;
    Intent logoutpage;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        welcome = findViewById(R.id.welcome);
        logout = findViewById(R.id.logoutButton);

        logoutpage = new Intent(MainActivity2.this,MainActivity.class);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);

        welcome.setText("Welcome "+pref.getString("username",null));
        logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();
                startActivity(logoutpage);
            }

        });

    }
}