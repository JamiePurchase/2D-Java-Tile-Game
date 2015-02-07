package dev.tilegame.battle;

public class Action
{
	// Details
	public String actionName;
	public String actionHint;
	public String actionType;
	
	// Cost
	public int costStamina = 0;
	public int costMagic = 0;
	
	// Target
	public String targetForceDefault = "Enemy";
	public boolean targetForceAll = false;
	public boolean targetSelectAlly = true;
	
	// Damage
	public boolean damageTarget;
	public String damageType = "Melee";
	public int damageBase;
	public boolean damageReflect = false;
	
	// Status Effect
	public boolean statusInflictActive = false;
	public String[] statusInflictType = new String[2];
	public int[] statusInflictChance = new int[2];
	
	// Anim
	public int animFrames;
	
	public Action(String name)
	{
		actionName = name;
	}

}