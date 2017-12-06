package edu.tsmckay.jabhgame;

public class Ship {
	
	public int shipHealth;
	public Weapon shipWeapon;
	public drawComponent drawShip;

//constructors

	public Ship(int h, Weapon w) {
		int shipHealth=h;
		Weapon shipWeapon=w;
	}
	
	
//accessors
	
	public int getHealth() {
		return shipHealth;
	}
	
	public Weapon getWeapon() {
		return shipWeapon;
	}
	
//other methods
	
	public double dealDamage() {	//deals normal damage or 1.5x damage with a probability of critChance
		if (Math.random()<shipWeapon.getCritChance())
			return 1.5*shipWeapon.getDamage();
		return shipWeapon.getDamage();
	}
	
}
