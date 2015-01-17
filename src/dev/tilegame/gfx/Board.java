package dev.tilegame.gfx;
import dev.tilegame.Game;
import dev.tilegame.datafiles.WriteFile;
import dev.tilegame.world.Board01;
import dev.tilegame.world.JvGooseberryManor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Board
{
	private static String boardName;
	private static String locationName;
	private static boolean bkgHasImage = false;
	private static BufferedImage bkgImage;
	private static int gridWidth;
	private static int gridHeight;
	private static BufferedImage[ ][ ] tileImage = new BufferedImage[26][18];
	private static int[ ][ ] tileType = new int[26][18];
	private static String[ ][ ] tileEntity = new String[26][18];
	private static int[ ][ ] tileEntityID = new int[26][18];
	
	// Temp
	private static int mushroomCount = 0;
	private static int[] mushroomFind = new int[10];
	private static int[] mushroomPosX = new int[10];
	private static int[] mushroomPosY = new int[10];
	
	// Temp
	private static int treasureCount = 0;
	private static int[] treasureFind = new int[10];
	private static int[] treasurePosX = new int[10];
	private static int[] treasurePosY = new int[10];
	
	// Temp
	private static int garnetCount = 0;
	private static int[] garnetFind = new int[10];
	private static int[] garnetPosX = new int[10];
	private static int[] garnetPosY = new int[10];
	
	public Board()
	{
		
	}
	
	public static void getData(String name)
	{
		if(name=="Board01"){Board01 boardLoader = new Board01();}
		if(name=="JvGooseberryManor"){JvGooseberryManor boardLoader = new JvGooseberryManor();}
	}
	
	public static int getGridHeight()
	{
		return gridHeight;
	}
	
	public static int getGridWidth()
	{
		return gridWidth;
	}
	
	public static int getGarnetCount()
	{
		return garnetCount;
	}
	
	public static String getLocation()
	{
		return locationName;
	}
	
	public static int getMushroomCount()
	{
		return mushroomCount;
	}
	
	public static String getName()
	{
		return boardName;
	}
	
	public static String getTileEntity(int x, int y)
	{
		return tileEntity[x][y];
	}
	
	public static int getTileEntityID(int x, int y)
	{
		return tileEntityID[x][y];
	}
	
	public static BufferedImage getTileImage(int x, int y)
	{
		return tileImage[x][y];
	}
	
	public static int getTreasureCount()
	{
		return treasureCount;
	}
	
	public static int getTileType(int x, int y)
	{
		return tileType[x][y];
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderTiles(g);
		Assets.entPlayer.render(g);
		renderTreasure(g);
		
		// Test (should loop through all NPCs and draw those that are on the visible area of the board
		g.drawImage(Assets.npcAnnaS, 256, 184, null);
	}
	
	public static void renderBackground(Graphics g)
	{
		g.drawImage(Assets.uiGameBorder, 0, 0, null);
		g.setColor(Color.BLACK);
		g.fillRect(11, 16, 1344, 736);
		if(bkgHasImage){g.drawImage(bkgImage, 11, 16, null);}
	}
	
	public void renderTile(Graphics g, int x, int y)
	{
		int drawX = x * 32 - 21;
		int drawY = y * 32 - 16;
		g.drawImage(Game.world.getTileImage(x, y), drawX, drawY, null);
	}
	
	public void renderTiles(Graphics g)
	{
		for(int x=1;x<=Game.world.getGridWidth();x+=1)
		{
			for(int y=1;y<=Game.world.getGridHeight();y+=1)
			{
				renderTile(g, x, y);
			}
		}
	}
	
	public static void renderTreasure(Graphics g)
	{
		for(int treasure=1;treasure<=getTreasureCount();treasure+=1)
		{
			if(treasureFind[treasure]<1)
			{
				int posX = 32 * treasurePosX[treasure] - 32;
				int posY = 32 * treasurePosY[treasure] - 32;
				g.drawImage(Assets.itemChest1, posX, posY, null);
			}
		}
	}
	
	public static void setBackground()
	{
		bkgHasImage = false;
	}
	
	public static void setBackground(BufferedImage image)
	{
		bkgHasImage = true;
		bkgImage = image;
	}
	
	public static void setGarnet(int x, int y)
	{
		garnetCount += 1;
		garnetFind[garnetCount] = 0;
		garnetPosX[garnetCount] = x;
		garnetPosY[garnetCount] = y;
		tileEntity[x][y] = "Garnet";
		tileEntityID[x][y] = garnetCount;
	}
	
	public static void setGarnetFound(int ID)
	{
		garnetFind[ID] = 1;
		int posX = garnetPosX[ID];
		int posY = garnetPosY[ID];
		tileEntity[posX][posY] = "None";
		tileEntityID[posX][posY] = 0;
		Game.backpackGarnets += 1;
	}
	
	public static void setGridHeight(int height)
	{
		gridHeight = height;
	}
	
	public static void setGridWidth(int width)
	{
		gridWidth = width;
	}
	
	public static void setLocation(String location)
	{
		locationName = location;
	}
	
	public static void setMushroom(int x, int y)
	{
		mushroomCount += 1;
		mushroomFind[mushroomCount] = 0;
		mushroomPosX[mushroomCount] = x;
		mushroomPosY[mushroomCount] = y;
		tileEntity[x][y] = "Mushroom";
		tileEntityID[x][y] = mushroomCount;
	}
	
	public static void setMushroomFound(int ID)
	{
		mushroomFind[ID] = 1;
		int posX = mushroomPosX[ID];
		int posY = mushroomPosY[ID];
		tileEntity[posX][posY] = "None";
		tileEntityID[posX][posY] = 0;
		Game.backpackMushrooms += 1;
	}
	
	public static void setName(String name)
	{
		boardName = name;
	}
	
	public static void setTile(int x, int y, String image, int type)
	{
		tileImage[x][y] = BoardTiles.getTileFile(image);
		tileType[x][y] = type;
	}
	
	public static void setTile(int x, int y, BufferedImage image, int type)
	{
		tileImage[x][y] = image;
		tileType[x][y] = type;
	}
	
	public static void setTreasure(int x, int y)
	{
		treasureCount += 1;
		treasureFind[treasureCount] = 0;
		treasurePosX[treasureCount] = x;
		treasurePosY[treasureCount] = y;
		tileEntity[x][y] = "Treasure";
		tileEntityID[x][y] = treasureCount;
	}
	
	public static void setTreasureFound(int ID)
	{
		treasureFind[ID] = 1;
		int posX = treasurePosX[ID];
		int posY = treasurePosY[ID];
		tileEntity[posX][posY] = "None";
		tileEntityID[posX][posY] = 0;
		Game.backpackTreasure += 1;
	}
	
	public static void tileInit(String fill, int type)
	{
		for(int x=1;x<=gridWidth;x+=1)
		{
			for(int y=1;y<=gridHeight;y+=1)
			{
				tileEntity[x][y] = "None";
				tileEntityID[x][y] = 0;
				tileImage[x][y] = BoardTiles.getTileFile(fill);
				tileType[x][y] = type;
			}
		}
	}
	
	public static void tileInit(BufferedImage image, int type)
	{
		for(int x=1;x<=gridWidth;x+=1)
		{
			for(int y=1;y<=gridHeight;y+=1)
			{
				tileEntity[x][y] = "None";
				tileEntityID[x][y] = 0;
				tileImage[x][y] = image;
				tileType[x][y] = type;
			}
		}
	}
}