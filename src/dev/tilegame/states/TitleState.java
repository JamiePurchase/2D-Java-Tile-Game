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
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			if(menuPos==1)
			{
				// New Game
				State.setStateChange("Game");
			}
			if(menuPos==2)
			{
				// Basic Instructions
				State.setStateChange("Tutorial");
			}
			if(menuPos==3)
			{
				// Game Options
				State.setStateChange("Options");
			}
			if(menuPos==4)
			{
				// Project Information
				State.setStateChange("About");
			}
		}
		if(Keyboard.getKeyPressed()=="Escape")
		{
			// Quit
			System.exit(0);
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
		renderOptions(g);
	}
	
	public void renderAbout(Graphics g)
	{
		g.drawImage(Assets.uiIntro0, 0, 0, null);
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Assets.uiTitleBkg,  0, 0, null);
	}
	
	public void renderOptions(Graphics g)
	{
		if(menuPos==1){g.drawImage(Assets.uiTitleOpt1a,  200, 275, null);}
		else{g.drawImage(Assets.uiTitleOpt1,  200, 275, null);}
		if(menuPos==2){g.drawImage(Assets.uiTitleOpt2a,  400, 275, null);}
		else{g.drawImage(Assets.uiTitleOpt2,  400, 275, null);}
		if(menuPos==3){g.drawImage(Assets.uiTitleOpt3a,  200, 350, null);}
		else{g.drawImage(Assets.uiTitleOpt3,  200, 350, null);}
		if(menuPos==4){g.drawImage(Assets.uiTitleOpt4a,  400, 350, null);}
		else{g.drawImage(Assets.uiTitleOpt4,  400, 350, null);}
	}
}