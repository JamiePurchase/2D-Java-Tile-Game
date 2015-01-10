package dev.tilegame.entities;

public abstract class CreatureEntity extends Entity
{
	private static String direction;
	private static int statHealth;
	
	public CreatureEntity()
	{
		
	}
	
	public static String getDirection()
	{
		return direction;
	}
	
	public static int getStatHealth()
	{
		return statHealth;
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