package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Graphics;

public class HUD
{
	
	public static int HEALTH = 100;
	
	public void tick()
	{
		HEALTH = Game.clamp(HEALTH, 0, 100);
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(15, 15, 300, 20);
		g.setColor(Color.red);
		g.fillRect(15, 15, HEALTH*3, 20);
		g.setColor(Color.white);
		g.drawRect(15, 15, 300, 20);
	}
}
