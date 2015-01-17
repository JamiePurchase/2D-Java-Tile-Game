package dev.tilegame.entities;

public abstract class EntityCreature extends Entity
{
	private static String action;
	private static String direction;
	private static int walkFrame;
	private static int walkFrameTick;
	private static int statHealth;
	
	public EntityCreature()
	{
		action = "Idle";
		direction = "S";
		walkFrame = 0;
		walkFrameTick = 0;
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
	
	public static int getWalkFrameTick()
	{
		return walkFrameTick;
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
	
	public static void setWalkFrameTick()
	{
		walkFrameTick = walkFrameTick + 1;
		if(walkFrameTick>10)
		{
			walkFrame = walkFrame + 1;
			walkFrameTick = 0;
		}
	}
	
	public static void walk(String direction)
	{
		setAction("Walk");
		setDirection(direction);
		setWalkFrame(1);
	}
}