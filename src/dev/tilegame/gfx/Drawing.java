package dev.tilegame.gfx;
import java.awt.Color;
import java.awt.Graphics;

public class Drawing
{
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
	
	public static void drawMenuItem(Graphics g, String text, int x, int y)
	{
		g.setFont(Assets.fontEditorMenu);
		g.setColor(Color.BLACK);
		g.drawString(text, x, y);
		/*g.setFont(Assets.fontStandardUnderline);
		String character = "" + text.charAt(1);
		g.drawString(character, x, y);*/
	}
}