package com.example.exp_7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.PrecomputedText;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
    private Button playBtn,runBtn;
    private EditText sec;
    private TextView text;
    private MediaPlayer player;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        playBtn = (Button) findViewById(R.id.playBtn);
        runBtn = (Button) findViewById(R.id.runBtn);
        sec = (EditText) findViewById(R.id.editText);
        text = (TextView) findViewById(R.id.text);
        player = MediaPlayer.create(MainActivity2.this,R.raw.damianpriest);

        runBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAsyncTaskRunner runner = new MyAsyncTaskRunner();
                String sleeptime = sec.getText().toString();
                runner.execute(sleeptime);
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player.isPlaying())
                    pauseMusic();
                else
                    playMusic();
            }
        });
    }

    public void playMusic()
    {
        if(player!=null)
        {
            player.start();
            playBtn.setText("Pause Music");
        }
    }

    public void pauseMusic()
    {
        if(player!=null)
        {
            player.pause();
            playBtn.setText("Play Music");
        }
    }

    public class MyAsyncTaskRunner extends AsyncTask<String,String,String>
    {
        private String response;
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(MainActivity2.this,"Progress Dialog","Wait for "+sec.getText().toString()+" seconds");
        }

        @Override
        protected void onProgressUpdate(String... s) {
            text.setText(s[0]);
        }

        @Override
        protected String doInBackground(String... strings) {
            publishProgress("Sleeping...");
            try {
                int time = Integer.parseInt(strings[0]);
                for (int i = 0; i < time; i++)
                {
                    Thread.sleep(1000);
                    response = "Slept for "+(i+1)+" of "+time+" seconds";
                    publishProgress(response);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            text.setText(s);
        }
    }
}