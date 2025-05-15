package com.clinicms.model;

import java.time.LocalDate;
import java.time.LocalTime;


public class Appointment {
    static int idCounter = 0;
    int id;
    int patientaId, doctorId;
    String date;
    String time;
    public Appointment(int patientaId, int doctorId)
    {
        this.patientaId = patientaId;
        this.doctorId = doctorId;
        time = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond();
        date = LocalDate.now().getYear() + ":" + LocalDate.now().getMonth() + ":" +  LocalDate.now().getDayOfMonth();
    }
}
