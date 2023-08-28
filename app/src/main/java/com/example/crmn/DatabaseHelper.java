package com.example.crmn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {



        private static final String DATABASE_NAME = "utilisateurs.db";
        private static final int DATABASE_VERSION = 1;

        // Noms de table et de colonnes
        public static final String TABLE_UTILISATEURS = "utilisateurs";
        public static final String COL_ID = "id";
        public static final String COL_NOM = "nom";
        public static final String COL_GRADE = "grade";
        public static final String COL_ETABLISSEMENT = "etablissement";
        public static final String COL_MAIL = "mail";
        public static final String COL_NUMTEL = "numtel";

        public static final String COL_DATE ="date";
        public static final String COL_ENTRE ="heur_entre";
        public static final String COL_SORTIE ="heur_sortie";
        public static final String COL_RESPONSABLE ="responsable";
        public static final String COL_PLATFORME ="platforme";




        // Requête de création de table
        private static final String CREATE_TABLE_UTILISATEURS = "CREATE TABLE " + TABLE_UTILISATEURS +
                "(" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NOM + " TEXT," +
                COL_GRADE + " TEXT," +
                COL_ETABLISSEMENT + " TEXT," +
                COL_MAIL + " TEXT," +
                COL_NUMTEL + " TEXT," +

                COL_DATE + " TEXT," +

                COL_ENTRE + " TEXT," +
                COL_SORTIE + " TEXT," +
                COL_RESPONSABLE + " TEXT," +
                COL_PLATFORME + " TEXT" +
                ")";

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_UTILISATEURS);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Mettez à jour la base de données si nécessaire
        }
}
