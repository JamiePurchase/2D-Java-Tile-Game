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
	private int editorCursorPosX = 5;
	private int editorCursorPosY = 3;
	
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
		renderTools(g);
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
		renderBoardCursor(g);
	}
	
	public void renderBoardCursor(Graphics g)
	{
		int cursorX = 32 * editorCursorPosX + 64;
		int cursorY = 32 * editorCursorPosY + 32;
		g.drawImage(Assets.uiEditorCursor1, cursorX, cursorY, null);
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
	
	public void renderTools(Graphics g)
	{
		renderToolsMenu(g);
		renderToolsBrush(g);
	}
	
	public void renderToolsBrush(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(0, 32, 128, 746);
		g.setColor(Color.BLACK);
		g.drawRect(0, 32, 128, 746);

		g.setFont(Assets.fontEditorMenu);
		g.setColor(Color.BLACK);
		g.drawString("Brush", 5, 54);
	}
	
	public void renderToolsMenu(Graphics g)
	{
		// Frame
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 1366, 32);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 1366, 32);

		// Title
		g.setFont(Assets.fontEditorMenuBold);
		g.setColor(Color.BLACK);
		g.drawString("EDITOR", 20, 22);
		
		// Menu Items
		Drawing.drawMenuItem(g, "File", 153, 22);
		Drawing.drawMenuItem(g, "Select", 253, 22);
		Drawing.drawMenuItem(g, "Tiles", 353, 22);
		Drawing.drawMenuItem(g, "Entities", 453, 22);
		
		if(editorToolbar==1)
		{
			g.setColor(Color.GRAY);
			g.fillRect(128,32,100,120);
			g.setColor(Color.BLACK);
			g.drawRect(128, 32, 100, 120);
			Drawing.drawMenuItem(g, "New", 153, 54);
			Drawing.drawMenuItem(g, "Load", 153, 84);
			Drawing.drawMenuItem(g, "Save", 153, 114);
			Drawing.drawMenuItem(g, "Close", 153, 144);
		}
		
		if(editorToolbar==2)
		{
			g.setColor(Color.GRAY);
			g.fillRect(228,32,100,120);
			g.setColor(Color.BLACK);
			g.drawRect(228, 32, 100, 120);
			Drawing.drawMenuItem(g, "New", 253, 54);
			Drawing.drawMenuItem(g, "Load", 253, 84);
			Drawing.drawMenuItem(g, "Save", 253, 114);
			Drawing.drawMenuItem(g, "Close", 253, 144);
		}
	}
}