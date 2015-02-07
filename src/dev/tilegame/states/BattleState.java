package dev.tilegame.states;
import dev.tilegame.Game;
import dev.tilegame.Keyboard;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.Drawing;

import java.awt.Color;
import java.awt.Graphics;

public class BattleState extends State
{
	// State
	private String battleState = "Idle";
	
	// Tick
	private boolean tickCharge = true;
	
	// Command Menu
	private boolean menuNow = false;
	private int menuAlly = 0;
	private int menuPos = 0;
	private int menuMax = 0;
	
	// Action
	private boolean actionActive = false;
	private int actionTick = 0;
	private int actionFrame = 0;
	private int actionFrameMax = 5;
	private boolean actionDamageActive = false;
	private int actionDamageTick = 0;
	private int actionDamageFrame = 0;
	
	// Victory
	
	// Defeat
	
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
		menuPos = 1;
		menuMax = 1;
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderForce(g, 1);
		renderForce(g, 2);
		renderStats(g);
		if(actionDamageActive==true){renderActionDamage(g);}
		if(menuNow==true){renderMenu(g);}
	}
	
	public void renderActionDamage(Graphics g)
	{
		// Temp
		String damageString = "27";
		int damagePosX = 200;
		int damagePosY = 185 - (actionDamageFrame * 5);
		
		Drawing.drawStringShadow(g, damageString, damagePosX, damagePosY, 1, Color.GRAY);
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Game.battleEngine.bkgImage, 0, 0, null);
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
		renderStatsAllyHealth(g, ally);
		renderStatsAllyCharge(g, ally);
	}
	
	public void renderStatsAllyHealth(Graphics g, int ally)
	{
		float healthNow = Game.battleEngine.unitAlly[ally].statHealthNow;
		float healthMax = Game.battleEngine.unitAlly[ally].statHealthMax;
		float percent = (healthNow / healthMax) * 100;
		int width = (int) (percent * 3);
		g.setColor(Color.BLACK);
		g.fillRect(799, 649, 302, 27);
		g.setColor(Color.RED);
		g.fillRect(800, 650, width, 25);
	}

	public void renderStatsAllyCharge(Graphics g, int ally)
	{
		float chargeNow = Game.battleEngine.unitAlly[ally].actionCharge;
		float chargeMax = Game.battleEngine.unitAlly[ally].actionChargeDelay;
		float percent = (chargeNow / chargeMax) * 100;
		int width = (int) (300 - (percent * 3));
		g.setColor(Color.BLACK);
		g.fillRect(799, 699, 302, 27);
		g.setColor(Color.RED);
		g.fillRect(800, 700, width, 25);
		
		// Debug
		/*String debug1 = "Charge time remaining = " + Game.battleEngine.unitAlly[ally].actionCharge + " / " + Game.battleEngine.unitAlly[ally].actionChargeDelay;
		String debug2 = "This is " + percent + "% and creates a width of " + width;
		System.out.println(debug1);
		System.out.println(debug2);*/
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
		// Temp
		if(actionActive==true)
		{
			// Note: check if the action requires the combat animation
			g.drawImage(Game.battleEngine.unitAlly[ally].getAnim("Combat", actionFrame), 1000, 200, null);
		}
		else{g.drawImage(Game.battleEngine.unitAlly[ally].getAnim("Idle"), 1000, 200, null);}
	}
	
	public void renderForceEnemy(Graphics g, int enemy)
	{
		g.drawImage(Game.battleEngine.unitEnemy[enemy].getAnim("Idle"), 200, 200, null);
	}
	
	public void setBattleState(String state)
	{
		if(state=="Action")
		{
			tickCharge = false;
			actionActive = true;
			actionTick = 0;
			actionFrame = 1;
		}
		if(state=="Idle")
		{
			tickCharge = true;
		}
		if(state=="Defeat")
		{
			battleState = "Defeat";
		}
		if(state=="Victory")
		{
			battleState = "Victory";
		}
	}
	
	public void tick()
	{
		// Check that each force still has active units
		tickForceActive(1);
		tickForceActive(2);
		
		// Battle advances
		if(battleState=="Idle")
		{
			// Units prepare for their next action
			if(tickCharge==true)
			{
				tickForceCharge(1);
				tickForceCharge(2);
			}
			
			// Command Menu
			if(menuNow==true){tickKeyEvents();}
		}
		
		// Action is being performed
		if(battleState=="Action")
		{
			// Temp
			if(actionActive==true){tickAction();}
			if(actionDamageActive==true){tickActionDamage();}
		}
	}
	
	public void tickAction()
	{
		// Temp
		actionTick += 1;
		if(actionTick>=10)
		{
			actionFrame += 1;
			actionTick = 0;
			
			// Temp
			if(actionFrame>actionFrameMax)
			{
				actionActive = false;
				actionTick = 0;
				actionFrame = 0;
				actionDamageActive = true;
				actionDamageTick = 0;
				actionDamageFrame = 0;
			}
		}
	}
		
	public void tickActionDamage()
	{
		// Temp
		actionDamageTick += 1;
		if(actionDamageTick>=10)
		{
			actionDamageFrame += 1;
			actionDamageTick = 0;
			
			// Temp
			if(actionDamageFrame>5)
			{				
				actionDamageActive = false;
				actionDamageTick = 0;
				actionDamageFrame = 0;

				// Temp
				Game.battleEngine.unitEnemy[1].inflictDamage(27);
				
				tickCharge = true;
				Game.battleEngine.unitAlly[1].actionCharge = 300;
			}
		}
	}
	
	public void tickForceActive(int force)
	{
		if(force==1)
		{
			if(Game.battleEngine.getUnitAllyCountActive()<1)
			{
				setBattleState("Defeat");
			}
		}
		if(force==2)
		{
			if(Game.battleEngine.getUnitEnemyCountActive()<1)
			{
				setBattleState("Victory");
			}
		}
	}
	
	public void tickForceCharge(int force)
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
					/*String debug = "Ally #" + ally + " is charging (" + Game.battleEngine.unitAlly[ally].actionCharge + ")";
					System.out.println(debug);*/
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
				/*String debug = "Enemy #" + enemy + " is charging (" + Game.battleEngine.unitEnemy[enemy].actionCharge + ")";
				System.out.println(debug);*/
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
				menuCommands();
				setBattleState("Action");
			}
		}
	}

}