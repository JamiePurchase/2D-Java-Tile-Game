package dev.tilegame.entities;

public abstract class Entity
{
	private static int positionX;
	private static int positionY;
	
	public Entity()
	{
		positionX = 1;
		positionY = 1;
	}
	
	public static int getPositionX()
	{
		return positionX;
	}
	
	public static int getPositionY()
	{
		return positionY;
	}
	
	public static void setPositionX(int pos)
	{
		positionX = pos;
	}
	
	public static void setPositionY(int pos)
	{
		positionY = pos;
	}
}