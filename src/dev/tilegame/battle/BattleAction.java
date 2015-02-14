package dev.tilegame.battle;

public class BattleAction
{
	// Action
	private boolean actionActive;
	private int actionTick;
	private int actionFrame;
	private int actionFrameMax;
	
	// 
	
	// Damage
	private boolean damageInflict;
	private int damageType;
	private int damageFrame;
	private int damageTotal;

	public BattleAction()
	{
		actionActive = false;
		actionTick = 0;
		actionFrame = 0;
		actionFrameMax = 0;
		actionSourceForce = 0;
		actionSourceUnit = 0;
		
		targetType = "Single";
		targetCount = 0;
		
		actionDamageFrame = 0;
		actionDamageTotal = 0;
		actionDamageType = "Melee";
	}
	
	public void damageSet(String type)
	{
		// Note: This will need to be turned into an array at somepoint, to accomodate for multiple potential targets
	}
	
	public void targetAdd(String force, int unit)
	{
		targetCount += 1;
		
	}
}