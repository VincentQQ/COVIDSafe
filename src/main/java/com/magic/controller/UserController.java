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
@Api(tags = "信息管理")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户注册")     //只有Patient可以注册
    @PostMapping("/register")
    public UserResponse register(@RequestBody Patient patient){
        return userService.register(patient);
    }

    @ApiOperation("用户登录")     //统一用id标示账号
    @PostMapping("/login")
    public UserResponse login(@RequestParam Integer id, @RequestParam String password, @RequestParam Integer role){
        return userService.login(id, password, role);
    }

    //前端用跳转逻辑处理登出

    @ApiOperation("用户信息编辑")   //编辑之前先查找，填充在空中，再返回完整Patient
    @PostMapping({"/editPatient"})
    public Boolean edit(@RequestBody Patient patient)
    {
        return userService.editPatient(patient);
    }

    @ApiOperation("医生信息编辑")     //编辑之前先查找，填充在空中，再返回完整Doctor
    @PostMapping({"/editDoctor"})
    public Boolean edit(@RequestBody Doctor doctor)
    {
        return userService.editDoctor(doctor);
    }

    @ApiOperation("查找用户")
    @PostMapping({"/searchPatient"})
    public Patient searchPatient(@RequestParam Integer patientId)
    {
        return userService.searchPatient(patientId);
    }

    @ApiOperation("查找医生")
    @PostMapping({"/searchDoctor"})
    public Doctor searchDoctor(@RequestParam Integer doctorId)
    {
        return userService.searchDoctor(doctorId);
    }
}


