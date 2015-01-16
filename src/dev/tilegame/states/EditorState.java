package dev.tilegame.states;
import dev.tilegame.Keyboard;
import dev.tilegame.gfx.Assets;

import java.awt.Color;
import java.awt.Graphics;

public class EditorState extends State
{
	private String editorFile = "";
	private int editorBrush = 1;
	
	// Look at this later
	private int[] entitySomething;
	
	private String gridBackground;
	private int gridWidth;
	private int gridHeight;
	private int gridPosX;
	private int gridPosY;
	private String[][] tileImage;
	private int[][] tileType;
	private String[][] tileEntity;
	private int[][] tileEntityID;
	
	public EditorState()
	{
		
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
		gridSetTileAll("None", 0);
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
		renderDetails(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Assets.uiAboutBkg,  0, 0, null);
	}
	
	public void renderDetails(Graphics g)
	{
		g.setFont(Assets.fontStandard);
		g.setColor(Color.WHITE);
		g.drawString("This game was developed in a weekend,", 150, 250);
		g.drawString("while I started to learn Java.", 200, 300);
		g.drawString("Created with Eclipse. Sprites from", 175, 350);
		g.drawString("famitsu. Inspiration from Youtube.", 175, 400);
		g.drawImage(Assets.uiOptDoneA,  300, 425, null);
	}
}