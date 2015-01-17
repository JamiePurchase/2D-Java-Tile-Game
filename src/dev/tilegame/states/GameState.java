package dev.tilegame.states;
import dev.tilegame.Game;
import dev.tilegame.Session;
import dev.tilegame.gfx.Assets;

import java.awt.Graphics;

public class GameState extends State
{
	public GameState()
	{
		
	}
	
	public void tick()
	{
		System.out.println("GameState tick() was called.");
		//Session.getPlayer().tick();
	}
	
	public void render(Graphics g)
	{
		Session.world.render(g);
	}

}