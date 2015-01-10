package dev.tilegame.gfx;
import java.awt.image.BufferedImage;

public class Board
{
	//private static BufferedImage[][] tileImage;
	//private static int[][] tileType;
	private static int gridWidth;
	private static int gridHeight;
	
	public Board(String template)
	{
		// Temp
		if(template=="Test")
		{
			gridWidth = 20;
			gridHeight = 16;
			for(int x=1;x<=20;x+=1)
			{
				for(int y=1;y<=16;y+=1)
				{
					//tileImage[x][y] = Assets.txtGrass;
					//tileType[x][y] = 0;
				}
			}
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
	
	/*public static BufferedImage getTileImage(int x, int y)
	{
		return tileImage[x][y];
	}*/
	
	/*public static int getTileType(int x, int y)
	{
		return tileType[x][y];
	}*/
}