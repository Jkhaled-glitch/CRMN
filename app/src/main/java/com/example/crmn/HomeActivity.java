package com.example.crmn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;


    TextView tsui;
    TextView txx;

    EditText ednom,edetablissement,ednumero,edemail ;
    RadioGroup grad;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        dbHelper = new DatabaseHelper(this);

        txx = findViewById(R.id.textexit);
        tsui = findViewById(R.id.textsuit);


        ednom = findViewById(R.id.editnometprenom);
        edetablissement = findViewById(R.id.editetablissment);
        ednumero = findViewById(R.id.editnumero);
        edemail = findViewById(R.id.editadress);
        grad = findViewById(R.id.radioid);


        txx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, loginActivity.class));

            }
        });


        tsui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int selectedId = grad.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Please select a grade", Toast.LENGTH_LONG).show();
                    return;
                }
                String nom = ednom.getText().toString();
                String grade = ((RadioButton) findViewById(selectedId)).getText().toString();
                String etab = edetablissement.getText().toString();
                String num = ednumero.getText().toString();
                String email = edemail.getText().toString();

                if (nom.length() == 0 || etab.length() == 0 || num.length() == 0 || email.length() == 0 || selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "please fill All details", Toast.LENGTH_LONG).show();
                } else {
                    //insertDataIntoDatabase(nom, grade, etab, num, email);
                    Intent intent = new Intent(HomeActivity.this, home2Activity.class);
                    intent.putExtra("nom",nom);
                    intent.putExtra("grade",grade);
                    intent.putExtra("etab",etab);
                    intent.putExtra("num",num);
                    intent.putExtra("email",email);
                    startActivity(intent);
                }

            }

        });
    }


        private void insertDataIntoDatabase(String nom, String grade, String etab, String num, String email) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(DatabaseHelper.COL_NOM, nom);
            values.put(DatabaseHelper.COL_GRADE, grade);
            values.put(DatabaseHelper.COL_ETABLISSEMENT, etab);
            values.put(DatabaseHelper.COL_MAIL, email);
            values.put(DatabaseHelper.COL_NUMTEL, num);

            long insertedId = db.insert(DatabaseHelper.TABLE_UTILISATEURS, null, values);
            db.close();

            if (insertedId != -1) {
                Toast.makeText(getApplicationContext(), "Data inserted successfully", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Failed to insert data", Toast.LENGTH_LONG).show();
            }
        }




    }
    /*
    // la methode ajouter utilisateur
    public boolean AjouterUtilisateur(String nom , String grade ,String établissement , String mail )
    {
        SQLiteDatabase data =db.getWritableDatabase ();
        ContentValues valeur = new ContentValues();
        valeur.put("nom",nom);
        valeur.put("grade",grade);
        valeur.put("établissement",établissement);
        valeur.put("mail",mail);
        valeur.put("numtel",numtel);
        long insertedid =data.insert(utilisateur,null,valeur);
        data.close();
        return  insertedid!=0;
    }

    //la methode pour récupérer les utilisateures
    public ArrayList<String> getall(){
        SQLiteDatabase dat =db.getReadableDatabase();
        ArrayList<String> utilisateur = new ArrayList<String>();
        Cursor cur =data.query(utilisateur,null,null,null,null,null,null);
        cur.moveToFirst();
        while (!cur.isAfterLast()){
            utilisateur.add(cur.getString(0)+":"+cur.getString(1)+":"+cur.getString(2)+":"+cur.getString(3)+":"+cur.getString(4)+":");
            cur.moveToNext();


        }
        cur.close();
        data.close();
        return  utilisateur;

    }


    //methode afficher
    private void afficher(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(Affiche.this, android.R.layout.simple_list_item_1,getall());
        listeView.setAdapter(arrayAdapter);
    }




*/

