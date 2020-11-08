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
@Api(tags = "医生功能")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @ApiOperation("查看医生关联用户")       //展示 基础信息+基础状态(status)
    @PostMapping("/checkPatient")
    public List<Patient> checkPatient(@RequestParam Integer doctorId){
        return doctorService.checkPatient(doctorId);
    }

    @ApiOperation("增加关联用户")   //增加后刷新关联用户列表
    @PostMapping("/addPatient")
    public List<Patient> addPatient(@RequestParam Integer patientId, @RequestParam Integer doctorId){
        return doctorService.addPatient(patientId, doctorId);
    }

    @ApiOperation("删除关联用户")   //删除后刷新关联用户列表
    @PostMapping("/deletePatient")
    public List<Patient> deletePatient(@RequestParam Integer patientId, @RequestParam Integer doctorId){
        return doctorService.deletePatient(patientId, doctorId);
    }

    @ApiOperation("查看用户状态详情") //详细状态State
    @PostMapping("/checkDetail")
    public Map<String,State> checkDetail(@RequestParam Integer patientId){
        return doctorService.ckeckDetail(patientId);
    }

    @ApiOperation("编辑用户状态详情") // 查看，填充State基础上
    @PostMapping("/editDetail")
    public State editDetail(@RequestBody State state){
        return doctorService.editDetail(state);
    }

    @ApiOperation("查看预约")
    @PostMapping("/checkApp")
    public List<Appointment> checkApp(@RequestParam Integer doctorId){
        return doctorService.checkApp(doctorId);
    }

    @ApiOperation("确认预约") // App状态accepted
    @PostMapping("/confirm")
    public Boolean confirm(@RequestParam Integer appointmentId){
        return doctorService.confirmApp(appointmentId);
    }

    @ApiOperation("取消预约") // App状态canceled
    @PostMapping("/cancel")
    public Boolean cancel(@RequestParam Integer appointmentId){
        return doctorService.cancelApp(appointmentId);
    }


}
