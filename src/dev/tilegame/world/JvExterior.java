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
		Game.world.setGridScroll(true);
		
		// Dimensions
		Game.world.setGridWidth(100);
		Game.world.setGridHeight(80);
		
		// Background
		Game.world.setBackground();
		
		// Tiles
		Game.world.tileInit(Assets.tlsJharvaVillage[0], 0);
		
		// Temp Tree
		Game.world.setTile(5, 5, Assets.tlsJharvaVillage[41], 1);
	
		Game.world.setTile(41, 39, Assets.tlsJharvaVillage[1], 1);
		Game.world.setTile(42, 39, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(43, 39, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(44, 39, Assets.tlsJharvaVillage[7], 1);
		Game.world.setTile(49, 39, Assets.tlsJharvaVillage[1], 1);
		Game.world.setTile(50, 39, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(51, 39, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(52, 39, Assets.tlsJharvaVillage[7], 1);
		Game.world.setTile(41, 40, Assets.tlsJharvaVillage[17], 1);
		Game.world.setTile(42, 40, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(43, 40, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(44, 40, Assets.tlsJharvaVillage[23], 1);
		Game.world.setTile(49, 40, Assets.tlsJharvaVillage[17], 1);
		Game.world.setTile(50, 40, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(51, 40, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(52, 40, Assets.tlsJharvaVillage[23], 1);
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
		Game.world.setTile(41, 41, Assets.tlsJharvaVillage[25], 1);
		Game.world.setTile(42, 41, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(43, 41, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(44, 41, Assets.tlsJharvaVillage[31], 1);
		Game.world.setTile(49, 41, Assets.tlsJharvaVillage[25], 1);
		Game.world.setTile(50, 41, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(51, 41, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(52, 41, Assets.tlsJharvaVillage[31], 1);
		Game.world.setTile(41, 42, Assets.tlsJharvaVillage[33], 1);
		Game.world.setTile(42, 42, Assets.tlsJharvaVillage[35], 1);
		Game.world.setTile(43, 42, Assets.tlsJharvaVillage[34], 1);
		Game.world.setTile(44, 42, Assets.tlsJharvaVillage[39], 1);
		Game.world.setTile(49, 42, Assets.tlsJharvaVillage[33], 1);
		Game.world.setTile(50, 42, Assets.tlsJharvaVillage[35], 1);
		Game.world.setTile(51, 42, Assets.tlsJharvaVillage[34], 1);
		Game.world.setTile(52, 42, Assets.tlsJharvaVillage[39], 1);
	}
}