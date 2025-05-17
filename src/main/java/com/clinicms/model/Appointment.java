package com.clinicms.model;

import java.time.LocalDateTime;

public class Appointment {
    int id;
    int patientId, doctorId;
    LocalDateTime dateTime;
    public Appointment(int patientId, int doctorId, LocalDateTime dateTime, int id)
    {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dateTime = dateTime;
        this.id = id;
    }
    public LocalDateTime getDateTime()
    {
        return dateTime;
    }
    public int getPatientId()
    {
        return patientId;
    }
    public int getDoctorId()
    {
        return doctorId;
    }
    @Override
    public String toString()
    {
        return "Id: " + id + " Doctor Id: " + doctorId + " Patient Id: " + patientId + " Appointment Time: " + dateTime;
    }
    public int getId() {
        return id;
    }
}
