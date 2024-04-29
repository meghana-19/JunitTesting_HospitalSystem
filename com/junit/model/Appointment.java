package com.junit.model;


import java.time.LocalDate;

class Appointment {
    private int patientId;
    private int doctorId;
    private LocalDate date;

    public Appointment(int patientId, int doctorId, LocalDate date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment [patientId=" + patientId + ", doctorId=" + doctorId + ", date=" + date + "]";
    }

    public Appointment() {
        super();
        // TODO Auto-generated constructor stub
    }

    
}