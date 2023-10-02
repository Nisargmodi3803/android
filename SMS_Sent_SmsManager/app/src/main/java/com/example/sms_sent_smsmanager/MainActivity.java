package com.example.sms_sent_smsmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText msgEdit,numberEdit;
    private Button send;
    private SmsManager sms;
    private String number,msg;
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
                sms = SmsManager.getDefault();
                sms.sendTextMessage(number,null,msg,null,null);
                Toast.makeText(MainActivity.this,"SMS Sent",Toast.LENGTH_SHORT).show();
            }
        });
    }
}