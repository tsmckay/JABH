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
		x += velX;
		y += velY;	//responsible for moving object
		
		x = Game.clamp(x, 0, Game.WIDTH-38);
		y = Game.clamp(y, 0, Game.HEIGHT-61);
		
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
					HUD.HEALTH-=3;
				}
			}
		}
	}
	
	public void fireProjectile() {}
	

	public void render(Graphics g)
	{
		g.setColor(Color.green);
		g.fillRect(x, y, 32, 32);
	}

}