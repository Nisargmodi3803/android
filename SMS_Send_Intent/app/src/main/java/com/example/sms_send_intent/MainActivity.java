package com.example.sms_send_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText msgEdit,numberEdit;
    private Button send;
    private String number,msg;
    private Intent smsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msgEdit = (EditText) findViewById(R.id.msgEdit);
        numberEdit = (EditText) findViewById(R.id.numberEdit);
        send = (Button) findViewById(R.id.sentBtn);

        number = numberEdit.getText().toString();
        msg = msgEdit.getText().toString();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smsIntent = new Intent(Intent.ACTION_SENDTO);
                smsIntent.setData(Uri.parse("smsto:" + Uri.encode(number)));
//                smsIntent.putExtra("address",number);
                smsIntent.putExtra("sms_body",msg);
                startActivity(Intent.createChooser(smsIntent,"Send sms via : "));
            }
        });
    }
}