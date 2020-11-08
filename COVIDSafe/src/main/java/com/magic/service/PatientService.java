package com.magic.service;


import com.magic.Bean.UserResponse;
import com.magic.domain.Appointment;
import com.magic.domain.State;

import java.util.List;

public interface PatientService {
    Integer matchDoctor( Integer patientId);
    List<Appointment> request(Integer patientId, Integer doctorId, String date, Integer type);
    List<Appointment> checkApp(Integer patientId);
    Boolean cancel(Integer appointmentId);
    UserResponse checkin(State state);
}
