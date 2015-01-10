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
		
	}
	
	public void render(Graphics g)
	{
		renderTiles(g);
		renderEntities(g);
	}
	
	public void renderEntities(Graphics g)
	{
		for(int x=1;x<=3;x+=1)
		{
			renderEntity(g, "Player");
		}
	}
	
	public void renderEntity(Graphics g, String entity)
	{
		BufferedImage drawImage = Assets.charPlayerS1;
		int drawX = Assets.entPlayer.getPositionX() * 32 - 32;
		int drawY = Assets.entPlayer.getPositionY() * 32 - 32;
		g.drawImage(drawImage, drawX, drawY, null);
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
		for(int x=1;x<=10;x+=1)
		{
			for(int y=1;y<=10;y+=1)
			{
				renderTile(g, x, y);
			}
		}
	}

}