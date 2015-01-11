package dev.tilegame.states;
import dev.tilegame.Keyboard;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.Drawing;

import java.awt.Color;
import java.awt.Graphics;

public class BattleState extends State
{
	private boolean menuNow = false;
	private int menuPos = 0;
	private int menuMax = 0;
	
	public BattleState()
	{
		
	}
	
	public void tick()
	{
		if(menuNow==true)
		{
			tickKeyEvents();
		}
	}
	
	public void tickKeyEvents()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			if(menuPos==1)
			{
				// Do stuff
			}
		}
		if(Keyboard.getKeyPressed()=="Up" && menuPos>2)
		{
			menuPos = menuPos - 2;
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Down" && menuPos<3)
		{
			menuPos = menuPos + 2;
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Left")
		{
			if(menuPos==2 || menuPos==4)
			{
				menuPos = menuPos - 1;
				Keyboard.setKeyDone();
			}
		}
		if(Keyboard.getKeyPressed()=="Right")
		{
			if(menuPos==1 || menuPos==3)
			{
				menuPos = menuPos + 1;
				Keyboard.setKeyDone();
			}
		}
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderUnits(g);
		if(menuNow==true){renderMenu(g);}
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Assets.battleBackground,  0, 0, null);
	}
	
	public void renderMenu(Graphics g)
	{
		// Command Menu
	}
	
	public void renderUnits(Graphics g)
	{
		g.drawImage(Assets.battleCharacter2Idle, 600, 200, null);
	}
}