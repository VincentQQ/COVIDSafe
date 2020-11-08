package com.magic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 *  patient
 */

@Data
@Entity
public class Patient {
        @Id
        private Integer patientId;
        private Integer doctorId;
        private String name;
        private String gender;
        private String password;
        private String phone;
        private String address;
        private Integer age;
        private Integer status;    // 0:COVID negative 1:COVID positive 2:quarantining
    }
