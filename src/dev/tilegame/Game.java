package dev.tilegame;
import dev.tilegame.audio.AudioPlayer;
import dev.tilegame.display.Display;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.Board;
import dev.tilegame.states.State;
import dev.tilegame.states.AboutState;
import dev.tilegame.states.BattleState;
import dev.tilegame.states.CharacterState;
import dev.tilegame.states.GameState;
import dev.tilegame.states.IntroState;
import dev.tilegame.states.MenuState;
import dev.tilegame.states.OptionsState;
import dev.tilegame.states.TitleState;
import dev.tilegame.states.TutorialState;
import dev.tilegame.world.Board01;
import dev.tilegame.datafiles.FileManager;
import dev.tilegame.datafiles.ReadFile;
import dev.tilegame.datafiles.WriteFile;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

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
	public static boolean chat = false;
	private static String boardChange;
	
	// Board Object
	public static Board world;
	
	// Campaign Data
	public static int campaignStage = 0;
	
	// Backpack (consider moving to it's own class?)
	public static int backpackGarnets = 0;
	public static int backpackMushrooms = 0;
	public static int backpackTreasure = 0;
	
	// Test
	public static String playerClass = "";
	
	// States
	private State stateAbout, stateCharacter, stateIntro, stateOptions, stateTitle, stateTutorial;
	private State stateGame, stateMenu;
	
	// Test
	private State stateBattle;

	public Game(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		// Test
		try
		{
			saveGame();
		}
		catch (IOException e)
		{
			System.out.println("IO Error");
		}
	}
	
	private void init()
	{
		display = new Display(title, width, height);
		Assets.init();
		initStates();
		initWorld();
		initAudio();
		State.setState(stateIntro);
	}
	
	private void initAudio()
	{
		AudioPlayer.init();
		AudioPlayer.load("/music/bgm1.wav", "music1");
		AudioPlayer.load("/music/bgm2.wav", "music2");
		AudioPlayer.load("/sounds/collectGarnet.wav", "Garnet");
		AudioPlayer.load("/sounds/collectMushroom.wav", "Mushroom");
		AudioPlayer.load("/sounds/collectTreasure.wav", "Treasure");
		AudioPlayer.play("music1");
	}

	private void initStates()
	{
		stateAbout = new AboutState();
		stateCharacter = new CharacterState();
		stateGame = new GameState();
		stateIntro = new IntroState();
		stateMenu = new MenuState();
		stateOptions = new OptionsState();
		stateTitle = new TitleState();
		stateTutorial = new TutorialState();
		
		// Test
		stateBattle = new BattleState();
	}
	
	private void initWorld()
	{
		world = new Board();
		//world.getData("Board01");
		world.getData("JvGooseberryManor");
	}
	
	private void tick()
	{
		// Change state
		if(State.getStateChange() == "About")
		{
			State.setState(stateAbout);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "Character")
		{
			State.setState(stateCharacter);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "Game")
		{
			State.setState(stateGame);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "Menu")
		{
			State.setState(stateMenu);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "Options")
		{
			State.setState(stateOptions);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "Title")
		{
			State.setState(stateTitle);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "Tutorial")
		{
			State.setState(stateTutorial);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		
		// Temp
		if(State.getStateChange() == "Battle")
		{
			State.setState(stateBattle);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		
		// Change Board
		if(boardChange!="")
		{
			world = new Board();
			world.getData(boardChange);
			boardChange = "";
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
				//System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		// End game
		stop();
	}
	
	public static void boardChange(String board)
	{
		boardChange = board;
	}
	
	public void saveGame() throws IOException
	{
		String file_name = "C:/Users/Jamie/Documents/My Workshop/Autumn Park/Datafiles/Data.txt";
		/*try
		{
			ReadFile file = new ReadFile(file_name);
			String[] aryLines = file.OpenFile();
			int i;
			for(i=0;i<aryLines.length;i+=1)
			{
				System.out.println(aryLines[i]);
			}
		}
		catch (IOException e)
		{
			System.out.println("IO Error");
		}*/
		WriteFile data = new WriteFile(file_name, true);
		data.writeToFile("Hello world");
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