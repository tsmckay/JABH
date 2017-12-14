package edu.tsmckay.game;

import java.util.Random;

public class Spawn
{
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	public Spawn(Handler handler, HUD hud)
	{
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick()
	{
		int enemyCount = 0;
		for (int i = 0; i < handler.object.size(); i++)
		{
			if (handler.object.get(i).getId() == ID.Enemy)
				enemyCount++;
		}
		if (enemyCount == 0)
		{
			for (int i = 0; i <= hud.getWave(); i++)
			{
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), 60, ID.Enemy, handler));
			}
			if ((hud.getWave()+1)%5 == 0)
			{
				for (int i=0; i < hud.getWave()/5+1; i++)
				{
					handler.addObject(new Boss(r.nextInt(Game.WIDTH), 120, ID.Enemy, handler));
				}
			}
			hud.setWave(hud.getWave()+1);
			hud.setScore(hud.getScore()+10000);
		}
		enemyCount = 0;
	}
	
}
