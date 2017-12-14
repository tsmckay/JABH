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
		handler.addObject( new Projectile(x, y, ID.Projectile, 5, Color.red, 25));
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
					setY(Game.HEIGHT+200);
					handler.removeObject(tempObject);
				}
			}
		}
	}

	public void tick()
	{
		x+=velX;
		y+=velY;
		
		if (y <= 0 || y >= Game.HEIGHT-32) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH-16) velX *= -1;
		
		collision();
	}

	public void render(Graphics g)
	{
		g.setColor(Color.blue);
		g.fillRect(x, y, 16, 16);
	}
}
