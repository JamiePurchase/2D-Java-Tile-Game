package dev.tilegame.gfx;
import java.awt.Color;
import java.awt.Graphics;

public class Drawing
{
	public static void drawCursor(Graphics g, int x, int y, int frame)
	{
		if(frame==1){g.drawImage(Assets.uiCursor1, x, y, null);}
		if(frame==2){g.drawImage(Assets.uiCursor2, x, y, null);}
		if(frame==3){g.drawImage(Assets.uiCursor3, x, y, null);}
		if(frame==4){g.drawImage(Assets.uiCursor2, x, y, null);}
	}
	
	public static void drawFrame(Graphics g, int x, int y, int width, int height)
	{
		// Shadow
		g.setColor(Color.gray);
		g.fillRect(x+5, y+5, width, height);
		
		// Background
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		
		// Border
		g.setColor(Color.white);
		g.drawRect(x, y, width, height);
	}
}