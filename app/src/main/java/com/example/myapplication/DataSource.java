package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public DataSource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // Insert a new patient
    public long insertPatient(Patient patient) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, patient.getName());
        values.put(DatabaseHelper.COLUMN_SURNAME, patient.getSurname());
        values.put(DatabaseHelper.COLUMN_ID_NO, patient.getIdNo());

        values.put(DatabaseHelper.COLUMN_CHRONIC_DISEASES, patient.getChronicDiseases());



        return database.insert(DatabaseHelper.TABLE_PATIENTS, null, values);
    }

    // Update a patient
    public int updatePatient(Patient patient) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, patient.getName());
        values.put(DatabaseHelper.COLUMN_SURNAME, patient.getSurname());
        values.put(DatabaseHelper.COLUMN_ID_NO, patient.getIdNo());

        values.put(DatabaseHelper.COLUMN_CHRONIC_DISEASES, patient.getChronicDiseases());



        return database.update(DatabaseHelper.TABLE_PATIENTS, values,
                DatabaseHelper.COLUMN_ID + " = ?", new String[]{String.valueOf(patient.getId())});
    }

    // Delete a patient
    public void deletePatient(long patientId) {
        database.delete(DatabaseHelper.TABLE_PATIENTS,
                DatabaseHelper.COLUMN_ID + " = ?", new String[]{String.valueOf(patientId)});
    }

    // Retrieve all patients
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        Cursor cursor = database.query(DatabaseHelper.TABLE_PATIENTS,
                null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Patient patient = cursorToPatient(cursor);
            patients.add(patient);
            cursor.moveToNext();
        }
        cursor.close();
        return patients;
    }

    // Convert cursor to Patient object
    @SuppressLint("Range")
    private Patient cursorToPatient(Cursor cursor) {
        Patient patient = new Patient();
        patient.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)));
        patient.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME)));
        patient.setSurname(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_SURNAME)));
        patient.setIdNo(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID_NO)));

        patient.setChronicDiseases(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CHRONIC_DISEASES)));


        return patient;
    }
}
