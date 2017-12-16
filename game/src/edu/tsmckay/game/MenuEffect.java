package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MenuEffect extends GameObject
{
	/*
	 * This class is a copy of the BasicEnemy class with some code removed
	 * They do not fire projectiles
	 * They initialize with one of three random colors
	 * They have no collision
	 */
	
	
	//counts ticks, used to fire projectiles at semi-random intervals
	int tickNum = 0;
	
	//new handler
	Handler handler;
	
	Color[] colors = { Color.RED, Color.BLUE, Color.GREEN };
	Color color = colors[ (int) ( 3 * Math.random()) ];
	
	//constructor for enemy
	public MenuEffect(int x, int y, ID id, Handler handler)
	{
		super(x, y, id);
		this.handler = handler;
		
		//randomizes x velocity to a value between 1 and 11
		velX = (int) (Math.random()*100%10+1);
		velY = (int) (Math.random()*100%10+1);
	}
	
	public Rectangle getBounds()
	{
		return null;
	}
	
	public void fireProjectile()
	{
	}

	private void collision()
	{
	}

	public void tick()
	{
		//adds velocities to current location
		x+=velX;
		y+=velY;
		
		//reverses enemies location when it hits a wall
		if (y <= 0 || y >= Game.HEIGHT-32) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH-16) velX *= -1;
		
		//runs collision check
		collision();
	}

	public void render(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x, y, 32, 32);
	}

	//useless inherited methods
	public boolean fromPlayer() {
		return false;
	}

	public int getDamage() {
		return 0;
	}
}
