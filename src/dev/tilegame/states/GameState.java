package dev.tilegame.states;
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
		Assets.entAnna.render(g);
		/*for(int x=1;x<=1;x+=1)
		{
			entity.render();
		}*/
		//Assets.entGarnet.render(g);
	}
	
	public void renderInfo(Graphics g)
	{
		g.drawImage(Assets.uiGameInfo1, 0, 0, null);
		g.setColor(Color.black);
		g.drawString("Test", 25, 25);
	}
	
	public void renderTile(Graphics g, int x, int y)
	{
		int drawX = x * 32 - 32;
		int drawY = y * 32 + 24;
		g.drawImage(Assets.brdTest.getTileImageFile(x, y), drawX, drawY, null);
	}
	
	public void renderTiles(Graphics g)
	{
		for(int x=1;x<=Assets.brdTest.getGridWidth();x+=1)
		{
			for(int y=1;y<=Assets.brdTest.getGridHeight();y+=1)
			{
				renderTile(g, x, y);
			}
		}
	}

}