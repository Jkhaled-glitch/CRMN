package com.example.crmn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class lab6Activity extends AppCompatActivity {
    Button beng;
    TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6);

        beng = findViewById(R.id.buttonenreg);

        tx = findViewById(R.id.textexitee);




        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(lab6Activity.this,home2Activity.class));

            }
        });


        beng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(lab6Activity.this,TerminalActivity.class));

            }
        });
    }
}