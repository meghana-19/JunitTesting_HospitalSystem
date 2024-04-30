package com.junit.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestCaseForSaveAppointmentsMethod {
    
    private static final String APPOINTMENTS_FILE = "C:\\Users\\MS42\\eclipse-workspace\\Task2Hospital_Junit\\src\\com\\junit\\model\\appointments.txt";

   
    @Test
    void test() {
        
        List<Appointment> appointments = new ArrayList<>();
        
        appointments.add(new Appointment(111, 3, LocalDate.of(2024, 06, 03)));
        appointments.add(new Appointment(141, 1, LocalDate.of(2024, 04, 15)));
        
        HospitalManagementSystem.setAppointments(appointments);
        
        HospitalManagementSystem.saveAppointments();
        
        try ( BufferedReader reader = new BufferedReader(new FileReader(APPOINTMENTS_FILE))) {
            
            //reading 1st line
            String line1 = reader.readLine();
            assertEquals("111,3,2024-06-03", line1);
            
            String line2 = reader.readLine();
            assertEquals("141,1,2024-04-15", line2);
            
            assertEquals(null, reader.readLine());
        }
                    
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        
    }  

}
