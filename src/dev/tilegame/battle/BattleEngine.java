package dev.tilegame.battle;

import java.awt.image.BufferedImage;

public class BattleEngine
{
	private BufferedImage backgroundImage;
	private BattleUnit[][] forceUnit;
	private int[] forceUnitCount;
	
	public BattleEngine()
	{
		forceUnitCount[1] = 0;
		forceUnitCount[2] = 0;
	}
	
	public void addUnit(BattleUnit unit, int force)
	{
		int pos = forceUnitCount[force] + 1;
		forceUnit[force][pos] = unit;
		forceUnitCount[force] = pos;
	}
	
	public BattleUnit getUnit(int force, int pos)
	{
		return forceUnit[force][pos];
	}
	
	public void setBackgroundImage(BufferedImage background)
	{
		backgroundImage = background;
	}
}