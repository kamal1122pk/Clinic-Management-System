package com.clinicms.model;

public class Patient {
    int id;
    String name;
    byte age;
    String gender;
    String contactInfo;
    public Patient(String name, byte age, String gender, String contactInfo, int id)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.id = id;
    }
    public Patient() {
        //TODO Auto-generated constructor stub
    }
    public String toString()
    {
        return "Name: " + name + " Age: " + age + " Gender: "+ gender + " Contact Info: " + contactInfo + " Id: " + id;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getContactInfo() { return contactInfo; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(Byte age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void getContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
}