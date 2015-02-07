package dev.tilegame.battle;

import java.awt.image.BufferedImage;

public class UnitEnemy
{
	// Details
	public String infoName;
	
	// Stats
	public int statHealth;
	
	// Anim
	public BufferedImage animIdle;
	
	// Action
	public String actionStance;
	public int actionCharge;
	
	public UnitEnemy(String name)
	{
		infoName = name;
	}

}