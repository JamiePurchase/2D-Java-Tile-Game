package dev.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Board
{
	private static String[ ][ ] tileImage = new String[25][17];
	private static int[ ][ ] tileType = new int[25][17];
	private static int gridWidth;
	private static int gridHeight;
	
	public Board(String template)
	{
		// Temp
		if(template=="Test")
		{
			gridWidth = 10;
			gridHeight = 10;
			tileInit();
			setTile(1, 1, "Tree", 1);
			setTile(2, 1, "Tree", 1);
			setTile(3, 1, "Tree", 1);
			setTile(4, 1, "Tree", 1);
			setTile(5, 1, "Tree", 1);
			setTile(6, 1, "Tree", 1);
			setTile(7, 1, "Tree", 1);
			setTile(8, 1, "Tree", 1);
			setTile(9, 1, "Tree", 1);
			setTile(10, 1, "Tree", 1);
			setTile(2, 1, "Tree", 1);
			setTile(3, 1, "Tree", 1);
			setTile(4, 1, "Tree", 1);
			setTile(5, 1, "Tree", 1);
			setTile(6, 1, "Tree", 1);
			setTile(7, 1, "Tree", 1);
			setTile(8, 1, "Tree", 1);
			setTile(9, 1, "Tree", 1);
			setTile(10, 1, "Tree", 1);
		}
	}
	
	public static int getGridHeight()
	{
		return gridHeight;
	}
	
	public static int getGridWidth()
	{
		return gridWidth;
	}
	
	public static String getTileImage(int x, int y)
	{
		return tileImage[x][y];
	}
	
	public static BufferedImage getTileImageFile(int x, int y)
	{
		if(tileImage[x][y]=="Grass"){return Assets.txtGrass;}
		if(tileImage[x][y]=="Tree"){return Assets.txtTree;}
		return Assets.txtGrass;
	}
	
	public static int getTileType(int x, int y)
	{
		return tileType[x][y];
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