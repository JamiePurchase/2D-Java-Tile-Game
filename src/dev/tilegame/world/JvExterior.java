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
		Game.world.setGridHeight(80);
		
		// Background
		Game.world.setBackground();
		
		// Tiles
		Game.world.tileInit(Assets.tlsJharvaVillage[0], 0);
		Game.world.setTile(41, 40, Assets.tlsJharvaVillage[9], 1);
		Game.world.setTile(42, 40, Assets.tlsJharvaVillage[10], 1);
		Game.world.setTile(43, 40, Assets.tlsJharvaVillage[10], 1);
		Game.world.setTile(44, 40, Assets.tlsJharvaVillage[15], 1);
		Game.world.setTile(47, 40, Assets.tlsJharvaVillage[9], 1);
		Game.world.setTile(48, 40, Assets.tlsJharvaVillage[10], 1);
		Game.world.setTile(49, 40, Assets.tlsJharvaVillage[10], 1);
		Game.world.setTile(50, 40, Assets.tlsJharvaVillage[15], 1);
		Game.world.setTile(69, 40, Assets.tlsJharvaVillage[0], 1); // need a tile for this one
		Game.world.setTile(70, 40, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(71, 40, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(72, 40, Assets.tlsJharvaVillage[47], 1);
		Game.world.setTile(77, 40, Assets.tlsJharvaVillage[42], 1);
		Game.world.setTile(78, 40, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(79, 40, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(80, 40, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(81, 40, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(82, 40, Assets.tlsJharvaVillage[0], 1); // need a tile for this one
	}
}