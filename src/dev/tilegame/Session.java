package dev.tilegame;
import dev.tilegame.gfx.Board;
import dev.tilegame.entities.EntityCreaturePlayer;
import dev.tilegame.inventory.Inventory;

public class Session
{
	public static Board world;
	public static Inventory inventory;
	public static EntityCreaturePlayer player;
	//public static QuestLog quests;
	
	// Temp
	// Campaign Data
	public static int campaignStage = 0;
	
	public Session()
	{
		
	}
	
	public static void SessionNew()
	{
		inventory = new Inventory();
		//quests = new QuestLog();	private void initWorld()
		player = new EntityCreaturePlayer();
		world = new Board();
		world.getData("Board01");
	}
	
	public static Board getBoard()
	{
		return world;
	}
	
	public static Inventory getInventory()
	{
		return inventory;
	}
	
	public static EntityCreaturePlayer getPlayer()
	{
		return player;
	}
	
	/*public static QuestLog getQuests()
	{
		return quests;
	}*/
	
	public static void setBoard(String newBoard)
	{
		world = new Board();
		world.getData(newBoard);
	}
}