package com.clinicms.dao;

import com.clinicms.model.Patient;
import com.clinicms.db.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    public void addPatient(Patient patient)
    {
        String sql = "INSERT INTO patients (name, age, gender, contact) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, patient.getName());
            stmt.setInt(2, patient.getAge());
            stmt.setString(3, patient.getGender());
            stmt.setString(4, patient.getContactInfo());

            stmt.executeUpdate();
            System.out.println("Patient added in SQL Data");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public List<Patient> getPatients()
    {
        String sql = "SELECT * FROM patients";
        List<Patient> patients = new ArrayList<>();
        try(Connection conn = DatabaseUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next())
            {
                Patient p = new Patient(rs.getString("name"), 
                (byte) rs.getInt("age"),
                rs.getString("gender"), 
                rs.getString("contact"), rs.getInt("id"));
                patients.add(p);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }
    public boolean deletePatient(int id)
    {
        String sql = "DELETE FROM patients WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
