package dev.tilegame.states;
import dev.tilegame.Game;
import dev.tilegame.Keyboard;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.Drawing;

import java.awt.Color;
import java.awt.Graphics;

public class BattleState extends State
{
	private boolean menuNow = false;
	private int menuAlly = 0;
	private int menuPos = 0;
	private int menuMax = 0;
	
	public BattleState()
	{
	}
	
	public void menuCommands()
	{
		menuNow = false;
		menuAlly = 0;
	}
	
	public void menuCommands(int ally)
	{
		menuNow = true;
		menuAlly = ally;
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderForce(g, 1);
		renderForce(g, 2);
		renderStats(g);
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
	
	public void renderStats(Graphics g)
	{
		renderStatsAlly(g, 1);
		//if();
	}
	
	public void renderStatsAlly(Graphics g, int ally)
	{
		int drawY = (50 * ally) + 550;
		Drawing.drawStringShadow(g, "Character 1", 750, drawY, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "1000", 950, drawY, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "525", 1100, drawY, 1, Color.GRAY);
	}
	
	public void renderForce(Graphics g, int force)
	{
		if(force==1)
		{
			for(int ally=1;ally<=Game.battleEngine.unitAllyCount;ally+=1)
			{
				renderForceAlly(g, ally);
				// Note: Should we specify a stance? Should the system automatically look at status effects, SOS and the like?
			}
		}
		if(force==2)
		{
			for(int enemy=1;enemy<=Game.battleEngine.unitEnemyCount;enemy+=1)
			{
				renderForceEnemy(g, enemy);
			}
		}
	}
		
	public void renderForceAlly(Graphics g, int ally)
	{
		g.drawImage(Assets.battleCharacter2Idle, 1000, 200, null);
	}
	
	public void renderForceEnemy(Graphics g, int enemy)
	{
		g.drawImage(Assets.battleBoarIdle, 200, 200, null);
	}
	
	public void tick()
	{
		tickForce(1);
		tickForce(2);
		if(menuNow==true)
		{
			tickKeyEvents();
		}
	}
	
	public void tickForce(int force)
	{
		if(force==1)
		{
			for(int ally=1;ally<=Game.battleEngine.unitAllyCount;ally+=1)
			{
				if(Game.battleEngine.unitAlly[ally].actionStance=="Charge")
				{
					Game.battleEngine.unitAlly[ally].actionCharge-=1;
					if(Game.battleEngine.unitAlly[ally].actionCharge==0)
					{
						Game.battleEngine.unitAlly[ally].actionStance="Idle";
						menuCommands(ally);
					}
					
					// Debug
					String debug = "Ally #" + ally + " is charging (" + Game.battleEngine.unitAlly[ally].actionCharge + ")";
					System.out.println(debug);
				}
			}
		}
		if(force==2)
		{
			for(int enemy=1;enemy<=Game.battleEngine.unitEnemyCount;enemy+=1)
			{
				if(Game.battleEngine.unitEnemy[enemy].actionStance=="Charge")
				{
					Game.battleEngine.unitEnemy[enemy].actionCharge-=1;
					if(Game.battleEngine.unitEnemy[enemy].actionCharge==0)
					{
						Game.battleEngine.unitEnemy[enemy].actionStance="Idle";
					}
				}
				
				// Debug
				String debug = "Enemy #" + enemy + " is charging (" + Game.battleEngine.unitEnemy[enemy].actionCharge + ")";
				System.out.println(debug);
			}
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
				menuCommands();
			}
		}
	}

}