package edu.tsmckay.game;

import java.awt.Graphics;
import java.awt.Rectangle;

//any and all game objects (players, enemies, etc.)

public abstract class GameObject
{
	
	protected int x, y; //accessible by all objects that inherit the GameObject class
	protected ID id; //identifier for GameObject
	protected int velX, velY; //velocity in x and y directions
	
	public GameObject(int x, int y, ID id)	//sets location and identifier of game object
	{
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();	//tick method that all game objects require
	public abstract void render(Graphics g);	//rendering method that all game objects require
	public abstract Rectangle getBounds();	//returns object bounds, useful for collision
	public abstract void fireProjectile();	//fires projectile from object
	public abstract boolean fromPlayer();
	public abstract int getDamage();
	
//getter and setter methods
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setId(ID id)
	{
		this.id = id;
	}
	
	public ID getId()
	{
		return id;
	}
	
	public void setVelX(int vel)
	{
		this.velX = vel;
	}
	
	public void setVelY(int vel)
	{
		this.velY = vel;
	}
	
	public int getVelX()
	{
		return velX;
	}
	
	public int getVelY()
	{
		return velY;
	}

}
