package com.magic.controller;

import com.magic.domain.Appointment;
import com.magic.domain.Patient;
import com.magic.domain.State;
import com.magic.service.DoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
@Api(tags = "Doctor Function")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @ApiOperation("Check related patients")       //Display base information + base status
    @PostMapping("/checkPatient")
    public List<Patient> checkPatient(@RequestParam Integer doctorId){
        return doctorService.checkPatient(doctorId);
    }

    @ApiOperation("Add related patients")   //Refresh the patients list after adding
    @PostMapping("/addPatient")
    public List<Patient> addPatient(@RequestParam Integer patientId, @RequestParam Integer doctorId){
        return doctorService.addPatient(patientId, doctorId);
    }

    @ApiOperation("Delete related patients")   //Refresh the patients list after deleting
    @PostMapping("/deletePatient")
    public List<Patient> deletePatient(@RequestParam Integer patientId, @RequestParam Integer doctorId){
        return doctorService.deletePatient(patientId, doctorId);
    }

    @ApiOperation("Check patients state") //Detailed states
    @PostMapping("/checkDetail")
    public Map<String,State> checkDetail(@RequestParam Integer patientId){
        return doctorService.ckeckDetail(patientId);
    }

    @ApiOperation("Edit patients states") //
    @PostMapping("/editDetail")
    public State editDetail(@RequestBody State state){
        return doctorService.editDetail(state);
    }

    @ApiOperation("Check appointment")
    @PostMapping("/checkApp")
    public List<Appointment> checkApp(@RequestParam Integer doctorId){
        return doctorService.checkApp(doctorId);
    }

    @ApiOperation("Confirm appointment") // Appointment condition accepted
    @PostMapping("/confirm")
    public Boolean confirm(@RequestParam Integer appointmentId){
        return doctorService.confirmApp(appointmentId);
    }

    @ApiOperation("Cancel appointment") // Appointment condition canceled
    @PostMapping("/cancel")
    public Boolean cancel(@RequestParam Integer appointmentId){
        return doctorService.cancelApp(appointmentId);
    }


}
