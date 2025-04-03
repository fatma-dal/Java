package com.zookeeperdemo;

public class Bat extends Mammal {

	public Bat() {
		super(300);
		// TODO Auto-generated constructor stub
	}
	
	public void fly() {
		this.setEnergyLevel(getEnergyLevel()-50);
		System.out.println("the bat is airborne");
	}
	
	public void eatHumans() {
		this.setEnergyLevel(getEnergyLevel()+25);
		System.out.println("the bat has eat a human");
	}
	
	
	public void attackTown() {
		this.setEnergyLevel(getEnergyLevel()-100);
		System.out.println("the bat has attack a town");
	}
	
	
	
}
