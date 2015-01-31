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
		Assets.entPlayer.setWalkSpeed(1);
		
		/*Game.world.getData("Board01");
		Assets.entPlayer.setPositionX(5);
		Assets.entPlayer.setPositionY(5);
		Game.world.setGridScroll(false);
		Game.world.setGridOffset(0, 0);*/
		
		// Temp
		Game.world.getData("JvExterior");
		Assets.entPlayer.setPositionX(50);
		Assets.entPlayer.setPositionY(44);
		Game.world.setGridScroll(true);
		Game.world.setGridOffset(29, 33);
		
		// Temp
		/*Game.world.getData("PyExterior");
		Assets.entPlayer.setPositionX(50);
		Assets.entPlayer.setPositionY(44);
		Game.world.setGridScroll(true);
		Game.world.setGridOffset(29, 33);*/
		
		// Temp
		/*Game.world.getData("JvPlayerBedroom");
		Assets.entPlayer.setPositionX(21);
		Assets.entPlayer.setPositionY(15);
		Game.world.setGridScroll(false);
		Game.world.setGridOffset(0, 0);*/
		
		// Temp
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