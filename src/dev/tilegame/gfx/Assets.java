package dev.tilegame.gfx;
import dev.tilegame.entities.PlayerCreatureEntity;
import dev.tilegame.entities.NpcCreatureEntity;
import dev.tilegame.entities.HarvestNatureEntity;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets
{
	// Character
	public static PlayerCreatureEntity entPlayer;
	
	// NPCs
	public static NpcCreatureEntity entAnna;
	
	// Harvest
	public static HarvestNatureEntity entGarnet;
	
	// Interface
	public static BufferedImage uiCursor1, uiCursor2, uiCursor3;
	public static BufferedImage uiIntro0, uiIntro1, uiIntro2, uiIntro3;
	public static BufferedImage uiTitleBkg, uiTitleOpt1, uiTitleOpt1a, uiTitleOpt2, uiTitleOpt2a;
	public static BufferedImage uiTitleOpt3, uiTitleOpt3a, uiTitleOpt4, uiTitleOpt4a;
	public static BufferedImage uiGameInfo1;
	
	// Sprites
	public static BufferedImage charPlayerN1, charPlayerN2, charPlayerN3;
	public static BufferedImage charPlayerE1, charPlayerE2, charPlayerE3;
	public static BufferedImage charPlayerS1, charPlayerS2, charPlayerS3;
	public static BufferedImage charPlayerW1, charPlayerW2, charPlayerW3;
	public static BufferedImage npcAnnaN, npcAnnaE, npcAnnaS, npcAnnaW;
	public static BufferedImage itemGarnet1, itemGarnet2;
	
	// Textures
	public static BufferedImage txtGrass, txtTree;
	public static BufferedImage txtFence1L, txtFence1M, txtFence1MS, txtFence1R;
	
	// Fonts
	public static Font fontStandard, fontOption, fontHint;
	
	public static void init()
	{
		initInterface();
		initSprites();
		initTextures();
		initEntities();
	}
	
	public static void initEntities()
	{
		initEntityPlayer();
		initEntityNPCs();
		initEntityHarvest();
	}
	
	public static void initEntityHarvest()
	{
		entGarnet = new HarvestNatureEntity("Garnet");
		entGarnet.setPositionX(7);
		entGarnet.setPositionY(3);
	}
	
	public static void initEntityNPCs()
	{
		entAnna = new NpcCreatureEntity();
		entAnna.setPositionX(5);
		entAnna.setPositionY(4);
	}
	
	public static void initEntityPlayer()
	{
		entPlayer = new PlayerCreatureEntity();
		entPlayer.setDirection("S");
		entPlayer.setPositionX(5);
		entPlayer.setPositionY(5);
	}
	
	public static void initInterface()
	{		
		// Intro
		uiIntro0 = ImageLoader.loadImage("/interface/intro0.png");
		uiIntro1 = ImageLoader.loadImage("/interface/intro1.png");
		uiIntro2 = ImageLoader.loadImage("/interface/intro2.png");
		uiIntro3 = ImageLoader.loadImage("/interface/intro3.png");
		
		// Title
		uiTitleBkg = ImageLoader.loadImage("/interface/titleBkg.png");
		uiTitleOpt1 = ImageLoader.loadImage("/interface/titleOpt1.png");
		uiTitleOpt1a = ImageLoader.loadImage("/interface/titleOpt1a.png");
		uiTitleOpt2 = ImageLoader.loadImage("/interface/titleOpt2.png");
		uiTitleOpt2a = ImageLoader.loadImage("/interface/titleOpt2a.png");
		uiTitleOpt3 = ImageLoader.loadImage("/interface/titleOpt3.png");
		uiTitleOpt3a = ImageLoader.loadImage("/interface/titleOpt3a.png");
		uiTitleOpt4 = ImageLoader.loadImage("/interface/titleOpt4.png");
		uiTitleOpt4a = ImageLoader.loadImage("/interface/titleOpt4a.png");
		
		// Game
		uiGameInfo1 = ImageLoader.loadImage("/interface/gameInfo1.png");
		
		// Fonts
		fontStandard = new Font("Times New Roman", Font.PLAIN, 26);
		fontOption = new Font("Times New Roman", Font.PLAIN, 32);
		fontHint = new Font("Times New Roman", Font.ITALIC, 22);
	}
	
	public static void initSprites()
	{
		// Player Sheet
		Spritesheet sheetPlayer = new Spritesheet(ImageLoader.loadImage("/sprites/player.png"));
		
		// Player Images
		charPlayerN1 = sheetPlayer.crop(32, 96, 32, 32);
		charPlayerN2 = sheetPlayer.crop(0, 96, 32, 32);
		charPlayerN3 = sheetPlayer.crop(64, 96, 32, 32);
		charPlayerE1 = sheetPlayer.crop(32, 64, 32, 32);
		charPlayerE2 = sheetPlayer.crop(0, 64, 32, 32);
		charPlayerE3 = sheetPlayer.crop(64, 64, 32, 32);
		charPlayerS1 = sheetPlayer.crop(32, 0, 32, 32);
		charPlayerS2 = sheetPlayer.crop(0, 0, 32, 32);
		charPlayerS3 = sheetPlayer.crop(64, 0, 32, 32);
		charPlayerW1 = sheetPlayer.crop(32, 32, 32, 32);
		charPlayerW2 = sheetPlayer.crop(0, 32, 32, 32);
		charPlayerW3 = sheetPlayer.crop(64, 32, 32, 32);
		
		// NCP Anna Sheet
		Spritesheet sheetAnna = new Spritesheet(ImageLoader.loadImage("/sprites/npcAnna.png"));
		
		// Player Images
		npcAnnaN = sheetAnna.crop(32, 96, 32, 32);
		npcAnnaE = sheetAnna.crop(32, 64, 32, 32);
		npcAnnaS = sheetAnna.crop(32, 0, 32, 32);
		npcAnnaW = sheetAnna.crop(32, 32, 32, 32);
		
		// Garnet Sheet
		Spritesheet sheetGarnet = new Spritesheet(ImageLoader.loadImage("/sprites/garnet.png"));
		
		// Garnet Images
		itemGarnet1 = sheetGarnet.crop(0, 0, 32, 32);
		itemGarnet2 = sheetGarnet.crop(32, 0, 32, 32);
	}
	
	public static void initTextures()
	{
		// World Sheet
		Spritesheet sheetWorld = new Spritesheet(ImageLoader.loadImage("/textures/world.png"));
		
		// World Images
		txtGrass = sheetWorld.crop(0, 0, 32, 32);
		txtTree = sheetWorld.crop(32, 0, 32, 32);
		txtFence1L = sheetWorld.crop(64, 0, 32, 32);
		txtFence1M = sheetWorld.crop(96, 0, 32, 32);
		txtFence1MS = sheetWorld.crop(128, 0, 32, 32);
		txtFence1R = sheetWorld.crop(160, 0, 32, 32);
	}

}