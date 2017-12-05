//weapon class
public class Weapon {
	public int currentAmmo;
	public int maxAmmo;
	public int damage; //damage dealt to other units
	public int fireRate; //time in milliseconds between shots

//constructor for weapon class
////////////////////////////////////////
	Weapon(int a, int d, int f){
		maxAmmo=a;
		currentAmmo=a;
		damage=d;
		fireRate=f; }
////////////////////////////////////////
	
//accessor methods
////////////////////////////////////////
	public int getAmmo(){
		return currentAmmo;
	}
	
	public int getDamage(){
		return (damage);
	}
	
	public int getFireRate(){
		return fireRate;
	}
////////////////////////////////////////
	
//other methods
////////////////////////////////////////
	public void reload(){
		currentAmmo=maxAmmo; 	//sets current ammunition back to full
	}
////////////////////////////////////////
}
