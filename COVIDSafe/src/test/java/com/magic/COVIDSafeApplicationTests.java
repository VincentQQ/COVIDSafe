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



}
