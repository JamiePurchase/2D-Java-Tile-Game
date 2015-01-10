package dev.tilegame.entities;
import dev.tilegame.Keyboard;
import dev.tilegame.gfx.Assets;

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
		int drawY = getPositionY() * 32 - 32;
		g.drawImage(drawImage, drawX, drawY, null);
	}
	
	public void tick()
	{
		tickKeyEvents();
		tickMovement();
	}
	
	public void tickKeyEvents()
	{
		if(Keyboard.getKeyPressed()=="Up")
		{
			setAction("Walk");
			setDirection("N");
			setWalkFrame(1);
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Down")
		{
			setAction("Walk");
			setDirection("S");
			setWalkFrame(1);
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Left")
		{
			setAction("Walk");
			setDirection("W");
			setWalkFrame(1);
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Right")
		{
			setAction("Walk");
			setDirection("E");
			setWalkFrame(1);
			Keyboard.setKeyDone();
		}
	}
	
	public void tickMovement()
	{
		if(getAction()=="Walk")
		{
			int walkFrameNew = getWalkFrame() + 1;
			if(walkFrameNew>4)
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
			else
			{
				setWalkFrame(walkFrameNew);
			}
		}
	}

}