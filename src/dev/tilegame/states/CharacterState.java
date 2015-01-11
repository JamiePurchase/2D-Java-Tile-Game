package dev.tilegame.states;
import dev.tilegame.Game;

import java.awt.Color;
import java.awt.Graphics;

import dev.tilegame.Keyboard;
import dev.tilegame.gfx.Assets;

public class CharacterState extends State
{

	private int menuPos = 1;
	private int menuMax = 3;
	
	public CharacterState()
	{
		
	}
	
	public void tick()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			if(menuPos==1){Game.playerClass = "Warmonger";}
			if(menuPos==2){Game.playerClass = "Stalker";}
			if(menuPos==3){Game.playerClass = "Spellweaver";}
			State.setStateChange("Game");
		}
		if(Keyboard.getKeyPressed()=="Escape")
		{
			// Back to Title
			State.setStateChange("Title");
		}
		if(Keyboard.getKeyPressed()=="Left")
		{
			menuPos = menuPos - 1;
			if(menuPos<1){menuPos = menuMax;}
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Right")
		{
			menuPos = menuPos + 1;
			if(menuPos>menuMax){menuPos = 1;}
			Keyboard.setKeyDone();
		}
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderOptions(g);
		renderInformation(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Assets.uiCharacterBkg,  0, 0, null);
	}
	
	public void renderInformation(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.setFont(Assets.fontReduced);
		if(menuPos==1)
		{
			g.drawString("Get up-close and personal as you pummel", 180, 380);
			g.drawString("your foes. Pain only strengthens you.", 180, 405);
			g.drawString("Warmongers live for the thrill of battle", 180, 430);
			g.drawString("and never refuse a challenging fight.", 180, 455);
		}
		if(menuPos==2)
		{
			g.drawString("Why let morality govern your methods?", 180, 380);
			g.drawString("There are always opportunities to prosper.", 180, 405);
			g.drawString("Stalkers are swift and deadly - especially", 180, 430);
			g.drawString("when they have the element of surprise.", 180, 455);
		}
		if(menuPos==3)
		{
			g.drawString("Magic is an unbreakable force, so long as", 180, 380);
			g.drawString("the caster remains composed and focussed.", 180, 405);
			g.drawString("Spellweavers can study a huge range of", 180, 430);
			g.drawString("techniques and provide excellent support.", 180, 455);
		}
	}
	
	public void renderOptions(Graphics g)
	{
		if(menuPos==1){g.drawImage(Assets.uiCharacterOpt1a,  100, 300, null);}
		else{g.drawImage(Assets.uiCharacterOpt1,  100, 300, null);}
		if(menuPos==2){g.drawImage(Assets.uiCharacterOpt2a,  300, 300, null);}
		else{g.drawImage(Assets.uiCharacterOpt2,  300, 300, null);}
		if(menuPos==3){g.drawImage(Assets.uiCharacterOpt3a,  500, 300, null);}
		else{g.drawImage(Assets.uiCharacterOpt3,  500, 300, null);}
	}
}