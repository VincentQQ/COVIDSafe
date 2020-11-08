package com.magic.service;

import com.magic.Bean.UserResponse;
import com.magic.domain.Doctor;
import com.magic.domain.Patient;

public interface UserService {
    UserResponse register(Patient patient);
    UserResponse login(Integer id, String password, Integer role);
    Boolean editPatient(Patient patient);
    Boolean editDoctor(Doctor doctor);
    Patient searchPatient(Integer patientId);
    Doctor searchDoctor(Integer doctorId);
}
