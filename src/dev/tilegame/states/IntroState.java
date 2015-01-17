package dev.tilegame.states;
import dev.tilegame.gfx.Assets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class IntroState extends State
{
	private int introFrame = 1;
	
	public IntroState()
	{
		
	}
	
	public void tick()
	{
		introFrame += 1;
		if(introFrame>800)
		{
			State.setStateChange("Title");
		}
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0,0,1366,768);
		if(introFrame>=100 && introFrame <= 300)
		{
			g.drawImage(Assets.uiIntro1, 0, 0, null);
		}
		if(introFrame>=350 && introFrame <= 500)
		{
			g.drawImage(Assets.uiIntro2, 0, 0, null);
		}
		if(introFrame>=550 && introFrame <= 750)
		{ ;
			g.drawImage(Assets.uiIntro3, 0, 0, null);
		}
	}
}