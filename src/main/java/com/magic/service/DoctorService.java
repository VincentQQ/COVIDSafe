package com.magic.service;

import com.magic.domain.Appointment;
import com.magic.domain.Patient;
import com.magic.domain.State;

import java.util.List;
import java.util.Map;

public interface DoctorService {
    List<Patient> checkPatient(Integer doctorId);
    List<Patient> addPatient(Integer patientId, Integer doctorId);
    List<Patient> deletePatient(Integer patientId, Integer doctorId);
    Map<String,State> ckeckDetail(Integer patientId);
    State editDetail (State state);
    List<Appointment> checkApp (int doctorID);
    Boolean confirmApp(Integer appointmentId);
    Boolean cancelApp(Integer appointmentId);
}
