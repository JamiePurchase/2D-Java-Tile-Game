package dev.tilegame.gfx;
import java.awt.image.BufferedImage;

public class Assets
{
	// Interface
	public static BufferedImage uiLogoAP;
	
	// Sprites
	public static BufferedImage charPlayerN1, charPlayerN2, charPlayerN3;
	public static BufferedImage charPlayerE1, charPlayerE2, charPlayerE3;
	public static BufferedImage charPlayerS1, charPlayerS2, charPlayerS3;
	public static BufferedImage charPlayerW1, charPlayerW2, charPlayerW3;
	
	// Textures
	public static BufferedImage txtGrass, txtTree;
	
	public static void init()
	{
		initInterface();
		initSprites();
		initTextures();
	}
	
	public static void initInterface()
	{
		// Logo AP
		uiLogoAP = ImageLoader.loadImage("/interface/logoAP.png");
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
	}
	
	public static void initTextures()
	{
		// World Sheet
		Spritesheet sheetWorld = new Spritesheet(ImageLoader.loadImage("/textures/world.png"));
		
		// World Images
		txtGrass = sheetWorld.crop(0, 0, 32, 32);
		txtTree = sheetWorld.crop(32, 0, 32, 32);
	}

}