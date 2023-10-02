package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox pizza,burger,dosa;
    private Button show;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizza = findViewById(R.id.pizzaCheckBox);
        burger = findViewById(R.id.burgerCheckBox);
        dosa = findViewById(R.id.dosaCheckBox);
        show = findViewById(R.id.showButton);
        tv = findViewById(R.id.showTextView);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder result = new StringBuilder();
                result.append("You Selected\n");
                if(pizza.isChecked())
                {
                    result.append("Pizza\n");
                }
                if(burger.isChecked())
                {
                    result.append("Burger\n");
                }
                if(dosa.isChecked())
                {
                    result.append("Dosa\n");
                }

                tv.setText(result.toString());
            }
        });

        pizza.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "Pizza CheckedBox Checked", Toast.LENGTH_SHORT).show();
            }
        });
        burger.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "Burger CheckedBox Checked", Toast.LENGTH_SHORT).show();
            }
        });
        dosa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "Dosa CheckedBox Checked", Toast.LENGTH_SHORT).show();
            }
        });

    }
}