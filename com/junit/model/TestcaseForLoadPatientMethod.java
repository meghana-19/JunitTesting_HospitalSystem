package com.junit.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestcaseForLoadPatientMethod {
    
    private static final String PATIENTS_FILE = "C:\\Users\\MS42\\eclipse-workspace\\Task2Hospital_Junit\\src\\com\\junit\\model\\patients.txt";



    // test case 1
    @Test
    void testCaseForLoadingPatients() {
        
        //given
        List<Patient> patients = new ArrayList<>();
        
        patients.add(new Patient(1, "Ujala", 22));
        patients.add(new Patient(141, "deepa", 37));
        patients.add(new Patient(15, "khana", 24));
        
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
        
     //   Test case 2 : to delete the file
//        @Test
//        void test() {
//            
//            File file = new File(PATIENTS_FILE);
//            if(!file.delete())
//            {
//                System.out.println("failed to delete test file");
//            }
//            
//            
//        }
    

}
