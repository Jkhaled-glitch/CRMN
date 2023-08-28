package com.example.crmn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class lab1Activity extends AppCompatActivity {
    TextView tx;
    Button beng;
    CheckBox op1,op2;
    RadioGroup radioGroup1;
    DataBaseMethods dbMethods;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);

        beng = findViewById(R.id.buttonenreg);
        tx = findViewById(R.id.textexitee);
        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        radioGroup1 = findViewById(R.id.radioGroup1);

        dbMethods = new DataBaseMethods(getApplicationContext());
        //get data from intent
        Intent intent = getIntent();
        String nom = intent.getStringExtra("nom");
        String grade = intent.getStringExtra("grade");
        String etab = intent.getStringExtra("etab");
        String num = intent.getStringExtra("num");
        String email = intent.getStringExtra("email");
        String date = intent.getStringExtra("date");
        String time1 = intent.getStringExtra("time1");
        String time2 = intent.getStringExtra("time2");
        String responsable = intent.getStringExtra("responsable");





        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                if(dbMethods.insertDataIntoDatabase(nom,grade, etab, num,email,time1,time2,responsable)){
                   // startActivity(new Intent(lab1Activity.this,home2Activity.class));
                }

                 */

            }
        });


        beng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (areOptionsSelected() && isRadioButtonSelected()){
                    //save data to db

                    long insertedId = dbMethods.insertDataIntoDatabase(nom,grade, etab, num,email,time1,time2,responsable);

                    if (insertedId != -1) {
                        startActivity(new Intent(lab1Activity.this,TerminalActivity.class));
                    }


            } else{
                Toast.makeText(getApplicationContext(), "Veuillez sélectionner tout les champs", Toast.LENGTH_LONG).show();

            }



        }

    });
    }

    private boolean areOptionsSelected() {
        return op1.isChecked() || op2.isChecked() ;
    }

    private boolean isRadioButtonSelected() {
        return radioGroup1.getCheckedRadioButtonId() != -1;
    }
}
