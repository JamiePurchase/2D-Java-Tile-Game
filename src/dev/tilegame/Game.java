package dev.tilegame;
import dev.tilegame.display.Display;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable
{
	private Display display;
	public String title;
	public int width, height;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;

	public Game(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
	}
	
	private void init()
	{
		display = new Display(title, width, height);
	}
	
	private void tick()
	{
		
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
		
		// Graphics draw
		g.fillRect(0, 0, width, height);
		
		// Graphics done
		bs.show();
		g.dispose();
	}
	
	public void run()
	{
		// Create window
		init();
		
		// Main game loop
		while(running)
		{
			tick();
			render();
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
}