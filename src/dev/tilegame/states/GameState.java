package dev.tilegame.states;
import dev.tilegame.Game;
import dev.tilegame.gfx.Assets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GameState extends State
{
	public GameState()
	{
		
	}
	
	public void tick()
	{
		Assets.entPlayer.tick();
	}
	
	public void render(Graphics g)
	{
		renderTiles(g);
		renderInfo(g);
		renderEntities(g);
	}
	
	public void renderEntities(Graphics g)
	{
		Assets.entPlayer.render(g);
		Game.world.drawMushrooms(g);
		Game.world.drawTreasure(g);
		
		// Test
		//Assets.entAnna.render(g);
		//int drawX = Assets.entAnna.getPositionX() * 32 - 32;
		//int drawY = Assets.entAnna.getPositionY() * 32 + 24;
		//g.drawImage(Assets.npcAnnaS, drawX, drawY, null);
		g.drawImage(Assets.npcAnnaS, 256, 184, null);
		
		/*for(int x=1;x<=1;x+=1)
		{
			entity.render();
		}*/
		//Assets.entGarnet.render(g);
	}
	
	public void renderInfo(Graphics g)
	{
		g.drawImage(Assets.uiGameInfo1, 0, 0, null);
		g.drawImage(Assets.uiGameInfoMushroom, 170, 0, null);
		g.drawImage(Assets.uiGameInfoCount[Game.backpackMushrooms], 245, 10, null);
		g.drawImage(Assets.uiGameInfoTreasure, 370, 0, null);
		g.drawImage(Assets.uiGameInfoCount[Game.backpackTreasure], 445, 10, null);
	}
	
	public void renderTile(Graphics g, int x, int y)
	{
		int drawX = x * 32 - 32;
		int drawY = y * 32 + 24;
		g.drawImage(Game.world.getTileImageFile(x, y), drawX, drawY, null);
	}
	
	public void renderTiles(Graphics g)
	{
		for(int x=1;x<=Game.world.getGridWidth();x+=1)
		{
			for(int y=1;y<=Game.world.getGridHeight();y+=1)
			{
				renderTile(g, x, y);
			}
		}
	}

}