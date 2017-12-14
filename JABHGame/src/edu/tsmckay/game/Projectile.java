package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile extends GameObject
{
	private Color color;
	private int size;
	public boolean fromPlayer;
	public int damage;

	public Projectile(int x, int y, ID id, int vel, int size, int damage, Color c, int offset, boolean fromPlayer)
	{
		super(x, y + offset, id);
		
		this.velY = vel;
		this.color = c;
		this.size = size;
		this.fromPlayer = fromPlayer;
		this.damage = damage;
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Rectangle getBounds()
	{
		return new Rectangle(x, y, size, size);
	}
	
	public boolean fromPlayer()
	{
		return fromPlayer;
	}

	public void tick()
	{
		x += velX;
		y += velY;
	}
	
	public void fireProjectile() {} //useless method
	
	public void render(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x, y, size, size);
	}
	
	
}
