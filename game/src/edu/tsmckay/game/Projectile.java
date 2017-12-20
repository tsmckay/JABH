package edu.tsmckay.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile extends GameObject
{
	//each projectile has a certain color, size, and damage value
	//it may also originate from the player
	private Color color;
	private int size;
	public boolean fromPlayer;
	public int damage;

	//constructor for projectile
	public Projectile(int x, int y, double scale,
										ID id, int vel, int size, int damage,
										Color c, int offset, boolean fromPlayer)
	{
		//adds offset to y coordinate
		super(x, y + offset, scale, id);

		this.velY = vel;
		this.color = c;
		this.size = size;
		this.fromPlayer = fromPlayer;
		this.damage = damage;
	}

	public void tick()
	{
		x += velX;
		y += velY;
	}

	public void render(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x, y, size, size);
	}

	//getter and setter methods
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

	//inherited method
	public void fireProjectile()
	{
	}

}
