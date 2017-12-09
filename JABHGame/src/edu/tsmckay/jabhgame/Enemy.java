package edu.tsmckay.jabhgame;
import java.awt.Rectangle;

////////////////////////////////////////////////////////// test edit /////////////

public class Enemy
{
	
	public int enemyHealth;
	public Weapon enemyWeapon;
	

	public Enemy(int h, Weapon w, int s)
	{
		enemyHealth=h; enemyWeapon=w;
	}
	
	public int getHealth()
	{
		return enemyHealth;
	}
	
	public Weapon getWeapon()
	{
		return enemyWeapon;
	}
	
}
	