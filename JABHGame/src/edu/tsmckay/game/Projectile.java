package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile extends GameObject
{
	Color color;
	int offset;
	String type;
	public Projectile(int x, int y, ID id, int vel, Color c, int offset)
	{
		super(x, y+offset, id);
		
		velY = vel;
		color = c;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 5, 5);
	}

	public void tick()
	{
		x += velX;
		y += velY;
	}
	
	public void fireProjectile() {} //useless method
	
	public void render(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x, y, 5, 5);
	}
	
	
}
