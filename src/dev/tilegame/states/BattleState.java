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
	}
}