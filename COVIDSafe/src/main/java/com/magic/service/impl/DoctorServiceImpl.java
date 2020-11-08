package com.magic.service.impl;

import com.magic.dao.AppointmentDao;
import com.magic.dao.DoctorDao;
import com.magic.dao.PatientDao;
import com.magic.dao.StateDao;
import com.magic.domain.Appointment;
import com.magic.domain.Patient;
import com.magic.domain.State;
import com.magic.service.DoctorService;
import com.magic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorDao doctorDao;

    @Autowired
    PatientDao patientDao;

    @Autowired
    StateDao stateDao;

    @Autowired
    AppointmentDao appointmentDao;

    /**
     *
     * @param doctorId
     * @return
     */
    @Override
    public List<Patient> checkPatient(Integer doctorId) {
        return patientDao.findByDoctorId(doctorId);
    }

    /**
     *
     * @param patientId
     * @param doctorId
     * @return
     */
    @Override
    public List<Patient> addPatient(Integer patientId, Integer doctorId) {
        Patient patient = patientDao.findByPatientId(patientId);
        patient.setDoctorId(doctorId);
        patientDao.save(patient);
        return checkPatient(doctorId);
    }

    /**
     *
     * @param patientId
     * @return
     */
    @Override
    public List<Patient> deletePatient(Integer patientId, Integer doctorId) {
        Patient patient = patientDao.findByPatientId(patientId);
        patient.setDoctorId(0);
        patientDao.save(patient);
        return checkPatient(doctorId);
    }

    /**
     *
     * @param patientId
     * @return
     */
    @Override
    public Map<String, State> ckeckDetail(Integer patientId) {
        Map<String,State> map = new HashMap<>();
        State state = stateDao.findByPatientId(patientId);
        Patient patient = patientDao.findByPatientId(patientId);
        map.put(patient.getName(),state);
        return map;
    }

    /**
     *
     * @param state
     * @return
     */
    @Override
    public State editDetail (State state){
          stateDao.delete(stateDao.findByPatientId(state.getPatientId()));
          Patient patient = patientDao.findByPatientId(state.getPatientId());
          patient.setStatus(state.getStatus());
          stateDao.save(state);
          patientDao.save(patient);
        return state;
    }

    /**
     *
     * @param doctorID
     * @return
     */
    @Override
    public List<Appointment> checkApp (int doctorID){
        return appointmentDao.findByDoctorId(doctorID);
    }

    /**
     *
     * @param appointmentId
     * @return
     */
    @Override
    public Boolean confirmApp(Integer appointmentId){
        Appointment appointment = appointmentDao.findByAppointmentId(appointmentId);
        appointment.setStatus(1);
        appointmentDao.save(appointment);
        return true;
    }

    /**
     *
     * @param appointmentId
     * @return
     */
    @Override
    public Boolean cancelApp(Integer appointmentId){
        Appointment appointment = appointmentDao.findByAppointmentId(appointmentId);
        appointment.setStatus(2);
        appointmentDao.save(appointment);
        return true;
    }
}
