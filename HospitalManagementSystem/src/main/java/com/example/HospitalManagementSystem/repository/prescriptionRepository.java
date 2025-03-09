package com.example.HospitalManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HospitalManagementSystem.model.prescription;

@Repository
public interface prescriptionRepository extends JpaRepository<prescription,Long> {
	public List<prescription> findByPatientName(String patientName);
	public List<prescription> findAll();

}
