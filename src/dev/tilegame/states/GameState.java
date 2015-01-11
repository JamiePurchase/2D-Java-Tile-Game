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
		Game.world.render(g);
		renderInfo(g);
	}
	
	public void renderInfo(Graphics g)
	{
		g.drawImage(Assets.uiGameInfo1, 0, 0, null);
		g.drawImage(Assets.uiGameInfoMushroom, 170, 0, null);
		g.drawImage(Assets.uiGameInfoCount[Game.backpackMushrooms], 245, 10, null);
		g.drawImage(Assets.uiGameInfoTreasure, 370, 0, null);
		g.drawImage(Assets.uiGameInfoCount[Game.backpackTreasure], 445, 10, null);
		g.drawImage(Assets.uiGameInfoGarnet, 570, 0, null);
		g.drawImage(Assets.uiGameInfoCount[Game.backpackGarnets], 645, 10, null);
	}

}