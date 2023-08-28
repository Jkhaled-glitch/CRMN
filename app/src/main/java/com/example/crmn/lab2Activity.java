package com.example.crmn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class lab2Activity extends AppCompatActivity {
Button beng;

    TextView tx;

    CheckBox op1,op2,op3,op4,op5,op6,op7,op8,op9,op10;
    RadioGroup radioGroup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);


        beng = findViewById(R.id.buttonenreg);
        tx = findViewById(R.id.textexitee);
        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        op3 = findViewById(R.id.op3);
        op4 = findViewById(R.id.op4);
        op5 = findViewById(R.id.op5);
        op6 = findViewById(R.id.op6);
        op7 = findViewById(R.id.op7);
        op8 = findViewById(R.id.op8);
        op9 = findViewById(R.id.op9);
        op10 = findViewById(R.id.op10);
        radioGroup1 = findViewById(R.id.radioGroup1);




        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(lab2Activity.this,home2Activity.class));

            }
        });


        beng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (areOptionsSelected() && isRadioButtonSelected()) {
                    startActivity(new Intent(lab2Activity.this, TerminalActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Veuillez sélectionner tout les champs", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
        private boolean areOptionsSelected() {
            return op1.isChecked() || op2.isChecked() || op3.isChecked()|| op4.isChecked()||op5.isChecked()|| op6.isChecked()|| op7.isChecked()|| op8.isChecked()|| op9.isChecked()|| op10.isChecked() ;
        }

        private boolean isRadioButtonSelected() {
            return radioGroup1.getCheckedRadioButtonId() != -1;
        }
    }
