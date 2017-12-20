package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD
{
	/*score starts at -10000 to offset the initial
	point value awarded from spawning the initial wave*/
	private int score = -20000;
	public static int HEALTH = 100;
	private int wave = 0;

	public void tick()
	{
		HEALTH = Game.clamp(HEALTH, 0, 100);
		//clamps health to an integer between 0 and 100
		score++; //increments score once per tick
	}

	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		//prints score and wave number to screen
		Font fontHUD = new Font("arial", 1, 30);
		g.setFont(fontHUD);
		g.drawString("Score: " + ( score/10 ), 1730, 35);
		g.drawString("Wave: " + (wave-1), 1732, 65);
		//background of health bar
		g.setColor(Color.gray);
		g.fillRect(13, 13, 604, 34);
		//health bar
		g.setColor(Color.MAGENTA);
		g.fillRect(15, 15, HEALTH*6, 30);
		//border for player
		g.fillRect(0, 2*Game.HEIGHT/3-10, Game.WIDTH, 3);
	}


	//getter and setter methods
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
