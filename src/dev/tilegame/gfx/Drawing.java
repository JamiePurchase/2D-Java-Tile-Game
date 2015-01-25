package dev.tilegame.gfx;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Drawing
{
	public static void drawImageOpaque(Graphics g, BufferedImage image, int posX, int posY, float alpha)
	{
		// Set Opacity
		Graphics2D g2D = (Graphics2D) g;
		AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g2D.setComposite(composite);
		
		// Draw Image
		g2D.drawImage(image, posX, posY, null);
		
		// Clear Opacity
		composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
		g2D.setComposite(composite);
	}
	
	public static void drawStringShadow(Graphics g, String text, int x, int y)
	{
		drawStringShadow(g, text, x, y, 2, Color.BLACK);
	}
		
	public static void drawStringShadow(Graphics g, String text, int x, int y, int shadow, Color color)
	{
		g.setFont(Assets.fontStandard);
		g.setColor(color);
		for(int n=1;n<=shadow;n+=1)
		{
			g.drawString(text, x+n, y+n);
		}
		g.setColor(Color.WHITE);
		g.drawString(text, x, y);
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
	
	public static void drawMenuItem(Graphics g, String text, int x, int y, int hover)
	{
		g.setFont(Assets.fontEditorMenu);
		if(hover==1){g.setFont(Assets.fontEditorMenuBold);}
		g.setColor(Color.BLACK);
		g.drawString(text, x, y);
		/*g.setFont(Assets.fontStandardUnderline);
		String character = "" + text.charAt(1);
		g.drawString(character, x, y);*/
	}
}