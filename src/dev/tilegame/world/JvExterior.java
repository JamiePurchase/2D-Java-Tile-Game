package dev.tilegame.world;

import dev.tilegame.Game;
import dev.tilegame.dialogue.talkHofmann;
import dev.tilegame.entities.BoardNpc;
import dev.tilegame.entities.BoardScenery;
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
		Game.world.setTile(57, 1, Assets.tlsJharvaVillage[104], 0);
		Game.world.setTile(58, 1, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(59, 1, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(60, 1, Assets.tlsJharvaVillage[129], 0);
		Game.world.setTile(61, 1, Assets.tlsJharvaVillage[130], 0);
		Game.world.setTile(57, 2, Assets.tlsJharvaVillage[112], 0);
		Game.world.setTile(58, 2, Assets.tlsJharvaVillage[113], 0);
		Game.world.setTile(59, 2, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(60, 2, Assets.tlsJharvaVillage[106], 0);
		Game.world.setTile(57, 3, Assets.tlsJharvaVillage[120], 0);
		Game.world.setTile(58, 3, Assets.tlsJharvaVillage[121], 0);
		Game.world.setTile(59, 3, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(60, 3, Assets.tlsJharvaVillage[114], 0);
		Game.world.setTile(57, 4, Assets.tlsJharvaVillage[128], 0);
		Game.world.setTile(58, 4, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(59, 4, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(60, 4, Assets.tlsJharvaVillage[122], 0);
		Game.world.setTile(57, 5, Assets.tlsJharvaVillage[64], 0);
		Game.world.setTile(58, 5, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(59, 5, Assets.tlsJharvaVillage[129], 0);
		Game.world.setTile(60, 5, Assets.tlsJharvaVillage[130], 0);
		Game.world.setTile(57, 6, Assets.tlsJharvaVillage[110], 0);
		Game.world.setTile(58, 6, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(59, 6, Assets.tlsJharvaVillage[68], 0);
		Game.world.setTile(56, 7, Assets.tlsFenceWooden[9], 1);
		//Game.world.setTile(57, 7, Assets.tlsFenceWooden[10], 1);
		Game.world.setTile(57, 7, Assets.tlsJharvaVillage[64], 0);
		Game.world.setTile(58, 7, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(59, 7, Assets.tlsJharvaVillage[111], 0);
		Game.world.setTile(60, 7, Assets.tlsFenceWooden[9], 1);
		Game.world.setTile(61, 7, Assets.tlsFenceWooden[10], 1);
		Game.world.setTile(56, 8, Assets.tlsFenceWooden[21], 1);
		Game.world.setTile(57, 8, Assets.tlsJharvaVillage[64], 0);
		Game.world.setTile(58, 8, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(59, 8, Assets.tlsJharvaVillage[68], 0);
		Game.world.setTile(60, 8, Assets.tlsFenceWooden[21], 1);
		Game.world.setTile(49, 9, Assets.tlsFenceWooden[2], 1);
		Game.world.setTile(50, 9, Assets.tlsFenceWooden[0], 1);
		Game.world.setTile(51, 9, Assets.tlsFenceWooden[1], 1);
		Game.world.setTile(52, 9, Assets.tlsFenceWooden[0], 1);
		Game.world.setTile(53, 9, Assets.tlsFenceWooden[1], 1);
		Game.world.setTile(54, 9, Assets.tlsFenceWooden[0], 1);
		Game.world.setTile(55, 9, Assets.tlsFenceWooden[1], 1);
		Game.world.setTile(56, 9, Assets.tlsFenceWooden[22], 1);
		Game.world.setTile(57, 9, Assets.tlsFenceWooden[27], 1);
		Game.world.setTile(58, 9, Assets.tlsFenceWooden[28], 1);
		Game.world.setTile(59, 9, Assets.tlsFenceWooden[29], 1);
		Game.world.setTile(60, 9, Assets.tlsFenceWooden[22], 1);
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
		Game.world.setTile(49, 10, Assets.tlsFenceWooden[14], 1);
		Game.world.setTile(50, 10, Assets.tlsFenceWooden[12], 1);
		Game.world.setTile(51, 10, Assets.tlsFenceWooden[13], 1);
		Game.world.setTile(52, 10, Assets.tlsFenceWooden[12], 1);
		Game.world.setTile(53, 10, Assets.tlsFenceWooden[13], 1);
		Game.world.setTile(54, 10, Assets.tlsFenceWooden[12], 1);
		Game.world.setTile(55, 10, Assets.tlsFenceWooden[13], 1);
		Game.world.setTile(56, 10, Assets.tlsFenceWooden[14], 1);
		Game.world.setTile(57, 10, Assets.tlsFenceWooden[39], 1);
		Game.world.setTile(58, 10, Assets.tlsFenceWooden[40], 1);
		Game.world.setTile(59, 10, Assets.tlsFenceWooden[41], 1);
		Game.world.setTile(60, 10, Assets.tlsFenceWooden[14], 1);
		Game.world.setTile(61, 10, Assets.tlsFenceWooden[12], 1);
		Game.world.setTile(62, 10, Assets.tlsJharvaVillage[99], 1);
		Game.world.setTile(63, 10, Assets.tlsFenceWooden[12], 1);
		Game.world.setTile(64, 10, Assets.tlsFenceWooden[13], 1);
		Game.world.setTile(65, 10, Assets.tlsJharvaVillage[96], 1);
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
		Game.world.setTile(56, 11, Assets.tlsJharvaVillage[126], 0);
		Game.world.setTile(57, 11, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(58, 11, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(59, 11, Assets.tlsJharvaVillage[68], 0);
		Game.world.setTile(62, 11, Assets.tlsJharvaVillage[80], 1);
		Game.world.setTile(63, 11, Assets.tlsJharvaVillage[85], 1);
		Game.world.setTile(65, 11, Assets.tlsJharvaVillage[16], 1);
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
		Game.world.setTile(56, 12, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(57, 12, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(58, 12, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(59, 12, Assets.tlsJharvaVillage[68], 0);
		Game.world.setTile(63, 12, Assets.tlsJharvaVillage[80], 1);
		Game.world.setTile(57, 13, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(58, 13, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(59, 13, Assets.tlsJharvaVillage[68], 0);
		Game.world.setTile(61, 13, Assets.tlsJharvaVillage[54], 1);
		Game.world.setTile(62, 13, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(63, 13, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(57, 14, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(58, 14, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(61, 14, Assets.tlsJharvaVillage[62], 1);
		Game.world.setTile(57, 15, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(58, 15, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(61, 15, Assets.tlsJharvaVillage[62], 1);
		Game.world.setTile(55, 16, Assets.tlsJharvaVillage[134], 0);
		Game.world.setTile(56, 16, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(57, 16, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(58, 16, Assets.tlsJharvaVillage[58], 0);
		Game.world.setTile(61, 16, Assets.tlsJharvaVillage[62], 1);
		Game.world.setTile(61, 17, Assets.tlsJharvaVillage[62], 1);
		Game.world.setTile(61, 18, Assets.tlsJharvaVillage[62], 1);
		Game.world.setTile(61, 19, Assets.tlsJharvaVillage[62], 1);
		Game.world.setTile(61, 20, Assets.tlsJharvaVillage[70], 1);
		Game.world.setTile(62, 20, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(63, 20, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(64, 20, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(65, 20, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(27, 22, Assets.tlsJharvaVillage[144], 1);
		Game.world.setTile(28, 22, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(29, 22, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(30, 22, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(31, 22, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(32, 22, Assets.tlsJharvaVillage[146], 1);
		Game.world.setTile(27, 23, Assets.tlsJharvaVillage[144], 1);
		Game.world.setTile(28, 23, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(29, 23, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(30, 23, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(31, 23, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(32, 23, Assets.tlsJharvaVillage[146], 1);
		Game.world.setTile(27, 24, Assets.tlsBridgeWooden[6], 1);
		Game.world.setTile(28, 24, Assets.tlsBridgeWooden[7], 1);
		Game.world.setTile(29, 24, Assets.tlsBridgeWooden[8], 1);
		Game.world.setTile(30, 24, Assets.tlsBridgeWooden[9], 1);
		Game.world.setTile(31, 24, Assets.tlsBridgeWooden[10], 1);
		Game.world.setTile(32, 24, Assets.tlsBridgeWooden[11], 1);
		Game.world.setTile(27, 25, Assets.tlsBridgeWooden[18], 0);
		Game.world.setTile(28, 25, Assets.tlsBridgeWooden[19], 0);
		Game.world.setTile(29, 25, Assets.tlsBridgeWooden[20], 0);
		Game.world.setTile(30, 25, Assets.tlsBridgeWooden[21], 0);
		Game.world.setTile(31, 25, Assets.tlsBridgeWooden[22], 0);
		Game.world.setTile(32, 25, Assets.tlsBridgeWooden[23], 0);
		Game.world.setTile(27, 26, Assets.tlsBridgeWooden[30], 0);
		Game.world.setTile(28, 26, Assets.tlsBridgeWooden[31], 0);
		Game.world.setTile(29, 26, Assets.tlsBridgeWooden[32], 0);
		Game.world.setTile(30, 26, Assets.tlsBridgeWooden[33], 0);
		Game.world.setTile(31, 26, Assets.tlsBridgeWooden[34], 0);
		Game.world.setTile(32, 26, Assets.tlsBridgeWooden[35], 0);
		Game.world.setTile(27, 27, Assets.tlsBridgeWooden[42], 1);
		Game.world.setTile(28, 27, Assets.tlsBridgeWooden[43], 1);
		Game.world.setTile(29, 27, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(30, 27, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(31, 27, Assets.tlsBridgeWooden[46], 1);
		Game.world.setTile(32, 27, Assets.tlsBridgeWooden[47], 1);
		Game.world.setTile(27, 28, Assets.tlsJharvaVillage[144], 1);
		Game.world.setTile(28, 28, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(29, 28, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(30, 28, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(31, 28, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(32, 28, Assets.tlsJharvaVillage[146], 1);
		Game.world.setTile(27, 29, Assets.tlsJharvaVillage[144], 1);
		Game.world.setTile(28, 29, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(29, 29, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(30, 29, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(31, 29, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(32, 29, Assets.tlsJharvaVillage[146], 1);
		Game.world.setTile(27, 30, Assets.tlsJharvaVillage[139], 1);
		Game.world.setTile(28, 30, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(27, 31, Assets.tlsJharvaVillage[147], 1);
		Game.world.setTile(28, 31, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(16, 32, Assets.tlsJharvaTemple[0], 1);
		Game.world.setTile(17, 32, Assets.tlsJharvaTemple[1], 1);
		Game.world.setTile(27, 32, Assets.tlsJharvaVillage[155], 1);
		Game.world.setTile(28, 32, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(16, 33, Assets.tlsJharvaTemple[7], 1);
		Game.world.setTile(17, 33, Assets.tlsJharvaTemple[8], 1);
		Game.world.setTile(71, 33, Assets.tlsJharvaVillage[1], 1);
		Game.world.setTile(72, 33, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(73, 33, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(74, 33, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(75, 33, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(76, 33, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(77, 33, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(78, 33, Assets.tlsJharvaVillage[7], 1);
		Game.world.setTile(16, 34, Assets.tlsJharvaTemple[14], 1);
		Game.world.setTile(17, 34, Assets.tlsJharvaTemple[15], 1);
		Game.world.setTile(71, 34, Assets.tlsJharvaVillage[17], 1);
		Game.world.setTile(72, 34, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(73, 34, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(74, 34, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(75, 34, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(76, 34, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(77, 34, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(78, 34, Assets.tlsJharvaVillage[23], 1);
		Game.world.setTile(16, 35, Assets.tlsJharvaTemple[21], 1);
		Game.world.setTile(17, 35, Assets.tlsJharvaTemple[22], 1);
		Game.world.setTile(18, 35, Assets.tlsJharvaTemple[23], 1);
		Game.world.setTile(19, 35, Assets.tlsJharvaTemple[24], 1);
		Game.world.setTile(20, 35, Assets.tlsJharvaTemple[25], 1);
		Game.world.setTile(21, 35, Assets.tlsJharvaTemple[26], 1);
		Game.world.setTile(22, 35, Assets.tlsJharvaTemple[27], 1);
		Game.world.setTile(71, 35, Assets.tlsJharvaVillage[25], 1);
		Game.world.setTile(72, 35, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(73, 35, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(74, 35, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(75, 35, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(76, 35, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(77, 35, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(78, 35, Assets.tlsJharvaVillage[31], 1);
		Game.world.setTile(16, 36, Assets.tlsJharvaTemple[28], 1);
		Game.world.setTile(17, 36, Assets.tlsJharvaTemple[29], 1);
		Game.world.setTile(18, 36, Assets.tlsJharvaTemple[30], 1);
		Game.world.setTile(19, 36, Assets.tlsJharvaTemple[31], 1);
		Game.world.setTile(20, 36, Assets.tlsJharvaTemple[32], 1);
		Game.world.setTile(21, 36, Assets.tlsJharvaTemple[33], 1);
		Game.world.setTile(22, 36, Assets.tlsJharvaTemple[34], 1);
		Game.world.setTile(68, 36, Assets.tlsJharvaVillage3[4], 1);
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
		Game.world.setTile(16, 37, Assets.tlsJharvaTemple[35], 1);
		Game.world.setTile(17, 37, Assets.tlsJharvaTemple[36], 1);
		Game.world.setTile(18, 37, Assets.tlsJharvaTemple[37], 1);
		Game.world.setTile(19, 37, Assets.tlsJharvaTemple[38], 1);
		Game.world.setTile(20, 37, Assets.tlsJharvaTemple[39], 1);
		Game.world.setTile(21, 37, Assets.tlsJharvaTemple[40], 1);
		Game.world.setTile(22, 37, Assets.tlsJharvaTemple[41], 1);
		Game.world.setTile(68, 37, Assets.tlsJharvaVillage3[8], 1);
		Game.world.setTile(69, 37, Assets.tlsJharvaVillage[62], 1);
		Game.world.setTile(82, 37, Assets.tlsJharvaVillage[63], 1);
		Game.world.setTile(16, 38, Assets.tlsJharvaTemple[42], 1);
		Game.world.setTile(17, 38, Assets.tlsJharvaTemple[43], 1);
		Game.world.setTile(18, 38, Assets.tlsJharvaTemple[44], 1);
		Game.world.setTile(19, 38, Assets.tlsJharvaTemple[45], 1);
		Game.world.setTile(20, 38, Assets.tlsJharvaTemple[46], 1);
		Game.world.setTile(21, 38, Assets.tlsJharvaTemple[47], 1);
		Game.world.setTile(22, 38, Assets.tlsJharvaTemple[48], 1);
		Game.world.setTile(68, 38, Assets.tlsJharvaVillage3[8], 1);
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
		Game.world.setTile(68, 39, Assets.tlsJharvaVillage3[8], 1);
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
		Game.world.setTile(62, 40, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(63, 40, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(68, 40, Assets.tlsJharvaVillage3[8], 1);
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
		Game.world.setTile(17, 41, Assets.tlsJharvaTemple[5], 1);
		Game.world.setTile(18, 41, Assets.tlsJharvaTemple[6], 1);
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
		Game.world.setTile(68, 41, Assets.tlsJharvaVillage3[16], 1);
		Game.world.setTile(69, 41, Assets.tlsJharvaVillage3[4], 1);
		Game.world.setTile(70, 41, Assets.tlsJharvaVillage3[5], 1);
		Game.world.setTile(71, 41, Assets.tlsJharvaVillage3[6], 1);
		Game.world.setTile(72, 41, Assets.tlsJharvaVillage3[7], 1);
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
		Game.world.setTile(68, 42, Assets.tlsJharvaVillage3[32], 1);
		Game.world.setTile(69, 42, Assets.tlsJharvaVillage3[12], 1);
		Game.world.setTile(70, 42, Assets.tlsJharvaVillage3[26], 1);
		Game.world.setTile(71, 42, Assets.tlsJharvaVillage3[26], 1);
		Game.world.setTile(72, 42, Assets.tlsJharvaVillage3[15], 1);
		Game.world.setTile(46, 43, Assets.tlsJharvaVillage[62], 1);
		Game.world.setTile(69, 43, Assets.tlsJharvaVillage3[20], 1);
		Game.world.setTile(70, 43, Assets.tlsJharvaVillage3[21], 1);
		Game.world.setTile(71, 43, Assets.tlsJharvaVillage3[22], 1);
		Game.world.setTile(72, 43, Assets.tlsJharvaVillage3[23], 1);
		Game.world.setTile(46, 44, Assets.tlsJharvaVillage[62], 1);
		Game.world.setTile(44, 45, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(45, 45, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(46, 45, Assets.tlsJharvaVillage[86], 1);
		Game.world.setTile(47, 45, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(48, 45, Assets.tlsJharvaVillage[43], 1);
		Game.world.setTile(49, 45, Assets.tlsJharvaVillage[47], 1);
		Game.world.setTile(22, 50, Assets.tlsJharvaVillage[1], 1);
		Game.world.setTile(23, 50, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(24, 50, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(25, 50, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(26, 50, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(27, 50, Assets.tlsJharvaVillage[7], 1);
		Game.world.setTile(22, 51, Assets.tlsJharvaVillage[17], 1);
		Game.world.setTile(23, 51, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(24, 51, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(25, 51, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(26, 51, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(27, 51, Assets.tlsJharvaVillage[23], 1);
		Game.world.setTile(54, 52, Assets.tlsJharvaVillage[23], 1);
		Game.world.setTile(51, 51, Assets.tlsJharvaVillage[1], 1);
		Game.world.setTile(52, 51, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(53, 51, Assets.tlsJharvaVillage[2], 1);
		Game.world.setTile(54, 51, Assets.tlsJharvaVillage[7], 1);
		Game.world.setTile(22, 52, Assets.tlsJharvaVillage[25], 1);
		Game.world.setTile(23, 52, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(24, 52, Assets.tlsJharvaSigns[2], 1);
		Game.world.setTile(25, 52, Assets.tlsJharvaSigns[3], 1);
		Game.world.setTile(26, 52, Assets.tlsJharvaVillage[27], 1);
		Game.world.setTile(27, 52, Assets.tlsJharvaVillage[31], 1);
		Game.world.setTile(51, 52, Assets.tlsJharvaVillage[17], 1);
		Game.world.setTile(52, 52, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(53, 52, Assets.tlsJharvaVillage[18], 1);
		Game.world.setTile(54, 52, Assets.tlsJharvaVillage[23], 1);
		Game.world.setTile(22, 53, Assets.tlsJharvaVillage[33], 1);
		Game.world.setTile(23, 53, Assets.tlsJharvaVillage[34], 1);
		Game.world.setTile(24, 53, Assets.tlsJharvaVillage[35], 1);
		Game.world.setTile(25, 53, Assets.tlsJharvaVillage[34], 1);
		Game.world.setTile(26, 53, Assets.tlsJharvaVillage[34], 1);
		Game.world.setTile(27, 53, Assets.tlsJharvaVillage[39], 1);
		Game.world.setTile(51, 53, Assets.tlsJharvaVillage[25], 1);
		Game.world.setTile(52, 53, Assets.tlsJharvaSigns[4], 1);
		Game.world.setTile(53, 53, Assets.tlsJharvaSigns[5], 1);
		Game.world.setTile(54, 53, Assets.tlsJharvaVillage[31], 1);
		Game.world.setTile(34, 54, Assets.tlsJharvaVillage[144], 1);
		Game.world.setTile(35, 54, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(36, 54, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(37, 54, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(38, 54, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(39, 54, Assets.tlsJharvaVillage[146], 1);
		Game.world.setTile(51, 54, Assets.tlsJharvaVillage[33], 1);
		Game.world.setTile(52, 54, Assets.tlsJharvaVillage[35], 1);
		Game.world.setTile(53, 54, Assets.tlsJharvaVillage[34], 1);
		Game.world.setTile(54, 54, Assets.tlsJharvaVillage[39], 1);
		Game.world.setTile(34, 55, Assets.tlsJharvaVillage[144], 1);
		Game.world.setTile(35, 55, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(36, 55, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(37, 55, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(38, 55, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(39, 55, Assets.tlsJharvaVillage[146], 1);
		Game.world.setTile(48, 55, Assets.tlsJharvaVillage2[65], 1);
		Game.world.setTile(49, 55, Assets.tlsJharvaVillage2[66], 1);
		Game.world.setTile(52, 55, Assets.tlsJharvaVillage2[30], 0);
		Game.world.setTile(32, 56, Assets.tlsBridgeWooden[50], 0);
		Game.world.setTile(33, 56, Assets.tlsBridgeWooden[51], 0);
		Game.world.setTile(34, 56, Assets.tlsBridgeWooden[6], 1);
		Game.world.setTile(35, 56, Assets.tlsBridgeWooden[7], 1);
		Game.world.setTile(36, 56, Assets.tlsBridgeWooden[8], 1);
		Game.world.setTile(37, 56, Assets.tlsBridgeWooden[9], 1);
		Game.world.setTile(38, 56, Assets.tlsBridgeWooden[10], 1);
		Game.world.setTile(39, 56, Assets.tlsBridgeWooden[11], 1);
		Game.world.setTile(40, 56, Assets.tlsBridgeWooden[48], 0);
		Game.world.setTile(41, 56, Assets.tlsBridgeWooden[49], 0);
		Game.world.setTile(42, 56, Assets.tlsJharvaVillage2[25], 0);
		Game.world.setTile(43, 56, Assets.tlsJharvaVillage2[25], 0);
		Game.world.setTile(44, 56, Assets.tlsJharvaVillage2[24], 0);
		Game.world.setTile(45, 56, Assets.tlsJharvaVillage2[4], 0);
		Game.world.setTile(46, 56, Assets.tlsJharvaVillage2[5], 0);
		Game.world.setTile(47, 56, Assets.tlsJharvaVillage2[6], 0);
		Game.world.setTile(48, 56, Assets.tlsJharvaVillage2[72], 0);
		Game.world.setTile(49, 56, Assets.tlsJharvaVillage2[74], 1);
		Game.world.setTile(50, 56, Assets.tlsJharvaVillage2[75], 1);
		Game.world.setTile(51, 56, Assets.tlsJharvaVillage[47], 1);
		Game.world.setTile(52, 56, Assets.tlsJharvaVillage2[38], 0);
		Game.world.setTile(53, 56, Assets.tlsJharvaVillage[42], 1);
		Game.world.setTile(54, 56, Assets.tlsJharvaVillage[46], 1);
		Game.world.setTile(55, 56, Assets.tlsJharvaVillage[45], 1);
		Game.world.setTile(32, 57, Assets.tlsBridgeWooden[62], 0);
		Game.world.setTile(33, 57, Assets.tlsBridgeWooden[63], 0);
		Game.world.setTile(34, 57, Assets.tlsBridgeWooden[18], 0);
		Game.world.setTile(35, 57, Assets.tlsBridgeWooden[19], 0);
		Game.world.setTile(36, 57, Assets.tlsBridgeWooden[20], 0);
		Game.world.setTile(37, 57, Assets.tlsBridgeWooden[21], 0);
		Game.world.setTile(38, 57, Assets.tlsBridgeWooden[22], 0);
		Game.world.setTile(39, 57, Assets.tlsBridgeWooden[23], 0);
		Game.world.setTile(40, 57, Assets.tlsBridgeWooden[60], 0);
		Game.world.setTile(41, 57, Assets.tlsBridgeWooden[61], 0);
		Game.world.setTile(42, 57, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(43, 57, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(44, 57, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(45, 57, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(46, 57, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(47, 57, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(48, 57, Assets.tlsJharvaVillage2[15], 0);
		Game.world.setTile(49, 57, Assets.tlsJharvaVillage2[24], 0);
		Game.world.setTile(50, 57, Assets.tlsJharvaVillage2[25], 0);
		Game.world.setTile(51, 57, Assets.tlsJharvaVillage2[24], 0);
		Game.world.setTile(52, 57, Assets.tlsJharvaVillage2[46], 0);
		Game.world.setTile(53, 57, Assets.tlsJharvaVillage2[25], 0);
		Game.world.setTile(32, 58, Assets.tlsBridgeWooden[74], 0);
		Game.world.setTile(33, 58, Assets.tlsBridgeWooden[75], 0);
		Game.world.setTile(34, 58, Assets.tlsBridgeWooden[30], 0);
		Game.world.setTile(35, 58, Assets.tlsBridgeWooden[31], 0);
		Game.world.setTile(36, 58, Assets.tlsBridgeWooden[32], 0);
		Game.world.setTile(37, 58, Assets.tlsBridgeWooden[33], 0);
		Game.world.setTile(38, 58, Assets.tlsBridgeWooden[34], 0);
		Game.world.setTile(39, 58, Assets.tlsBridgeWooden[35], 0);
		Game.world.setTile(40, 58, Assets.tlsBridgeWooden[72], 0);
		Game.world.setTile(41, 58, Assets.tlsBridgeWooden[73], 0);
		Game.world.setTile(42, 58, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(43, 58, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(44, 58, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(45, 58, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(46, 58, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(47, 58, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(48, 58, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(49, 58, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(50, 58, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(51, 58, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(52, 58, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(53, 58, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(32, 59, Assets.tlsBridgeWooden[86], 0);
		Game.world.setTile(33, 59, Assets.tlsBridgeWooden[87], 0);
		Game.world.setTile(34, 59, Assets.tlsBridgeWooden[42], 1);
		Game.world.setTile(35, 59, Assets.tlsBridgeWooden[43], 1);
		Game.world.setTile(36, 59, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(37, 59, Assets.tlsJharvaVillage[145], 1);
		Game.world.setTile(38, 59, Assets.tlsBridgeWooden[46], 1);
		Game.world.setTile(39, 59, Assets.tlsBridgeWooden[47], 1);
		Game.world.setTile(40, 59, Assets.tlsBridgeWooden[84], 0);
		Game.world.setTile(41, 59, Assets.tlsBridgeWooden[85], 0);
		Game.world.setTile(42, 59, Assets.tlsJharvaVillage2[33], 0);
		Game.world.setTile(43, 59, Assets.tlsJharvaVillage2[12], 0);
		Game.world.setTile(44, 59, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(45, 59, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(46, 59, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(47, 59, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(48, 59, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(49, 59, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(50, 59, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(51, 59, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(52, 59, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(53, 59, Assets.tlsJharvaVillage2[28], 0);
		Game.world.setTile(43, 60, Assets.tlsJharvaVillage2[20], 0);
		Game.world.setTile(44, 60, Assets.tlsJharvaVillage2[21], 0);
		Game.world.setTile(45, 60, Assets.tlsJharvaVillage2[22], 0);
		Game.world.setTile(46, 60, Assets.tlsJharvaVillage2[23], 0);
		Game.world.setTile(47, 60, Assets.tlsJharvaVillage2[33], 0);
		Game.world.setTile(48, 60, Assets.tlsJharvaVillage2[32], 0);
		Game.world.setTile(49, 60, Assets.tlsJharvaVillage2[32], 0);
		Game.world.setTile(50, 60, Assets.tlsJharvaVillage2[33], 0);
		Game.world.setTile(51, 60, Assets.tlsJharvaVillage2[32], 0);
		Game.world.setTile(52, 60, Assets.tlsJharvaVillage2[33], 0);
		Game.world.setTile(53, 60, Assets.tlsJharvaVillage2[32], 0);
		
		// Footsteps
		Game.world.setFootstepInit("Grass");
		Game.world.setFootstep(34, 57, "Wood");
		Game.world.setFootstep(35, 57, "Wood");
		Game.world.setFootstep(36, 57, "Wood");
		Game.world.setFootstep(37, 57, "Wood");
		Game.world.setFootstep(38, 57, "Wood");
		Game.world.setFootstep(39, 57, "Wood");
		
		// Scenery (north gate)
		Game.world.setScenery(57, 10, "JvGateWooden");
		Game.world.setScenery(58, 10, "JvGateWooden");
		Game.world.setScenery(59, 10, "JvGateWooden");
		
		// Scenery (job board)
		Game.world.setScenery(17, 41, "JvJobBoard");
		Game.world.setScenery(18, 41, "JvJobBoard");
		
		// Scenery (potion shop sign)
		//Game.world.setScenery(54, 56, "JvSignShopPotion");
		
		int id = Game.world.setScenery(new BoardScenery(57, 10));
		//Game.world.sceneryObject[id].script = new scnJvGateWooden();
		
		// Signs
		Game.world.setSign(54, 56, "Trusted Tonics","You can rely on us for quality potions and a good stock of alchemical ingredients.");
		
		// Portals
		Game.world.setPortal("Interact", 50, 42, "JvPlayerHouse", 21, 18, "N");
		Game.world.setPortal("Interact", 74, 36, "JvLaboratoryMain", 19, 18, "N");
		Game.world.setPortal("Interact", 24, 53, "JvBlacksmith", 21, 18, "N");
		Game.world.setPortal("Interact", 52, 54, "JvPotionShop", 21, 18, "N");
		
		// Elevation (north bridge)
		Game.world.setElevation(27, 25, 14);
		Game.world.setElevation(28, 25, 24);
		Game.world.setElevation(29, 25, 34);
		Game.world.setElevation(30, 25, 34);
		Game.world.setElevation(31, 25, 24);
		Game.world.setElevation(32, 25, 14);
		Game.world.setElevation(27, 26, 16);
		Game.world.setElevation(28, 26, 26);
		Game.world.setElevation(29, 26, 36);
		Game.world.setElevation(30, 26, 38);
		Game.world.setElevation(31, 26, 28);
		Game.world.setElevation(32, 26, 18);
		
		// Elevation (south bridge)
		Game.world.setElevation(34, 57, 14);
		Game.world.setElevation(35, 57, 24);
		Game.world.setElevation(36, 57, 34);
		Game.world.setElevation(37, 57, 34);
		Game.world.setElevation(38, 57, 24);
		Game.world.setElevation(39, 57, 14);
		Game.world.setElevation(34, 58, 16);
		Game.world.setElevation(35, 58, 26);
		Game.world.setElevation(36, 58, 36);
		Game.world.setElevation(37, 58, 38);
		Game.world.setElevation(38, 58, 28);
		Game.world.setElevation(39, 58, 18);
	}
}