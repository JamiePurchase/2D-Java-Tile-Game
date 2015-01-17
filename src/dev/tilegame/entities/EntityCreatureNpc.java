package dev.tilegame.entities;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.tilegame.gfx.Assets;

public class EntityCreatureNpc extends EntityCreature
{

	public EntityCreatureNpc()
	{
		
	}
	
	public static BufferedImage getImage()
	{
		if(getDirection()=="N"){return Assets.npcAnnaN;}
		if(getDirection()=="E"){return Assets.npcAnnaE;}
		if(getDirection()=="S"){return Assets.npcAnnaS;}
		if(getDirection()=="W"){return Assets.npcAnnaW;}
		return Assets.npcAnnaS;
	}
	
	public void render(Graphics g)
	{
		BufferedImage drawImage = getImage();
		int drawX = getPositionX() * 32 - 32;
		int drawY = getPositionY() * 32 + 24;
		g.drawImage(drawImage, drawX, drawY, null);
	}
	
	public void tick()
	{
	}
}