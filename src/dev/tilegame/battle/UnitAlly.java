package dev.tilegame.battle;

import java.awt.image.BufferedImage;

public class UnitAlly
{
	// Details
	public String infoName;
	
	// Stats
	public int statHealth;
	
	// Anim
	public BufferedImage animIdle;
	// Note: Consider creating a tileset for each unit, with 'Idle', 'Dead', 'Attack' etc... as array indexes
	
	// Action
	public String actionStance;
	public int actionCharge;
	
	public UnitAlly(String name)
	{
		infoName = name;
	}

}