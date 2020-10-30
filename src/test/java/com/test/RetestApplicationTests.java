package com.test;

import com.test.dao.DoctorDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RetestApplicationTests {

    @Autowired
    DoctorDao doctorDao;

    @Test
    void contextLoads() {
        System.out.println(1);
    }

}
