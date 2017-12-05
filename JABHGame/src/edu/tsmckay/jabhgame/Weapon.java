public class Weapon {
	public int currentAmmo;
	public int maxAmmo;
	public int damage; //damage dealt to other units
	public int fireRate; //time in milliseconds between shots

//constructor

	Weapon(int a, int d, int f){
		maxAmmo=a;
		currentAmmo=a;
		damage=d;
		fireRate=f; }
	
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
	
//other methods

	public void reload(){; 						//sets current ammunition back to full
		currentAmmo=maxAmmo;
		//some sort of delay based on fire rate
	}
	
	public void setCurrentAmmo(int a) {			//sets ammo of weapon to int a (does not change max ammo)
		currentAmmo=a;
	}
}
