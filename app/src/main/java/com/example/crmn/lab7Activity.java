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

public class lab7Activity extends AppCompatActivity {



    TextView tx,txplus;

    CheckBox opp1,opp2,opp3,opp4,opp8,opp5,opp6,opp7;
    RadioGroup radioGroup1;
    int lab7CheckedCount = 0;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7);






        tx = findViewById(R.id.textexitee);
        txplus = findViewById(R.id.texteplus);

        opp1 = findViewById(R.id.op1);
        opp2 = findViewById(R.id.op2);
        opp3=findViewById(R.id.option2);
        opp4=findViewById(R.id.option3);
        opp5=findViewById(R.id.option4);
        opp6=findViewById(R.id.option5);
        opp7=findViewById(R.id.option6);
        opp8=findViewById(R.id.option7);



        radioGroup1 = findViewById(R.id.radioGroup1);




        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(lab7Activity.this,home2Activity.class));

            }
        });


        txplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnyCheckBoxChecked = isAnyCheckBoxCheckedInLab7();
                if (isRadioButtonSelected() || isAnyCheckBoxChecked) {
                    Intent intent = new Intent(lab7Activity.this, lab72Activity.class);
                    intent.putExtra("fromLab7", true);
                    intent.putExtra("lab7CheckedCount", lab7CheckedCount); // Ajoutez cette ligne
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Veuillez sélectionner au moins une case à cocher", Toast.LENGTH_LONG).show();
                }
            }

        });


    }




    public boolean isNoCheckBoxCheckedInLab7() {
        return !isAnyCheckBoxCheckedInLab7();
    }

    public boolean isAnyCheckBoxCheckedInLab7() {
        lab7CheckedCount = 0;
        if (opp1.isChecked()) lab7CheckedCount++;
        if (opp2.isChecked()) lab7CheckedCount++;
        if (opp3.isChecked()) lab7CheckedCount++;
        if (opp4.isChecked()) lab7CheckedCount++;
        if (opp5.isChecked()) lab7CheckedCount++;
        if (opp6.isChecked()) lab7CheckedCount++;
        if (opp7.isChecked()) lab7CheckedCount++;
        if (opp8.isChecked()) lab7CheckedCount++;


        return lab7CheckedCount > 0;
    }

    private boolean isRadioButtonSelected() {
        return radioGroup1.getCheckedRadioButtonId() != -1;
    }

}