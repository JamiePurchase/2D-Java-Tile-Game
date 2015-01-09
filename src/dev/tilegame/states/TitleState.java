package dev.tilegame.states;
import dev.tilegame.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;

public class TitleState extends State
{
	public TitleState()
	{
		
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 600);
		g.drawImage(Assets.uiLogoAP,  150, 20, null);
	}
}