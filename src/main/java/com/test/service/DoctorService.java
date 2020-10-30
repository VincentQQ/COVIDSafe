package com.test.service;

import com.test.Bean.UserRequest;
import com.test.Bean.UserResponse;

public interface DoctorService {
    UserResponse login (UserRequest userRequest);
}
