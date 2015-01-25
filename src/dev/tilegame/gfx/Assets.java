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
	
	// Avatars
	public static BufferedImage avtPlayer1;
	
	// Interface
	public static BufferedImage uiCursor1, uiCursor2;
	public static BufferedImage uiIntro1, uiIntro2, uiIntro3;
	public static BufferedImage uiTitleBkg, uiTitleOpt1, uiTitleOpt1a, uiTitleOpt2, uiTitleOpt2a;
	public static BufferedImage uiTitleOpt3, uiTitleOpt3a, uiTitleOpt4, uiTitleOpt4a, uiTitleOpt5, uiTitleOpt5a;
	public static BufferedImage uiOptDone, uiOptDoneA;
	public static BufferedImage uiOptionsBkg, uiTutorialBkg, uiAboutBkg;
	public static BufferedImage uiGameInfo1, uiGameBorder;
	public static BufferedImage[] uiGameInfoCount = new BufferedImage[10];
	public static BufferedImage uiMenuBkg;
	public static BufferedImage uiCharacterBkg, uiCharacterOpt1, uiCharacterOpt1a, uiCharacterOpt2;
	public static BufferedImage uiCharacterOpt2a, uiCharacterOpt3, uiCharacterOpt3a;
	public static BufferedImage uiEditorCursor1, uiEditorGrid;

	// Sprites
	public static BufferedImage charPlayer1N1, charPlayer1N2, charPlayer1N3;
	public static BufferedImage charPlayer1E1, charPlayer1E2, charPlayer1E3;
	public static BufferedImage charPlayer1S1, charPlayer1S2, charPlayer1S3;
	public static BufferedImage charPlayer1W1, charPlayer1W2, charPlayer1W3;
	public static BufferedImage charPlayer2N1, charPlayer2N2, charPlayer2N3;
	public static BufferedImage charPlayer2E1, charPlayer2E2, charPlayer2E3;
	public static BufferedImage charPlayer2S1, charPlayer2S2, charPlayer2S3;
	public static BufferedImage charPlayer2W1, charPlayer2W2, charPlayer2W3;
	public static BufferedImage charPlayer3N1, charPlayer3N2, charPlayer3N3;
	public static BufferedImage charPlayer3E1, charPlayer3E2, charPlayer3E3;
	public static BufferedImage charPlayer3S1, charPlayer3S2, charPlayer3S3;
	public static BufferedImage charPlayer3W1, charPlayer3W2, charPlayer3W3;
	public static BufferedImage npcAnnaN, npcAnnaE, npcAnnaS, npcAnnaW;
	public static BufferedImage itemMushroom1, itemChest1;
	public static BufferedImage itemGarnet1, itemGarnet2;
	
	// Test
	public static BufferedImage battleBackground;
	public static BufferedImage battleCharacter2Idle;
	public static BufferedImage battleBoarIdle;
	
	// Textures
	public static BufferedImage txtGrass, txtFence1L, txtFence1M, txtFence1MS, txtFence1R;
	public static BufferedImage txtTree1a, txtTree1b, txtTree1c, txtTree2a, txtTree2b;
	public static BufferedImage txtTree3aL, txtTree3aR, txtTree3bL, txtTree3bR;
	public static BufferedImage txtTree4aL, txtTree4aR, txtTree5aL, txtTree5aR;
	public static BufferedImage txtTree6TL, txtTree6TR, txtTree6BL, txtTree6BR;
	public static BufferedImage txtTree7aT, txtTree7aB, txtTree7bT, txtTree7bB;
	
	// Tilesets
	public static BufferedImage[] tlsJharvaVillage, tlsJharvaInterior;
	
	// Board Backgrounds
	public static BufferedImage bkgJvGooseberryManor;
	
	// Fonts
	public static Font fontStandard, fontStandardBold, fontStandardUnderline;
	public static Font fontInfoCount, fontReduced;
	public static Font fontDebugTitle, fontDebugStandard;
	public static Font fontEditorMenu, fontEditorMenuBold, fontEditorMenuInfo, fontEditorMenuTitle;
	
	public static void init()
	{
		initAvatars();
		initBackgrounds();
		initEntities();
		initFonts();
		initSprites();
		initInterface();
		initTextures();
		initTilesets();
	}
	
	public static void initAvatars()
	{
		avtPlayer1 = ImageLoader.loadImage("/avatars/player1.png");
	}
	
	public static void initBackgrounds()
	{
		bkgJvGooseberryManor = ImageLoader.loadImage("/backgrounds/JvGooseberryManor.png");
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
		initInterfaceAbout();
		initInterfaceCharacterSelect();
		initInterfaceCursor();
		initInterfaceGame();
		initInterfaceIntro();
		initInterfaceMenu();
		initInterfaceOptions();
		initInterfaceTitle();
		initInterfaceTutorial();
	}
	
	public static void initInterfaceAbout()
	{
		uiAboutBkg = ImageLoader.loadImage("/interface/aboutBkg.png");
	}
	
	public static void initInterfaceCharacterSelect()
	{
		uiCharacterBkg = ImageLoader.loadImage("/interface/characterSelectBkg.png");
		uiCharacterOpt1 = ImageLoader.loadImage("/interface/characterOpt1.png");
		uiCharacterOpt1a = ImageLoader.loadImage("/interface/characterOpt1a.png");
		uiCharacterOpt2 = ImageLoader.loadImage("/interface/characterOpt2.png");
		uiCharacterOpt2a = ImageLoader.loadImage("/interface/characterOpt2a.png");
		uiCharacterOpt3 = ImageLoader.loadImage("/interface/characterOpt3.png");
		uiCharacterOpt3a = ImageLoader.loadImage("/interface/characterOpt3a.png");
	}
	
	public static void initInterfaceCursor()
	{
		uiCursor1 = ImageLoader.loadImage("/interface/cursor1.png");
		uiCursor2 = ImageLoader.loadImage("/interface/cursor2b.png");
	}
	
	public static void initInterfaceEditor()
	{
		uiEditorCursor1 = ImageLoader.loadImage("/interface/editorCursor1.png");
		uiEditorGrid = ImageLoader.loadImage("/interface/editorGrid.png");
	}
	
	public static void initInterfaceGame()
	{
		uiGameInfo1 = ImageLoader.loadImage("/interface/gameInfo1.png");
		uiGameBorder = ImageLoader.loadImage("/interface/gameBorder.png");
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
	}
	
	public static void initInterfaceIntro()
	{
		uiIntro1 = ImageLoader.loadImage("/interface/intro1.png");
		uiIntro2 = ImageLoader.loadImage("/interface/intro2.png");
		uiIntro3 = ImageLoader.loadImage("/interface/intro3.png");
	}
	
	public static void initInterfaceMenu()
	{
		uiMenuBkg = ImageLoader.loadImage("/interface/menuBkg.png");
	}
	
	public static void initInterfaceOptions()
	{
		uiOptionsBkg = ImageLoader.loadImage("/interface/optionsBkg.png");
	}
	
	public static void initInterfaceTitle()
	{
		uiTitleBkg = ImageLoader.loadImage("/interface/titleBkg.png");
		uiTitleOpt1 = ImageLoader.loadImage("/interface/titleOpt1.png");
		uiTitleOpt1a = ImageLoader.loadImage("/interface/titleOpt1a.png");
		uiTitleOpt2 = ImageLoader.loadImage("/interface/titleOpt2.png");
		uiTitleOpt2a = ImageLoader.loadImage("/interface/titleOpt2a.png");
		uiTitleOpt3 = ImageLoader.loadImage("/interface/titleOpt3.png");
		uiTitleOpt3a = ImageLoader.loadImage("/interface/titleOpt3a.png");
		uiTitleOpt4 = ImageLoader.loadImage("/interface/titleOpt4.png");
		uiTitleOpt4a = ImageLoader.loadImage("/interface/titleOpt4a.png");
		uiTitleOpt5 = ImageLoader.loadImage("/interface/titleOpt5.png");
		uiTitleOpt5a = ImageLoader.loadImage("/interface/titleOpt5a.png");
		uiOptDone = ImageLoader.loadImage("/interface/uiOptDone.png");
		uiOptDoneA = ImageLoader.loadImage("/interface/uiOptDoneA.png");
	}
	
	public static void initInterfaceTutorial()
	{
		uiTutorialBkg = ImageLoader.loadImage("/interface/tutorialBkg.png");
	}
	
	public static void initFonts()
	{
		fontStandard = new Font("MV Boli", Font.PLAIN, 26);
		fontStandardBold = new Font("MV Boli", Font.BOLD, 26);
		fontStandardUnderline = new Font("MV Boli", Font.PLAIN, 26);
		fontInfoCount = new Font("Times New Roman", Font.BOLD, 36);
		fontReduced = new Font("MV Boli", Font.PLAIN, 20);
		fontDebugTitle = new Font("MV Boli", Font.BOLD, 32);
		fontDebugStandard = new Font("MV Boli", Font.PLAIN, 26);
		fontEditorMenu = new Font("Arial", Font.PLAIN, 18);
		fontEditorMenuBold = new Font("Arial", Font.BOLD, 18);
		fontEditorMenuInfo = new Font("Arial", Font.ITALIC, 18);
		fontEditorMenuTitle = new Font("Arial", Font.BOLD, 18);
	}
	
	public static void initSprites()
	{
		// Player Sheet
		Spritesheet sheetPlayer1 = new Spritesheet(ImageLoader.loadImage("/sprites/player1.png"));
		Spritesheet sheetPlayer2 = new Spritesheet(ImageLoader.loadImage("/sprites/player2.png"));
		Spritesheet sheetPlayer3 = new Spritesheet(ImageLoader.loadImage("/sprites/player3.png"));
		
		// Player Images
		charPlayer1N1 = sheetPlayer1.crop(32, 96, 32, 32);
		charPlayer1N2 = sheetPlayer1.crop(0, 96, 32, 32);
		charPlayer1N3 = sheetPlayer1.crop(64, 96, 32, 32);
		charPlayer1E1 = sheetPlayer1.crop(32, 64, 32, 32);
		charPlayer1E2 = sheetPlayer1.crop(0, 64, 32, 32);
		charPlayer1E3 = sheetPlayer1.crop(64, 64, 32, 32);
		charPlayer1S1 = sheetPlayer1.crop(32, 0, 32, 32);
		charPlayer1S2 = sheetPlayer1.crop(0, 0, 32, 32);
		charPlayer1S3 = sheetPlayer1.crop(64, 0, 32, 32);
		charPlayer1W1 = sheetPlayer1.crop(32, 32, 32, 32);
		charPlayer1W2 = sheetPlayer1.crop(0, 32, 32, 32);
		charPlayer1W3 = sheetPlayer1.crop(64, 32, 32, 32);
		charPlayer2N1 = sheetPlayer2.crop(32, 96, 32, 32);
		charPlayer2N2 = sheetPlayer2.crop(0, 96, 32, 32);
		charPlayer2N3 = sheetPlayer2.crop(64, 96, 32, 32);
		charPlayer2E1 = sheetPlayer2.crop(32, 64, 32, 32);
		charPlayer2E2 = sheetPlayer2.crop(0, 64, 32, 32);
		charPlayer2E3 = sheetPlayer2.crop(64, 64, 32, 32);
		charPlayer2S1 = sheetPlayer2.crop(32, 0, 32, 32);
		charPlayer2S2 = sheetPlayer2.crop(0, 0, 32, 32);
		charPlayer2S3 = sheetPlayer2.crop(64, 0, 32, 32);
		charPlayer2W1 = sheetPlayer2.crop(32, 32, 32, 32);
		charPlayer2W2 = sheetPlayer2.crop(0, 32, 32, 32);
		charPlayer2W3 = sheetPlayer2.crop(64, 32, 32, 32);
		charPlayer3N1 = sheetPlayer3.crop(32, 96, 32, 32);
		charPlayer3N2 = sheetPlayer3.crop(0, 96, 32, 32);
		charPlayer3N3 = sheetPlayer3.crop(64, 96, 32, 32);
		charPlayer3E1 = sheetPlayer3.crop(32, 64, 32, 32);
		charPlayer3E2 = sheetPlayer3.crop(0, 64, 32, 32);
		charPlayer3E3 = sheetPlayer3.crop(64, 64, 32, 32);
		charPlayer3S1 = sheetPlayer3.crop(32, 0, 32, 32);
		charPlayer3S2 = sheetPlayer3.crop(0, 0, 32, 32);
		charPlayer3S3 = sheetPlayer3.crop(64, 0, 32, 32);
		charPlayer3W1 = sheetPlayer3.crop(32, 32, 32, 32);
		charPlayer3W2 = sheetPlayer3.crop(0, 32, 32, 32);
		charPlayer3W3 = sheetPlayer3.crop(64, 32, 32, 32);
		
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
		
		// Test
		initSpritesBattle();
	}
	
	public static void initSpritesBattle()
	{
		battleBackground = ImageLoader.loadImage("/battle/backgrounds/test1.png");
		battleCharacter2Idle = ImageLoader.loadImage("/battle/character2/Idle.png");
		battleBoarIdle = ImageLoader.loadImage("/battle/boar/Idle.png");
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
		//
		txtTree7aT = sheetWorld.crop(256, 0, 32, 32);
		txtTree7aB = sheetWorld.crop(256, 32, 32, 32);
		txtTree7bT = sheetWorld.crop(288, 0, 32, 32);
		txtTree7bB = sheetWorld.crop(288, 32, 32, 32);
	}
	
	public static void initTilesets()
	{
		tlsJharvaInterior = Tileset.getTileset("/textures/JharvaInterior.png", 8, 6);
		tlsJharvaVillage = Tileset.getTileset("/textures/JharvaVillage.png", 8, 6);
	}

}