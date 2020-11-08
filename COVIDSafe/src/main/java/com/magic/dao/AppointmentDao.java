package com.magic.dao;

import com.magic.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Integer> {
    Appointment findByAppointmentId(Integer id);
    List<Appointment> findByPatientId(Integer id);
    List<Appointment> findByDoctorId(Integer id);
}
