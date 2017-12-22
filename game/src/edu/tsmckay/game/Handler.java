package edu.tsmckay.game;

import java.awt.Graphics;
import java.util.LinkedList;

/*
 * maintains, updates, and renders all game objects individually
 * basically, this runs through each instance of the GameObject
 * class and performs two operations for each one: tick and render
 */

public class Handler 
{
	
	//creates a list of objects
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	//starts number of ticks at zero
	int tickNum = 0;
	
	public void tick()
	{
		//loops through all game objects
		for (int i = 0; i <object.size(); i++)
		{
			//sets working object to the #i object in list
			GameObject tempObject = object.get(i);
			
			//randomly fires projectiles from enemy objects
			if (tickNum % (int)(Math.random()*200+1) == 0 && tempObject.getId() == ID.Enemy && Math.random() < .8)
			{
				tempObject.fireProjectile();
			}
			
			//ticks object i
			tempObject.tick();
			
			//removes object if it is out of bounds
			if (tempObject.getY() > Game.HEIGHT+10)
			{
				object.remove(i);
			}
		}
		

		
		//iterates number of ticks
		tickNum++;
		
	}
	
	public void render(Graphics g)
	{
		//loops through all objects
		for (int i = 0; i <object.size(); i++)
		{
			//sets working object to the #i object in list
			GameObject tempObject = object.get(i);
			
			//renders object i
			tempObject.render(g);
		}
	}
	
//remove or add object to list of GameObjects
	
	public void addObject(GameObject object)
	{
		this.object.add(object);
	}
	
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}
	
	public int getTickNum()
	{
		return tickNum;
	}
	
}
