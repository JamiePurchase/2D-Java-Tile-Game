package dev.tilegame;
import dev.tilegame.audio.AudioPlayer;
import dev.tilegame.display.Display;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.Board;
import dev.tilegame.gfx.BoardTiles;
import dev.tilegame.gfx.Drawing;
import dev.tilegame.gfx.ImageLoader;
import dev.tilegame.states.State;
import dev.tilegame.world.Board01;
import dev.tilegame.datafiles.FileManager;
import dev.tilegame.datafiles.ReadFile;
import dev.tilegame.datafiles.WriteFile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

public class EditorBoard extends JPanel implements Runnable
{
	// Application
	private static final long serialVersionUID = 1L;
	private Display display;
	public String title;
	public int width, height;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	private int introFrame = 1;
	
	// Editor
	public String editorState = "Intro";
	private int editorFileNew = 0;
	private static String editorFilePath = "";
	private static String editorInfoText = "";
	private static int editorInfoTime = 0;
	private static int editorViewGrid = 0;
	private static int editorViewSolid = 0;
	private static int editorViewEntities = 0;
	private static int editorViewZones = 0;
	
	// Board
	private static String boardName;
	private static String boardLocation;
	private static int boardBkgActive;
	private static String boardBkgImage;
	private static int boardWidth;
	private static int boardHeight;
	
	// Tiles
	private static String[][] tileImage = new String[26][18];
	private static int[][] tileType = new int[26][18];
	private static String[][] tileEntity = new String[26][18];
	private static int[][] tileEntityID = new int[26][18];
	
	// Brushes
	private int brushType;
	private String brushTileImage = "Tree";
	
	// Cursor
	private String cursorState = "Grid";
	private int cursorGridPosX = 5;
	private int cursorGridPosY = 3;
	private int cursorGridMaxX = 10;
	private int cursorGridMaxY = 10;
	private int cursorMenuPosX = 1;
	private int[] cursorMenuPosY = new int[5];
	private int cursorMenuMaxX = 4;
	private int[] cursorMenuMaxY = new int[5];
	
	// Resources
	public static BufferedImage assetIntro = ImageLoader.loadImage("/interface/editorIntro.png");
	public static BufferedImage assetCursor1 = ImageLoader.loadImage("/interface/editorCursor1.png");

	public EditorBoard()
	{
		cursorMenuMaxY[1] = 4;
		cursorMenuMaxY[2] = 4;
		cursorMenuMaxY[3] = 4;
		cursorMenuMaxY[4] = 4;
		editorNew();
	}
	
	private void brushAction()
	{
		// Temp
		gridSetTileImage(brushTileImage, cursorGridPosX, cursorGridPosY);
		gridSetTileType(1, cursorGridPosX, cursorGridPosY);
	}
	
	private void createWindow()
	{
		display = new Display("Autumn Park Editor", 1366, 768);
		Assets.init(); 
	}
	
	private void editorLoad()
	{
		try
		{
			editorLoadBoard();
		}
		catch (IOException e)
		{
			System.out.println("IO Error");
		}
		
		// Brush
		brushType = 1;
		
		// Cursor
		cursorState = "Grid";
		cursorGridPosX = 1;
		cursorGridPosY = 1;
		cursorGridMaxX = boardWidth;
		cursorGridMaxY = boardHeight;
		
		// Info
		editorInfoText = "Board Loaded";
		editorInfoTime = 100;
	}
	
	private void editorLoadBoard() throws IOException
	{
		// Temp
		editorFilePath = "C:/Users/Jamie/Documents/My Workshop/Autumn Park/Datafiles/Board01.txt";
		
		// Open File
		ReadFile file = new ReadFile(editorFilePath);
		String[] aryLines = file.OpenFile();
		String[] fileData = new String[aryLines.length];
		System.out.println("File has " + aryLines.length + " lines");
		int i = 0;
		for(i=0;i<aryLines.length;i+=1)
		{
			fileData[i] = aryLines[i];
			System.out.println(i + " " + aryLines[i]);
		}
		
		// Board
		boardName = fileData[1];
		boardLocation = fileData[2];
		boardWidth = Integer.parseInt(fileData[3]);
		boardHeight = Integer.parseInt(fileData[4]);
		boardBkgActive = Integer.parseInt(fileData[5]);
		boardBkgImage = fileData[6];
		
		// Tiles
		int tileMax = boardWidth * boardHeight;
		int tileX = 1;
		int tileY = 1;
		/*int linePart = 1;
		int lineMax = tileMax + 10;
		for(int line=10;line<=lineMax;line+=1)
		{
			if(linePart==1){tileImage[tileX][tileY] = fileData[line];}
			if(linePart==2){tileType[tileX][tileY] = Integer.parseInt(fileData[line]);}
			if(linePart==3){tileEntity[tileX][tileY] = fileData[line];}
			if(linePart==4){tileEntityID[tileX][tileY] = Integer.parseInt(fileData[line]);}
			linePart+=1;
			if(linePart>4)
			{
				linePart = 1;
				tileY+=1;
				if(tileY>boardHeight)
				{
					tileX+=1;
					tileY = 1;
				}
			}
		}*/
		
		tileImage[1][1] = fileData[10];
		tileImage[1][2] = fileData[14];
		
		// Temp
		//tileImage[1][1] = fileData[11];
	}
	
	private void editorNew()
	{
		// Board
		boardBkgActive = 0;
		boardBkgImage = "";
		boardWidth = 24;
		boardHeight = 17;
		
		// Tiles
		gridSetAll("Grass", 0);
		
		// Brush
		brushType = 1;
		
		// Cursor
		cursorState = "Grid";
		cursorGridPosX = 1;
		cursorGridPosY = 1;
		cursorGridMaxX = boardWidth;
		cursorGridMaxY = boardHeight;
	}
	
	public void editorSave()
	{
		try
		{
			editorSaveBoard();
		}
		catch (IOException e)
		{
			System.out.println("IO Error");
		}
		cursorState = "Grid";
		editorInfoText = "Board Saved";
		editorInfoTime = 100;
	}
	
	public static void editorSaveBoard() throws IOException
	{
		// Temp
		editorFilePath = "C:/Users/Jamie/Documents/My Workshop/Autumn Park/Datafiles/Board01.txt";
		
		// Open File
		WriteFile data = new WriteFile(editorFilePath, false);
		String br = System.getProperty("line.separator");
		
		// Board Data
		String write = "Test Board Save" + br;
		write = write + boardName + br;
		write = write + boardLocation + br;
		write = write + boardWidth + br;
		write = write + boardHeight + br;
		write = write + boardBkgActive + br;
		write = write + boardBkgImage + br;
		write = write + "Music (to do later)" + br;
		write = write + "Wild Encounters (to do later)" + br;
		write = write + "#" + br;
		
		// Tile Data
		for(int x=1;x<=boardWidth;x+=1)
		{
			for(int y=1;y<=boardHeight;y+=1)
			{
				write = write + tileImage[x][y] + br;
				write = write + tileType[x][y] + br;
				write = write + tileEntity[x][y] + br;
				write = write + tileEntityID[x][y] + br;
			}
		}
		write = write + "#" + br;
		
		// Garnet Data
		// Mushroom Data
		// Treasure Data
		
		// Write Data
		data.writeToFile(write);
	}
	
	public void gridSetAll(String fill, int type)
	{
		for(int x=1;x<=boardWidth;x+=1)
		{
			for(int y=1;y<=boardHeight;y+=1)
			{
				gridSetTileEntity("None", 0, x, y);
				gridSetTileImage(fill, x, y);
				gridSetTileType(type, x, y);
			}
		}
	}
	
	public void gridSetTileEntity(String entity, int entityID, int x, int y)
	{
		tileEntity[x][y] = entity;
		tileEntityID[x][y] = entityID;
	}
	
	public void gridSetTileImage(String fill, int x, int y)
	{
		tileImage[x][y] = fill;
	}
	
	public void gridSetTileType(int type, int x, int y)
	{
		tileType[x][y] = type;
	}
	
	private void render()
	{
		// Buffer strategy
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		// Graphics start
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		// Graphics draw
		if(editorState=="Intro")
		{
			renderIntro(g);
		}
		else
		{
			renderBackground(g);
			renderBoard(g);
			renderTools(g);
		}

		// Graphics done
		bs.show();
		g.dispose();
	}
	
	public void renderBackground(Graphics g)
	{
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
		BufferedImage cursorImage = assetCursor1;
		int cursorPosX = 32 * cursorGridPosX + 118;
		int cursorPosY = 32 * cursorGridPosY + 0;
		g.drawImage(cursorImage, cursorPosX, cursorPosY, null);
	}
	
	public void renderBoardTile(Graphics g, int x, int y)
	{
		int drawX = x * 32 + 118;
		int drawY = y * 32 + 0;
		g.drawImage(BoardTiles.getTileFile(tileImage[x][y]), drawX, drawY, null);
		//if(editorViewGrid==1){g.drawImage(Assets.uiEditorGrid, drawX, drawY, null);}
		g.drawImage(Assets.uiEditorGrid, drawX, drawY, null);
	}
	
	public void renderBoardTiles(Graphics g)
	{
		for(int x=1;x<=boardWidth;x+=1)
		{
			for(int y=1;y<=boardHeight;y+=1)
			{
				if(tileImage[x][y]!=""){renderBoardTile(g, x, y);}
			}
		}
	}
	
	public void renderIntro(Graphics g)
	{
		g.drawImage(assetIntro, 0, 0, null);
	}
	
	public void renderTools(Graphics g)
	{
		renderToolsMenu(g);
		renderToolsBrush(g);
	}
	
	public void renderToolsBrush(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(0, 32, 150, 746);
		g.setColor(Color.BLACK);
		g.drawRect(0, 32, 150, 746);

		g.setFont(Assets.fontEditorMenu);
		g.setColor(Color.BLACK);
		g.drawString("Brush", 10, 54);
		
		// Brush Tile Image (brushTileImage)
		g.drawImage(Assets.tlsJharvaVillage[41],20,100,null);
		g.setColor(Color.BLACK);
		g.drawRect(20, 100, 32, 32);
	}
	
	public void renderToolsMenu(Graphics g)
	{
		// Frame
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 1366, 32);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 150, 32);
		g.drawRect(150, 0, 1216, 32);

		// Title
		g.setFont(Assets.fontEditorMenuTitle);
		g.setColor(Color.BLACK);
		g.drawString("EDITOR", 20, 22);
		
		// Menu Items
		Drawing.drawMenuItem(g, "File", 165, 22, 0);
		Drawing.drawMenuItem(g, "Board", 265, 22, 0);
		Drawing.drawMenuItem(g, "Tools", 365, 22, 0);
		Drawing.drawMenuItem(g, "View", 465, 22, 0);
		
		// Grid Details
		g.setColor(Color.BLACK);
		g.drawRect(675, 0, 400, 32);
		g.setFont(Assets.fontEditorMenu);
		g.setColor(Color.BLACK);
		String textPos = "Position: " + cursorGridPosX + "," + cursorGridPosY;
		String textType = "Normal";
		if(tileType[cursorGridPosX][cursorGridPosY]==1){textType = "Solid";}
		String textImage = tileImage[cursorGridPosX][cursorGridPosY];
		g.drawString(textPos, 700, 22);
		g.drawString(textType, 850, 22);
		g.drawString(textImage, 950, 22);
		
		// Info Message
		g.setFont(Assets.fontEditorMenuInfo);
		g.setColor(Color.BLACK);
		if(editorInfoTime>1){g.drawString(editorInfoText, 1100, 22);}
		
		if(cursorState=="Menu" && cursorMenuPosX==1)
		{
			g.setColor(Color.GRAY);
			g.fillRect(150,32,150,120);
			g.setColor(Color.WHITE);
			int fillY = 30 * cursorMenuPosY[1] + 2;
			g.fillRect(150, fillY, 150, 30);
			g.setColor(Color.BLACK);
			g.drawRect(150, 32, 150, 120);
			if(cursorMenuPosY[1]==1){Drawing.drawMenuItem(g, "New", 165, 54, 1);}
			else{Drawing.drawMenuItem(g, "New", 165, 54, 0);}
			if(cursorMenuPosY[1]==2){Drawing.drawMenuItem(g, "Load", 165, 84, 1);}
			else{Drawing.drawMenuItem(g, "Load", 165, 84, 0);}
			if(cursorMenuPosY[1]==3){Drawing.drawMenuItem(g, "Save", 165, 114, 1);}
			else{Drawing.drawMenuItem(g, "Save", 165, 114, 0);}
			if(cursorMenuPosY[1]==4){Drawing.drawMenuItem(g, "Close", 165, 144, 1);}
			else{Drawing.drawMenuItem(g, "Close", 165, 144, 0);}
		}
		
		if(cursorState=="Menu" && cursorMenuPosX==2)
		{
			g.setColor(Color.GRAY);
			g.fillRect(250,32,150,120);
			g.setColor(Color.WHITE);
			int fillY = 30 * cursorMenuPosY[2] + 2;
			g.fillRect(250, fillY, 150, 30);
			g.setColor(Color.BLACK);
			g.drawRect(250, 32, 150, 120);
			if(cursorMenuPosY[2]==1){Drawing.drawMenuItem(g, "Details", 265, 54, 1);}
			else{Drawing.drawMenuItem(g, "Details", 265, 54, 0);}
			if(cursorMenuPosY[2]==2){Drawing.drawMenuItem(g, "Dimensions", 265, 84, 1);}
			else{Drawing.drawMenuItem(g, "Dimensions", 265, 84, 0);}
			if(cursorMenuPosY[2]==3){Drawing.drawMenuItem(g, "Music", 265, 114, 1);}
			else{Drawing.drawMenuItem(g, "Music", 265, 114, 0);}
			if(cursorMenuPosY[2]==4){Drawing.drawMenuItem(g, "Encounters", 265, 144, 1);}
			else{Drawing.drawMenuItem(g, "Encounters", 265, 144, 0);}
		}
		
		if(cursorState=="Menu" && cursorMenuPosX==3)
		{
			g.setColor(Color.GRAY);
			g.fillRect(350,32,150,120);
			g.setColor(Color.WHITE);
			int fillY = 30 * cursorMenuPosY[3] + 2;
			g.fillRect(350, fillY, 150, 30);
			g.setColor(Color.BLACK);
			g.drawRect(350, 32, 150, 120);
			if(cursorMenuPosY[3]==1){Drawing.drawMenuItem(g, "Brush", 365, 54, 1);}
			else{Drawing.drawMenuItem(g, "Brush", 365, 54, 0);}
			if(cursorMenuPosY[3]==2){Drawing.drawMenuItem(g, "????", 365, 84, 1);}
			else{Drawing.drawMenuItem(g, "????", 365, 84, 0);}
			if(cursorMenuPosY[3]==3){Drawing.drawMenuItem(g, "????", 365, 114, 1);}
			else{Drawing.drawMenuItem(g, "????", 365, 114, 0);}
			if(cursorMenuPosY[3]==4){Drawing.drawMenuItem(g, "????", 365, 144, 1);}
			else{Drawing.drawMenuItem(g, "????", 365, 144, 0);}
		}
		
		if(cursorState=="Menu" && cursorMenuPosX==4)
		{
			g.setColor(Color.GRAY);
			g.fillRect(450,32,150,120);
			g.setColor(Color.WHITE);
			int fillY = 30 * cursorMenuPosY[4] + 2;
			g.fillRect(450, fillY, 150, 30);
			g.setColor(Color.BLACK);
			g.drawRect(450, 32, 150, 120);
			if(cursorMenuPosY[4]==1){Drawing.drawMenuItem(g, "Grid", 465, 54, 1);}
			else{Drawing.drawMenuItem(g, "Grid", 465, 54, 0);}
			if(cursorMenuPosY[4]==2){Drawing.drawMenuItem(g, "Solidity", 465, 84, 1);}
			else{Drawing.drawMenuItem(g, "Solidity", 465, 84, 0);}
			if(cursorMenuPosY[4]==3){Drawing.drawMenuItem(g, "Entities", 465, 114, 1);}
			else{Drawing.drawMenuItem(g, "Entities", 465, 114, 0);}
			if(cursorMenuPosY[4]==4){Drawing.drawMenuItem(g, "Zones", 465, 144, 1);}
			else{Drawing.drawMenuItem(g, "Zones", 465, 144, 0);}
		}
	}
	
	public void run()
	{
		// Render speed
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		// Create window
		createWindow();
		
		// Main game loop
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1)
			{
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000)
			{
				//System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		// End game
		stop();
	}
	
	public synchronized void start()
	{
		if(running==false)
		{
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public synchronized void stop()
	{
		if(running==true)
		{
			try
			{
				thread.join();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void tick()
	{
		if(editorState=="Intro")
		{
			// Splashscreen
			tickIntro();
		}
		else
		{
			// Info Message
			if(editorInfoTime>1)
			{
				editorInfoTime-=1;
				if(editorInfoTime==0){editorInfoText = "";}
			}
		
			// Key Events
			tickEvents();
		}
	}
	
	private void tickEvents()
	{
		if(cursorState=="Grid"){tickEventsGrid();}
		if(cursorState=="Menu"){tickEventsMenu();}
	}
	
	private void tickEventsGrid()
	{
		if(Keyboard.getKeyPressed()=="Enter")
		{
			cursorState = "Menu";
			cursorMenuPosX = 1;
			cursorMenuPosY[1] = 1;
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Space")
		{
			brushAction();
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Up" && cursorGridPosY>1)
		{
			cursorGridPosY-=1;
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Down" && cursorGridPosY<cursorGridMaxY)
		{
			cursorGridPosY+=1;
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Left" && cursorGridPosX>1)
		{
			cursorGridPosX-=1;
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Right" && cursorGridPosX<cursorGridMaxX)
		{
			cursorGridPosX+=1;
			Keyboard.setKeyDone();
		}
	}
	
	private void tickEventsMenu()
	{
		if(Keyboard.getKeyPressed()=="Space" || Keyboard.getKeyPressed()=="Enter")
		{
			if(cursorMenuPosX==1)
			{
				if(cursorMenuPosY[1]==1)
				{
					editorNew();
					Keyboard.setKeyDone();
				}
				if(cursorMenuPosY[1]==2)
				{
					editorLoad();
					Keyboard.setKeyDone();
				}
				if(cursorMenuPosY[1]==3)
				{
					editorSave();
					Keyboard.setKeyDone();
				}
				if(cursorMenuPosY[1]==4)
				{
					System.exit(0);
				}
			}
			if(cursorMenuPosX==2)
			{
				if(cursorMenuPosY[2]==1)
				{
					//
					Keyboard.setKeyDone();
				}
				if(cursorMenuPosY[2]==2)
				{
					//
					Keyboard.setKeyDone();
				}
				if(cursorMenuPosY[2]==3)
				{
					//
					Keyboard.setKeyDone();
				}
				if(cursorMenuPosY[2]==4)
				{
					//
					Keyboard.setKeyDone();
				}
			}
			if(cursorMenuPosX==3)
			{
				if(cursorMenuPosY[3]==1)
				{
					//
					Keyboard.setKeyDone();
				}
				if(cursorMenuPosY[3]==2)
				{
					//
					Keyboard.setKeyDone();
				}
				if(cursorMenuPosY[3]==3)
				{
					//
					Keyboard.setKeyDone();
				}
				if(cursorMenuPosY[3]==4)
				{
					//
					Keyboard.setKeyDone();
				}
			}
			if(cursorMenuPosX==4)
			{
				if(cursorMenuPosY[4]==1)
				{
					if(editorViewGrid==0){editorViewGrid = 1;}
					else{editorViewGrid = 0;}
					Keyboard.setKeyDone();
				}
				if(cursorMenuPosY[4]==2)
				{
					if(editorViewSolid==0){editorViewSolid = 1;}
					else{editorViewSolid = 0;}
					Keyboard.setKeyDone();
				}
				if(cursorMenuPosY[4]==3)
				{
					if(editorViewEntities==0){editorViewEntities = 1;}
					else{editorViewEntities = 0;}
					Keyboard.setKeyDone();
				}
				if(cursorMenuPosY[4]==4)
				{
					if(editorViewZones==0){editorViewZones = 1;}
					else{editorViewZones = 0;}
					Keyboard.setKeyDone();
				}
			}
		}
		if(Keyboard.getKeyPressed()=="Escape")
		{
			cursorState = "Grid";
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Up" && cursorMenuPosY[cursorMenuPosX]>1)
		{
			cursorMenuPosY[cursorMenuPosX]-=1;
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Down" && cursorMenuPosY[cursorMenuPosX]<cursorMenuMaxY[cursorMenuPosX])
		{
			cursorMenuPosY[cursorMenuPosX]+=1;
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Left" && cursorMenuPosX>1)
		{
			cursorMenuPosX-=1;
			cursorMenuPosY[cursorMenuPosX] = 1;
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Right" && cursorMenuPosX<cursorMenuMaxX)
		{
			cursorMenuPosX+=1;
			cursorMenuPosY[cursorMenuPosX] = 1;
			Keyboard.setKeyDone();
		}
	}
	
	private void tickIntro()
	{
		introFrame += 1;
		if(introFrame>100)
		{
			editorState = "Editor";
		}
	}
}