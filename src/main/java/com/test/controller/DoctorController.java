package com.test.controller;


import com.test.Bean.UserRequest;
import com.test.Bean.UserResponse;
import com.test.dao.DoctorDao;
import com.test.domain.Doctor;
import com.test.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/login")
    @ResponseBody
    public int DoctorLogin (){

        //test data
        UserRequest userRequest = new UserRequest();
        userRequest.setName("YY");
        userRequest.setPassword("123");

        UserResponse userResponse = doctorService.login(userRequest);
        return userResponse.getIfSuccess();
    }

}
