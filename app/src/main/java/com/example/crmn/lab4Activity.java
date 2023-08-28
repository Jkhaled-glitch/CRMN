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

public class lab4Activity extends AppCompatActivity {

    Button beng;
    TextView tx;

    CheckBox op1,op2,op11,op12;
    RadioGroup radioGroup1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);


        beng = findViewById(R.id.buttonenreg);
        tx = findViewById(R.id.textexitee);

        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        op11 = findViewById(R.id.option1);
        op12 = findViewById(R.id.option2);
        radioGroup1 = findViewById(R.id.radioGroup1);






        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(lab4Activity.this,home2Activity.class));

            }
        });


        beng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (areOptionsSelected() && isRadioButtonSelected()) {
                    startActivity(new Intent(lab4Activity.this, TerminalActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Veuillez sélectionner tout les champs", Toast.LENGTH_LONG).show();


                }
            }
        });
    }
        private boolean areOptionsSelected() {
            return op1.isChecked() || op2.isChecked() || op11.isChecked() || op12.isChecked() ;
        }

        private boolean isRadioButtonSelected() {
            return radioGroup1.getCheckedRadioButtonId() != -1;
        }

    }