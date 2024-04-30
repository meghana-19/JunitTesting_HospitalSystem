package com.junit.model;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalManagementSystem {

    private static final String PATIENTS_FILE = "C:\\Users\\MS42\\eclipse-workspace\\Task2Hospital_Junit\\src\\com\\junit\\model\\patients.txt";
    private static final String DOCTORS_FILE = "C:\\Users\\MS42\\eclipse-workspace\\HospitalSystem\\src\\com\\basic\\model\\doctors.txt";
    private static final String APPOINTMENTS_FILE = "C:\\Users\\MS42\\eclipse-workspace\\Task2Hospital_Junit\\src\\com\\junit\\model\\appointments.txt";

    private static List<Patient> patients = new ArrayList<>();
    private static List<Doctor> doctors = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        loadData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("HOSPITAL MANAGEMENT SYSTEM ");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. View Doctors");
            System.out.println("4. Book Appointment");
            System.out.println("5. View Appointments");
            System.out.println("6. Exit");

            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    System.out.println();
                    break;
                case 2:
                    viewPatients();
                    System.out.println();
                    break;
                case 3:
                    viewDoctors();
                    System.out.println();
                    break;
                case 4:
                    bookAppointment(scanner);
                    System.out.println();
                    break;
                case 5:
                    viewAppointments();
                    System.out.println();
                    break;
                case 6:
                    saveData();
                    System.out.println("THANK YOU! FOR USING HOSPITAL MANAGEMENT SYSTEM!!");
                    return;
                default:
                    System.out.println("Enter valid choice!!!");
                    break;
            }
        }
    }

    private static void loadData() {
        loadPatients();
        loadDoctors();
        loadAppointments();
    }

    public static void loadPatients() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATIENTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                Patient patient = new Patient(id, name, age);
                patients.add(patient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    // Other methods...

    public static List<Patient> getPatients() {
        return patients;
    }

    public static void loadDoctors() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DOCTORS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String specialization = parts[2];
                Doctor doctor = new Doctor(id, name, specialization);
                doctors.add(doctor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Doctor> getDoctors() {
        return doctors;
    }

    public static void loadAppointments() {
        try (BufferedReader reader = new BufferedReader(new FileReader(APPOINTMENTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int patientId = Integer.parseInt(parts[0]);
                int doctorId = Integer.parseInt(parts[1]);
                LocalDate date = LocalDate.parse(parts[2]);
                Appointment appointment = new Appointment(patientId, doctorId, date);
                appointments.add(appointment);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Appointment> getAppointments()
    {
        return appointments;
    }

    public static void addPatient(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Patient Name: ");
        String name = scanner.next();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        if(age > 0 && age <= 110)
        {
            Patient patient = new Patient(id, name, age);
            patients.add(patient);
            savePatients();
            System.out.println("Patient Added Successfully!!");             
        }else {
            System.out.println("Enter correct age (age must be between 1 to 110");
            System.out.print("Enter Patient Age: ");
             age = scanner.nextInt();
             Patient patient = new Patient(id, name, age);
             patients.add(patient);
             savePatients();
             System.out.println("Patient Added Successfully!!");
        }
        
    }

    public static void viewPatients() {
        System.out.println("Patients: ");
        System.out.println("+------------+--------------------+----------+");
        System.out.println("| Patient ID | Name               | Age      |");
        System.out.println("+------------+--------------------+----------+");
        for (Patient patient : patients) {
            System.out.printf("| %-10d | %-18s | %-8d |\n", patient.getId(), patient.getName(), patient.getAge());
            System.out.println("+------------+--------------------+----------+");
        }
    }

    public static void viewDoctors() {
        System.out.println("Doctors: ");
        System.out.println("+------------+--------------------+------------------+");
        System.out.println("| Doctor ID  | Name               | Specialization   |");
        System.out.println("+------------+--------------------+------------------+");
        for (Doctor doctor : doctors) {
            System.out.printf("| %-10d | %-18s | %-16s |\n", doctor.getId(), doctor.getName(), doctor.getSpecialization());
            System.out.println("+------------+--------------------+------------------+");
        }
    }

    public static void bookAppointment(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String dateString = scanner.next();
        LocalDate date = LocalDate.parse(dateString);
        if(doctorId<6 && doctorId>0){
            Appointment appointment = new Appointment(patientId, doctorId, date);
        appointments.add(appointment);
        saveAppointments();
        System.out.println("Appointment Booked!");
    }else { 
        System.out.println("!!Enter correct details!!!");
    }
        }
        
        

    public static void viewAppointments() {
        System.out.println("Appointments: ");
        System.out.println("+------------+------------+----------------------+");
        System.out.println("| Patient ID | Doctor ID  | Appointment Date     |");
        System.out.println("+------------+------------+----------------------+");
        for (Appointment appointment : appointments) {
            System.out.printf("| %-10d | %-10d | %-20s |\n", appointment.getPatientId(), appointment.getDoctorId(), appointment.getDate());
            System.out.println("+------------+------------+----------------------+");
        }
    }

    public static void saveData() {
        savePatients();
        saveAppointments();
    }

    public static void savePatients() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PATIENTS_FILE))) {
            for (Patient patient : patients) {
                writer.println(patient.getId() + "," + patient.getName() + "," + patient.getAge());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void setPatients(List<Patient> patients)
    {
        HospitalManagementSystem.patients = patients;
    }

    public static void setAppointments(List<Appointment> appointments)
    {
        HospitalManagementSystem.appointments = appointments;
    }
    public static void saveAppointments() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(APPOINTMENTS_FILE))) {
            for (Appointment appointment : appointments) {
                writer.println(appointment.getPatientId() + "," + appointment.getDoctorId() + "," + appointment.getDate());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
