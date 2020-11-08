package com.magic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 *  appointment
 */

@Data
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;
    private String patientName;
    private String doctorName;
    private Integer doctorId;
    private Integer patientId;
    private Integer status;      // 0: waiting 1: accepted 2: canceled
    private Integer type;        // 0: test  1:treatment  2:consult
    private String date;
}
