package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject
{
	int tickNum = 0;
	Handler handler;
	public BasicEnemy(int x, int y, ID id, Handler handler)
	{
		super(x, y, id);
		this.handler = handler;
				
		velX = (int) (Math.random()*100%10+1);
		velY = 0;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 16-2, 16-2);
	}
	
	public void fireProjectile()
	{
		handler.addObject( new Projectile(x, y, ID.Projectile));
	}

	public void tick()
	{
		x+=velX;
		y+=velY;
		
		if (y <= 0 || y >= Game.HEIGHT-32) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH-16) velX *= -1;
	}

	public void render(Graphics g)
	{
		g.setColor(Color.blue);
		g.fillRect(x, y, 16, 16);
	}
}
