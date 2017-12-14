package edu.tsmckay.game;

import java.awt.Graphics;
import java.util.LinkedList;

//maintains, updates, and renders all game objects individually

//basically, this runs through each instance of the GameObject class and performs two operations for each one: tick and render

public class Handler 
{

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick()
	{
		for (int i = 0; i <object.size(); i++)	//loops through all game objects
		{
			GameObject tempObject = object.get(i); //sets working object to the #i object in list
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g)
	{
		for (int i = 0; i <object.size(); i++)
		{
			GameObject tempObject = object.get(i); //sets working object to the #i object in list

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
	
}
