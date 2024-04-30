package com.junit.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestCaseForLoadDoctorsMethod {
    
    private static final String DOCTORS_FILE = "C:\\Users\\MS42\\eclipse-workspace\\Task2Hospital_Junit\\src\\com\\junit\\model\\doctors.txt";
    

    // test case 1
    @Test
    void testCase_LoadDoctors() {
        
        //given 
        List<Doctor> doctors = new ArrayList<>();
        
        doctors.add(new Doctor(1, "Dr. Singh", "Cardiology"));
        doctors.add(new Doctor(2, "Dr. Patel", "Neurology"));
        doctors.add(new Doctor(3, "Dr. Reddy", "Orthopedics"));
        doctors.add(new Doctor(4, "Dr. Gupta", "Oncology"));
        doctors.add(new Doctor(5, "Dr. Kumar", "Pediatrics"));
        
        //when
        HospitalManagementSystem.loadDoctors();
        
        //then
        assertEquals(doctors.size(), HospitalManagementSystem.getDoctors().size());
        for(int i = 0; i < doctors.size(); i++)
        {
            assertEquals(doctors.get(i).getId(), HospitalManagementSystem.getDoctors().get(i).getId());
            assertEquals(doctors.get(i).getName(), HospitalManagementSystem.getDoctors().get(i).getName());
            assertEquals(doctors.get(i).getSpecialization(), HospitalManagementSystem.getDoctors().get(i).getSpecialization());

        }
    }

        //Test Case 2 : to delete the file
        @Test
        void test() {
            
            File file = new File(DOCTORS_FILE);
            if(!file.delete())
            {
                System.out.println("failed to delete test file");
            }
            
            
        }
}
