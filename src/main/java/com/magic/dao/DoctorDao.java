package com.magic.dao;

import com.magic.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDao extends JpaRepository<Doctor,Integer> {
    Doctor findByDoctorId(Integer id);
}
