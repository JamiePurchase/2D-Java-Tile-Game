package dev.tilegame.states;
import dev.tilegame.Keyboard;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.Drawing;

import java.awt.Color;
import java.awt.Graphics;

public class TitleState extends State
{
	private int menuPos = 1;
	
	public TitleState()
	{
		
	}
	
	public void tick()
	{
		// Test
		//if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		if(Keyboard.getKeyPressed()=="Enter")
		{
			State.setStateChange("Battle");
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			if(menuPos==1)
			{
				// Character Selection
				State.setStateChange("Character");
				Keyboard.setKeyDone();
			}
			if(menuPos==2)
			{
				// Load Game
				//State.setStateChange("Load");
				//Keyboard.setKeyDone();
				
				// Temp
				State.setStateChange("Debug");
				Keyboard.setKeyDone();
			}
			if(menuPos==3)
			{
				// Basic Instructions
				State.setStateChange("Tutorial");
				Keyboard.setKeyDone();
			}
			if(menuPos==4)
			{
				// Game Options
				State.setStateChange("Options");
				Keyboard.setKeyDone();
			}
			if(menuPos==5)
			{
				// Project Information
				State.setStateChange("About");
				Keyboard.setKeyDone();
			}
		}
		if(Keyboard.getKeyPressed()=="Escape")
		{
			// Quit
			System.exit(0);
		}
		if(Keyboard.getKeyPressed()=="Up")
		{
			if(menuPos>2 && menuPos<5)
			{
				menuPos = menuPos - 2;
				Keyboard.setKeyDone();
			}
			else if(menuPos==5)
			{
				menuPos = 3;
				Keyboard.setKeyDone();
			}
		}
		if(Keyboard.getKeyPressed()=="Down")
		{
			if(menuPos<3)
			{
				menuPos = menuPos + 2;
				Keyboard.setKeyDone();
			}
			else if(menuPos>2 && menuPos<5)
			{
				menuPos = 5;
				Keyboard.setKeyDone();
			}
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
		renderOptions(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Assets.uiTitleBkg,  0, 0, null);
	}
	
	public void renderOptions(Graphics g)
	{
		g.drawImage(Assets.uiCursor1,  200, 275, null);
		g.drawImage(Assets.uiCursor2,  200, 475, null);
		
		/*if(menuPos==1){g.drawImage(Assets.uiTitleOpt1a,  200, 275, null);}
		else{g.drawImage(Assets.uiTitleOpt1,  200, 275, null);}
		if(menuPos==2){g.drawImage(Assets.uiTitleOpt5a,  400, 275, null);}
		else{g.drawImage(Assets.uiTitleOpt5,  400, 275, null);}
		if(menuPos==3){g.drawImage(Assets.uiTitleOpt2a,  200, 350, null);}
		else{g.drawImage(Assets.uiTitleOpt2,  200, 350, null);}
		if(menuPos==4){g.drawImage(Assets.uiTitleOpt3a,  400, 350, null);}
		else{g.drawImage(Assets.uiTitleOpt3,  400, 350, null);}
		if(menuPos==5){g.drawImage(Assets.uiTitleOpt4a,  300, 425, null);}
		else{g.drawImage(Assets.uiTitleOpt4,  300, 425, null);}*/
	}
}