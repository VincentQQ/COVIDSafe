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
@Api(tags = "用户健康功能")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @ApiOperation("关联医生回填") //如果有关联医生id，自动填充；无关联医生id，返回0
    @PostMapping("/matchDoctor")
    public Integer matchDoctor(@RequestParam Integer patientId){
        return patientService.matchDoctor(patientId);
    }

    @ApiOperation("预约医生")  //预约后刷新查看预约列表，App状态waiting
    @PostMapping("/request")
    public List<Appointment> request(@RequestParam Integer patientId, @RequestParam Integer doctorId,
                                     @RequestParam String date, @RequestParam Integer type){
        return patientService.request(patientId, doctorId, date, type);
    }

    @ApiOperation("查看预约")
    @PostMapping("/checkApp")
    public List<Appointment> checkApp(@RequestParam Integer patientId){
        return patientService.checkApp(patientId);
    }

    @ApiOperation("取消预约")  //预约后刷新查看预约列表，App状态canceled
    @PostMapping("/cancel")
    public Boolean cancel(@RequestParam Integer appointmentId){
        return patientService.cancel(appointmentId);
    }

    @ApiOperation("健康打卡") //打卡后status同步到 Patient
    @PostMapping("/checkin")
    public UserResponse ckeckin( @RequestBody State state){
        return patientService.checkin(state);
    }
}
