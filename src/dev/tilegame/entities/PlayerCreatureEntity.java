package dev.tilegame.entities;
import dev.tilegame.Game;
import dev.tilegame.Keyboard;
import dev.tilegame.audio.AudioPlayer;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.Board;
import dev.tilegame.states.State;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PlayerCreatureEntity extends CreatureEntity
{
	
	public PlayerCreatureEntity()
	{
		
	}
	
	public static BufferedImage getImage()
	{
		if(getAction()=="Idle")
		{
			if(Game.playerClass=="Warmonger")
			{
				if(getDirection()=="N"){return Assets.charPlayer1N1;}
				if(getDirection()=="E"){return Assets.charPlayer1E1;}
				if(getDirection()=="S"){return Assets.charPlayer1S1;}
				if(getDirection()=="W"){return Assets.charPlayer1W1;}
			}
			if(Game.playerClass=="Stalker")
			{
				if(getDirection()=="N"){return Assets.charPlayer2N1;}
				if(getDirection()=="E"){return Assets.charPlayer2E1;}
				if(getDirection()=="S"){return Assets.charPlayer2S1;}
				if(getDirection()=="W"){return Assets.charPlayer2W1;}
			}
			if(Game.playerClass=="Spellweaver")
			{
				if(getDirection()=="N"){return Assets.charPlayer3N1;}
				if(getDirection()=="E"){return Assets.charPlayer3E1;}
				if(getDirection()=="S"){return Assets.charPlayer3S1;}
				if(getDirection()=="W"){return Assets.charPlayer3W1;}
			}
		}
		if(getAction()=="Walk")
		{
			if(Game.playerClass=="Warmonger")
			{
				if(getDirection()=="N")
				{
					if(getWalkFrame()==1){return Assets.charPlayer1N2;}
					if(getWalkFrame()==2){return Assets.charPlayer1N1;}
					if(getWalkFrame()==3){return Assets.charPlayer1N3;}
					if(getWalkFrame()==4){return Assets.charPlayer1N1;}
				}
				if(getDirection()=="E")
				{
					if(getWalkFrame()==1){return Assets.charPlayer1E2;}
					if(getWalkFrame()==2){return Assets.charPlayer1E1;}
					if(getWalkFrame()==3){return Assets.charPlayer1E3;}
					if(getWalkFrame()==4){return Assets.charPlayer1E1;}
				}
				if(getDirection()=="S")
				{
					if(getWalkFrame()==1){return Assets.charPlayer1S2;}
					if(getWalkFrame()==2){return Assets.charPlayer1S1;}
					if(getWalkFrame()==3){return Assets.charPlayer1S3;}
					if(getWalkFrame()==4){return Assets.charPlayer1S1;}
				}
				if(getDirection()=="W")
				{
					if(getWalkFrame()==1){return Assets.charPlayer1W2;}
					if(getWalkFrame()==2){return Assets.charPlayer1W1;}
					if(getWalkFrame()==3){return Assets.charPlayer1W3;}
					if(getWalkFrame()==4){return Assets.charPlayer1W1;}
				}
			}
			if(Game.playerClass=="Stalker")
			{
				if(getDirection()=="N")
				{
					if(getWalkFrame()==1){return Assets.charPlayer2N2;}
					if(getWalkFrame()==2){return Assets.charPlayer2N1;}
					if(getWalkFrame()==3){return Assets.charPlayer2N3;}
					if(getWalkFrame()==4){return Assets.charPlayer2N1;}
				}
				if(getDirection()=="E")
				{
					if(getWalkFrame()==1){return Assets.charPlayer2E2;}
					if(getWalkFrame()==2){return Assets.charPlayer2E1;}
					if(getWalkFrame()==3){return Assets.charPlayer2E3;}
					if(getWalkFrame()==4){return Assets.charPlayer2E1;}
				}
				if(getDirection()=="S")
				{
					if(getWalkFrame()==1){return Assets.charPlayer2S2;}
					if(getWalkFrame()==2){return Assets.charPlayer2S1;}
					if(getWalkFrame()==3){return Assets.charPlayer2S3;}
					if(getWalkFrame()==4){return Assets.charPlayer2S1;}
				}
				if(getDirection()=="W")
				{
					if(getWalkFrame()==1){return Assets.charPlayer2W2;}
					if(getWalkFrame()==2){return Assets.charPlayer2W1;}
					if(getWalkFrame()==3){return Assets.charPlayer2W3;}
					if(getWalkFrame()==4){return Assets.charPlayer2W1;}
				}
			}
			if(Game.playerClass=="Spellweaver")
			{
				if(getDirection()=="N")
				{
					if(getWalkFrame()==1){return Assets.charPlayer3N2;}
					if(getWalkFrame()==2){return Assets.charPlayer3N1;}
					if(getWalkFrame()==3){return Assets.charPlayer3N3;}
					if(getWalkFrame()==4){return Assets.charPlayer3N1;}
				}
				if(getDirection()=="E")
				{
					if(getWalkFrame()==1){return Assets.charPlayer3E2;}
					if(getWalkFrame()==2){return Assets.charPlayer3E1;}
					if(getWalkFrame()==3){return Assets.charPlayer3E3;}
					if(getWalkFrame()==4){return Assets.charPlayer3E1;}
				}
				if(getDirection()=="S")
				{
					if(getWalkFrame()==1){return Assets.charPlayer3S2;}
					if(getWalkFrame()==2){return Assets.charPlayer3S1;}
					if(getWalkFrame()==3){return Assets.charPlayer3S3;}
					if(getWalkFrame()==4){return Assets.charPlayer3S1;}
				}
				if(getDirection()=="W")
				{
					if(getWalkFrame()==1){return Assets.charPlayer3W2;}
					if(getWalkFrame()==2){return Assets.charPlayer3W1;}
					if(getWalkFrame()==3){return Assets.charPlayer3W3;}
					if(getWalkFrame()==4){return Assets.charPlayer3W1;}
				}
			}
		}
		return null;
	}
	
	public void render(Graphics g)
	{
		BufferedImage drawImage = getImage();
		int drawX = ((getPositionX() - Game.world.getGridOffsetX()) * 32) - 21;
		int drawY = ((getPositionY() - Game.world.getGridOffsetY()) * 32) - 16;
		if(getAction()=="Walk")
		{
			int offset = getWalkFrame() * 8;
			if(getDirection()=="N"){drawY -= offset;}
			if(getDirection()=="E"){drawX += offset;}
			if(getDirection()=="S"){drawY += offset;}
			if(getDirection()=="W"){drawX -= offset;}
		}
		g.drawImage(drawImage, drawX, drawY, null);
		
		// Debug
		/*String debug1 = "Player location: " + getPositionX() + ", " + getPositionY();
		String debug2 = "Grid Offset: " + Game.world.getGridOffsetX() + ", " + Game.world.getGridOffsetY();
		String debug3 = "Draw Coords = " + drawX + ", " + drawY;
		System.out.println(debug1);
		System.out.println(debug2);
		System.out.println(debug3);*/
	}
	
	public void tick()
	{
		if(getAction()=="Idle"){tickKeyEvents();}
		tickMovement();
	}
	
	public void tickKeyEntity(int posX, int posY)
	{
		if(Game.world.getTileEntity(posX, posY)=="NPC")
		{
			//Game.chat = true;
			
			// Debug
			String debug1 = "Interacted with an npc at " + posX + ", " + posY;
			System.out.println(debug1);
		}
		if(Game.world.getTileEntity(posX, posY)=="Portal")
		{
			// Debug
			String debug1 = "Interacted with a portal at " + posX + ", " + posY;
			System.out.println(debug1);
		}
	}
	
	public void tickKeyEvents()
	{
		if(Game.chat==true)
		{
			tickKeyEventsChat();
		}
		else
		{
			tickKeyEventsStandard();
		}
	}
	
	public void tickKeyEventsChat()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			Game.chat = false;
		}
	}
		
	public void tickKeyEventsStandard()
	{
		if(Keyboard.getKeyPressed()=="Enter")
		{
			Keyboard.setKeyDone();
			State.setStateChange("Menu");
		}
		if(Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			int checkPosX = getPositionX();
			int checkPosY = getPositionY();
			if(getDirection()=="N"){checkPosY -= 1;}
			if(getDirection()=="E"){checkPosX += 1;}
			if(getDirection()=="S"){checkPosY += 1;}
			if(getDirection()=="W"){checkPosX -= 1;}
			if(!Game.world.getTileEntity(checkPosX, checkPosY).equals("None")){tickKeyEntity(checkPosX, checkPosY);}
		}
		if(Keyboard.getKeyPressed()=="Up")
		{
			if(getPositionY()>1)
			{
				int newPosX = getPositionX();
				int newPosY = getPositionY() - 1;
				if(Game.world.getTileType(newPosX, newPosY)==0)
				{
					walk("N");
					if(Game.world.getGridScroll()==true){Game.world.setGridScrollNew("N");}
				}
			}
			setDirection("N");
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Down")
		{
			if(getPositionY()<Game.world.getGridHeight())
			{
				int newPosX = getPositionX();
				int newPosY = getPositionY() + 1;
				if(Game.world.getTileType(newPosX, newPosY)==0)
				{
					walk("S");
					if(Game.world.getGridScroll()==true){Game.world.setGridScrollNew("S");}
				}
			}
			setDirection("S");
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Left")
		{
			if(getPositionX()>1)
			{
				int newPosX = getPositionX() - 1;
				int newPosY = getPositionY();
				if(Game.world.getTileType(newPosX, newPosY)==0)
				{
					walk("W");
					if(Game.world.getGridScroll()==true){Game.world.setGridScrollNew("W");}
				}
			}
			setDirection("W");
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Right")
		{
			if(getPositionX()<Game.world.getGridWidth())
			{
				int newPosX = getPositionX() + 1;
				int newPosY = getPositionY();
				if(Game.world.getTileType(newPosX, newPosY)==0)
				{
					walk("E");
					if(Game.world.getGridScroll()==true){Game.world.setGridScrollNew("E");}
				}
			}
			setDirection("E");
			Keyboard.setKeyDone();
		}
	}
	
	public void tickMovement()
	{
		if(getAction()=="Walk")
		{
			// Each time this is called we might advance to the next frame (based on movement speed)
			setWalkFrameTick();
			
			// Scroll the board if necessary
			if(Game.world.getGridScrollAction()==true && getWalkFrame()==2)
			{
				Game.world.setGridOffsetMove(getDirection());
				Game.world.setGridScrollDone();
			}
			
			// Walking finished
			if(getWalkFrame()>4)
			{
				int walkPosX = getPositionX();
				int walkPosY = getPositionY();
				if(getDirection()=="N"){walkPosY -= 1;}
				if(getDirection()=="E"){walkPosX += 1;}
				if(getDirection()=="S"){walkPosY += 1;}
				if(getDirection()=="W"){walkPosX -= 1;}
				setPositionX(walkPosX);
				setPositionY(walkPosY);
				setAction("Idle");
				setWalkFrame(0);
			}
		}
	}
	
	public static void walk(String direction)
	{
		setAction("Walk");
		setDirection(direction);
		setWalkFrame(1);
		int tileX = Assets.entPlayer.getPositionX();
		int tileY = Assets.entPlayer.getPositionY();
		if(direction=="N"){tileY -= 1;}
		if(direction=="E"){tileX += 1;}
		if(direction=="S"){tileY += 1;}
		if(direction=="W"){tileX -= 1;}
		if(Game.world.getTileEntity(tileX, tileY)=="Treasure")
		{
			int ID = Game.world.getTileEntityID(tileX, tileY);
			Game.world.setTreasureFound(ID);
			AudioPlayer.play("Treasure");
		}
	}

}