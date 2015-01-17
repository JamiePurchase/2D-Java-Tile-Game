package dev.tilegame;

import dev.tilegame.inventory.Inventory;
import dev.tilegame.journal.Journal;
import dev.tilegame.quests.QuestLog;

public class Session
{
	private static String filePath;
	private static Inventory inventory;
	private static Journal journal;
	private static QuestLog questLog;
	
	public Session()
	{
		
	}
	
	public String getFilePath()
	{
		return filePath;
	}
	
	public Inventory getInventory()
	{
		return inventory;
	}
	
	public Inventory getJournal()
	{
		return inventory;
	}
	
	public QuestLog getQuestLog()
	{
		return questLog;
	}
	
	public void setFilePath(String path)
	{
		filePath = path;
	}
	
	public static void setInventory(Inventory newInventory)
	{
		inventory = newInventory;
	}
	
	public static void setJournal(Journal newJournal)
	{
		journal = newJournal;
	}
	
	public static void setQuestLog(QuestLog newQuestLog)
	{
		questLog = newQuestLog;
	}
}