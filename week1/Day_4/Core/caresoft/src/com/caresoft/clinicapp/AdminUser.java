package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer employeeID, String role) {
		this.employeeID = employeeID;
		this.setId(employeeID);
		this.role = role;
		this.securityIncidents=new ArrayList<String>();
	}
    // TO DO: Implement HIPAACompliantUser!
    

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		if(String.valueOf(pin).length() == 6) {
			this.setPin(pin);
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if(confirmedAuthID!=this.id) {
			this.authIncident();
			return false;
		}else {
			return true;
		}
	}
	
    // TO DO: Implement HIPAACompliantAdmin!
	
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return this.securityIncidents;
	}
	
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
	public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

	

	
    
    // TO DO: Setters & Getters
}
