package com.test.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patient_id;
    private int doctor_id;
    private String name;
    private String gender;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String emergency_contact;
    private int dob;
    private int status;    // 0:quarantining 1:COVID positive 2:well
    private float height;
    private float weight;

}
