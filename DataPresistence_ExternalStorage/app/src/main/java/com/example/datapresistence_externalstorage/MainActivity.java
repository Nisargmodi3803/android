package com.example.datapresistence_externalstorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.*;
import android.content.*;
import android.view.View;
import android.widget.*;
import java.io.*;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button login;
    Intent logintopage;
    File f;
    FileOutputStream fstream;
    private String folder="files";
    private String filename="nisarg.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.userEdit);
        password = findViewById(R.id.passEdit);
        login = findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString()+"\n";
                String pass = password.getText().toString();

                try
                {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[] {android.Manifest.permission.READ_EXTERNAL_STORAGE},23);

                    if(!isExternalStorageAvailable() || isExternalStorageReadOnly())
                    {
                        Toast.makeText(MainActivity.this,"ExternalStorage not available",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"External Storage available",Toast.LENGTH_LONG).show();
                        f = new File(getExternalFilesDir(folder),filename);
                    }

                    fstream = new FileOutputStream(f);
                    fstream.write(user.getBytes());
                    fstream.write(pass.getBytes());
                    fstream.close();

                    logintopage = new Intent(MainActivity.this,MainActivity2.class);
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

    public static boolean isExternalStorageAvailable()
    {
        String ext = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(ext))
        {
            return true;
        }
        return false;
    }

    public static boolean isExternalStorageReadOnly()
    {
        String ext = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(ext))
        {
            return true;
        }
        return false;
    }


}