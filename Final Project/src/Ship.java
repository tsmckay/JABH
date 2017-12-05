
public class Ship {
	
	public int shipHealth;
	public Weapon shipWeapon;

//constructors

	Ship(int h) {				//constructor for ship w/out weapon
		int shipHealth=h;
	}
	
	Ship(int h, weapon w){
		int shipHealth=h;			//overloaded constructor for ship w/ weapon
		weapon shipWeapon=w;
	}
	
	
//accessors
	
	public void getHealth() {
		return shipHealth;
	}
	
	public void getWeapon() {
		return shipWeapon;
	}
	
//other methods
	
	public int dealDamage() {
		if (Math.random()<critChance) return 1.5*shipWeapon.getDamage();
		return shipWeapon.getDamage();
	}
	
}
