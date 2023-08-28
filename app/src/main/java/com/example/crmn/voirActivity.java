package com.example.crmn;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import java.util.ArrayList;
import java.util.Arrays;
import android.widget.TextView;
import android.view.Gravity;



public class voirActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    Button exit;
    TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voir);

        exit=findViewById(R.id.btnExit);

        dbHelper = new DatabaseHelper(this);
        tableLayout = findViewById(R.id.tableLayout);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(voirActivity.this,loginActivity.class));

            }
        });


        ArrayList<DataModel> dataList = getAllDataFromDatabase();

        for (DataModel data : dataList) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            addTextViewToRow(row, data.getNom());
            addTextViewToRow(row, data.getGrade());
            addTextViewToRow(row, data.getEtablissement());
            addTextViewToRow(row, data.getNum());
            addTextViewToRow(row, data.getEmail());


            addTextViewToRow(row, data.getDate());
            addTextViewToRow(row, data.getHeur_entre());
            addTextViewToRow(row, data.getHeur_sortie());
            addTextViewToRow(row, data.getResponsable());
            addTextViewToRow(row, data.getPlatforme());

            tableLayout.addView(row);
        }
    }




    private ArrayList<DataModel> getAllDataFromDatabase() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<DataModel> dataList = new ArrayList<>();
        Cursor cursor = db.query(DatabaseHelper.TABLE_UTILISATEURS, null, null, null, null, null, null);
        if (cursor != null) {
            String[] columnNames = cursor.getColumnNames();
            Log.d("ColumnNames", Arrays.toString(columnNames));


            if (cursor.moveToFirst()) {
            do {
                String nom = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NOM));
                String grade = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GRADE));
                String etab = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ETABLISSEMENT));
                String num = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NUMTEL));
                String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MAIL));


                String date = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DATE));
                String heur_entre = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ENTRE));
                String heur_sortie = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_SORTIE));
                String responsable = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_RESPONSABLE));
                String platforme = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PLATFORME));
                dataList.add(new DataModel(nom, grade, etab, num, email ,date, heur_entre, heur_sortie, responsable , platforme));
            } while (cursor.moveToNext());
        }

        cursor.close();}
        db.close();
        return dataList;
    }


    private void addTextViewToRow(TableRow row, String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setPadding(8, 8, 8, 8);
        textView.setGravity(Gravity.CENTER);
        row.addView(textView);

    }






}