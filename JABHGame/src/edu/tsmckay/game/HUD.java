package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Graphics;

public class HUD
{
	
	public int score = -10000;
	public static int HEALTH = 100;
	private int greenTint = 255;
	private int wave = 0;
	
	public void tick()
	{
		HEALTH = Game.clamp(HEALTH, 0, 100); //clamps score to an integer between 0 and 100
		greenTint = Game.clamp(greenTint, 0, 255);
		greenTint = HEALTH*2;
		score++;	//increments score once per tick
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.drawString("Score: " + ( score/10 + Game.getScore()), 550, 25);
		g.drawString("Wave: " + (wave), 552, 45);
		g.setColor(Color.gray);
		g.fillRect(15, 15, 300, 20);
		g.setColor(Color.blue);
		g.fillRect(0, 2*Game.HEIGHT/3-10, Game.WIDTH, 3);
		g.setColor(new Color(75, greenTint, 0));
		g.fillRect(15, 15, HEALTH*3, 20);
	}

	public int getScore() {
		return score;
	}

	public int getWave() {
		return wave;
	}

	public void setWave(int wave) {
		this.wave = wave;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
