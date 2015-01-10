package dev.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Board
{
	private static String[ ][ ] tileImage = new String[26][18];
	private static int[ ][ ] tileType = new int[26][18];
	private static int gridWidth;
	private static int gridHeight;
	
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
	
	public static int getTileEntity(int x, int y)
	{
		// Temp
		if(x==Assets.entAnna.getPositionX() && y==Assets.entAnna.getPositionY())
		{
			return 1;
		}
		return 0;
	}
	
	public static String getTileImage(int x, int y)
	{
		return tileImage[x][y];
	}
	
	public static BufferedImage getTileImageFile(int x, int y)
	{
		if(tileImage[x][y]=="Grass"){return Assets.txtGrass;}
		if(tileImage[x][y]=="Tree"){return Assets.txtTree;}
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
	
	public static void setTile(int x, int y, String image, int type)
	{
		tileImage[x][y] = image;
		tileType[x][y] = type;
	}
	
	public static void tileInit()
	{
		for(int x=1;x<=gridWidth;x+=1)
		{
			for(int y=1;y<=gridHeight;y+=1)
			{
				tileImage[x][y] = "Grass";
				tileType[x][y] = 0;
			}
		}
	}
}