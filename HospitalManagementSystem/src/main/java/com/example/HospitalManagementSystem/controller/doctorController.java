package com.example.HospitalManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.HospitalManagementSystem.model.appointment;
import com.example.HospitalManagementSystem.service.doctorService;

@Controller
@RequestMapping("/doctors")
public class doctorController {
	@Autowired
	private doctorService service;
	@GetMapping("/doctorAppointments")
	public String showDoctorAppointments(Model model) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String doctorName = authentication.getName();
//		List<appointment> doctorAppointments = service.findByDoctorName(doctorName);
//		model.addAttribute("doctorAppointments",doctorAppointments);
//		return "doctorAppointments";
//	}
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String doctorName = authentication.getName();
    List<appointment> doctorAppointments = service.findAll();
    System.out.println("Doctor's appointments: " + doctorAppointments); 
    model.addAttribute("doctorAppointments", doctorAppointments);
    return "doctorAppointments";
}
	@GetMapping("/createPrescription")
	public String createPrescription() {
		return "createPrescription";
	}

}
