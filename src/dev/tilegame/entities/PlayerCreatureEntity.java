package dev.tilegame.entities;
import dev.tilegame.gfx.Assets;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class PlayerCreatureEntity extends CreatureEntity implements KeyListener
{
	private static boolean moveN = false, moveE = false, moveS = false, moveW = false;
	private int moveSpeed = 3;
	
	public PlayerCreatureEntity()
	{
		
	}
	
	public static BufferedImage getImage()
	{
		if(moveN){return Assets.charPlayerN1;}
		if(getAction()=="Idle")
		{
			if(getDirection()=="N"){return Assets.charPlayerN1;}
			if(getDirection()=="E"){return Assets.charPlayerE1;}
			if(getDirection()=="S"){return Assets.charPlayerS1;}
			if(getDirection()=="W"){return Assets.charPlayerW1;}
		}
		return Assets.charPlayerS1;
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		System.out.println("Key Pressed");
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			moveN = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			moveE = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			moveS = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			moveW = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		System.out.println("Key Released");
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			moveN = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			moveE = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			moveS = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			moveW = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent key)
	{
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
		if(moveN)
		{
			int newY = getPositionY() - moveSpeed; 
			setPositionY(newY);
		}
		if(moveE)
		{
			int newX = getPositionX() + moveSpeed; 
			setPositionX(newX);
		}
		if(moveS)
		{
			//int newY = getPositionY() + moveSpeed;
			int newY = getPositionY() + 1;
			if(newY>16){newY = 0;}
			setPositionY(newY);
		}
		if(moveW)
		{
			int newX = getPositionX() - moveSpeed; 
			setPositionX(newX);
		}
	}

}