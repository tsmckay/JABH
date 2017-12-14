package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Rectangle;

public class Player extends GameObject
{

	Handler handler;
	public Player(int x, int y, ID id, Handler handler)
	{
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 32-4, 32-4);
	}

	public void tick()
	{
		x = (x+velX)%Game.WIDTH;
		y = (y+velY)%Game.HEIGHT;	//responsible for moving object
		
		if (x < 0)
		{
			x+=Game.WIDTH;
		}
		
		if (y < 0)
		{
			y+=Game.HEIGHT;
		}
		
		collision();
	}
	
	private void collision()
	{
		for (int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.Projectile)
			{
				if (getBounds().intersects( tempObject.getBounds() ) )
				{
					HUD.HEALTH-=20;
					handler.removeObject(tempObject);
				}
			}
		}
	}
	
	public void fireProjectile()
	{
		handler.addObject( new Projectile(x, y, ID.Projectile, -10, Color.white, -5));
	}
	

	public void render(Graphics g)
	{
		g.setColor(Color.green);
		g.fillRect(x, y, 32, 32);
	}

}