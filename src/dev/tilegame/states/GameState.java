package dev.tilegame.states;
import dev.tilegame.gfx.Assets;
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
		renderEntities(g);
	}
	
	public void renderEntities(Graphics g)
	{
		Assets.entPlayer.render(g);
		/*for(int x=1;x<=1;x+=1)
		{
			entity.render();
		}*/
	}
	
	public void renderTile(Graphics g, int x, int y)
	{
		//BufferedImage drawImage = Assets.brdTest.getTileImage(x, y);
		BufferedImage drawImage = Assets.txtGrass;
		int drawX = x * 32 - 32;
		int drawY = y * 32 - 32;
		g.drawImage(drawImage, drawX, drawY, null);
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