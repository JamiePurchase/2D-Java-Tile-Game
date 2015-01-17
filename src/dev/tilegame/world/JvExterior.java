package dev.tilegame.world;

import dev.tilegame.Game;
import dev.tilegame.gfx.Assets;

public class JvExterior
{
	
	public JvExterior()
	{
		// Data
		Game.world.setName("JvExterior");
		Game.world.setLocation("Jharva Village");
		
		// Dimensions
		Game.world.setGridWidth(100);
		Game.world.setGridHeight(100);
		
		// Background
		Game.world.setBackground();
		
		// Tiles
		Game.world.tileInit("Grass", 0);
		Game.world.setTile(1, 1, Assets.tlsJharvaVillage[0], 1);
	}
}