package dev.tilegame.battle;

import java.awt.image.BufferedImage;

import dev.tilegame.gfx.Tileset;

public class BattleSheets
{
	// Allies
	static BufferedImage[] bashCharacter2;

	public BattleSheets()
	{
		bashCharacter2 = Tileset.getTileset("/battle/character2/battleSheet.png", 5, 2, 160, 160);
	}
	
}