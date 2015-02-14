package dev.tilegame.states;
import dev.tilegame.Game;
import dev.tilegame.Keyboard;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.Drawing;

import java.awt.Color;
import java.awt.Graphics;

public class BattleState extends State
{
	// Details
	public String battleState = "Idle";
	
	// Settings
	public boolean settingForceCharge = true;
	
	// Command Menu
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
		menuPos = 1;
		menuMax = 4;
		// Note: need to get these values from elsewhere
	}
	
	//==========================> RENDER: START
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderForce(g);
		renderStats(g);
		if(menuNow==true){renderMenu(g);}
		
		// Development Info
		renderDevInfo(g);
	}
	
	/*public void renderActionDamage(Graphics g)
	{
		// Temp
		String damageString = "27";
		int damagePosX = 200;
		int damagePosY = 185 - (actionDamageFrame * 5);
		
		Drawing.drawStringShadow(g, damageString, damagePosX, damagePosY, 1, Color.GRAY);
	}*/
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Game.battleEngine.bkgImage, 0, 0, null);
	}
	
	public void renderDevInfo(Graphics g)
	{
		// Shadow
		g.setColor(Color.GRAY);
		g.fillRect(484,210,400,350);
		g.fillRect(485,211,400,350);
		g.fillRect(486,212,400,350);
		g.fillRect(487,213,400,350);
		
		// Background
		g.setColor(Color.BLACK);
		g.fillRect(483,209,400,350);
		
		// Border
		g.setColor(Color.WHITE);
		g.drawRect(483,209,400,350);
		g.drawRect(484,210,398,348);
		
		// Data
		String ally1Action = Game.battleEngine.unitAlly[1].stanceType + " (" + Game.battleEngine.unitAlly[1].stanceFrame + ")";
		
		// Write
		Drawing.drawStringShadow(g, Game.battleEngine.unitAlly[1].unitName, 525, 250, 1, Color.GRAY);
		Drawing.drawStringShadow(g, ally1Action, 650, 250, 1, Color.GRAY);
		/*Drawing.drawStringShadow(g, "Combat", 525, 300, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "Mystic", 525, 350, 1, Color.GRAY);
		Drawing.drawStringShadow(g, "Item", 525, 400, 1, Color.GRAY);*/
	}
	
	//==========================> RENDER: FORCES
	
	public void renderForce(Graphics g)
	{
		// Allies
		for(int ally=1;ally<=Game.battleEngine.unitAllyCount;ally+=1)
		{
			renderForceAlly(g, ally, Game.battleEngine.unitAlly[ally].stanceType, Game.battleEngine.unitAlly[ally].stanceFrame);
		}

		// Enemies
		for(int enemy=1;enemy<=Game.battleEngine.unitEnemyCount;enemy+=1)
		{
			renderForceEnemy(g, enemy);
		}
	}
	
	public void renderForceAlly(Graphics g, int ally)
	{
		if(Game.battleEngine.unitAlly[ally].statusKO==true){renderForceAlly(g, ally, "Death", 1);}
		// Note: there should be many other variations (eg: poison, stone, frenzy, etc...)
		else{renderForceAlly(g, ally, "Idle", 1);}
	}

	public void renderForceAlly(Graphics g, int ally, String stance, int frame)
	{
		g.drawImage(Game.battleEngine.unitAlly[ally].getAnim(stance, frame), Game.battleEngine.unitAlly[ally].animPosX, Game.battleEngine.unitAlly[ally].animPosY, null);
	}
	
	public void renderForceEnemy(Graphics g, int enemy)
	{
		if(Game.battleEngine.unitEnemy[enemy].statusKO==true){renderForceEnemy(g, enemy, "Death", 1);}
		else{renderForceEnemy(g, enemy, "Idle", 1);}
	}
	
	public void renderForceEnemy(Graphics g, int enemy, String stance, int frame)
	{
		g.drawImage(Game.battleEngine.unitEnemy[enemy].getAnim(stance), Game.battleEngine.unitEnemy[enemy].animPosX, Game.battleEngine.unitEnemy[enemy].animPosY, null);
	}
	
	//==========================> RENDER: MENU
	
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
		
		// Cursor (temporary)
		int cursorY = (50 * menuPos) + 500;
		g.setColor(Color.WHITE);
		g.setFont(Assets.fontStandard);
		g.drawString(">", 75, cursorY);
	}
	
	//==========================> RENDER: STATS
	
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
	}
	
	//==========================> TICK: MAIN
	
	public void tick()
	{
		// Check that each force still has active units
		if(battleState=="Idle")
		{
			if(Game.battleEngine.getUnitAllyCountActive()<1){battleState = "Defeat";}
			if(Game.battleEngine.getUnitEnemyCountActive()<1){battleState = "Victory";}
		}

		// Battle advances
		if(battleState=="Idle")
		{
			if(settingForceCharge==true){tickCharge();}
			if(menuNow==true){tickMenu();}
			tickStance();
		}
		
		// Victory Screen
		if(battleState=="Victory"){tickVictory();}
		
		// Defeat Screen
		if(battleState=="Defeat"){tickDefeat();}
	}
	
	//==========================> TICK: CHARGE
	
	public void tickCharge()
	{
		// Allies
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
			}
		}
		
		// Enemies
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
		}
	}
	
	//==========================> TICK: DEFEAT
	
	public void tickDefeat()
	{
		
	}
	
	//==========================> TICK: MENU
	
	public void tickMenu()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			// Note: lots of work to do here - when any option is selected, the details should already exist as a BattleCommand object
			if(menuPos==1)
			{
				menuNow = false;
				
				// Temp
				Game.battleEngine.unitAlly[1].stanceFrame = 1;
				Game.battleEngine.unitAlly[1].stanceFrameMax = 5;
				Game.battleEngine.unitAlly[1].stanceTick = 0;
				Game.battleEngine.unitAlly[1].stanceTickMax = 20;
				Game.battleEngine.unitAlly[1].stanceType = "Combat";
			}
		}
		if(Keyboard.getKeyPressed()=="Up" && menuPos>1)
		{
			Keyboard.setKeyDone();
			menuPos -= 1;
		}
		if(Keyboard.getKeyPressed()=="Down" && menuPos<menuMax)
		{
			Keyboard.setKeyDone();
			menuPos += 1;
		}
	}
	
	//==========================> TICK: STANCE
	
	public void tickStance()
	{
		// Allies
		for(int ally=1;ally<=Game.battleEngine.unitAllyCount;ally+=1)
		{
			// Does this stance have multiple frames?
			if(Game.battleEngine.unitAlly[ally].stanceFrameMax>1)
			{
				Game.battleEngine.unitAlly[ally].stanceTick += 1;
				if(Game.battleEngine.unitAlly[ally].stanceTick>=Game.battleEngine.unitAlly[ally].stanceTickMax)
				{
					Game.battleEngine.unitAlly[ally].stanceTick = 0;
					Game.battleEngine.unitAlly[ally].stanceFrame += 1;
					
					if(Game.battleEngine.unitAlly[ally].stanceFrame>Game.battleEngine.unitAlly[ally].stanceFrameMax)
					{
						// Note: We must know whether to keep repeating or change
						Game.battleEngine.unitAlly[ally].stanceFrame = 1;
						Game.battleEngine.unitAlly[ally].stanceFrameMax = 1;
						Game.battleEngine.unitAlly[ally].stanceTick = 0;
						Game.battleEngine.unitAlly[ally].stanceTickMax = 0;
						Game.battleEngine.unitAlly[ally].stanceType = "Idle";
					}
				}
			}
		}
			
		// Enemies
		for(int enemy=1;enemy<=Game.battleEngine.unitEnemyCount;enemy+=1)
		{
			// Note: Animate all enemy stances that have multiple frames
		}
	}
	
	//==========================> TICK: VICTORY
	
	public void tickVictory()
	{
		
	}

}