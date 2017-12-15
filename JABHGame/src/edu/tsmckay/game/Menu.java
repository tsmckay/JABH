package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter
{
	private Game game;
	private Handler handler;
	private HUD hud;
	
	public Menu(Game game, Handler handler, HUD hud)
	{
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		handler.addObject(new MenuEffect(50, 100, ID.MenuEffect, handler));
		handler.addObject(new MenuEffect(100, 100, ID.MenuEffect, handler));
		handler.addObject(new MenuEffect(100, 50, ID.MenuEffect, handler));
	}
	
	public void mousePressed(MouseEvent e)
	{
		int mx = e.getX();
		int my = e.getY();
		
		if (game.gameState == STATE.Menu)
		{
			if (mouseOver(mx, my, Game.WIDTH/2-5-320, 100, 300, 64))
			{
				game.gameState = STATE.Select;
				
				AudioPlayer.getSound("select").play();
				return;
			}
			
			//quit
			if (mouseOver(mx, my, Game.WIDTH/2-5-320, 200, 300, 64))
			{
				System.exit(1);
			}
		}
		
		if (game.gameState == STATE.GameOver)
		{
			if (mouseOver(mx, my, 0, 0, Game.WIDTH, Game.HEIGHT))
			{
				game.gameState = STATE.Select;
				
				AudioPlayer.getSound("select").play();
				return;
			}
		}
		
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
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
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
		
		//main menu
		if (game.gameState == STATE.Menu)
		{
			Font fnt = new Font("arial", 1, 45);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Jack Attack", 340, 140);
			g.drawString("Start Game", Game.WIDTH/2 -320+ 24, 150);
			g.drawString("Exit", Game.WIDTH/2 + 102 -325, 250);
			
			Font fntSmall = new Font("arial", 1, 20);
			g.setFont(fntSmall);
			g.drawString("Trevor McKay", 80+320, 220);
			g.drawString("Dean Whiteside", 76+320, 250);
			
			g.fillRect(21+320, 170, 250, 5);
			
			g.setColor(Color.magenta);
			g.drawRect(Game.WIDTH/2-325, 100, 300, 64);
			g.drawRect(Game.WIDTH/2-325, 200, 300, 64);
		}
		
		else if (game.gameState == STATE.GameOver)
		{
			Font fnt = new Font("arial", 1, 45);
			g.setFont(fnt);
			g.setColor(Color.MAGENTA);
			g.drawString("Game Over", 180, 80);
			g.setColor(Color.WHITE);
			g.drawString("- click to try again -", 110, 200);
			g.drawString("Score: " + hud.getScore()/10, 180, 300);
			g.drawString("Wave: " + hud.getWave(), 180, 350);
		}
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
	
	public void tick()
	{
		
	}
}
