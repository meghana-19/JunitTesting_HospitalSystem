package com.junit.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestcaseForLoadPatientMethod {
    
    private static final String PATIENTS_FILE = "C:\\Users\\MS42\\eclipse-workspace\\Task2Hospital_Junit\\src\\com\\junit\\model\\patients.txt";



    @Test
    void testCaseForLoadingPatients() {
        
        //given
        List<Patient> patients = new ArrayList<>();
        
        patients.add(new Patient(1, "Ujala", 22));
        patients.add(new Patient(141, "deepa", 37));
        patients.add(new Patient(111, "khana", 34));
        patients.add(new Patient(112, "deepu", 78));
        
        //when
        HospitalManagementSystem.loadPatients();
        
        //then
        assertEquals(patients.size(), HospitalManagementSystem.getPatients().size());
        for (int i = 0; i < patients.size(); i++) {
            assertEquals(patients.get(i).getId(), HospitalManagementSystem.getPatients().get(i).getId());
            assertEquals(patients.get(i).getName(), HospitalManagementSystem.getPatients().get(i).getName());
            assertEquals(patients.get(i).getAge(), HospitalManagementSystem.getPatients().get(i).getAge());
        }
    }
    
    private void writePatientsToFile(List<Patient> patients, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Patient patient : patients) {
                writer.println(patient.getId() + "," + patient.getName() + "," + patient.getAge());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
        
      
}
