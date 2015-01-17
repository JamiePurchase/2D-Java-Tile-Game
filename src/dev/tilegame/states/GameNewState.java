package dev.tilegame.states;
import dev.tilegame.Game;
import dev.tilegame.Session;
import dev.tilegame.Keyboard;
import dev.tilegame.gfx.Assets;
import dev.tilegame.inventory.Inventory;
import dev.tilegame.journal.Journal;
import dev.tilegame.quests.QuestLog;

import java.awt.Color;
import java.awt.Graphics;

public class GameNewState extends State
{
	private int setupDone = 0;
	
	public GameNewState()
	{
		init();
	}
	
	public void init()
	{
		// Session
		Session newSession = new Session();
		Game.setSession(newSession);
		
		// Initial Board
		Game.world.getData("Board01");
		Assets.entPlayer.setPositionX(5);
		Assets.entPlayer.setPositionY(5);
		
		// Inventory
		Inventory newInventory = new Inventory();
		Session.setInventory(newInventory);
		
		// Journal
		Journal newJournal = new Journal();
		Session.setJournal(newJournal);
		
		// Quest Log
		QuestLog newQuestLog = new QuestLog();
		newQuestLog.init();
		Session.setQuestLog(newQuestLog);
		
		// Done
		setupDone = 1;
	}
	
	public void tick()
	{
		if(setupDone==1)
		{
			State.setStateChange("Game");
		}
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1366, 768);
	}
}