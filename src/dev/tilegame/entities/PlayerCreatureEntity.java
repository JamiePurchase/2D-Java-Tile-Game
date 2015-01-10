package dev.tilegame.entities;
import dev.tilegame.Game;
import dev.tilegame.Keyboard;
import dev.tilegame.gfx.Assets;
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
			if(getDirection()=="N"){return Assets.charPlayerN1;}
			if(getDirection()=="E"){return Assets.charPlayerE1;}
			if(getDirection()=="S"){return Assets.charPlayerS1;}
			if(getDirection()=="W"){return Assets.charPlayerW1;}
		}
		if(getAction()=="Walk")
		{
			if(getDirection()=="N")
			{
				if(getWalkFrame()==1){return Assets.charPlayerN2;}
				if(getWalkFrame()==2){return Assets.charPlayerN1;}
				if(getWalkFrame()==3){return Assets.charPlayerN3;}
				if(getWalkFrame()==4){return Assets.charPlayerN1;}
			}
			if(getDirection()=="E")
			{
				if(getWalkFrame()==1){return Assets.charPlayerE2;}
				if(getWalkFrame()==2){return Assets.charPlayerE1;}
				if(getWalkFrame()==3){return Assets.charPlayerE3;}
				if(getWalkFrame()==4){return Assets.charPlayerE1;}
			}
			if(getDirection()=="S")
			{
				if(getWalkFrame()==1){return Assets.charPlayerS2;}
				if(getWalkFrame()==2){return Assets.charPlayerS1;}
				if(getWalkFrame()==3){return Assets.charPlayerS3;}
				if(getWalkFrame()==4){return Assets.charPlayerS1;}
			}
			if(getDirection()=="W")
			{
				if(getWalkFrame()==1){return Assets.charPlayerW2;}
				if(getWalkFrame()==2){return Assets.charPlayerW1;}
				if(getWalkFrame()==3){return Assets.charPlayerW3;}
				if(getWalkFrame()==4){return Assets.charPlayerW1;}
			}
		}
		return Assets.charPlayerS1;
	}
	
	public void render(Graphics g)
	{
		BufferedImage drawImage = getImage();
		int drawX = getPositionX() * 32 - 32;
		int drawY = getPositionY() * 32 + 24;
		if(getAction()=="Walk")
		{
			int offset = getWalkFrame() * 8;
			if(getDirection()=="N"){drawY -= offset;}
			if(getDirection()=="E"){drawX += offset;}
			if(getDirection()=="S"){drawY += offset;}
			if(getDirection()=="W"){drawX -= offset;}
		}
		g.drawImage(drawImage, drawX, drawY, null);
	}
	
	public void tick()
	{
		if(getAction()=="Idle"){tickKeyEvents();}
		tickMovement();
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
			Game.chat = false;
		}
	}
		
	public void tickKeyEventsStandard()
	{
		if(Keyboard.getKeyPressed()=="Enter")
		{
			State.setStateChange("Menu");
		}
		if(Keyboard.getKeyPressed()=="Up")
		{
			if(getPositionY()>1)
			{
				int newPosX = getPositionX();
				int newPosY = getPositionY() - 1;
				if(Assets.brdTest.getTileType(newPosX, newPosY)==0)
				{
					walk("N");
				}
			}
			setDirection("N");
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Down")
		{
			if(getPositionY()<Assets.brdTest.getGridHeight())
			{
				int newPosX = getPositionX();
				int newPosY = getPositionY() + 1;
				if(Assets.brdTest.getTileType(newPosX, newPosY)==0)
				{
					walk("S");
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
				if(Assets.brdTest.getTileType(newPosX, newPosY)==0)
				{
					walk("W");
				}
			}
			setDirection("W");
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Right")
		{
			if(getPositionX()<Assets.brdTest.getGridWidth())
			{
				int newPosX = getPositionX() + 1;
				int newPosY = getPositionY();
				if(Assets.brdTest.getTileType(newPosX, newPosY)==0)
				{
					walk("E");
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
			setWalkFrameTick();
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

}