package dev.tilegame.states;
import dev.tilegame.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends State
{
	public MenuState()
	{
		
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 600);
	}
}