package com.test.dao;

import com.test.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorDao extends JpaRepository<Doctor,Integer> {

      Doctor findByName(String name);
}
