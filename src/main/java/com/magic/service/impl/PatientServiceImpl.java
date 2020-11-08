package com.magic.service.impl;


import com.magic.Bean.UserResponse;
import com.magic.dao.AppointmentDao;
import com.magic.dao.DoctorDao;
import com.magic.dao.PatientDao;
import com.magic.dao.StateDao;
import com.magic.domain.Appointment;
import com.magic.domain.Patient;
import com.magic.domain.State;
import com.magic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientDao patientDao;

    @Autowired
    AppointmentDao appointmentDao;

    @Autowired
    StateDao stateDao;

    @Autowired
    DoctorDao doctorDao;

    /**
     * 自动回填医生id
     * @param patientId
     * @return
     */
    @Override
    public Integer matchDoctor(Integer patientId) {
        Integer doctorId = patientDao.findByPatientId(patientId).getDoctorId();
        if(doctorId == null || doctorId == 0){
            return 0;
        }
        return doctorId;
    }

    /**
     * 预约医生
     * @param patientId
     * @param doctorId
     * @param date
     * @param type
     * @return
     */
    @Override
    public List<Appointment> request(Integer patientId, Integer doctorId, String date, Integer type) {
        Appointment appointment = new Appointment();
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setPatientName(patientDao.findByPatientId(patientId).getName());
        appointment.setDoctorName(doctorDao.findByDoctorId(doctorId).getName());
        appointment.setType(type);
        appointment.setStatus(0);
        appointment.setDate(date);
        appointmentDao.save(appointment);
        return checkApp(patientId);
    }

    /**
     * 查看预约
     * @param patientId
     * @return
     */
    @Override
    public List<Appointment> checkApp(Integer patientId) {
        return appointmentDao.findByPatientId(patientId);
    }

    /**
     * 取消预约
     * @param appointmentId
     * @return
     */
    @Override
    public Boolean cancel(Integer appointmentId) {
        Appointment appointment = appointmentDao.findByAppointmentId(appointmentId);
        appointment.setStatus(2);
        appointmentDao.save(appointment);
        return true;
    }

    /**
     * 健康打卡
     * @param state
     * @return
     */
    @Override
    public UserResponse checkin(State state) {
        UserResponse userResponse = new UserResponse();
        if(stateDao.findByPatientId(state.getPatientId()) != null){
            stateDao.delete(stateDao.findByPatientId(state.getPatientId()));
            stateDao.save(state);
            Patient patient = patientDao.findByPatientId(state.getPatientId());
            patient.setStatus(state.getStatus());
            patientDao.save(patient);
        } else{
            stateDao.save(state);
            Patient patient = patientDao.findByPatientId(state.getPatientId());
            patient.setStatus(state.getStatus());
            patientDao.save(patient);
        }

        userResponse.setMessage("checkin success");
        userResponse.setIsSuccess(true);
        return userResponse;
    }
}
