package com.test.Bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UserRequest {
    private String name;
    private String password;
    private Integer role; // 0:patient, 1:doctor
}
