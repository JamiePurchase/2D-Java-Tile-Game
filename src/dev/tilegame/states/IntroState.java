package dev.tilegame.states;
import dev.tilegame.gfx.Assets;

import java.awt.Color;
import java.awt.Graphics;

public class IntroState extends State
{
	private int introFrame = 1;
	
	public IntroState()
	{
		
	}
	
	public void tick()
	{
		introFrame += 1;
		if(introFrame>400)
		{
			State.setStateChange("Title");
		}
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 600);
		if(introFrame>=100 && introFrame <= 300)
		{
			g.setFont(Assets.fontStandard);
			g.setColor(Color.white);
			g.drawString("Jamie Purchase", 350, 300);
			g.drawString("Presents", 380, 350);
		}
	}
}