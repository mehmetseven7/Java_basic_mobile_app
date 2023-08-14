package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "patient.db";
    public static final int DATABASE_VERSION = 1;

    // Table name and column names
    public static final String TABLE_PATIENTS = "patients";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME = "surname";
    public static final String COLUMN_ID_NO = "id_no";

    public static final String COLUMN_CHRONIC_DISEASES = "chronic_diseases";
    public static final String COLUMN_HEALTH_HISTORY = "health_history";
    public static final String COLUMN_TREATMENT = "treatment";
    public static final String COLUMN_DOCTOR_NOTE = "doctor_note";


    // Create table query
    private static final String CREATE_TABLE_PATIENTS =
            "CREATE TABLE " + TABLE_PATIENTS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_SURNAME + " TEXT, " +
                    COLUMN_ID_NO + " TEXT, " +
                    COLUMN_CHRONIC_DISEASES + " TEXT " +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PATIENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PATIENTS);
        onCreate(db);
    }
}
