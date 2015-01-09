package dev.tilegame.states;
import dev.tilegame.gfx.Assets;
import java.awt.Graphics;

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
		g.drawImage(Assets.txtTree, 0, 0, null);
		g.drawImage(Assets.txtGrass, 0, 0, null);
	}
}