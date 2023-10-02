package com.example.togglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2;
    ToggleButton Bluetooth,Wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bluetooth = findViewById(R.id.BluetoothToggle);
        Wifi = findViewById(R.id.WifiToggle);
        tv1 = findViewById(R.id.TextView1);
        tv2 = findViewById(R.id.TextView2);

        Bluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(Bluetooth.isChecked())
                    tv1.setText("Bluetooth is checked");
                else
                    tv1.setText("Bluetooth is unchecked");
            }
        });

        Wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(Bluetooth.isChecked())
                    tv2.setText("Wifi is checked");
                else
                    tv2.setText("Wifi is unchecked");
            }
        });
    }
}