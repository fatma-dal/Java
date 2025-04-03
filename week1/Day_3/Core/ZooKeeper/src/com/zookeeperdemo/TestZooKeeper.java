package com.zookeeperdemo;

public class TestZooKeeper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla gorilla =new Gorilla();
        Bat bat =new Bat();
        gorilla.throwSomething();
        gorilla.throwSomething();
        gorilla.throwSomething();
        gorilla.eatBananas();
        gorilla.eatBananas();
        gorilla.climb();
        gorilla.displayEnergy();

        System.out.println("**********************");
        bat.attackTown();
        bat.attackTown();
        bat.attackTown();
        bat.eatHumans();
        bat.eatHumans();
        bat.fly();
        bat.fly();
        bat.displayEnergy();
        
	}

}
