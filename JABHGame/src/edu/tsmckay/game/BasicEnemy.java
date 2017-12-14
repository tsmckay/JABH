package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Graphics;

public class BasicEnemy extends GameObject
{
	public BasicEnemy(int x, int y, ID id)
	{
		super(x, y, id);
		
		velX = (int) (Math.random()*100%5+3);
		velY = (int) (Math.random()*100%5+3);
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
