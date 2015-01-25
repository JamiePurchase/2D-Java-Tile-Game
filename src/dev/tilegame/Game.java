package dev.tilegame;
import dev.tilegame.audio.AudioPlayer;
import dev.tilegame.display.Display;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.Board;
import dev.tilegame.message.MessagePrompt;
import dev.tilegame.message.MessageSpeech;
import dev.tilegame.message.MessageStandard;
import dev.tilegame.message.MessageTutorial;
import dev.tilegame.states.DebugState;
import dev.tilegame.states.GameNewState;
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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JPanel;

public class Game extends JPanel implements Runnable
{
	private static final long serialVersionUID = 1L;
	private Display display;
	public String title;
	public int width, height;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	
	// Note: Consider where this should be
	public static boolean chat = false;
	
	// State Management
	private static String boardChange = "none";
	public static String stateChange = "none";
	
	// Development Mode
	public static boolean development = false;
	
	// Session
	public static Session session;
	public static boolean audio = true;
	
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
	private State stateGame, stateGameNew, stateMenu;
	private State stateBattle;
	private State stateDebug;
	
	// Messages
	public static boolean messageActive = false;
	public static String messageType = "None";
	public static MessageStandard messageObjectStandard;
	public static MessagePrompt messageObjectPrompt;
	public static MessageSpeech messageObjectSpeech;
	public static MessageTutorial messageObjectTutorial;

	public Game(String title, int width, int height, boolean dev)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		this.development = dev;
	}
	
	public static void boardChange(String board)
	{
		boardChange = board;
	}
	
	private void init()
	{
		// Create Display
		display = new Display(title, width, height);
		
		// Load Resources
		Assets.init();
		initStates();
		initWorld();
		initAudio();
		
		// Development Menu
		if(development==true){State.setState(stateDebug);}
		
		// Introduction
		else
		{
			AudioPlayer.play("music1");
			State.setState(stateIntro);
		}
	}
	
	private void initAudio()
	{
		AudioPlayer.init();
		AudioPlayer.load("/music/bgm1.wav", "music1");
		AudioPlayer.load("/music/bgm2.wav", "music2");
		AudioPlayer.load("/sounds/collectGarnet.wav", "Garnet");
		AudioPlayer.load("/sounds/collectMushroom.wav", "Mushroom");
		AudioPlayer.load("/sounds/collectTreasure.wav", "Treasure");
	}

	private void initStates()
	{
		stateAbout = new AboutState();
		stateCharacter = new CharacterState();
		stateDebug = new DebugState();
		stateGame = new GameState();
		stateGameNew = new GameNewState();
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
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
	
	public void saveGame() throws IOException
	{
		String file_name = "C:/Users/Jamie/Documents/My Workshop/Autumn Park/Datafiles/Data.txt";
		WriteFile data = new WriteFile(file_name, false);
		data.writeToFile("Hello world");
	}
	
	public static void setMessage(MessagePrompt message)
	{
		messageActive = true;
		messageType = "Prompt";
		messageObjectPrompt = message; 
	}
	
	public static void setMessage(MessageSpeech message)
	{
		messageActive = true;
		messageType = "Speech";
		messageObjectSpeech = message; 
	}
	
	public static void setMessage(MessageStandard message)
	{
		messageActive = true;
		messageType = "Standard";
		messageObjectStandard = message; 
	}
	
	public static void setMessage(MessageTutorial message)
	{
		messageActive = true;
		messageType = "Tutorial";
		messageObjectTutorial = message; 
	}
	
	public static void setSession(Session newSession)
	{
		session = newSession;
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
		if(State.getStateChange() == "Debug")
		{
			State.setState(stateDebug);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "Game")
		{
			State.setState(stateGame);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "GameNew")
		{
			State.setState(stateGameNew);
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
		if(boardChange!="none")
		{
			world = new Board();
			world.getData(boardChange);
			boardChange = "none";
		}
		
		// Tick state
		if(State.getState() != null)
		{
			State.getState().tick();
		}
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