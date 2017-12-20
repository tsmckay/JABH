package edu.tsmckay.game;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas //new class windows which inherits canvas
{
	private static final long serialVersionUID = 7083802404550265596L;

	public Window(int w, int h, String title, Game game)
	{
		JFrame frame = new JFrame(title);	//creates new frame
		frame.setPreferredSize(new Dimension(w, h));	//
		frame.setMinimumSize(new Dimension(w, h));		//sets size
		frame.setMaximumSize(new Dimension(w, h));		//
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//closes program when window is closed
		frame.setResizable(false);		//prevents resizing
		frame.setLocationRelativeTo(null);
		frame.add(game);	//adds game to frame
		frame.setVisible(true);		//makes windows visible
		game.start();	//starts game
	}
}
