package com.devicedemo;

public class Device {
	int battery;

	public Device() {
		battery=100;
	}
	
	public void status() {
		System.out.println(getBattery());
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}
}
