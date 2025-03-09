package com.example.HospitalManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HospitalManagementSystem.model.prescription;
import com.example.HospitalManagementSystem.repository.prescriptionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PrescriptionService {
	@Autowired
	private prescriptionRepository repository;
	public List<prescription> findByPatientName(String patientName){
		return repository.findByPatientName(patientName);
	}
	public void save(prescription Prescription) {
		repository.save(Prescription);
	}
	public List<prescription> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
