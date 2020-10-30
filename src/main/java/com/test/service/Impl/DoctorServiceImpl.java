package com.test.service.Impl;

import com.test.Bean.UserRequest;
import com.test.Bean.UserResponse;
import com.test.dao.DoctorDao;
import com.test.domain.Doctor;
import com.test.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorDao doctorDao;

    /**
     * Doctor login
     * -1 means information incorrect
     * 0 means do not fill in the complete username and password
     * 1 means match successfully
     * @param userRequest
     * @return
     */

    @Override
    public UserResponse login (UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        userResponse.setIfSuccess(-1);
        if(StringUtils.isEmpty(userRequest.getName()) ||StringUtils.isEmpty(userRequest.getPassword())){
            userResponse.setIfSuccess(0);
        }
        Doctor doctor = doctorDao.findByName(userRequest.getName());
        if(userRequest.getPassword().equals(doctor.getPassword())){
            userResponse.setIfSuccess(1);
        }
        return userResponse;
    }

}
