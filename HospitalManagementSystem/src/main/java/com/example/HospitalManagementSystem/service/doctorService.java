package com.example.HospitalManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HospitalManagementSystem.model.appointment;
import com.example.HospitalManagementSystem.model.doctor;
import com.example.HospitalManagementSystem.repository.appointmentRepository;
import com.example.HospitalManagementSystem.repository.doctorRepository;

@Service
public class doctorService {
	@Autowired
	private doctorRepository repository;
	@Autowired
	appointmentRepository repo;
	public List<appointment> findByDoctorName(String doctorName) {
		return repo.findByDoctorName(doctorName);
	}
	public void save(doctor doc) {
		repository.save(doc);
	}
	public List<appointment> findAll() {
		return repo.findAll();
	}
}
