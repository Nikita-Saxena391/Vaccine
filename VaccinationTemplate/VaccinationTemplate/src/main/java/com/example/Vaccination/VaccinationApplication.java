package com.example.Vaccination;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SpringBootApplication
public class VaccinationApplication {

    public static void main(String[] args) {

        /*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

		 Tasks:
		1. Fetch context from ApplicationContext.xml and initiate Scanner.
		2. Fetch vaccine and User type choice.
		3. Get the required bean from context.
		4. Get the appointment details form user
		5. Display the appointment details
		6. Run the loop again to book for another user or else exit.
		
		 */
    	Scanner s=new Scanner(System.in);
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    	Vaccine vaccine=null;
    	User user=null;
    	System.out.println("Welcome to the Vaccination Application");
    	System.out.println("Please choose your vaccine prefference:");
    	System.out.println("1. Covid");
    	System.out.println("2. Polio");
    	System.out.println("3. Typhoid");
    	int choice=s.nextInt();
    	switch(choice) {
    	case 1:vaccine=(Vaccine) context.getBean("covid");
    	break;
    	case 2:vaccine=(Vaccine) context.getBean("polio");
    	break;
    	case 3:vaccine=(Vaccine) context.getBean("typhoid");
    	break;
    	}
    	System.out.println("Whom do you want to vaccinate?");
    	System.out.println("1. Father");
    	System.out.println("2. Mother");
    	System.out.println("3. Self");
    	System.out.println("4. Spouse");
    	System.out.println("5. Exit");
    	int choice2=s.nextInt(); 
    	switch(choice2) {
    	case 1:{
    		switch(choice) {
    		case 1:user=(User) context.getBean("fatherCovid");
    		break;
    		case 2:user=(User) context.getBean("fatherPolio");
    		break;
    		case 3:user=(User) context.getBean("fatherTyphoid");
    		break;
    		}
    		break;
    	}
    	
    		case 2:{
    			switch(choice) {
    		case 1:user=(User) context.getBean("motherCovid");
    		break;
    		case 2:user=(User) context.getBean("motherPolio");
    		break;
    		case 3:user=(User) context.getBean("motherTyphoid");
    		break;
    		}
    			break;
    		}
    		case 3:{
    			switch(choice) {
    		case 1:user=(User) context.getBean("selfCovid");
    		break;
    		case 2:user=(User) context.getBean("selfPolio");
    		break;
    		case 3:user=(User) context.getBean("selfTyphoid");
    		break;
    		}
    			break;
    		}
    		case 4:{
    			switch(choice) {
    		case 1:user=(User) context.getBean("spouseCovid");
    		break;
    		case 2:user=(User) context.getBean("spousePolio");
    		break;
    		case 3:user=(User) context.getBean("spouseTyphoid");
    		break;
    		}
    			break;
    	}
    	
    		default:System.out.println("error");
    		break;
    	}
    
    	
    
    	System.out.println("Please enter the details:");
    	System.out.println("Name:");
    	String name=s.nextLine();
    	System.out.println("Age:");
    	int age=s.nextInt();
    	s.nextLine();
    	System.out.println("Appointment date(YYYY-MM-DD:");
    	String date=s.nextLine();
    	System.out.println("Appointment time:");
    	String time=s.nextLine();
    	System.out.println("Appointment location:");
    	String loc=s.nextLine();
    	TimeAndLocation timeAndLocation=new TimeAndLocation();
    	timeAndLocation.setDetails(time, loc, date);
    	if(user!=null) {
    	user.setAppointment();
    	}
    	System.out.println("Do you want to register for someone else");
    	System.out.println("1. Yes");
    	System.out.println("2. No");
    	int c=s.nextInt();
    
    	
    		
    	
    	
    	
    	
    	
    	
    
    }
}