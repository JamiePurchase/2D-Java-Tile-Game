package dev.tilegame.dialogue;

import java.awt.Graphics;

import dev.tilegame.Game;
import dev.tilegame.Keyboard;
import dev.tilegame.message.MessageSpeech;
import dev.tilegame.message.MessageStandard;

public class Conversation
{
	public int pieceActive = 0;
	public int pieceCount = 0;
	public String[][] pieceDialogue = new String[100][4];
	public String[] pieceEvent = new String[100];
	public String[] pieceType = new String[100];
	public String[] pieceSpeaker = new String[100];
	
	// Temp
	public MessageStandard[] pieceMessage = new MessageStandard[100];
	
	public Conversation()
	{
		
	}
	
	public void advance()
	{
		pieceActive += 1;
		if(pieceActive<=pieceCount)
		{
			if(pieceType[pieceActive]=="Standard")
			{
				pieceMessage[pieceActive] = new MessageStandard(pieceDialogue[pieceActive][1],pieceDialogue[pieceActive][2],pieceDialogue[pieceActive][3]);
			}
			/*if(pieceType[pieceActive]=="Speech")
			{
				MessageSpeech newMessage = new MessageSpeech(pieceSpeaker[pieceActive],pieceDialogue[pieceActive][1],pieceDialogue[pieceActive][2],pieceDialogue[pieceActive][3]);
				Game.messageObjectSpeech = newMessage;
			}*/
		}
		else
		{
			Game.conversationActive = false;
		}
	}
	
	public void render(Graphics g)
	{
		if(pieceType[pieceActive]=="Standard")
		{
			pieceMessage[pieceActive].render(g);
		}
		/*if(pieceType[pieceActive]=="Speech")
		{
			Game.messageObjectSpeech.render(g);
		}*/
	}
	
	public void tick()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			advance();
		}
	}
}