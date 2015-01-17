package dev.tilegame.quests;

public class Quest
{
	public String name;
	public int stage;
	
	public Quest(String newName)
	{
		name = newName;
		stage = 0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getStage()
	{
		return stage;
	}
}