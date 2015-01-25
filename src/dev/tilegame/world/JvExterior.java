package dev.tilegame.world;

import dev.tilegame.Game;
import dev.tilegame.entities.NpcCreatureEntity;
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
		Game.world.setTile(71, 33, Assets.tlsJharvaVillage[1], 1);
		Game.world.setTile(72, 33, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(73, 33, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(74, 33, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(75, 33, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(76, 33, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(77, 33, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(78, 33, Assets.tlsJharvaVillage[7], 1);
		Game.world.setTile(71, 34, Assets.tlsJharvaVillage[17], 1);
		Game.world.setTile(72, 34, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(73, 34, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(74, 34, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(75, 34, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(76, 34, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(77, 34, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(78, 34, Assets.tlsJharvaVillage[23], 1);
		Game.world.setTile(71, 35, Assets.tlsJharvaVillage[25], 1);
		Game.world.setTile(72, 35, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(73, 35, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(74, 35, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(75, 35, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(76, 35, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(77, 35, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(78, 35, Assets.tlsJharvaVillage[31], 1);
		Game.world.setTile(69, 36, Assets.tlsJharvaVillage[54], 1);
		Game.world.setTile(70, 36, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(71, 36, Assets.tlsJharvaVillage[52], 1);
		Game.world.setTile(72, 36, Assets.tlsJharvaVillage[34], 1);
		Game.world.setTile(73, 36, Assets.tlsJharvaVillage[34], 1);
		Game.world.setTile(74, 36, Assets.tlsJharvaVillage[35], 1);
		Game.world.setTile(75, 36, Assets.tlsJharvaVillage[34], 1);
		Game.world.setTile(76, 36, Assets.tlsJharvaVillage[34], 1);
		Game.world.setTile(77, 36, Assets.tlsJharvaVillage[34], 1);
		Game.world.setTile(78, 36, Assets.tlsJharvaVillage[39], 1);
		Game.world.setTile(69, 37, Assets.tlsJharvaVillage[62], 1);
		Game.world.setTile(82, 37, Assets.tlsJharvaVillage[63], 1);
		Game.world.setTile(69, 38, Assets.tlsJharvaVillage[62], 1);
		Game.world.setTile(82, 38, Assets.tlsJharvaVillage[63], 1);
		Game.world.setTile(41, 39, Assets.tlsJharvaVillage[1], 1);
		Game.world.setTile(42, 39, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(43, 39, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(44, 39, Assets.tlsJharvaVillage[7], 1);
		Game.world.setTile(49, 39, Assets.tlsJharvaVillage[1], 1);
		Game.world.setTile(50, 39, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(51, 39, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(52, 39, Assets.tlsJharvaVillage[7], 1);
		Game.world.setTile(69, 39, Assets.tlsJharvaVillage[62], 1);
		Game.world.setTile(82, 39, Assets.tlsJharvaVillage[63], 1);
		Game.world.setTile(41, 40, Assets.tlsJharvaVillage[17], 1);
		Game.world.setTile(42, 40, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(43, 40, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(44, 40, Assets.tlsJharvaVillage[23], 1);
		Game.world.setTile(49, 40, Assets.tlsJharvaVillage[17], 1);
		Game.world.setTile(50, 40, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(51, 40, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(52, 40, Assets.tlsJharvaVillage[23], 1);
		Game.world.setTile(69, 40, Assets.tlsJharvaVillage[70], 1);
		Game.world.setTile(70, 40, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(71, 40, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(72, 40, Assets.tlsJharvaVillage[47], 1);
		Game.world.setTile(77, 40, Assets.tlsJharvaVillage[42], 1);
		Game.world.setTile(78, 40, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(79, 40, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(80, 40, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(81, 40, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(82, 40, Assets.tlsJharvaVillage[71], 1);
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
		
		// NPCs
		NpcCreatureEntity entHofmann = new NpcCreatureEntity();
		entHofmann.setImageIdle(Assets.npcHofmann[10],"N");
		entHofmann.setImageIdle(Assets.npcHofmann[7],"E");
		entHofmann.setImageIdle(Assets.npcHofmann[1],"S");
		entHofmann.setImageIdle(Assets.npcHofmann[4],"W");
		entHofmann.setPosition(64, 41);
		entHofmann.setDirection("S");
		Game.world.setNpc(entHofmann);
		
		// Portals
		Game.world.setPortal("Interact", 50, 42, "JvPlayerHouse", 21, 18, "N");
	}
}