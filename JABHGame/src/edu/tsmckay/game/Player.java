package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject
{

	public Player(int x, int y, ID id)
	{
		super(x, y, id);
	}

	public void tick()
	{
		x += velX;
		y += velY;	//responsible for moving object
		
		x = Game.clamp(x, 0, Game.WIDTH-38);
		y = Game.clamp(y, 0, Game.HEIGHT-61);
	}

	public void render(Graphics g)
	{
		g.setColor(Color.green);
		g.fillRect(x, y, 32, 32);
	}

}