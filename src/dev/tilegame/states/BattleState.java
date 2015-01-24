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
		// Test
		menuNow = true;
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
		// Shadow
		g.setColor(Color.GRAY);
		g.fillRect(61,511,230,210);
		g.fillRect(62,512,230,210);
		g.fillRect(63,513,230,210);
		g.fillRect(64,514,230,210);
		
		// Background
		g.setColor(Color.BLACK);
		g.fillRect(60,510,230,210);
		
		// Border
		g.setColor(Color.WHITE);
		g.drawRect(60,510,230,210);
		g.drawRect(61,511,228,208);
		
		// Options
		Drawing.drawStringShadow(g, "Attack", 100, 550, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "Combat", 100, 600, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "Mystic", 100, 650, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "Item", 100, 700, 1, Color.GRAY);
	}
	
	public void renderUnits(Graphics g)
	{
		// Allies
		/*for(var pos=1;pos<=Battle.forceUnitCount[1];pos+=1)
		{
			//g.drawImage(Battle.forceUnit[1][pos].getAnim(), 600, 200, null);
			// Note: Should we specify a stance? Should the system automatically look at status effects, SOS and the like?
		}*/
		
		// Enemies
		/*for(var pos=1;pos<=Battle.forceUnitCount[2];pos+=1)
		{
			//g.drawImage(Assets.battleCharacter2Idle, 600, 200, null);
		}*/
		
		// Temp
		g.drawImage(Assets.battleCharacter2Idle, 1000, 200, null);
		g.drawImage(Assets.battleBoarIdle, 200, 200, null);
	}
}