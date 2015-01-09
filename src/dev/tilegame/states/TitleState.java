package dev.tilegame.states;
import dev.tilegame.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;

public class TitleState extends State
{
	private int menuPos = 1;
	private int menuMax = 3;
	private int cursorFrame = 1;
	
	public TitleState()
	{
		
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		cursorFrame += 1;
		if(cursorFrame>40){cursorFrame = 1;}
		renderBackground(g);
		renderOptions(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 600);
		g.drawImage(Assets.uiLogoAP,  150, 20, null);
		g.setFont(Assets.fontHint);
		g.setColor(Color.white);
		g.drawString("Created by Jamie Purchase", 30, 580);
	}
	
	public void renderOptions(Graphics g)
	{
		g.setFont(Assets.fontOption);
		g.setColor(Color.white);
		g.drawString("New Game", 300, 300);
		g.drawString("Options", 300, 350);
		g.drawString("End Game", 300, 400);
		renderOptionsCursor(g);
	}
	
	public void renderOptionsCursor(Graphics g)
	{
		int x = 250;
		int y = 50 * menuPos + 225;
		if(cursorFrame>0 && cursorFrame<=10){g.drawImage(Assets.uiCursor1, x, y, null);}
		if(cursorFrame>10 && cursorFrame<=20){g.drawImage(Assets.uiCursor2, x, y, null);}
		if(cursorFrame>20 && cursorFrame<=30){g.drawImage(Assets.uiCursor3, x, y, null);}
		if(cursorFrame>30 && cursorFrame<=40){g.drawImage(Assets.uiCursor2, x, y, null);}
	}
}