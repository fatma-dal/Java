package com.devicedemo;

public class Phone extends Device {

	public Phone() {
		super();
	}
	
	public void makeCall() {
		this.setBattery(this.getBattery()-5);
		System.out.println("your bettery level : "+this.getBattery());
	}
	
	public void playGame() {
		this.setBattery(this.getBattery()-20);
		System.out.println("your bettery level : "+this.getBattery());
	}
	
	public void charge() {
		this.setBattery(this.getBattery()+50);
		System.out.println("your bettery level : "+this.getBattery());
	}
	
}
