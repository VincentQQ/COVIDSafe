package com.magic;


import com.magic.dao.PatientDao;
import com.magic.dao.StateDao;
import com.magic.domain.Patient;
import com.magic.domain.State;
import com.magic.service.DoctorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class COVIDSafeApplicationTests {

    @Autowired
    PatientDao patientDao;

    @Autowired
    StateDao stateDao;

    @Autowired
    DoctorService doctorService;

    @Test
    void contextLoads() {
        System.out.println(1);
    }

    @Test
    void checkmessage(){
        Optional<Patient> optional = patientDao.findById(1001);
        Patient patient = optional.get();
        System.out.println(patient.getAddress());
    }

    @Test
    void currentPatients(){
//        List<Patient> list = patientDao.findByDoctorid(123);
//        int n = list.size();
//        Patient[] patients = new Patient[100];
//        for(int i=0;i<n;i++){
//            patients[i]=list.get(i);
//        }
//        System.out.println(patients[0].getPatientid());
//        System.out.println(patients[1].getPatientid());
//        //System.out.println(n);


    }
}
