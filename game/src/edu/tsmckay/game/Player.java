package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Rectangle;

/*
 * This is the player
 * It moves faster than enemies and has the ability to fire projectiles
 */

public class Player extends GameObject
{

	Handler handler; //declares a handler
	
	//constructor for Player
	public Player(int x, int y, ID id, Handler handler)
	{
		super(x, y, id);
		this.handler = handler;
	}
	
	//returns bounds of player
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 32-2, 32-2);	//returns bounds - 2 to make the collision a bit more forgiving
	}

	public void tick()
	{
		//responsible for moving object
		//modulus operator allows the player to wrap around the screen in the positive X and Y direction
		x = (x+velX)%Game.WIDTH;
		y = Game.clamp(y+velY, 2*Game.HEIGHT/3, Game.HEIGHT-64);
		
		//these statements allow the player to wrap around the screen in the  X and Y direction
		if (x < 0)
		{
			x+=Game.WIDTH;
		}
		
		if (y < 0)
		{
			y+=Game.HEIGHT;
		}
		
		collision();	//runs collision method
		
	}
	

	//collision method
	private void collision()
	{
		//loops through all objects
		for (int i = 0; i < handler.object.size(); i++)
		{
			//sets working object to current object in loop
			GameObject tempObject = handler.object.get(i);
			//tests for collision if it is a projectile
			if (tempObject.getId() == ID.Projectile)
			{
				//tests if bounds are intersecting
				if (getBounds().intersects( tempObject.getBounds() ) )
				{
					//subtracts health from player
					HUD.HEALTH -= tempObject.getDamage();
					AudioPlayer.getSound("hurt").play();
					//removes projectile object
					handler.removeObject(tempObject);
				}
			}
		}
	}
	
	public void fireProjectile()
	{
		//fires a projectile from the player with a color of white and a Y-offset of -5
		handler.addObject( new Projectile(x+15, y, ID.Projectile, -20, 10, 10, Color.blue, -15, true));
	}
	

	public void render(Graphics g)
	{
		//renders player as a green 32x32 square
		g.setColor(Color.red);
		g.fillRect(x, y, 32, 32);
	}

	//useless inherited methods
	public boolean fromPlayer()
	{
		return false;
	}

	public int getDamage() {
		return 0;
	}

}