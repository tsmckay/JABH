package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Boss extends GameObject
{
	//counts ticks, used to fire projectiles at semi-random intervals
	int tickNum = 0;
	
	//new handler
	Handler handler;
	
	//constructor for enemy
	public Boss(int x, int y, double scale, ID id, Handler handler)
	{
		super(x, y, scale, id);
		this.handler = handler;
		
		//randomizes x velocity to a value between 1 and 11
		velX = (int) (Math.random()*100%4+1);
		velY = 0;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, (int)(Game.WIDTH*scale), (int)(Game.WIDTH*scale));
	}
	
	//fires cyan projectile of size 30
	public void fireProjectile()
	{
		handler.addObject( new Projectile(x, y, 0, ID.Projectile, 4, 30, 10, Color.CYAN, 25, false));
	}
	
	//collision method; see BasicEnemy.collision()
	private void collision()
	{
		for (int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.Projectile)
			{
				if ( tempObject.fromPlayer() )
				{
					if (getBounds().intersects( tempObject.getBounds() ) )
						{
							AudioPlayer.getSound("destroy").play();
							handler.removeObject(this);
							handler.removeObject(tempObject);
						}
				}
			}
		}
	}

	public void tick()
	{
		//adds velocity to location
		x+=velX;
		y+=velY;
		
		//reverse direction when the enemy hits a wall
		if (y <= 0 || y >= Game.HEIGHT-32) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH-16) velX *= -1;
		
		//checks for collision
		collision();
	}

	//renders boss as a magenta 64x64 square
	public void render(Graphics g)
	{
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, (int)(Game.WIDTH*scale), (int)(Game.WIDTH*scale));
	}

	//inherited methods
	public boolean fromPlayer() 
	{
		return false;
	}

	public int getDamage() {
		return 0;
	}
}
