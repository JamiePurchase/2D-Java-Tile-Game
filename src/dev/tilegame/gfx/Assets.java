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
	public static BufferedImage uiOptDone, uiOptDoneA;
	public static BufferedImage uiOptionsBkg, uiTutorialBkg, uiAboutBkg;
	public static BufferedImage uiGameInfo1, uiGameInfoMushroom, uiGameInfoTreasure;
	public static BufferedImage[] uiGameInfoCount = new BufferedImage[10];

	// Sprites
	public static BufferedImage charPlayerN1, charPlayerN2, charPlayerN3;
	public static BufferedImage charPlayerE1, charPlayerE2, charPlayerE3;
	public static BufferedImage charPlayerS1, charPlayerS2, charPlayerS3;
	public static BufferedImage charPlayerW1, charPlayerW2, charPlayerW3;
	public static BufferedImage npcAnnaN, npcAnnaE, npcAnnaS, npcAnnaW;
	public static BufferedImage itemMushroom1, itemChest1;
	public static BufferedImage itemGarnet1, itemGarnet2;
	
	// Textures
	public static BufferedImage txtGrass, txtFence1L, txtFence1M, txtFence1MS, txtFence1R;
	public static BufferedImage txtTree1a, txtTree1b, txtTree1c, txtTree2a, txtTree2b;
	public static BufferedImage txtTree3aL, txtTree3aR, txtTree3bL, txtTree3bR;
	public static BufferedImage txtTree4aL, txtTree4aR, txtTree5aL, txtTree5aR;
	public static BufferedImage txtTree6TL, txtTree6TR, txtTree6BL, txtTree6BR;
	
	// Fonts
	public static Font fontStandard, fontOption, fontHint, fontInfoCount;
	
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
		uiOptDone = ImageLoader.loadImage("/interface/uiOptDone.png");
		uiOptDoneA = ImageLoader.loadImage("/interface/uiOptDoneA.png");
		
		// Options
		uiOptionsBkg = ImageLoader.loadImage("/interface/optionsBkg.png");
		
		// Tutorial
		uiTutorialBkg = ImageLoader.loadImage("/interface/tutorialBkg.png");
		
		// About
		uiAboutBkg = ImageLoader.loadImage("/interface/aboutBkg.png");
		
		// Game
		uiGameInfo1 = ImageLoader.loadImage("/interface/gameInfo1.png");
		uiGameInfoMushroom = ImageLoader.loadImage("/interface/gameInfoPanelM.png");
		uiGameInfoTreasure = ImageLoader.loadImage("/interface/gameInfoPanelT.png");
		Spritesheet sheetInfoCount = new Spritesheet(ImageLoader.loadImage("/interface/gameInfoCount.png"));
		uiGameInfoCount[0] = sheetInfoCount.crop(0, 0, 36, 36);
		uiGameInfoCount[1] = sheetInfoCount.crop(36, 0, 36, 36);
		uiGameInfoCount[2] = sheetInfoCount.crop(72, 0, 36, 36);
		uiGameInfoCount[3] = sheetInfoCount.crop(108, 0, 36, 36);
		uiGameInfoCount[4] = sheetInfoCount.crop(144, 0, 36, 36);
		uiGameInfoCount[5] = sheetInfoCount.crop(180, 0, 36, 36);
		uiGameInfoCount[6] = sheetInfoCount.crop(216, 0, 36, 36);
		uiGameInfoCount[7] = sheetInfoCount.crop(252, 0, 36, 36);
		uiGameInfoCount[8] = sheetInfoCount.crop(288, 0, 36, 36);
		uiGameInfoCount[9] = sheetInfoCount.crop(324, 0, 36, 36);
		
		// Fonts
		fontStandard = new Font("Times New Roman", Font.PLAIN, 26);
		fontOption = new Font("Times New Roman", Font.PLAIN, 32);
		fontHint = new Font("Times New Roman", Font.ITALIC, 22);
		fontInfoCount = new Font("Times New Roman", Font.BOLD, 36);
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
		
		// Mushroom
		itemMushroom1 = ImageLoader.loadImage("/sprites/mushroom.png");
		
		// Treasure
		itemChest1 = ImageLoader.loadImage("/sprites/chest.png");
		
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
		txtTree1a = sheetWorld.crop(32, 0, 32, 32);
		txtFence1L = sheetWorld.crop(64, 0, 32, 32);
		txtFence1M = sheetWorld.crop(96, 0, 32, 32);
		txtFence1MS = sheetWorld.crop(128, 0, 32, 32);
		txtFence1R = sheetWorld.crop(160, 0, 32, 32);
		
		// Look at these again
		txtTree1b = sheetWorld.crop(0, 32, 32, 32);
		txtTree1c = sheetWorld.crop(0, 64, 32, 32);
		txtTree2a = sheetWorld.crop(96, 32, 32, 32);
		txtTree2b = sheetWorld.crop(96, 64, 32, 32);
		txtTree3aL = sheetWorld.crop(32, 32, 32, 32);
		txtTree3aR = sheetWorld.crop(64, 32, 32, 32);
		txtTree3bL = sheetWorld.crop(32, 64, 32, 32);
		txtTree3bR = sheetWorld.crop(64, 64, 32, 32);
		txtTree4aL = sheetWorld.crop(128, 32, 32, 32);
		txtTree4aR = sheetWorld.crop(160, 32, 32, 32);
		txtTree5aL = sheetWorld.crop(128, 64, 32, 32);
		txtTree5aR = sheetWorld.crop(160, 64, 32, 32);
		//
		txtTree6TL = sheetWorld.crop(192, 0, 32, 32);
		txtTree6TR = sheetWorld.crop(224, 0, 32, 32);
		txtTree6BL = sheetWorld.crop(192, 32, 32, 32);
		txtTree6BR = sheetWorld.crop(224, 32, 32, 32);
	}

}