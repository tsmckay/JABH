package edu.tsmckay.jabhgame;

////////////////////////////////////////

public class Ship
{
	public int shipHealth;
	public Weapon shipWeapon;


	public Ship(int h, Weapon w)
	{
		int shipHealth=h;
		Weapon shipWeapon=w;
	}
	
	
	public int getHealth()
	{
		return shipHealth;
	}
	
	public Weapon getWeapon()
	{
		return shipWeapon;
	}
	
	
	public double dealDamage() 
	{
		if (Math.random()<shipWeapon.getCritChance())
			return 1.5*shipWeapon.getDamage();
		return shipWeapon.getDamage();
	}
}
