package dev.tilegame.battle;

import java.awt.image.BufferedImage;

import dev.tilegame.Game;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.ImageLoader;
import dev.tilegame.gfx.Tileset;

public class MockData
{
	public MockData()
	{
		Game.battleEngine = new BattleEngine();
		Game.battleEngine.bkgImage = ImageLoader.loadImage("/battle/backgrounds/test1.png");
		loadForceAllies();
		loadForceEnemies();
	}
	
	public static void loadForceAllies()
	{
		UnitAlly ally1 = new UnitAlly("Jamie");
		ally1.statHealth = 1000;
		ally1.animSheet = Tileset.getTileset("/battle/character2/battleSheet.png", 6, 6, 160, 160);
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
		enemy1.animSheet = Tileset.getTileset("/battle/boar/boar01.png", 1, 1, 100, 100);
		enemy1.actionStance = "Charge";
		enemy1.actionCharge = 200;
		Game.battleEngine.addUnitEnemy(enemy1);
	}
}