package edu.tsmckay.game;

public enum ID //new enumeration for all game object IDs
{
	//allows game to ID whether a GameObject is a player, projectile, or enemy
	Player(), //object is a player
	Projectile(), //object is a projectile
	MenuEffect(), //object is a particle in the main menu
	Enemy(); //object is a BasicEnemy or Boss
}
