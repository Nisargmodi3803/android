package com.example.email_send;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText toEdit,subjectEdit,msgEdit;
    private Button sendBtn;
    private String to,subject,msg;
    private Intent email_Intent;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toEdit = findViewById(R.id.toEditText);
        subjectEdit = findViewById(R.id.subjectEditText);
        msgEdit = findViewById(R.id.msgEditText);
        sendBtn = findViewById(R.id.sendBtn);

        to = toEdit.getText().toString();
        subject = subjectEdit.getText().toString();
        msg = msgEdit.getText().toString();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email_Intent = new Intent(Intent.ACTION_SEND);
                email_Intent.putExtra(Intent.EXTRA_EMAIL,to);
                email_Intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                email_Intent.putExtra(Intent.EXTRA_TEXT,msg);
                email_Intent.setType("message/rfc822");
                startActivity(Intent.createChooser(email_Intent,"Choose Mail Via"));
            }
        });
    }
}