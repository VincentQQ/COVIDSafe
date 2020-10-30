package com.test.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctor_id;
    private String name;
    private String gender;
    private String email;
    private String password;
    private String phone;

}
