package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile extends GameObject
{

	public Projectile(int x, int y, ID id)
	{
		super(x, y, id);
		
		velY = 10;
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
	
	public void fireProjectile() {}
	
	public void render(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect(x, y, 5, 5);
	}
	
	
}
