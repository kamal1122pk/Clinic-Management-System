package com.clinicms;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.clinicms.service.Services;
import com.clinicms.ui.Ui;

public class Main {
    Services services = new Services();
    Ui ui = new Ui();
    Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        Main main = new Main();
        int i = 0;
        while (i != 10)
        {
            main.ui.showUi();
            System.out.print("Enter: ");
            i = main.s.nextInt();
            main.s.nextLine();
            switch(i)
            {
                case 1:
                    {System.out.print("Enter name: ");
                    String name = main.s.nextLine();
                    System.out.print("Enter specialization: ");
                    String specialization = main.s.nextLine();
                    System.out.print("Enter ID: ");
                    int id = main.s.nextInt();
                    main.s.nextLine();
                    main.services.addDoctor(name, specialization, id);}
                    break;
                case 2:
                    {System.out.print("Enter name: ");
                    String name = main.s.nextLine();
                    System.out.print("Enter age: ");
                    byte age = (byte) main.s.nextInt();
                    main.s.nextLine();
                    System.out.print("Enter Gender: ");
                    String gender = main.s.nextLine();
                    System.out.print("Enter Contact Info: ");
                    String contactInfo = main.s.nextLine();
                    System.out.print("Enter ID: ");
                    int id = main.s.nextInt();
                    main.s.nextLine();
                    main.services.addPatient(name, age, gender, contactInfo, id);}
                    break;
                case 3:
                    {System.out.print("Enter doctor id: ");
                    int doctorId = main.s.nextInt();
                    main.s.nextLine();
                    System.out.print("Enter patient id: ");
                    int patientId = main.s.nextInt();
                    main.s.nextLine();
                    System.out.print("Enter ID: ");
                    int id = main.s.nextInt();
                    main.s.nextLine();
                    System.out.print("Enter Date and Time (yyyy-MM-dd HH:mm): ");
                    String dateTimeStr = main.s.nextLine();
                    main.services.bookAppointment(patientId, doctorId, id, LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));}
                    break;
                case 4:
                    main.services.getAllDoctors();
                    break;
                case 5:
                    main.services.getAllPatients();
                    break;
                case 6:
                    {System.out.print("Enter ID: ");
                    int id = main.s.nextInt();
                    main.s.nextLine();
                    main.services.deletePatient(id);}
                    break;
                case 7:
                    {System.out.print("Enter ID: ");
                    int id = main.s.nextInt();
                    main.s.nextLine();
                    main.services.deleteDoctor(id);}
                    break;
                case 8:
                    {System.out.print("Enter ID: ");
                    int id = main.s.nextInt();
                    main.s.nextLine();
                    main.services.deleteAppointment(id);}
                    break;
                case 9:
                    main.services.getAllAppointments();
                    break;
                case 10:
                    System.out.println("Existing...");
                    main.services.getLogger().info("Exited");
                    break;
                default:
                    System.out.println("Enter a valid input");
            }
        }
    }
}
