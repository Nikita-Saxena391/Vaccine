package com.example.HospitalManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.HospitalManagementSystem.model.prescription;
import com.example.HospitalManagementSystem.service.PrescriptionService;
import com.example.HospitalManagementSystem.service.appointmentService;



@Controller
@RequestMapping("/patients")
public class PrescriptionController {
	@Autowired
	private PrescriptionService service;
	
	@Autowired
	private appointmentService service1;
	
	@GetMapping("/viewPrescription")
	public String viewPrescription(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String patientName = auth.getName();
		List<prescription> prescriptions = service.findAll();
		model.addAttribute("prescriptions",prescriptions);
		return"viewPrescription";
	}
	
	
	@PostMapping("/savePrescription")
	public String saveProduct(@ModelAttribute("prescription") prescription prescription,
			BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes
			) {
		Integer id= prescription.getAppointmentID();
		service1.setPrescription("prescribed", id);
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String doctorName = auth.getName();
	prescription.setDoctorName(doctorName);
	   service.save(prescription);
	   String message = "Prescription was successfully saved ";
	   redirectAttributes.addFlashAttribute("message", message);
	   redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	   return "redirect:/patients/viewPrescription";
}

}
