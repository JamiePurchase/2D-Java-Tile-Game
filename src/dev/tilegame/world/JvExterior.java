package dev.tilegame.world;

import dev.tilegame.Game;
import dev.tilegame.dialogue.talkHofmann;
import dev.tilegame.entities.BoardNpc;
import dev.tilegame.entities.BoardScenery;
import dev.tilegame.entities.NpcCreatureEntity;
import dev.tilegame.gfx.Assets;
import dev.tilegame.scenery.scnJvGateWooden;

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
		Game.world.setTile(56, 7, Assets.tlsFenceWooden[9], 1);
		Game.world.setTile(57, 7, Assets.tlsFenceWooden[10], 1);
		Game.world.setTile(56, 8, Assets.tlsFenceWooden[21], 1);
		Game.world.setTile(56, 9, Assets.tlsFenceWooden[22], 1);
		Game.world.setTile(57, 9, Assets.tlsFenceWooden[27], 1);
		Game.world.setTile(58, 9, Assets.tlsFenceWooden[28], 1);
		Game.world.setTile(59, 9, Assets.tlsFenceWooden[29], 1);
		Game.world.setTile(60, 9, Assets.tlsFenceWooden[2], 1);
		Game.world.setTile(61, 9, Assets.tlsFenceWooden[0], 1);
		Game.world.setTile(62, 9, Assets.tlsFenceWooden[1], 1);
		Game.world.setTile(63, 9, Assets.tlsFenceWooden[0], 1);
		Game.world.setTile(64, 9, Assets.tlsFenceWooden[1], 1);
		Game.world.setTile(65, 9, Assets.tlsFenceWooden[0], 1);
		Game.world.setTile(66, 9, Assets.tlsFenceWooden[1], 1);
		Game.world.setTile(67, 9, Assets.tlsFenceWooden[2], 1);
		Game.world.setTile(68, 9, Assets.tlsFenceWooden[48], 1);
		Game.world.setTile(69, 9, Assets.tlsFenceWooden[49], 1);
		Game.world.setTile(70, 9, Assets.tlsFenceWooden[50], 1);
		Game.world.setTile(71, 9, Assets.tlsFenceWooden[51], 1);
		Game.world.setTile(56, 10, Assets.tlsFenceWooden[14], 1);
		Game.world.setTile(57, 10, Assets.tlsFenceWooden[39], 1);
		Game.world.setTile(58, 10, Assets.tlsFenceWooden[40], 1);
		Game.world.setTile(59, 10, Assets.tlsFenceWooden[41], 1);
		Game.world.setTile(60, 10, Assets.tlsFenceWooden[14], 1);
		Game.world.setTile(61, 10, Assets.tlsFenceWooden[12], 1);
		Game.world.setTile(62, 10, Assets.tlsFenceWooden[13], 1);
		Game.world.setTile(63, 10, Assets.tlsFenceWooden[12], 1);
		Game.world.setTile(64, 10, Assets.tlsFenceWooden[13], 1);
		Game.world.setTile(65, 10, Assets.tlsFenceWooden[12], 1);
		Game.world.setTile(66, 10, Assets.tlsFenceWooden[13], 1);
		Game.world.setTile(67, 10, Assets.tlsFenceWooden[14], 1);
		Game.world.setTile(68, 10, Assets.tlsFenceWooden[60], 1);
		Game.world.setTile(69, 10, Assets.tlsFenceWooden[61], 1);
		Game.world.setTile(70, 10, Assets.tlsFenceWooden[62], 1);
		Game.world.setTile(71, 10, Assets.tlsFenceWooden[63], 1);
		Game.world.setTile(72, 10, Assets.tlsFenceWooden[2], 1);
		Game.world.setTile(73, 10, Assets.tlsFenceWooden[0], 1);
		Game.world.setTile(74, 10, Assets.tlsFenceWooden[1], 1);
		Game.world.setTile(75, 10, Assets.tlsFenceWooden[0], 1);
		Game.world.setTile(76, 10, Assets.tlsFenceWooden[1], 1);
		Game.world.setTile(77, 10, Assets.tlsFenceWooden[2], 1);
		Game.world.setTile(68, 11, Assets.tlsFenceWooden[72], 1);
		Game.world.setTile(69, 11, Assets.tlsFenceWooden[73], 1);
		Game.world.setTile(70, 11, Assets.tlsFenceWooden[74], 1);
		Game.world.setTile(71, 11, Assets.tlsFenceWooden[75], 1);
		Game.world.setTile(72, 11, Assets.tlsFenceWooden[14], 1);
		Game.world.setTile(73, 11, Assets.tlsFenceWooden[12], 1);
		Game.world.setTile(74, 11, Assets.tlsFenceWooden[13], 1);
		Game.world.setTile(75, 11, Assets.tlsFenceWooden[12], 1);
		Game.world.setTile(76, 11, Assets.tlsFenceWooden[13], 1);
		Game.world.setTile(77, 11, Assets.tlsFenceWooden[14], 1);
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
		Game.world.setTile(45, 40, Assets.tlsJharvaVillage[61], 1);
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
		Game.world.setTile(45, 41, Assets.tlsJharvaVillage[69], 1);
		Game.world.setTile(46, 41, Assets.tlsJharvaVillage[62], 1);
		Game.world.setTile(49, 41, Assets.tlsJharvaVillage[25], 1);
		Game.world.setTile(50, 41, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(51, 41, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(52, 41, Assets.tlsJharvaVillage[31], 1);
		Game.world.setTile(41, 42, Assets.tlsJharvaVillage[33], 1);
		Game.world.setTile(42, 42, Assets.tlsJharvaVillage[35], 1);
		Game.world.setTile(43, 42, Assets.tlsJharvaVillage[34], 1);
		Game.world.setTile(44, 42, Assets.tlsJharvaVillage[53], 1);
		Game.world.setTile(45, 42, Assets.tlsJharvaVillage[77], 1);
		Game.world.setTile(46, 42, Assets.tlsJharvaVillage[93], 1);
		Game.world.setTile(49, 42, Assets.tlsJharvaVillage[33], 1);
		Game.world.setTile(50, 42, Assets.tlsJharvaVillage[35], 1);
		Game.world.setTile(51, 42, Assets.tlsJharvaVillage[34], 1);
		Game.world.setTile(52, 42, Assets.tlsJharvaVillage[39], 1);
		Game.world.setTile(46, 43, Assets.tlsJharvaVillage[62], 1);
		Game.world.setTile(46, 44, Assets.tlsJharvaVillage[62], 1);
		Game.world.setTile(44, 45, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(45, 45, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(46, 45, Assets.tlsJharvaVillage[86], 1);
		Game.world.setTile(47, 45, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(48, 45, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(49, 45, Assets.tlsJharvaVillage[47], 1);
		Game.world.setTile(51, 51, Assets.tlsJharvaVillage[1], 1);
		Game.world.setTile(52, 51, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(53, 51, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(54, 51, Assets.tlsJharvaVillage[7], 1);
		Game.world.setTile(51, 52, Assets.tlsJharvaVillage[17], 1);
		Game.world.setTile(52, 52, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(53, 52, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(54, 52, Assets.tlsJharvaVillage[23], 1);
		Game.world.setTile(51, 53, Assets.tlsJharvaVillage[25], 1);
		Game.world.setTile(52, 53, Assets.tlsJharvaSigns[4], 1);
		Game.world.setTile(53, 53, Assets.tlsJharvaSigns[5], 1);
		Game.world.setTile(54, 53, Assets.tlsJharvaVillage[31], 1);
		Game.world.setTile(51, 54, Assets.tlsJharvaVillage[33], 1);
		Game.world.setTile(52, 54, Assets.tlsJharvaVillage[35], 1);
		Game.world.setTile(53, 54, Assets.tlsJharvaVillage[34], 1);
		Game.world.setTile(54, 54, Assets.tlsJharvaVillage[39], 1);
		
		// Scenery
		Game.world.setScenery(57, 10, "JvGateWooden");
		Game.world.setScenery(58, 10, "JvGateWooden");
		Game.world.setScenery(59, 10, "JvGateWooden");
		
		int id = Game.world.setScenery(new BoardScenery(57, 10));
		Game.world.sceneryObject[id].script = new scnJvGateWooden();
		
		// Portals
		Game.world.setPortal("Interact", 50, 42, "JvPlayerHouse", 21, 18, "N");
		Game.world.setPortal("Interact", 74, 36, "JvLaboratoryMain", 19, 18, "N");
	}
}