package dev.tilegame.entities;

public abstract class CreatureEntity extends Entity
{
	private static String action;
	private static String direction;
	private static int statHealth;
	
	public CreatureEntity()
	{
		action = "Idle";
	}
	
	public static String getAction()
	{
		return action;
	}
	
	public static String getDirection()
	{
		return direction;
	}
	
	public static int getStatHealth()
	{
		return statHealth;
	}
	
	public static void setAction(String act)
	{
		action = act;
	}
	
	public static void setDirection(String dir)
	{
		direction = dir;
	}
	
	public static void setStatHealth(int health)
	{
		statHealth = health;
	}
}