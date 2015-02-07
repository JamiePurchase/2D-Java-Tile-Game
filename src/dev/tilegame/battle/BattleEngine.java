package dev.tilegame.battle;

import java.awt.image.BufferedImage;

public class BattleEngine
{
	// Background
	private BufferedImage backgroundImage;
	
	// Allies
	public UnitAlly[] unitAlly = new UnitAlly[4];
	public int unitAllyCount = 0;
	
	// Enemies
	public UnitEnemy[] unitEnemy = new UnitEnemy[4];
	public int unitEnemyCount = 0;
	
	// Anim Sheets
	public BattleSheets bash;
	
	public BattleEngine()
	{
		bash = new BattleSheets();
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
	
	public void setBackgroundImage(BufferedImage background)
	{
		backgroundImage = background;
	}
}