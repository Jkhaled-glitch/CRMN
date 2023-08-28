package com.example.crmn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import java.util.Calendar;

public class home2Activity extends AppCompatActivity {
    TextView t1 ,tvalider;
    RadioGroup plat;
    DatabaseHelper dbHelper;



    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private TextView date ,heur_entre,heur_sortie ,responsable ;

    RadioButton rlab1,rlab2,rlab3,rlab4,rlab5,rlab6,rlab7;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);


        dbHelper = new DatabaseHelper(this);

        t1 = findViewById(R.id.textexit);

        tvalider = findViewById(R.id.textvalid);
        plat = findViewById(R.id.idradio);


        rlab1 = findViewById(R.id.radioButtoncao);
        rlab2 = findViewById(R.id.radioButtonunano);
        rlab3 = findViewById(R.id.radioButtonnanoscop);
        rlab4 = findViewById(R.id.radioButtonfablab);
        rlab5 = findViewById(R.id.radioButtonnanomat);
        rlab6 = findViewById(R.id.radioButtonnanofab);
        rlab7 = findViewById(R.id.radioButtontestdc);


        date =findViewById(R.id.editTextDate3);
        heur_entre=findViewById(R.id.editTextDate);
        heur_sortie =findViewById(R.id.editTextDate2);
        responsable =findViewById(R.id.editTextTextPersonName);





        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home2Activity.this,HomeActivity.class));

            }
        });



        tvalider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = plat.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Please select a platforme", Toast.LENGTH_LONG).show();
                    return;
                }

                // Récupération des données de l'intent
                Intent intent = getIntent();
                String nom = intent.getStringExtra("nom");
                String grade = intent.getStringExtra("grade");
                String etab = intent.getStringExtra("etab");
                String num = intent.getStringExtra("num");
                String email = intent.getStringExtra("email");

                String dateValue = date.getText().toString();
                String time1Value = heur_entre.getText().toString();
                String time2Value = heur_sortie.getText().toString();
                String responsableValue = responsable.getText().toString();

                if (selectedId == -1 || dateValue.isEmpty() || time1Value.isEmpty() || time2Value.isEmpty() || responsableValue.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs", Toast.LENGTH_LONG).show();
                } else {
                    Intent nextIntent = null;
                    if (rlab1.isChecked()) {
                        nextIntent = new Intent(home2Activity.this, lab1Activity.class);

                    } else if (rlab2.isChecked()) {
                        nextIntent = new Intent(home2Activity.this, lab2Activity.class);
                    } else if (rlab3.isChecked()) {
                        nextIntent = new Intent(home2Activity.this, lab3Activity.class);

                    } else if (rlab4.isChecked()) {
                        nextIntent = new Intent(home2Activity.this, lab4Activity.class);

                    } else if (rlab5.isChecked()) {
                        nextIntent = new Intent(home2Activity.this, lab5Activity.class);

                    } else if (rlab6.isChecked()) {
                        nextIntent = new Intent(home2Activity.this, lab6Activity.class);

                    } else if (rlab7.isChecked()) {
                        nextIntent = new Intent(home2Activity.this, lab7Activity.class);

                    }

                    if (nextIntent != null) {
                        // Add the extra data to the intent
                        nextIntent.putExtra("nom", nom);
                        nextIntent.putExtra("grade", grade);
                        nextIntent.putExtra("etab", etab);
                        nextIntent.putExtra("num", num);
                        nextIntent.putExtra("email", email);
                        nextIntent.putExtra("date", dateValue);
                        nextIntent.putExtra("time1", time1Value);
                        nextIntent.putExtra("time2", time2Value);
                        nextIntent.putExtra("responsable", responsableValue);

                        startActivity(nextIntent);
                    }
                }
            }
        });






        //for the datepicker
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });




       heur_entre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });




        heur_sortie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });



    }
    private void insertDataIntoDatabase(String date, String time1, String time2, String responsable, String plat) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_DATE, date);
        values.put(DatabaseHelper.COL_ENTRE, time1);
        values.put(DatabaseHelper.COL_SORTIE, time2);
        values.put(DatabaseHelper.COL_PLATFORME, plat);
        values.put(DatabaseHelper.COL_RESPONSABLE, responsable);

        long insertedId = db.insert(DatabaseHelper.TABLE_UTILISATEURS, null, values);
        db.close();

        if (insertedId != -1) {
            Toast.makeText(getApplicationContext(), "Data inserted successfully", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Failed to insert data", Toast.LENGTH_LONG).show();
        }
    }







}