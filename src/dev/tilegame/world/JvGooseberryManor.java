package dev.tilegame.world;

import dev.tilegame.Game;
import dev.tilegame.gfx.Assets;

public class JvGooseberryManor
{
	
	public JvGooseberryManor()
	{
		// Data
		Game.world.setName("JvGooseberryManor");
		Game.world.setLocation("Gooseberry Manor, Jharva Village");
		
		// Dimensions
		Game.world.setGridWidth(25);
		Game.world.setGridHeight(17);
		
		// Background
		Game.world.setBackground(Assets.bkgJvGooseberryManor);
		
		// Tiles
		Game.world.tileInit("", 0);
	}
}