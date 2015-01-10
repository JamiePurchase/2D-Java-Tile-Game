package dev.tilegame.gfx;
import dev.tilegame.Game;

import java.awt.image.BufferedImage;

public class Board
{
	private static String[ ][ ] tileEntity = new String[26][18];
	private static int[ ][ ] tileEntityID = new int[26][18];
	private static String[ ][ ] tileImage = new String[26][18];
	private static int[ ][ ] tileType = new int[26][18];
	private static int gridWidth;
	private static int gridHeight;
	
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
	
	public Board()
	{
		tileInit();
	}
	
	public static int getGridHeight()
	{
		return gridHeight;
	}
	
	public static int getGridWidth()
	{
		return gridWidth;
	}
	
	public static String getTileEntity(int x, int y)
	{
		return tileEntity[x][y];
	}
	
	public static int getTileEntityID(int x, int y)
	{
		return tileEntityID[x][y];
	}
	
	public static String getTileImage(int x, int y)
	{
		return tileImage[x][y];
	}
	
	public static BufferedImage getTileImageFile(int x, int y)
	{
		if(tileEntity[x][y]=="Mushroom"){return Assets.itemMushroom1;}
		if(tileEntity[x][y]=="Treasure"){return Assets.itemChest1;}
		if(tileImage[x][y]=="Grass"){return Assets.txtGrass;}
		if(tileImage[x][y]=="Tree"){return Assets.txtTree1a;}
		if(tileImage[x][y]=="TreeB"){return Assets.txtTree1b;}
		if(tileImage[x][y]=="TreeC"){return Assets.txtTree1c;}
		if(tileImage[x][y]=="Shrub"){return Assets.txtTree2a;}
		if(tileImage[x][y]=="ShrubB"){return Assets.txtTree2b;}
		if(tileImage[x][y]=="TreesL"){return Assets.txtTree3aL;}
		if(tileImage[x][y]=="TreesR"){return Assets.txtTree3aR;}
		if(tileImage[x][y]=="TreesBL"){return Assets.txtTree3bL;}
		if(tileImage[x][y]=="TreesBR"){return Assets.txtTree3bR;}
		if(tileImage[x][y]=="TreesCL"){return Assets.txtTree4aL;}
		if(tileImage[x][y]=="TreesCR"){return Assets.txtTree4aR;}
		if(tileImage[x][y]=="TreesDL"){return Assets.txtTree5aL;}
		if(tileImage[x][y]=="TreesDR"){return Assets.txtTree5aR;}
		if(tileImage[x][y]=="Fence1L"){return Assets.txtFence1L;}
		if(tileImage[x][y]=="Fence1M"){return Assets.txtFence1M;}
		if(tileImage[x][y]=="Fence1MS"){return Assets.txtFence1MS;}
		if(tileImage[x][y]=="Fence1R"){return Assets.txtFence1R;}
		return Assets.txtGrass;
	}
	
	public static int getTileType(int x, int y)
	{
		return tileType[x][y];
	}
	
	public static void setGridHeight(int height)
	{
		gridHeight = height;
	}
	
	public static void setGridWidth(int width)
	{
		gridWidth = width;
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
	
	public static void setTile(int x, int y, String image, int type)
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
	
	public static void tileInit()
	{
		for(int x=1;x<=gridWidth;x+=1)
		{
			for(int y=1;y<=gridHeight;y+=1)
			{
				tileEntity[x][y] = "None";
				tileEntityID[x][y] = 0;
				tileImage[x][y] = "Grass";
				tileType[x][y] = 0;
			}
		}
	}
}