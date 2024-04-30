package com.junit.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestCaseForSavePatientsMethod {
    
    private static final String PATIENTS_FILE = "C:\\Users\\MS42\\eclipse-workspace\\Task2Hospital_Junit\\src\\com\\junit\\model\\patients.txt";


    @Test
    void test() {
        
        List<Patient> patients = new ArrayList<>();
        
        patients.add(new Patient(1, "Ujala", 22));
        patients.add(new Patient(141, "deepa", 37));
        patients.add(new Patient(15, "khana", 24));
        
        HospitalManagementSystem.setPatients(patients);
        
        
        HospitalManagementSystem.savePatients();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(PATIENTS_FILE)))
        {
            //reading 1st line from patients.txt file
            String line1 = reader.readLine();
            assertEquals("1,Ujala,22", line1);
            
            //2nd line
            String line2 = reader.readLine();
            assertEquals("141,deepa,37", line2);
            
            //3rd line
            String line3 = reader.readLine();
            assertEquals("15,khana,24", line3);
            
            //no more lines
            assertEquals(null,reader.readLine());
                    
        } catch(IOException e)
        {
            e.printStackTrace();
        }
        
        
    }

}
