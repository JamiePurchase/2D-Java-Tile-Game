package dev.tilegame.states;
import dev.tilegame.Keyboard;
import dev.tilegame.gfx.Assets;
import java.awt.Graphics;

public class AboutState extends State
{
	private int menuPos = 1;
	
	public AboutState()
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
		renderDetails(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Assets.uiAboutBkg,  0, 0, null);
	}
	
	public void renderDetails(Graphics g)
	{
		g.drawImage(Assets.uiOptDoneA,  300, 425, null);
	}
}