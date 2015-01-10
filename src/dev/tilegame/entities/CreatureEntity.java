package dev.tilegame.entities;

public abstract class CreatureEntity extends Entity
{
	private static String action;
	private static String direction;
	private static int walkFrame; 
	private static int statHealth;
	
	public CreatureEntity()
	{
		action = "Idle";
		direction = "S";
		walkFrame = 0;
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
	
	public static int getWalkFrame()
	{
		return walkFrame;
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
	
	public static void setWalkFrame(int value)
	{
		walkFrame = value;
	}
}