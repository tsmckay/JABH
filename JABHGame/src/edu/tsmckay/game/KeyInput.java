package edu.tsmckay.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
	//creates handler
	private Handler handler;
	public KeyInput(Handler handler)
	{
		this.handler = handler;
	}
	
	//events on key press
	public void keyPressed(KeyEvent e)
	{
		//gets key code
		int key = e.getKeyCode();
		
		//loops through objects to find player
		for (int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.Player)
			{
				if (key == KeyEvent.VK_W) tempObject.setVelY(-5);	//moves player up on W
				if (key == KeyEvent.VK_S) tempObject.setVelY(5);	//moves player down on S
				if (key == KeyEvent.VK_D) tempObject.setVelX(5);	//moves player right on D
				if (key == KeyEvent.VK_A) tempObject.setVelX(-5);	//moves player left on A
				if (key == KeyEvent.VK_SPACE) tempObject.fireProjectile();	//fires projectile on space bar
			}
		}
		
		if (key == KeyEvent.VK_ESCAPE) System.exit(1); //exits on escape
	}
	
	//events on key release
	public void keyReleased(KeyEvent e)
	{
		//gets key code
		int key = e.getKeyCode();
		
		//loops through objects to find player
		for (int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.Player)
			{
				//resets velocity to 0 after key is released
				if (key == KeyEvent.VK_W) tempObject.setVelY(0);
				if (key == KeyEvent.VK_S) tempObject.setVelY(0);
				if (key == KeyEvent.VK_D) tempObject.setVelX(0);
				if (key == KeyEvent.VK_A) tempObject.setVelX(0);
			}
		}
	}
}
