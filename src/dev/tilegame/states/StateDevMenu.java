package dev.tilegame.states;
import java.awt.Color;
import java.awt.Graphics;

import dev.tilegame.Game;
import dev.tilegame.Keyboard;
import dev.tilegame.gfx.Assets;

public class StateDevMenu extends State
{
	private int menuRef;
	private String[][] menuOption = new String[10][10];
	private int[] menuPos = new int[10];
	private int[] menuMax = new int[10];
	private String[] menuTitle = new String[10];
	
	public StateDevMenu()
	{
		// Main
		menuTitle[0] = "Main";
		menuOption[0][1] = "Settings";
		menuOption[0][2] = "Inventory";
		menuOption[0][3] = "Battle";
		menuOption[0][4] = "Back";
		menuMax[0] = 4;
		
		// Settings
		menuTitle[1] = "Settings";
		menuOption[1][1] = "Board Info";
		menuOption[1][2] = "Walk Speed";
		menuOption[1][3] = "???";
		menuOption[1][4] = "???";
		menuMax[1] = 4;
	}
	
	public void init()
	{
		menuRef = 0;
		menuPos[0] = 1;
		menuPos[1] = 1;
	}
	
	public void tick()
	{
		// Reinitialise State
		if(State.getStateReinit())
		{
			init();
			State.setStateReinit(false);
		}
		
		// Key Events
		tickKey();
	}
	
	public void tickKey()
	{
		if(menuRef==0){tickKeyMain();}
	}
	
	public void tickKeyMain()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			if(menuPos[0]==1)
			{
				menuRef = 1;
			}
			if(menuPos[0]==4)
			{
				State.setStateChange("Game");
			}
		}
		if(Keyboard.getKeyPressed()=="Escape")
		{
			Keyboard.setKeyDone();
			State.setStateChange("Title");
			// Note: Consider setting a variable to say where we came from and return there (ie: title or game)
		}
		if(Keyboard.getKeyPressed()=="Up" && menuPos[menuRef]>1)
		{
			Keyboard.setKeyDone();
			menuPos[menuRef]-=1;
		}
		if(Keyboard.getKeyPressed()=="Down" && menuPos[menuRef]<menuMax[menuRef])
		{
			Keyboard.setKeyDone();
			menuPos[menuRef]+=1;
		}
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderMenu(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0,0,1366,768);
	}
	
	public void renderMenu(Graphics g)
	{
		renderMenuOptions(g);
		renderMenuCursor(g);
	}
	
	public void renderMenuCursor(Graphics g)
	{
		int cursorPosX = 0;
		int cursorPosY = 0;
		if(menuRef==0)
		{
			cursorPosX = 75;
			cursorPosY = 30 * menuPos[menuRef] + 70;
		}
		g.setColor(Color.GREEN);
		g.setFont(Assets.fontDebugStandard);
		g.drawString(">", cursorPosX, cursorPosY);
	}
	
	public void renderMenuOptions(Graphics g)
	{
		String title = "Development Menu: " + menuTitle[menuRef];
		g.setFont(Assets.fontDebugTitle);
		g.setColor(Color.GREEN);
		g.drawString(title, 50, 50);
		g.setFont(Assets.fontDebugStandard);
		for(int opt=1;opt<=menuMax[menuRef];opt+=1)
		{
			int drawX = 100;
			int drawY = (opt * 30) + 70;
			g.drawString(menuOption[menuRef][opt], drawX, drawY);
		}
	}
}