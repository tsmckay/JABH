package edu.tsmckay.game;

import java.util.Random;

public class Spawn
{

	private Handler handler;
	private HUD hud;
	private double enemyScale = .05;
	private double bossScale = .1;

	//random seed for object placement
	private Random r = new Random();

	//constructor for spawner
	public Spawn(Handler handler, HUD hud)
	{
		this.handler = handler;
		this.hud = hud;
	}

	//method responsible for spawning a new wave
	public void newWave()
	{
		//spawns enemies in one row for waves 1-5
		if (hud.getWave()<6)
		{
			for (int i = 0; i < hud.getWave(); i++)
			{
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH)-10, 60,
																				 enemyScale, ID.Enemy, handler));
			}
		}

		//spawns enemies in two rows for waves 6-10
		if (hud.getWave()<11 && hud.getWave()>5)
		{
			for (int i = 0; i < 5; i++)
			{
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH)-10, 60,
																				 enemyScale, ID.Enemy, handler));
			}

			for (int i = 5; i < hud.getWave(); i++)
			{
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH)-10, 110,
																				 enemyScale, ID.Enemy, handler));
			}
		}

		//spawns enemies in three rows for waves 11+
		//game caps in difficulty at wave 11
		if (hud.getWave()>10)
		{
			for (int i = 0; i < 5; i++)
			{
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH)-10, 60,
																				 enemyScale, ID.Enemy, handler));
			}
			for (int i = 0; i < 5; i++)
			{
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH)-10, 110,
																				enemyScale, ID.Enemy, handler));
			}
			for (int i = 10; i < 15; i++)
			{
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH)-10, 160,
																				 enemyScale, ID.Enemy, handler));
			}

			handler.addObject(new Boss(r.nextInt(Game.WIDTH)-10, 80,
																 bossScale, ID.Enemy, handler));
																 //adds an additional boss
		}

		//adds one boss every 5 waves
		if ((hud.getWave())%5 == 0)
		{
			for (int i=0; i < hud.getWave()/5; i++)
			{
				handler.addObject(new Boss(r.nextInt(Game.WIDTH)-10, 80,
																	 bossScale, ID.Enemy, handler));
			}
		}

	}

	public void tick()
	{
		//counts enemies
		int enemyCount = 0;
		for (int i = 0; i < handler.object.size(); i++)
		{
			if (handler.object.get(i).getId() == ID.Enemy)
				enemyCount++;
		}

		//spawns new wave and adds points if there are no more enemies
		if (enemyCount == 0)
		{
			newWave();

			hud.setWave(hud.getWave()+1);
			hud.setScore(hud.getScore()+10000);
		}
		enemyCount = 0;
	}

}
