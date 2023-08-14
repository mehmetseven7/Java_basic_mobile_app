package com.example.myapplication;

public class Patient {
    private int id;
    private String name;
    private String surname;
    private String idNo;

    private String chronicDiseases;
    private String healthHistory;
    private String treatment;
    private String doctorNote;

    public Patient() {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.idNo = idNo;

        this.chronicDiseases = chronicDiseases;
        this.healthHistory = healthHistory;
        this.treatment = treatment;
        this.doctorNote = doctorNote;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getIdNo() {
        return idNo;
    }



    public String getChronicDiseases() {
        return chronicDiseases;
    }

    public String getHealthHistory() {
        return healthHistory;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getDoctorNote() {
        return doctorNote;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }


    public void setChronicDiseases(String chronicDiseases) {
        this.chronicDiseases = chronicDiseases;
    }


    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setDoctorNote(String doctorNote) {
        this.doctorNote = doctorNote;
    }
}
