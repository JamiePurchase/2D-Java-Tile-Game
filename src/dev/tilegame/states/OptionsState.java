package dev.tilegame.states;
import dev.tilegame.Keyboard;
import dev.tilegame.gfx.Assets;
import java.awt.Graphics;

public class OptionsState extends State
{
	private int menuPos = 1;
	
	public OptionsState()
	{
		
	}
	
	public void tick()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space" || Keyboard.getKeyPressed()=="Escape")
		{
			Keyboard.setKeyDone();
			State.setStateChange("Title");
		}
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderOptions(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Assets.uiOptionsBkg,  0, 0, null);
	}
	
	public void renderOptions(Graphics g)
	{
		g.drawImage(Assets.uiOptDone,  300, 425, null);
	}
}