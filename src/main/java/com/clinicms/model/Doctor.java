package com.clinicms.model;

public class Doctor {
    int id;
    String name;
    boolean availability;
    String specialization;
    public Doctor(String name, String specialization, int id)
    {
        this.name = name;
        this.specialization = specialization;
        availability = true;
        this.id = id;
    }
    public String toString()
    {
        return "Name: " + name + " Specialization: " + specialization + " ID: " + id + " Availability: " + availability;
    }
    public int getId()
    {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSpecialization() {
        return specialization;
    }
}
