/*
 * JABH by Trevor McKay
 * AP Computer Science 2017-2018
 * tsmckay100@student.hbuhsd.edu
 */

package edu.tsmckay.jabhgame;
import javax.swing.JFrame;
import java.awt.Rectangle;


/////////////////////////////////////////////////////

public class Main extends JFrame
{
	
	public static void main(String[] args)
	{
		JFrame window = new JFrame();
		window.setTitle("JABH by Trevor McKay");
		window.setSize(1000,1000);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}