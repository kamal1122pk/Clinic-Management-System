package com.clinicms.service;

import java.util.ArrayList;

import com.clinicms.model.Appointment;
import com.clinicms.model.Doctor;
import com.clinicms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Services {
    private static final Logger logger = LogManager.getLogger(Appointment.class);
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Patient> patients = new ArrayList<>();
    ArrayList<Appointment> appointments = new ArrayList<>();

    public void addDoctor(String name, String specialization)
    {
        doctors.add(new Doctor(name, specialization));
        logger.info("Doctor added");
    }
    public void getAllDoctors()
    {
        for (Doctor doctor : doctors)
        {
            logger.info(doctor);
        }
    }
    public Doctor findDoctorById(int id)
    {
        for (Doctor doctor : doctors)
        {
            if (doctor.getId() == id)
            {
                logger.info(doctor);
                return doctor;
            }
        }
        logger.info("No doctor");
        return null;
    }
    public void addPatient(String name, byte age, String contactInfo)
    {
        patients.add(new Patient(name, age, contactInfo));
        logger.info("Patient added");
    }
    public void bookAppointment(int patientId, int doctorId)
    {
        appointments.add(new Appointment(patientId, doctorId));
    }
    public void getAllPatients()
    {
        for (Patient patient : patients)
        {
            logger.info(patient);
        }
    }
    public Logger getLogger()
    {
        return logger;
    }
}
