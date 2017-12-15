package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject
{
	//counts ticks, used to fire projectiles at semi-random intervals
	int tickNum = 0;
	
	//new handler
	Handler handler;
	
	//constructor for enemy
	public BasicEnemy(int x, int y, ID id, Handler handler)
	{
		super(x, y, id);
		this.handler = handler;
		
		//randomizes x velocity to a value between 1 and 11
		velX = (int) (Math.random()*100%10+1);
		velY = 0;
	}
	
	//gets collision bounds
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 32+5, 16+5);
	}
	
	//fires red projectile from current enemy location
	public void fireProjectile()
	{
		handler.addObject( new Projectile(x, y, ID.Projectile, 5, 5, 5, Color.red, 25, false));
	}
	
	//tests for collision with projectiles
	//this method is called once per tick
	private void collision()
	{
		for (int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.Projectile)
			{
				//checks if projectiles are from player
				if ( tempObject.fromPlayer() )
				{
					if (getBounds().intersects( tempObject.getBounds() ) )
						{
							//removes enemy and the projectile
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
		//adds velocities to current location
		x+=velX;
		y+=velY;
		
		//reverses enemies location when it hits a wall
		if (y <= 0 || y >= Game.HEIGHT-32) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH-16) velX *= -1;
		
		//runs collision check
		collision();
	}

	//renders object as a blue square
	public void render(Graphics g)
	{
		g.setColor(Color.blue);
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
