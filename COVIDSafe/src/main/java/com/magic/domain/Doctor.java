package com.magic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 *  doctor
 */

@Data
@Entity
public class Doctor {
    @Id
    private Integer doctorId;
    private String name;
    private String gender;
    private String email;
    private String password;
    private String phone;


}
