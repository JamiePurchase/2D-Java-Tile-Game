package dev.tilegame.battle;

import java.awt.image.BufferedImage;

public class BattleEngine
{
	// Background
	public BufferedImage bkgImage;
	
	// Allies
	public UnitAlly[] unitAlly = new UnitAlly[4];
	public int unitAllyCount = 0;
	
	// Enemies
	public UnitEnemy[] unitEnemy = new UnitEnemy[4];
	public int unitEnemyCount = 0;
	
	public BattleEngine()
	{
	}
	
	public int addUnitAlly(UnitAlly unit)
	{
		unitAllyCount += 1;
		unitAlly[unitAllyCount] = unit;		
		return unitAllyCount;
	}
	
	public int addUnitEnemy(UnitEnemy unit)
	{
		unitEnemyCount += 1;
		unitEnemy[unitEnemyCount] = unit;
		return unitEnemyCount;
	}
	
	public UnitAlly getUnitAlly(int pos)
	{
		return unitAlly[pos];
	}

	public UnitEnemy getUnitEnemy(int pos)
	{
		return unitEnemy[pos];
	}
}