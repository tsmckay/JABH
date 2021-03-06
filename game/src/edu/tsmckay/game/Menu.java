package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/*
 * This is the main menu when the game is launched
 * Also responible for rendering the game over and difficulty select screens
 */

//locations of menu objects are hard-coded and independent of window size

public class Menu extends MouseAdapter
{
	//allows game to update while using menu
	private Game game;
	private Handler handler;
	private HUD hud;
	
	//used for random placement of menu effects
	private Random r = new Random();
	
	public Menu(Game game, Handler handler, HUD hud)
	{
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		
		//spawns some rectangles that bounce around in the background
		for (int i = 0; i<9; i++){
			handler.addObject(new MenuEffect(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuEffect, handler));
		}
	}
	
	public void mousePressed(MouseEvent e)
	{
		//retrieves location of mouse pointer
		int mx = e.getX();
		int my = e.getY();
		
		//brings player to diff. select if player clicks start
		if (game.gameState == STATE.Menu)
		{
			if (mouseOver(mx, my, Game.WIDTH/2-5-320, 200, 300, 64))
			{
				game.gameState = STATE.Select;
				
				AudioPlayer.getSound("select").play();
				return;
			}
			
			//quits game if player presses quit
			if (mouseOver(mx, my, Game.WIDTH/2-5-320, 300, 300, 64))
			{
				System.exit(1);
			}
		}
		
		//restarts game if the player clicks on the screen during game over
		if (game.gameState == STATE.GameOver)
		{
			if (mouseOver(mx, my, 0, 0, Game.WIDTH, Game.HEIGHT))
			{
				game.gameState = STATE.Select;
				
				AudioPlayer.getSound("select").play();
				return;
			}
		}
		
		//selects difficulty
		if (game.gameState == STATE.Select)
		{
			if (mouseOver(mx, my, 170, 100, 300, 64))
			{
				AudioPlayer.getSound("select").play();
				handler.object.clear();
				hud.setWave(1);
				hud.setScore(-10000);
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2+175, ID.Player, handler));
			}
			
			if (mouseOver(mx, my, 170, 200, 300, 64))
			{
				AudioPlayer.getSound("select").play();
				handler.object.clear();
				hud.setWave(10);
				hud.setScore(-10000);
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2+175, ID.Player, handler));
			}
		}
	}
	
	//tests if mouse is over input rectangle
	private boolean mouseOver(int mx, int my, int x, int y, int w, int h)
	{
		if (mx > x && mx < x + w)
		{
			if(my > y && my < y + h)
			{
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	public void render(Graphics g)
	{
		
		//main menu objects
		if (game.gameState == STATE.Menu)
		{
			Font fnt = new Font("arial", 1, 45);
			Font smallfnt = new Font("arial", 1, 25);
			g.setFont(smallfnt);
			g.setColor(Color.white);
			g.drawString("Red Square", 800, 220);
			g.drawString("Dodges Lots of", 775, 250);
			g.drawString("Blue Squares", 790, 280);
			g.setFont(fnt);
			g.drawString("Start Game", Game.WIDTH/2 - 296, 250);
			g.drawString("Exit", Game.WIDTH/2 - 223, 350);
			
			Font fntVSmall = new Font ("arial", 1, 15);
			g.setFont(fntVSmall);
			g.drawString("a creatively named game by", 770, 330);
			Font fntSmall = new Font("arial", 1, 20);
			g.setFont(fntSmall);
			g.drawString("Trevor McKay", 800, 380);
			g.drawString("Dean Whiteside", 796, 410);
			
			g.fillRect(741, 300, 250, 5);
			
			g.setColor(Color.magenta);
			g.drawRect(Game.WIDTH/2-325, 200, 300, 64);
			g.drawRect(Game.WIDTH/2-325, 300, 300, 64);
		}
		
		//game over menu objects
		else if (game.gameState == STATE.GameOver)
		{
			Font fnt = new Font("arial", 1, 45);
			g.setFont(fnt);
			g.setColor(Color.MAGENTA);
			g.drawString("Game Over", 180, 80);
			g.setColor(Color.WHITE);
			g.drawString("- click to try again -", 110, 200);
			g.drawString("Score: " + hud.getScore()/10, 180, 300);
			g.drawString("Wave: " + (hud.getWave()-1), 180, 350);
		}
		
		//select menu objects
		else if (game.gameState == STATE.Select)
		{
			Font fnt = new Font("arial", 1, 45);
			g.setFont(fnt);
			
			g.setColor(Color.magenta);
			g.drawRect(170, 100, 300, 64);
			g.drawRect(170, 200, 300, 64);
			
			g.setColor(Color.white);
			g.drawString("Wave 1", 245, 150);
			g.drawString("Wave 10", 235, 250);
		}
	}
}
