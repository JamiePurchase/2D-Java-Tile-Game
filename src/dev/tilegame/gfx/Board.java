package dev.tilegame.gfx;
import dev.tilegame.Game;
import dev.tilegame.datafiles.WriteFile;
import dev.tilegame.world.Board01;
import dev.tilegame.world.JvExterior;
import dev.tilegame.world.JvGooseberryManor;
import dev.tilegame.world.JvPlayerBedroom;
import dev.tilegame.world.JvPlayerHouse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Board
{
	// Details
	private static String boardName;
	private static String locationName;
	
	// Grid
	private static int gridWidth;
	private static int gridHeight;
	private static boolean gridScroll = false;
	private static boolean gridScrollAction = false;
	private static String gridScrollDirection;
	private static int gridScrollFrame;
	private static int gridScrollTick;
	private static int gridOffsetX = 0;
	private static int gridOffsetY = 0;
	
	// Background
	private static boolean bkgHasImage = false;
	private static BufferedImage bkgImage;
	
	// Tiles
	private static BufferedImage[ ][ ] tileImage = new BufferedImage[101][81];
	private static int[ ][ ] tileType = new int[101][81];
	private static String[ ][ ] tileEntity = new String[101][81];
	private static int[ ][ ] tileEntityID = new int[101][81];
	
	// Lighting
	private static boolean lightingActive = false;
	private static String lightingStyle;
	
	// Portals
	public static int portalCount = 0;
	//public static Portal[] = new Portal[10];
	public static int[] portalPosX = new int[10];
	public static int[] portalPosY = new int[10];
	public static String[] portalSendBoard = new String[10];
	public static String[] portalSendDirection = new String[10];
	public static int[] portalSendX = new int[10];
	public static int[] portalSendY = new int[10];
	public static int[] portalOffsetX = new int[10];
	public static int[] portalOffsetY = new int[10];

	// Scenery
	private static int sceneryCount = 0;
	private static int[] sceneryPosX = new int[50];
	private static int[] sceneryPosY = new int[50];
	
	// Treasure
	private static int treasureCount = 0;
	private static int[] treasureFind = new int[10];
	private static int[] treasurePosX = new int[10];
	private static int[] treasurePosY = new int[10];
	
	public Board()
	{
		
	}
	
	public static void getData(String name)
	{
		if(name=="Board01"){Board01 boardLoader = new Board01();}
		if(name=="JvExterior"){JvExterior boardLoader = new JvExterior();}
		if(name=="JvPlayerBedroom"){JvPlayerBedroom boardLoader = new JvPlayerBedroom();}
		if(name=="JvPlayerHouse"){JvPlayerHouse boardLoader = new JvPlayerHouse();}
		if(name=="JvGooseberryManor"){JvGooseberryManor boardLoader = new JvGooseberryManor();}
	}
	
	public static int getGridEdgeE()
	{
		return gridOffsetX + 42;
	}
	
	public static int getGridEdgeN()
	{
		return gridOffsetY;
	}
	
	public static int getGridEdgeS()
	{
		return gridOffsetY + 42;
	}
	
	public static int getGridEdgeW()
	{
		return gridOffsetX;
	}
	
	public static int getGridHeight()
	{
		return gridHeight;
	}
	
	public static int getGridOffsetX()
	{
		return gridOffsetX;
	}
	
	public static int getGridOffsetXMax()
	{
		return gridWidth - 42;
	}
	
	public static int getGridOffsetY()
	{
		return gridOffsetY;
	}
	
	public static int getGridOffsetYMax()
	{
		return gridHeight - 23;
	}
	
	public static boolean getGridScroll()
	{
		return gridScroll;
	}
	
	public static boolean getGridScrollAction()
	{
		return gridScrollAction;
	}
	
	public static String getGridScrollDirection()
	{
		return gridScrollDirection;
	}
	
	public static int getGridScrollFrame()
	{
		return gridScrollFrame;
	}
	
	public static int getGridWidth()
	{
		return gridWidth;
	}
	
	public static String getLocation()
	{
		return locationName;
	}
	
	public static boolean getOnScreen(int x, int y)
	{
		if(x>=getGridEdgeW() && x<=getGridEdgeE())
		{
			if(y>=getGridEdgeN() && y<=getGridEdgeS())
			{
				return true;
			}
		}
		return false;
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
	
	public void tick()
	{
		// Board Scrolling
		if(gridScrollAction==true)
		{
			gridScrollTick+=1;
			int gridScrollTickMax = 10;
			if(Assets.entPlayer.getWalkSpeed()==2){gridScrollTickMax = 5;}
			if(gridScrollTick>=gridScrollTickMax)
			{
				gridScrollFrame+=1;
				if(gridScrollFrame==4)
				{
					gridScrollAction = false;
					Game.world.gridScrollDirection = "";
					Game.world.gridScrollFrame = 0;
				}
			}
		}
		
		// Player
		Assets.entPlayer.tick();
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderTiles(g);
		if(lightingActive==true){renderLighting(g);}
		renderPlayer(g);
		renderTreasure(g);
		if(Game.messageActive==true){renderMessage(g);}
		
		// Test (should loop through all NPCs and draw those that are on the visible area of the board
		//g.drawImage(Assets.npcAnnaS, 256, 184, null);
	}
	
	public static void renderBackground(Graphics g)
	{
		g.drawImage(Assets.uiGameBorder, 0, 0, null);
		g.setColor(Color.BLACK);
		g.fillRect(11, 16, 1344, 736);
		if(bkgHasImage){g.drawImage(bkgImage, 11, 16, null);}
		// Note: Should the background image be larger than the screen when the board is?
	}
	
	public void renderLighting(Graphics g)
	{
		if(lightingStyle=="Afternoon"){Drawing.drawImageOpaque(g, Assets.lightBlack, 0, 0, 0.25f);}
		if(lightingStyle=="Night"){Drawing.drawImageOpaque(g, Assets.lightBlack, 0, 0, 0.75f);}
	}
	
	public void renderMessage(Graphics g)
	{
		if(Game.messageType=="Prompt"){Game.messageObjectPrompt.render(g);}
		if(Game.messageType=="Speech"){Game.messageObjectSpeech.render(g);}
		if(Game.messageType=="Standard"){Game.messageObjectStandard.render(g);}
		if(Game.messageType=="Tutorial"){Game.messageObjectTutorial.render(g);}
	}
	
	public void renderPlayer(Graphics g)
	{
		Assets.entPlayer.render(g);
	}
	
	public void renderTile(Graphics g, int x, int y)
	{
		int drawX = (x * 32) - 21 - (gridOffsetX * 32);
		int drawY = (y * 32) - 16 - (gridOffsetY * 32);
		
		// Debug
		String debug1 = "renderTile from board coords " + x + "," + y;
		String debug2 = "drawX = " + drawX + " and drawY = " + drawY;
		System.out.println(debug1);
		System.out.println(debug2);
		//g.drawImage(tileImage[x][y], drawX, drawY, null);
	}
	
	public void renderTileAt(Graphics g, int tileX, int tileY, int posX, int posY)
	{
		renderTileAt(g, tileX, tileY, posX, posY, "", 0);
	}
	
	public void renderTileAt(Graphics g, int tileX, int tileY, int posX, int posY, String scrollDirection, int scrollFrame)
	{
		int drawX = (posX * 32) - 21;
		int drawY = (posY * 32) - 16;
		if(scrollDirection=="N"){drawY-=(scrollFrame*8);}
		if(scrollDirection=="E"){drawX+=(scrollFrame*8);}
		if(scrollDirection=="S"){drawY+=(scrollFrame*8);}
		if(scrollDirection=="W"){drawX-=(scrollFrame*8);}
		g.drawImage(tileImage[tileX][tileY], drawX, drawY, null);
		
		// Debug
		String debug1 = "renderTileAt(g, " + tileX + ", " + tileY + ", " + posX + ", " + posY + ",)";
		String debug2 = "drawX = " + drawX + " and drawY = " + drawY + " and image = " + tileImage[tileX][tileY];
		//System.out.println(debug1);
		//System.out.println(debug2);
	}
	
	public void renderTiles(Graphics g)
	{
		// Note: this should scroll the board smoothly when the player walks
		/*if(gridScrollAction==true){renderTilesScrolling(g);}
		else{renderTilesStandard(g);}*/
		
		// Note: for now we are using the basic method
		renderTilesStandard(g);
	}
	
	public void renderTilesScrolling(Graphics g)
	{
		for(int x=1;x<=43;x+=1)
		{
			for(int y=1;y<=24;y+=1)
			{
				int tileX = x + gridOffsetX;
				int tileY = y + gridOffsetY;
				if(gridScrollDirection=="N"){tileY-=1;}
				if(gridScrollDirection=="E"){tileX+=1;}
				if(gridScrollDirection=="S"){tileY+=1;}
				if(gridScrollDirection=="W"){tileX-=1;}
				renderTileAt(g, tileX, tileY, x, y, gridScrollDirection, gridScrollFrame);
			}
		}
	}
	
	public void renderTilesStandard(Graphics g)
	{
		for(int x=1;x<=42;x+=1)
		{
			for(int y=1;y<=23;y+=1)
			{
				// Note: Old method was to loop through all tiles (using gridWidth and gridHeight) and draw some
				//if(getOnScreen(x, y)==true){renderTile(g, x, y);}
				
				// Note: New method is to draw exactly 42 x 23 tiles, using the offset values to pick which tiles to use
				int tileX = x + gridOffsetX;
				int tileY = y + gridOffsetY;
				renderTileAt(g, tileX, tileY, x, y);
			}
		}
		
		// Debug
		/*renderTileAt(g, 1, 1, 1, 1);
		String debug1 = "gridOffsetX = " + gridOffsetX + " and gridOffsetY = " + gridOffsetY;
		System.out.println(debug1);*/
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
	
	public static void setGridHeight(int height)
	{
		gridHeight = height;
	}
	
	public static void setGridOffset(int x, int y)
	{
		setGridOffsetX(x);
		setGridOffsetY(y);
	}
	
	public static void setGridOffsetMove(String direction)
	{
		if(direction=="N" && gridOffsetY>0){gridOffsetY-=1;}
		if(direction=="E" && gridOffsetX<getGridOffsetXMax()){gridOffsetX+=1;}
		if(direction=="S" && gridOffsetY<getGridOffsetYMax()){gridOffsetY+=1;}
		if(direction=="W" && gridOffsetX>0){gridOffsetX-=1;}
	}
	
	public static void setGridOffsetX(int x)
	{
		gridOffsetX = x;
	}
	
	public static void setGridOffsetY(int y)
	{
		gridOffsetY = y;
	}
	
	public static void setGridScroll(boolean scroll)
	{
		gridScroll = scroll;
	}
	
	public static void setGridScrollDone()
	{
		gridScrollAction = false;
		gridScrollDirection = "";
		gridScrollFrame = 0;
		gridScrollTick = 0;
	}
	
	public static void setGridScrollNew(String direction)
	{
		gridScrollAction = true;
		gridScrollDirection = direction;
		gridScrollFrame = 1;
		gridScrollTick = 0;
	}
	
	public static void setGridWidth(int width)
	{
		gridWidth = width;
	}
	
	public static void setLocation(String location)
	{
		locationName = location;
	}
	
	public static void setName(String name)
	{
		boardName = name;
	}
	
	public static void setPortal(int posX, int posY, String sendBoard, int sendX, int sendY, String sendDirection)
	{
		setPortal(posX, posY, sendBoard, sendX, sendY, sendDirection, 0, 0);
	}
	
	public static void setPortal(int posX, int posY, String sendBoard, int sendX, int sendY, String sendDirection, int offsetX, int offsetY)
	{
		portalCount += 1;
		portalPosX[portalCount] = posX;
		portalPosY[portalCount] = posY;
		portalSendBoard[portalCount] = sendBoard;
		portalSendDirection[portalCount] = sendDirection;
		portalSendX[portalCount] = sendX;
		portalSendY[portalCount] = sendY;
		portalOffsetX[portalCount] = offsetX;
		portalOffsetY[portalCount] = offsetY;
		tileEntity[posX][posY] = "Portal";
		tileEntityID[posX][posY] = portalCount;
	}
	
	public static void setScenery(int posX, int posY)
	{
		sceneryCount += 1;
		sceneryPosX[portalCount] = posX;
		sceneryPosY[portalCount] = posY;
		tileEntity[posX][posY] = "Scenery";
		tileEntityID[posX][posY] = sceneryCount;
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
		
		// Debug
		/*String debug1 = "tileInit(" + fill + ", " + type + ")";
		String debug2 = "gridWidth = " + gridWidth + " and gridHeight = " + gridHeight;
		String debug3 = "image = " + BoardTiles.getTileFile(fill);
		System.out.println(debug1);
		System.out.println(debug2);
		System.out.println(debug3);*/
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
		
		// Debug
		/*String debug1 = "tileInit(" + image + ", " + type + ")";
		String debug2 = "gridWidth = " + gridWidth + " and gridHeight = " + gridHeight;
		System.out.println(debug1);
		System.out.println(debug2);*/
	}

}