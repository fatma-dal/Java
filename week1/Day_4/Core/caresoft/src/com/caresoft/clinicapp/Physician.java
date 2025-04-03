package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	
	// TO DO: Constructor that takes an IDcopy
	public Physician(Integer Idcopy) {
		this.setId(Idcopy);
	}
    // TO DO: Implement HIPAACompliantUser!
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		if(String.valueOf(pin).length() == 4) {
			this.setPin(pin);
			return true;
		}else {
			return false;
		}
	}
		
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		return confirmedAuthID == this.getId();
	}
	
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	// TO DO: Setters & Getters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
  
}
