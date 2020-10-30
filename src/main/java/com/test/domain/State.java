package com.test.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name="State")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int condition_id;
    private Date date;
    private float temperature;
    private boolean vomit;
    private boolean cold;
    private boolean dizzy;
    private boolean nauseous;
    private boolean hard_to_breath;
    private String other;

}