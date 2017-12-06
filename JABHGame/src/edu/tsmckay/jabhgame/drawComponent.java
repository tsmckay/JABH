package edu.tsmckay.jabhgame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class drawComponent extends JComponent{		//new class drawComponent inherits all properties of JComponent
	public void paintComponent(Graphics g) { 		//creates component of graphics 'g'
		Graphics2D g2 = (Graphics2D) g;				//castes 'g' to be Graphics2D
	}
}