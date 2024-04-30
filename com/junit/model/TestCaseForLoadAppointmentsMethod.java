package com.junit.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestCaseForLoadAppointmentsMethod {
    
    private static final String APPOINTMENTS_FILE = "C:\\Users\\MS42\\eclipse-workspace\\Task2Hospital_Junit\\src\\com\\junit\\model\\appointments.txt";
    

    // test case 1
    @Test
    void testMethod_LoadAppointments() {
        
        //given
        List<Appointment> appointments = new ArrayList<>();
        
        appointments.add(new Appointment(111, 3, LocalDate.of(2024, 06, 03)));
        appointments.add(new Appointment(141, 1, LocalDate.of(2024, 04, 15)));
        
        
        //when
        HospitalManagementSystem.loadAppointments();;
        
        //then
        assertEquals(appointments.size(), HospitalManagementSystem.getAppointments().size());
        for (int i = 0; i < appointments.size(); i++)
        {
            assertEquals(appointments.get(i).getPatientId(), HospitalManagementSystem.getAppointments().get(i).getPatientId());
            assertEquals(appointments.get(i).getDoctorId(), HospitalManagementSystem.getAppointments().get(i).getDoctorId());
            assertEquals(appointments.get(i).getDate(), HospitalManagementSystem.getAppointments().get(i).getDate());

        }
        
    }
    
    

}
