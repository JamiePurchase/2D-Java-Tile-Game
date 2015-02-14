package dev.tilegame.states;
import dev.tilegame.Game;
import dev.tilegame.Session;
import dev.tilegame.Keyboard;
import dev.tilegame.gfx.Assets;
import dev.tilegame.inventory.Inventory;
import dev.tilegame.journal.Journal;
import dev.tilegame.quests.Quest;
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
		initBoard();
		initQuests();
	}
	
	public void initBoard()
	{
		// Session
		Session newSession = new Session();
		Game.setSession(newSession);
		
		// Initial Board
		Assets.entPlayer.setWalkSpeed(1);
		
		/*Game.world.getData("Board01");
		Assets.entPlayer.setPositionX(5);
		Assets.entPlayer.setPositionY(5);
		Game.world.setGridScroll(false);
		Game.world.setGridOffset(0, 0);*/
		
		// Temp (Jharva Village Centre)
		/*Game.world.getData("JvExterior");
		Assets.entPlayer.setPositionX(50);
		Assets.entPlayer.setPositionY(44);
		Game.world.setGridScroll(true);
		Game.world.setGridOffset(29, 33);*/
		
		// Temp (Jharva Laboratory)
		/*Game.world.getData("JvExterior");
		Assets.entPlayer.setPosition(71, 38);
		Game.world.setGridScroll(true);
		Game.world.setGridOffset();*/
		
		// Temp (Jharva Village Blacksmith)
		Game.world.getData("JvExterior");
		Assets.entPlayer.setPosition(24, 55);
		Game.world.setGridScroll(true);
		Game.world.setGridOffset();
		Assets.entPlayer.setWalkSpeed(10);
		
		// Temp (Jharva Village North Gate)
		/*Game.world.getData("JvExterior");
		Assets.entPlayer.setPositionX(58);
		Assets.entPlayer.setPositionY(13);
		Game.world.setGridScroll(true);
		Game.world.setGridOffset(37, 2);*/
		
		// Temp (Jharva Village North Bridge)
		/*Game.world.getData("JvExterior");
		Assets.entPlayer.setPositionX(34);
		Assets.entPlayer.setPositionY(25);
		Game.world.setGridScroll(true);
		Game.world.setGridOffset();*/
		
		// Temp (Jharva Village South Bridge)
		/*Game.world.getData("JvExterior");
		Assets.entPlayer.setPositionX(41);
		Assets.entPlayer.setPositionY(57);
		Game.world.setGridScroll(true);
		Game.world.setGridOffset();*/
		
		// Temp (Python City Centre)
		/*Game.world.getData("PyExterior");
		Assets.entPlayer.setPositionX(50);
		Assets.entPlayer.setPositionY(44);
		Game.world.setGridScroll(true);
		Game.world.setGridOffset(29, 33);*/
		
		// Temp (Jharva Village Player Bedroom)
		/*Game.world.getData("JvPlayerBedroom");
		Assets.entPlayer.setPositionX(21);
		Assets.entPlayer.setPositionY(15);
		Game.world.setGridScroll(false);
		Game.world.setGridOffset(0, 0);*/
		
		// Temp (Jharva Village Laboratory Main)
		/*Game.world.getData("JvLaboratoryMain");
		Assets.entPlayer.setPositionX(21);
		Assets.entPlayer.setPositionY(15);
		Game.world.setGridScroll(false);
		Game.world.setGridOffset(0, 0);*/

		// Inventory
		Inventory newInventory = new Inventory();
		Session.setInventory(newInventory);
		
		// Journal
		Journal newJournal = new Journal();
		Session.setJournal(newJournal);
		
		// Quest Log
		
		// Done
		setupDone = 1;
	}
	
	public void initQuests()
	{
		QuestLog newQuestLog = new QuestLog();
		newQuestLog.init();
		Session.setQuestLog(newQuestLog);
		
		// Temp
		/*Quest newQuest = new Quest("Main", "Welcome to Jharva Village");
		newQuest.setStageObjective(1, "Talk to Professor Hoffman");*/
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