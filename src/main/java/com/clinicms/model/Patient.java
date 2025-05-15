package com.clinicms.model;

public class Patient {
    static int idCounter = 0;
    int id;
    String name;
    byte age;
    String contactInfo;
    public Patient(String name, byte age, String contactInfo)
    {
        this.name = name;
        this.age = age;
        this.contactInfo = contactInfo;
        id = idCounter++;
    }
    public String toString()
    {
        return "Name: " + name + "Age: " + age + "Contact Info: " + contactInfo + "Id: " + id;
    }
}