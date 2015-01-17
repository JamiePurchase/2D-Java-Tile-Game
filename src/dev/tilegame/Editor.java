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

public class Editor extends JPanel implements Runnable
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
	private int editorCursorMaxX = 10;
	private int editorCursorMaxY = 10;
	
	// Cursor
	public static BufferedImage assetIntro = ImageLoader.loadImage("/interface/editorIntro.png");
	public static BufferedImage assetCursor1 = ImageLoader.loadImage("/interface/editorCursor1.png");

	public Editor()
	{
	}
	
	private void createWindow()
	{
		display = new Display("Autumn Park Editor", 1366, 768);
		Assets.init(); 
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
		int cursorX = 32 * editorCursorPosX + 122;
		int cursorY = 32 * editorCursorPosY + 0;
		g.drawImage(assetCursor1, cursorX, cursorY, null);
	}
	
	public void renderBoardTile(Graphics g, int x, int y)
	{
		int drawX = x * 32 + 122;
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
		if(editorState=="Intro"){tickIntro();}
		else{tickEvents();}
	}
	
	private void tickEvents()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space" || Keyboard.getKeyPressed()=="Escape")
		{
			System.exit(0);
		}
		if(Keyboard.getKeyPressed()=="Up" && editorCursorPosY>1)
		{
			editorCursorPosY-=1;
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Down" && editorCursorPosY<editorCursorMaxY)
		{
			editorCursorPosY+=1;
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Left" && editorCursorPosX>1)
		{
			editorCursorPosX-=1;
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Right" && editorCursorPosX<editorCursorMaxX)
		{
			editorCursorPosX+=1;
			Keyboard.setKeyDone();
		}
		if(Mouse.getMousePressed()==1)
		{
			System.exit(0);
		}
	}
	
	private void tickIntro()
	{
		introFrame += 1;
		if(introFrame>200)
		{
			editorState = "Editor";
		}
	}
}