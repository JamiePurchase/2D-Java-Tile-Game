package dev.tilegame.states;
import dev.tilegame.Keyboard;
import dev.tilegame.battle.MockData;
import dev.tilegame.gfx.Assets;

import java.awt.Color;
import java.awt.Graphics;

public class DebugState extends State
{
	private int menuPos = 1;
	private int menuMax = 4;
	
	public DebugState()
	{
		
	}
	
	public void actionTestBattle()
	{
		new MockData();
		State.setStateChange("Battle");
	}
	
	public void tick()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			if(menuPos==1)
			{
				State.setStateChange("Editor");
			}
			if(menuPos==2)
			{
				actionTestBattle();
			}
			if(menuPos==3)
			{
				State.setStateChange("Menu");
			}
			if(menuPos==4)
			{
				State.setStateChange("Title");
			}
		}
		if(Keyboard.getKeyPressed()=="Escape")
		{
			Keyboard.setKeyDone();
			State.setStateChange("Title");
			// Note: Consider setting a variable to say where we came from and return there (ie: title or game)
		}
		if(Keyboard.getKeyPressed()=="Up" && menuPos>1)
		{
			Keyboard.setKeyDone();
			menuPos-=1;
		}
		if(Keyboard.getKeyPressed()=="Down" && menuPos<menuMax)
		{
			Keyboard.setKeyDone();
			menuPos+=1;
		}
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderDetails(g);
		renderCursor(g);
	}
	
	public void renderBackground(Graphics g)
	{
		//g.drawImage(Assets.uiAboutBkg,  0, 0, null);
		g.setColor(Color.BLACK);
		g.fillRect(0,0,1366,768);
	}
	
	public void renderCursor(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.setFont(Assets.fontDebugStandard);
		int cursorPosY = 30 * menuPos + 70;
		g.drawString(">", 75, cursorPosY);
	}
	
	public void renderDetails(Graphics g)
	{
		g.setFont(Assets.fontDebugTitle);
		g.setColor(Color.GREEN);
		g.drawString("Debug Menu", 50, 50);
		g.setFont(Assets.fontDebugStandard);
		g.drawString("Board Editor", 100, 100);
		g.drawString("Battle System", 100, 130);
		g.drawString("Pause Menu", 100, 160);
		g.drawString("Close", 100, 190);
	}
}