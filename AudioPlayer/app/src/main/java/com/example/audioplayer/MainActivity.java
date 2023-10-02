package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = (Button) findViewById(R.id.playBtn);
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this,R.raw.damian_priest);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying())
                {
                    pauseMusic();
                }
                else
                {
                    playmusic();
                }
            }
        });
    }

    public void playmusic()
    {
        if(mediaPlayer!=null)
        {
            mediaPlayer.start();
            playBtn.setText("PAUSE");
        }
    }

    public void pauseMusic()
    {
        if(mediaPlayer!=null)
        {
            mediaPlayer.pause();
            playBtn.setText("PLAY");
        }
    }
}