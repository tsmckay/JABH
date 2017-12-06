package edu.tsmckay.jabhgame;

public class Weapon {
	public int currentAmmo;
	public int maxAmmo;
	public int damage; //damage dealt to other units
	public int fireRate; //time in milliseconds between shots
	public double critChance;

//constructor

	public Weapon(int a, int d, int f){
		maxAmmo=a;
		currentAmmo=a; //max ammo and current ammo are both set to the same integer initially
		damage=d;
		fireRate=f; 
		critChance=(Math.random())%(.2); } //generates a random critical chance from 0-.2
	
//accessor methods
	
	public int getAmmo(){
		return currentAmmo;
	}
	
	public int getDamage(){
		return (damage);
	}
	
	public int getFireRate(){
		return fireRate;
	}
	
	public double getCritChance() {
		return critChance;
	}
	
//other methods [test edit]

	public void reload(){; 						//sets current ammunition back to full
		currentAmmo=maxAmmo;
		//some sort of delay based on fire rate
	}
	
	public void setCurrentAmmo(int a) {			//sets ammo of weapon to int a (does not change max ammo)
		currentAmmo=a;
	}
}
