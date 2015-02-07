package dev.tilegame.battle;

import java.awt.image.BufferedImage;

public class UnitEnemy
{
	// Details
	public String infoName;
	
	// Stats
	public int statHealth;
	
	// Anim
	public BufferedImage[] animSheet;
	public int animSheetIdle = 1;
	
	// Action
	public String actionStance;
	public int actionCharge;
	
	public UnitEnemy(String name)
	{
		infoName = name;
	}
	
	public BufferedImage getAnim(String stance)
	{
		//if(stance=="Idle"){return animSheet[0];}
		//if(stance=="KO"){return animSheet[29];}
		return animSheet[0];
	}

}