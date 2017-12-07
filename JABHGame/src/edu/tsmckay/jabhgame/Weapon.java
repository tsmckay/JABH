package edu.tsmckay.jabhgame;

///////////////////////////////////////////////

public class Weapon
{
	public int currentAmmo;
	public int maxAmmo;
	public int damage;
	public int fireRate;
	public double critChance;


	public Weapon(int a, int d, int f)
	{
		maxAmmo=a;
		currentAmmo=a;
		damage=d;
		fireRate=f; 
		critChance=(Math.random())%(.2); 
	}
	
	
	public int getAmmo()
	{
		return currentAmmo;
	}
	
	public int getDamage()
	{
		return (damage);
	}
	
	public int getFireRate()
	{
		return fireRate;
	}
	
	public double getCritChance()
	{
		return critChance;
	}
	

	public void reload()
	{
		currentAmmo=maxAmmo;
	}
	
	public void setCurrentAmmo(int a)
	{
		currentAmmo=a;
	}
}
