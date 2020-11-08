package com.magic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 *  condition
 */

@Data
@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int conditionId;
    private int patientId;
    private Integer status;    // 0:quarantining 1:COVID positive 2:well
    private float temperature;
    private boolean vomit;
    private boolean cold;
    private boolean dizzy;
    private boolean nauseous;
    private boolean hardToBreath;
    private String other;
}
