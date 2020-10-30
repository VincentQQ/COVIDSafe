package com.test.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name="appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Appointment_id;
    private int doctor_id;
    private int patient_id;
    private int status;      // 0: waiting 1: accepted 2: rejected
    private int type;        // 0: test检测     1:treatment治疗
    private Date date;
}
