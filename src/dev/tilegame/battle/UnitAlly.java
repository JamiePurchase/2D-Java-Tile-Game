package dev.tilegame.battle;

import java.awt.image.BufferedImage;

public class UnitAlly
{
	// Details
	public String infoName;
	
	// Stats
	public int statHealth;
	
	// Anim
	public BufferedImage[] animSheet;
	public int animSheetIdle = 1;
	public int animSheetCombat = 5;
	public int animSheetDefend = 4;
	public int animSheetDeath = 5;
	public int animSheetMystic = 3;
	
	// Action
	public String actionStance;
	public int actionCharge;
	
	public UnitAlly(String name)
	{
		infoName = name;
	}
	
	public BufferedImage getAnim(String stance)
	{
		return getAnim(stance, 1);
	}
	
	public BufferedImage getAnim(String stance, int frame)
	{
		int animID = 7;
		if(stance=="Idle"){animID = 7 + (frame - 1);}
		if(stance=="Combat"){animID = 13 + (frame - 1);}
		if(stance=="Defend"){animID = 19 + (frame - 1);}
		if(stance=="Death"){animID = 25 + (frame - 1);}
		if(stance=="Mystic"){animID = 31 + (frame - 1);}
		if(stance=="KO"){animID = 29;}
		return animSheet[animID];
	}

}