package edu.tsmckay.jabhgame;

public class Enemy {
	
	//class definition
	public int enemyHealth;
	public Weapon enemyWeapon;
	public drawComponent drawEnemy;
	
	//constructor
	public Enemy(int h, Weapon w, int s) {		//create ship with health "h" and weapon "w"
		enemyHealth=h; enemyWeapon=w;
		
		//set size of enemy based on int s (scale from 1-10)
		int defaultX=0; int defaultY=0;
		s=s%10;
		enemyRect = new Rectangle(10*s, 10*s, x, y);
	}
	
	//accessors
	public int getHealth() {	//return health
		return enemyHealth;
	}
	
	public Weapon getWeapon() {		//return weapon. not sure if useful
		return enemyWeapon;
	}
	
}
	