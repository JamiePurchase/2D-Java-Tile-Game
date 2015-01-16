package dev.tilegame.states;
import dev.tilegame.Game;
import dev.tilegame.Keyboard;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.BoardTiles;
import dev.tilegame.gfx.Drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EditorState extends State
{
	private int editorFileNew = 0;
	private String editorFilePath = "";
	
	// Look at this later
	private int[] entitySomething;
	
	private String gridBackground;
	private int gridWidth;
	private int gridHeight;
	private int gridPosX;
	private int gridPosY;
	private String[][] tileImage = new String[26][18];
	private int[][] tileType = new int[26][18];
	private String[][] tileEntity = new String[26][18];
	private int[][] tileEntityID = new int[26][18];
	
	// Toolbar
	private int editorToolbar = 0;
	
	// Brushes
	private int editorBrushType;
	
	public EditorState()
	{
		editorInit();
	}
	
	public void editorInit()
	{
		editorBrushType = 1;
		editorNew();
	}
	
	public void editorLoad(String file)
	{
		// Try and load the board from a text file
		// Give a visual error if this failed
	}
	
	public void editorNew()
	{
		// Reset the grid arrays
		//gridSetBackground; - image or colour?
		//gridSetTileAll("None", 0);
		
		// Temp
		gridWidth = 10;
		gridHeight = 10; 
		gridSetTileAll("Grass", 0);
		tileImage[3][3] = "Tree";
	}
	
	public void gridSetTileAll(String fill, int type)
	{
		for(int x=1;x<=gridWidth;x+=1)
		{
			for(int y=1;y<=gridHeight;y+=1)
			{
				tileEntity[x][y] = "None";
				tileEntityID[x][y] = 0;
				tileImage[x][y] = fill;
				tileType[x][y] = type;
			}
		}
	}
	
	public void tick()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space" || Keyboard.getKeyPressed()=="Escape")
		{
			Keyboard.setKeyDone();
			State.setStateChange("Title");
		}
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderBoard(g);
		renderToolbars(g);
	}
	
	public void renderBackground(Graphics g)
	{
		//g.drawImage(Assets.uiAboutBkg,  0, 0, null);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1366, 768);
	}
	
	public void renderBoard(Graphics g)
	{
		renderBoardTiles(g);
	}
	
	public void renderBoardTile(Graphics g, int x, int y)
	{
		int drawX = x * 32 - 32;
		int drawY = y * 32 + 0;
		g.drawImage(BoardTiles.getTileFile(tileImage[x][y]), drawX, drawY, null);
	}
	
	public void renderBoardTiles(Graphics g)
	{
		for(int x=1;x<=gridWidth;x+=1)
		{
			for(int y=1;y<=gridHeight;y+=1)
			{
				if(tileImage[x][y]!=""){renderBoardTile(g, x, y);}
			}
		}
	}
	
	public void renderToolbars(Graphics g)
	{
		// Toolbar
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 1366, 32);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 1366, 32);
		
		// Menu Items
		Drawing.drawMenuItem(g, "File", 25, 22);
		Drawing.drawMenuItem(g, "Select", 125, 22);
		Drawing.drawMenuItem(g, "Tiles", 225, 22);
		Drawing.drawMenuItem(g, "Entities", 325, 22);
		
		if(editorToolbar==1)
		{
			g.setColor(Color.GRAY);
			g.fillRect(0,32,100,120);
			g.setColor(Color.BLACK);
			g.drawRect(0, 32, 100, 120);
			Drawing.drawMenuItem(g, "New", 25, 54);
			Drawing.drawMenuItem(g, "Load", 25, 84);
			Drawing.drawMenuItem(g, "Save", 25, 114);
			Drawing.drawMenuItem(g, "Close", 25, 144);
		}
	}
}