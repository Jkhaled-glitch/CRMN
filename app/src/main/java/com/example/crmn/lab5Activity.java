package com.example.crmn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class lab5Activity extends AppCompatActivity {



    Button beng;
    TextView tx;
    CheckBox op1,op2,op3,op4,op5,op6,op7,op8,op9,op10,op11,op12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);


        beng = findViewById(R.id.buttonenreg);
        tx = findViewById(R.id.textexitee);
        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        op3 = findViewById(R.id.option3);
        op4 = findViewById(R.id.option4);
        op5 = findViewById(R.id.option5);
        op6 = findViewById(R.id.option6);
        op7 = findViewById(R.id.option7);
        op8 = findViewById(R.id.option8);
        op9 = findViewById(R.id.option9);
        op10 = findViewById(R.id.option10);
        op11= findViewById(R.id.option11);
        op12= findViewById(R.id.option12);




        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(lab5Activity.this,home2Activity.class));

            }
        });


        beng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (areOptionsSelected() ){
                    startActivity(new Intent(lab5Activity.this, TerminalActivity.class));
                } else{
                    Toast.makeText(getApplicationContext(), "Veuillez sélectionner tout les champs", Toast.LENGTH_LONG).show();

                }

            }

        });
    }

    private boolean areOptionsSelected() {
        return op1.isChecked() || op2.isChecked() ||op3.isChecked() ||op4.isChecked() ||op5.isChecked() ||op6.isChecked() ||op7.isChecked() ||op8.isChecked() ||op9.isChecked() ||op10.isChecked() ||op11.isChecked() ||op12.isChecked() ;
    }


}
