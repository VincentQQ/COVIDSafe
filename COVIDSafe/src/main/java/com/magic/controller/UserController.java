package com.magic.controller;

import com.magic.Bean.UserResponse;
import com.magic.domain.Doctor;
import com.magic.domain.Patient;
import com.magic.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "Information management")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("Patient register")     //Only patients can register
    @PostMapping("/register")
    public UserResponse register(@RequestBody Patient patient){
        return userService.register(patient);
    }

    @ApiOperation("User login")     //ID is used to mark the account number
    @PostMapping("/login")
    public UserResponse login(@RequestParam Integer id, @RequestParam String password, @RequestParam Integer role){
        return userService.login(id, password, role);
    }

    //The front end processes logout with jump logic

    @ApiOperation("Edit patient information")
    @PostMapping({"/editPatient"})
    public Boolean edit(@RequestBody Patient patient)
    {
        return userService.editPatient(patient);
    }

    @ApiOperation("Edit doctor information")
    @PostMapping({"/editDoctor"})
    public Boolean edit(@RequestBody Doctor doctor)
    {
        return userService.editDoctor(doctor);
    }

    @ApiOperation("Search patient")
    @PostMapping({"/searchPatient"})
    public Patient searchPatient(@RequestParam Integer patientId)
    {
        return userService.searchPatient(patientId);
    }

    @ApiOperation("Search doctor")
    @PostMapping({"/searchDoctor"})
    public Doctor searchDoctor(@RequestParam Integer doctorId)
    {
        return userService.searchDoctor(doctorId);
    }
}


