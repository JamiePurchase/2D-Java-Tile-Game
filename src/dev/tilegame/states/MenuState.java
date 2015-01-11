package dev.tilegame.states;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.Drawing;
import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends State
{
	
	private int menuPos = 1;
	private int menuMax = 7;
	
	public MenuState()
	{
		
	}
	
	public void keyPress(String key)
	{
		if(key=="ENTER")
		{
			// Enter a submenu
		}
		if(key=="ESCAPE")
		{
			// Close the menu
		}
		if(key=="UP" && menuPos>1)
		{
			menuPos -= 1;
			return;
		}
		if(key=="DOWN" && menuPos<menuMax)
		{
			menuPos += 1;
			return;
		}
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.green);
		g.fillRect(0, 0, 800, 600);
		renderOptions(g);
		renderInformation(g);
	}
	
	public void renderInformation(Graphics g)
	{
		// Frame
		Drawing.drawFrame(g, 15, 470, 770, 110);
		
		// Text
		g.setFont(Assets.fontStandard);
		g.drawString("Information", 45, 505);
	}
	
	public void renderOptions(Graphics g)
	{
		renderOption(g, 1, "Inventory", 15, 15);
		renderOption(g, 2, "Equipment", 15, 80);
		renderOption(g, 3, "Abilities", 15, 145);
		renderOption(g, 4, "Formation", 15, 210);
		renderOption(g, 5, "Journal", 15, 275);
		renderOption(g, 6, "Options", 15, 340);
		renderOption(g, 7, "Done", 15, 405);
	}
	
	public void renderOption(Graphics g, int id, String option, int x, int y)
	{
		// Frame
		Drawing.drawFrame(g, x, y, 200, 50);
	
		// Highlighted
		if(id==menuPos)
		{
			g.setColor(Color.gray);
			g.fillRect(x, y, 200, 50);
			g.setColor(Color.white);
			g.drawRect(x, y, 200, 50);
		}
		
		// Text
		g.setFont(Assets.fontStandard);
		g.setColor(Color.white);
		g.drawString(option, x+25, y+35);
	}
}