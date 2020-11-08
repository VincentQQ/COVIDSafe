package com.magic.dao;

import com.magic.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientDao extends JpaRepository<Patient,Integer> {
    List<Patient> findByDoctorId(Integer id);
    Patient findByPatientId(Integer id);
}
