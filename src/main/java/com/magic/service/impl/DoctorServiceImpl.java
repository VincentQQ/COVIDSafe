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
     * 查看医生关联用户
     * @param doctorId
     * @return
     */
    @Override
    public List<Patient> checkPatient(Integer doctorId) {
        return patientDao.findByDoctorId(doctorId);
    }

    /**
     * 增加关联用户
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
     * 删除关联用户
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
     * 查看用户状态详情
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
     * 编辑用户状态
     * @param state
     * @return
     */
    @Override
    public State editDetail (State state){
          stateDao.delete(stateDao.findByPatientId(state.getPatientId()));
          stateDao.save(state);
        return state;
    }

    /**
     * 根据医生ID查看所有的预约
     * @param doctorID
     * @return
     */
    @Override
    public List<Appointment> checkApp (int doctorID){
        return appointmentDao.findByDoctorId(doctorID);
    }

    /**
     * 医生确认预约
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
     * 医生取消预约
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
