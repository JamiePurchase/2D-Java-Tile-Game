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
		Game.world.tick();
	}
	
	public void render(Graphics g)
	{
		Game.world.render(g);
	}

}