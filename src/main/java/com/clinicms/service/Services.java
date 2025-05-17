package com.clinicms.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.clinicms.dao.AppointmentDAO;
import com.clinicms.dao.DoctorDAO;
import com.clinicms.dao.PatientDAO;
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
    PatientDAO patientsDAO = new PatientDAO();
    DoctorDAO doctorsDAO = new DoctorDAO();
    AppointmentDAO appointmentsDAO = new AppointmentDAO();

    public void addDoctor(String name, String specialization, int id)
    {
        Doctor d = new Doctor(name, specialization, id);
        doctorsDAO.addDoctor(d);
        doctors.add(d);
        logger.info("Doctor added");
    }
    public void getAllDoctors()
    {
        List<Doctor> doctors = doctorsDAO.getDoctors();
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
    public void addPatient(String name, byte age, String gender, String contactInfo, int id)
    {
        Patient p = new Patient(name, age, gender, contactInfo, id);
        patientsDAO.addPatient(p);
        patients.add(p);
        logger.info("Patient added");
    }
    public void bookAppointment(int patientId, int doctorId, int id, LocalDateTime dateTime)
    {
        Appointment p = new Appointment(patientId, doctorId, dateTime, id);
        appointmentsDAO.addAppointment(p);
        appointments.add(p);
    }
    public void getAllPatients()
    {
        List<Patient> patients = patientsDAO.getPatients();
        for (Patient patient : patients)
        {
            logger.info(patient);
        }
    }
    public Logger getLogger()
    {
        return logger;
    }
    public void deletePatient(int id)
    {
        if (patientsDAO.deletePatient(id))
        {
            logger.info("Patient Deleted");
            for (int i = 0; i < patients.size(); i++)
            {
                if (patients.get(i).getId() == id) 
                {
                    patients.remove(i);
                    return;
                }
            }
        }
    }
    public void deleteDoctor(int id)
    {
        if (doctorsDAO.deleteDoctor(id))
        {
            logger.info("Doctor deleted");
            for (int i = 0; i < doctors.size(); i++)
            {
                if (doctors.get(i).getId() == id) 
                {
                    doctors.remove(i);
                    return;
                }
            }
        }
    }
    public void deleteAppointment(int id) {
        if(appointmentsDAO.deleteAppointment(id))
        {
            logger.info("Appointment Successfully deleted");
            for (int i = 0; i < appointments.size(); i++)
            {
                if (appointments.get(i).getId() == id) 
                {
                    appointments.remove(i);
                    return;
                }
            }
        }
        else {
            logger.info("Deletation Failed");
        }
    }
    public void getAllAppointments()
    {
        List<Appointment> appointments = appointmentsDAO.getAppointments();
        for (Appointment appointment : appointments)
        {
            logger.info(appointment);
        }
    }
}
