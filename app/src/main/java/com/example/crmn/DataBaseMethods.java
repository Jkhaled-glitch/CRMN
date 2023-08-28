package com.example.crmn;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class DataBaseMethods {
    Context context;
    DatabaseHelper dbHelper ;

    public DataBaseMethods(Context context) {
        this.context = context;
        this.dbHelper = new DatabaseHelper(context);
    }


    public long insertDataIntoDatabase(String nom, String grade, String etab, String num, String email, String time1, String time2, String responsable) {

        //Toast.make
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_NOM, nom);
        values.put(DatabaseHelper.COL_GRADE, grade);
        values.put(DatabaseHelper.COL_ETABLISSEMENT, etab);
        values.put(DatabaseHelper.COL_MAIL, email);
        values.put(DatabaseHelper.COL_NUMTEL, num);

        values.put(DatabaseHelper.COL_ENTRE, time1);
        values.put(DatabaseHelper.COL_SORTIE, time2);
        values.put(DatabaseHelper.COL_RESPONSABLE, responsable);

        long insertedId = db.insert(DatabaseHelper.TABLE_UTILISATEURS, null, values);
        db.close();

        if (insertedId != -1) {
            Toast.makeText(context, "Data inserted successfully", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Failed to insert data", Toast.LENGTH_LONG).show();

        }
        return insertedId;

    }

}
