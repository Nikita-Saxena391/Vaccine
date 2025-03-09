package com.example.HospitalManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.HospitalManagementSystem.dto.appointmentDto;
import com.example.HospitalManagementSystem.model.appointment;
import com.example.HospitalManagementSystem.service.appointmentService;



@Controller
@RequestMapping("/patients")
public class PatientController {
	@Autowired
	private appointmentService service;
	
	
	
	@GetMapping("/myAppointments")
	public String myAppointments(Model model) {
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//String patientName = authentication.getName();
		//List<appointment> listAppointments = service.findByPat(patientName);
		List<appointment> listAppointments=service.findAllAppointments();
		model.addAttribute("listAppointments",listAppointments);
		return "myAppointments";
	}
	@GetMapping("/add")
    public String showCreateForm(appointment appointment) {
        return "add";  // Return the form view
    }

    @PostMapping("/add")
    public String createAppointment(@Valid @ModelAttribute("appointment") appointment appointment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
       
        	
            return "add";
        }
        service.save(appointment);
        return "patients";
    }
   
	
	
	@GetMapping("/cancelAppointment")
	public String cancelAppointment(Model model) {
		appointment cancelAppointment = new appointment();
		model.addAttribute("appointment",cancelAppointment);
		return "cancelAppointment";
	
	}

	@GetMapping("/updateAppointment/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        appointment appointment = service.findAppointmentById(id);
        model.addAttribute("appointmentDTO", appointment);
        return "updateAppointment";
    }

    @PostMapping("/updateAppointment")
    public String updateAppointment(@ModelAttribute("appointmentDTO") appointmentDto dto) {
        service.update(dto);
        return "redirect:/patients/myAppointments";
    }
	
}
