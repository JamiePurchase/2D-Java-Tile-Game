package dev.tilegame.battle;

import java.awt.image.BufferedImage;

public class UnitAlly extends Unit
{
	// Stats
	public int statStaminaNow;
	public int statStaminaMax;
	public int statMagicNow;
	public int statMagicMax;
	public int statFrenzyNow;
	
	// Rank
	public int rankLevel;
	public int rankExpTotal;
	public int rankExpRequired;
	
	// Commands
	public BattleCommand[] commandMenu = new BattleCommand[4];
	
	// Frenzy
	public int BattleActionFrenzyCount = 0;
	public ActionFrenzy[] frenzyTechnique = new ActionFrenzy[10];
	
	public UnitAlly(String name)
	{
		unitName = name;
	}

}