package com.zookeeperdemo;

public class Gorilla extends Mammal {

	public Gorilla() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void throwSomething() {
		this.setEnergyLevel(getEnergyLevel()-5);
		System.out.println("the gorilla has thrown something");
	}
	
	public void eatBananas() {
		this.setEnergyLevel(getEnergyLevel()+10);
		System.out.println("the gorilla has eat a banana");
	}
	
	public void  climb() {
		this.setEnergyLevel(getEnergyLevel()-10);
		System.out.println("the gorilla has climbed a tree");
	}
}
