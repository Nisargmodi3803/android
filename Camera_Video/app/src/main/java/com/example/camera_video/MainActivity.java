package com.example.camera_video;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private Button takeVideoBtn;
    private VideoView videoView;
    private static final int video_capture_code=2;
    private Intent iPhoto,iVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        takeVideoBtn = (Button) findViewById(R.id.take_video_btn);
        videoView = (VideoView) findViewById(R.id.video_view);

        takeVideoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iVideo = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(iVideo,video_capture_code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==video_capture_code)
        {
            if (resultCode==RESULT_OK)
            {
                Uri videoUri = data.getData();
                videoView.setVideoURI(videoUri);
                MediaStore.Video.Media.getContentUri("demo");
            }
            else
            {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}