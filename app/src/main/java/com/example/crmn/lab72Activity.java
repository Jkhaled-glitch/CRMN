package com.example.crmn;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class lab72Activity extends AppCompatActivity {
    Button beng;
    TextView tx;
    CheckBox  ck8, ck9, ck10, ck11, ck12,ck13,ck14,ck15;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab72);


        beng = findViewById(R.id.buttonenreg);

        tx = findViewById(R.id.textexitee);

        ck8 = findViewById(R.id.option8);
        ck9 = findViewById(R.id.option9);
        ck10 = findViewById(R.id.option10);
        ck11 = findViewById(R.id.option11);
        ck12 = findViewById(R.id.option12);
        ck13 = findViewById(R.id.option13);
        ck14 = findViewById(R.id.option14);
        ck15 = findViewById(R.id.option15);


        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(lab72Activity.this, lab7Activity.class));

            }
        });

        int lab7CheckedCount = getIntent().getIntExtra("lab7CheckedCount", 0); // Récupération de la valeur

        beng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( (lab7CheckedCount > 0 || isAnyCheckBoxCheckedInLab72())||(lab7CheckedCount < 0 &&isAnyCheckBoxCheckedInLab72()) ){
                    startActivity(new Intent(lab72Activity.this, TerminalActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Veuillez sélectionner au moins une case à cocher", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    private boolean isAnyCheckBoxCheckedInLab72() {
        return ck8.isChecked() || ck9.isChecked() || ck10.isChecked() || ck11.isChecked() ||
                ck12.isChecked() || ck13.isChecked() || ck14.isChecked() || ck15.isChecked();
    }



}