package dev.tilegame;
import dev.tilegame.display.Display;
import dev.tilegame.gfx.Assets;
import dev.tilegame.states.State;
import dev.tilegame.states.GameState;
import dev.tilegame.states.IntroState;
import dev.tilegame.states.MenuState;
import dev.tilegame.states.TitleState;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JPanel;

public class Game extends JPanel implements Runnable
{
	private Display display;
	public String title;
	public int width, height;
	private Thread thread;
	private boolean running = false;
	public static String stateChange = "none";
	private BufferStrategy bs;
	private Graphics g;
	
	// Temp
	public static boolean menuDown = false;
	
	// States
	private State stateGame, stateIntro, stateMenu, stateTitle;

	public Game(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
	}
	
	private void init()
	{
		display = new Display(title, width, height);
		Assets.init();
		initStates();
		//State.setState(stateTitle);
		State.setState(stateIntro);
	}

	private void initStates()
	{
		stateGame = new GameState();
		stateIntro = new IntroState();
		stateMenu = new MenuState();
		stateTitle = new TitleState();
	}
	
	private void tick()
	{
		// Change state
		if(State.getStateChange() == "Title")
		{
			State.setState(stateTitle);
			State.setStateChange("");
		}
		
		// Tick state
		if(State.getState() != null)
		{
			State.getState().tick();
		}
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
		if(State.getState() != null)
		{
			State.getState().render(g);
		}

		// Graphics done
		bs.show();
		g.dispose();
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
		init();
		
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
				System.out.println("Ticks and Frames: " + ticks);
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
}