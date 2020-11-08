package com.magic.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.magic.Bean.UserResponse;
import com.magic.dao.DoctorDao;
import com.magic.dao.PatientDao;
import com.magic.domain.Doctor;
import com.magic.domain.Patient;
import com.magic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    /**
     *
     * @param patient
     * @return
     */
    @Override
    public UserResponse register(Patient patient) {
        UserResponse response = new UserResponse();
        response.setIsSuccess(false);
        if(patient.getPatientId() == null || StringUtil.isEmpty(patient.getName())||StringUtil.isEmpty(patient.getPassword()))
        {
            response.setMessage("Please complete all important blank");
            return response;
        }
        patientDao.save(patient);
        response.setMessage("Register success");
        response.setIsSuccess(true);
        return response;
    }

    /**
     *
     * @param id,password,role
     * @return
     */
    @Override
    public UserResponse login(Integer id, String password, Integer role) {
        UserResponse response = new UserResponse();
        response.setIsSuccess(false);
        if (id == null || StringUtil.isEmpty(password)) {
            response.setMessage("Account or password cannot be empty！");
            return response;
        }
        if(role == null){
            response.setMessage("Please select your role！");
            return response;
        }
        if (role == 0) {
            Patient patient = patientDao.findByPatientId(id);
            if (password.equals(patient.getPassword())) {
                response.setMessage("Login success");
                response.setIsSuccess(true);
                return response;
            } else {
                response.setMessage("Id or password error");
                return response;
            }

        }
        if (role == 1) {
            Doctor doctor = doctorDao.findByDoctorId(id);
            if (password.equals(doctor.getPassword())) {
                response.setMessage("Login success");
                response.setIsSuccess(true);
                return response;
            } else {
                response.setMessage("Id or password error");
                return response;
            }
        }
        return response;
    }

    /**
     *
     * @param patient
     * @return
     */
    @Override
    public Boolean editPatient(Patient patient) {
        patientDao.delete(patientDao.findByPatientId(patient.getPatientId()));
        patientDao.save(patient);
        return true;
    }

    /**
     *
     * @param doctor
     * @return
     */
    @Override
    public Boolean editDoctor(Doctor doctor) {
        doctorDao.delete(doctorDao.findByDoctorId(doctor.getDoctorId()));
        doctorDao.save(doctor);
        return true;
    }

    /**
     *
     * @param patientId
     * @return
     */
    @Override
    public Patient searchPatient(Integer patientId) {
            return patientDao.findByPatientId(patientId);
        }

    /**
     *
      * @param doctorId
     * @return
     */
    @Override
    public Doctor searchDoctor(Integer doctorId) {
        return doctorDao.findByDoctorId(doctorId);
    }

}

