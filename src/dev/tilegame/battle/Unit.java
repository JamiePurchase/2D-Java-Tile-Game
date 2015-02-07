package dev.tilegame.battle;

import java.awt.image.BufferedImage;

public abstract class Unit
{
	// Details
	public String unitName;
	
	// Stats
	public int statHealthNow;
	public int statHealthMax;
	
	// Anim
	public int animPosX;
	public int animPosY;
	public int animWide;
	public int animHigh;
	public BufferedImage[] animSheet;
	public int animSheetIdle = 1;
	public int animSheetCombat = 5;
	public int animSheetDefend = 4;
	public int animSheetDeath = 5;
	public int animSheetMystic = 3;
	
	// Status
	public boolean statusActive = true;
	public boolean statusKO = false;
	public boolean statusFrenzy = false;
	
	// Action
	public String actionStance;
	public int actionCharge;
	public Action[] action = new Action[50];
	public int actionCount = 0;
	
	public Unit()
	{
		
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
	
	public void inflictDamage(int amount)
	{
		statHealthNow -= amount;
		if(statHealthNow<1)
		{
			statHealthNow = 0;
			statusKO = true;
			actionStance = "KO";
		}
	}
}