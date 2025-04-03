package com.zookeeperdemo;

public class Mammal {
	int energyLevel;

	public Mammal() {
		energyLevel=100;
	}
	
	
	
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}



	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	public int  displayEnergy() {
		System.out.println("your energy level : "+ energyLevel);
		return energyLevel;
	}
	
}
