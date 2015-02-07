package dev.tilegame.battle;

import dev.tilegame.Game;
import dev.tilegame.gfx.Assets;

public class MockData
{
	public MockData()
	{
		Game.battleEngine = new BattleEngine();
		loadForceAllies();
		loadForceEnemies();
	}
	
	public static void loadForceAllies()
	{
		UnitAlly ally1 = new UnitAlly("Jamie");
		ally1.statHealth = 1000;
		ally1.animIdle = Game.battleEngine.bash.bashCharacter2[0];
		ally1.actionStance = "Charge";
		ally1.actionCharge = 300;
		Game.battleEngine.addUnitAlly(ally1);
		
		// Note: We need to put this/these battle allies into the main engine
		// Note: Player should have Assets.battleCharacter2Idle for the idle anim
	}
	
	public static void loadForceEnemies()
	{
		UnitEnemy enemy1 = new UnitEnemy("Boar");
		enemy1.statHealth = 500;
		enemy1.animIdle = Assets.battleBoarIdle;
		enemy1.actionStance = "Charge";
		enemy1.actionCharge = 200;
		Game.battleEngine.addUnitEnemy(enemy1);
	}
}