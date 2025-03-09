package com.example.HospitalManagementSystem.model;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="appointment",schema="hospital")
@DynamicUpdate
public class appointment {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private Integer appointment_id;
	//@Column(name="patient_Name")
	//private String patientName;
	//@Column(name="doctor_name")
	//private String doctorName;
	@Column(name="appointment_date")
	private String date;
	@Column(name="prescription")
	private String prescription;
	@Column(name="confirmed")
	private String confirmed;
	 @javax.validation.constraints.NotNull(message = "Patient name cannot be null")
	    @Size(min = 1, max = 100, message = "Patient name must be between 1 and 100 characters")
	 @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Patient name must contain only letters and spaces")
	    
	    @Column(name = "patient_name")
	    private String patientName;

	    @javax.validation.constraints.NotNull(message = "Doctor name cannot be null")
	    @Size(min = 1, max = 100, message = "Doctor name must be between 1 and 100 characters")
	    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Doctor name must contain only letters and spaces")
	    @Column(name = "doctor_name")
	    private String doctorName;
public appointment() {
		
	}
	@Override
	public String toString() {
		return "appointment [appointment_id=" + appointment_id + ", patientName=" + patientName + ", doctorName="
				+ doctorName + ", date=" + date + ", prescription=" + prescription + ", confirmed=" + confirmed + "]";
	}
	public appointment(Integer appointment_id, String patientName, String doctorName, String date, String prescription,
			String confirmed) {
		super();
		this.appointment_id = appointment_id;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.date = date;
		this.prescription = prescription;
		this.confirmed = confirmed;
	}
	public Integer getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(Integer appointment_id) {
		this.appointment_id = appointment_id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public String getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
	
	

}
