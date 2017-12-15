package edu.tsmckay.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
	//creates handler
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	Game game;
	
	public KeyInput(Handler handler, Game game)
	{
		this.handler = handler;
		this.game = game;
		
		keyDown[0]=false; //w
		keyDown[1]=false; //s
		keyDown[2]=false; //d
		keyDown[3]=false; //a
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
				//sets keyDown to true when key is pressed
				if (key == KeyEvent.VK_W) { tempObject.setVelY(-5);	keyDown[0] = true; }
				if (key == KeyEvent.VK_S) { tempObject.setVelY(5); keyDown[1] = true; }
				if (key == KeyEvent.VK_D) { tempObject.setVelX(5); keyDown[2] = true; }
				if (key == KeyEvent.VK_A) { tempObject.setVelX(-5); keyDown[3] = true; }
				if (key == KeyEvent.VK_SPACE) tempObject.fireProjectile();
			}
		}
		
		//pauses or unpauses game
		if (key == KeyEvent.VK_ESCAPE)
			{
				if (game.gameState == STATE.Game)
				if (Game.paused) Game.paused = false;
				else Game.paused = true;
			}
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
				//sets keyDown back to false when key is released
				if (key == KeyEvent.VK_W) keyDown[0] = false;
				if (key == KeyEvent.VK_S) keyDown[1] = false;
				if (key == KeyEvent.VK_D) keyDown[2] = false;
				if (key == KeyEvent.VK_A) keyDown[3] = false;
				
				//this fixes choppy movement
				if (!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				if (!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			}
		}
	}
}
