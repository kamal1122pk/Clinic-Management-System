package com.clinicms.model;

public class Doctor {
    static int idCounter = 0;
    int id;
    String name;
    boolean availability;
    String specialization;
    public Doctor(String name, String specialization)
    {
        this.name = name;
        this.specialization = specialization;
        id = idCounter++;
        availability = true;
    }
    public String toString()
    {
        return "Name: " + name + "Specialization: " + specialization + "ID: " + id + "Availability: " + availability;
    }
    public int getId()
    {
        return id;
    }
}
