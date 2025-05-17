package com.clinicms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clinicms.db.DatabaseUtil;
import com.clinicms.model.Doctor;

public class DoctorDAO {
    public void addDoctor(Doctor doctor)
    {
        String sql = "INSERT INTO doctors (name, specialization) VALUES (?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getSpecialization());

            stmt.executeUpdate();
            System.out.println("Doctor added in SQL Data");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public List<Doctor> getDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors";

        try (Connection conn = DatabaseUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Doctor d = new Doctor(
                    rs.getString("name"),
                    rs.getString("specialization"),
                    rs.getInt("id")
                );
                doctors.add(d);
            }

        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }
    public boolean deleteDoctor(int id) 
    {
        String sql = "DELETE FROM doctors WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
