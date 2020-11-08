package com.magic.controller;


import com.magic.Bean.UserResponse;
import com.magic.domain.Appointment;
import com.magic.domain.Patient;
import com.magic.domain.State;
import com.magic.service.PatientService;
import com.magic.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/patient")
@Api(tags = "Patient health function")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @ApiOperation("Associated doctors backfill") //If there is an associated doctor ID, it will be filled automatically; if there is no associated doctor ID, it will return 0
    @PostMapping("/matchDoctor")
    public Integer matchDoctor(@RequestParam Integer patientId){
        return patientService.matchDoctor(patientId);
    }

    @ApiOperation("Request an appointment")  //Refresh and view the appointment list after appointment, and the app status is waiting
    @PostMapping("/request")
    public List<Appointment> request(@RequestParam Integer patientId, @RequestParam Integer doctorId,
                                     @RequestParam String date, @RequestParam Integer type){
        return patientService.request(patientId, doctorId, date, type);
    }

    @ApiOperation("Check appointment")
    @PostMapping("/checkApp")
    public List<Appointment> checkApp(@RequestParam Integer patientId){
        return patientService.checkApp(patientId);
    }

    @ApiOperation("Cancel appointment")  //Refresh and view the appointment list after appointment, and the app status is cancelled
    @PostMapping("/cancel")
    public Boolean cancel(@RequestParam Integer appointmentId){
        return patientService.cancel(appointmentId);
    }

    @ApiOperation("Health check-in") //Status is synchronized to patient after clock in
    @PostMapping("/checkin")
    public UserResponse ckeckin( @RequestBody State state){
        return patientService.checkin(state);
    }
}
