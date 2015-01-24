package dev.tilegame.gfx;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Message
{
	private String[] messageText = new String[4];
	private boolean portraitActive;
	private BufferedImage portraitImage;
	private boolean speakerActive;
	private String speakerText;

	public Message(String text1, String text2, String text3)
	{
		messageText[1] = text1;
		messageText[2] = text2;
		messageText[3] = text3;
		portraitActive = false;
		speakerActive = false;
	}
	
	public void render(Graphics g)
	{
		// Shadow
		g.setColor(Color.GRAY);
		g.fillRect(51, 569, 1266, 150);
		g.fillRect(52, 570, 1266, 150);
		g.fillRect(53, 571, 1266, 150);
		g.fillRect(54, 572, 1266, 150);
		
		// Background
		g.setColor(Color.WHITE);
		g.fillRect(50, 568, 1266, 150);
		
		// Border
		g.setColor(Color.BLACK);
		g.drawRect(50, 568, 1266, 150);
		
		// Text
		g.setColor(Color.BLACK);
		g.setFont(Assets.fontStandard);
		g.drawString(messageText[1], 75, 615);
		g.drawString(messageText[2], 75, 655);
		g.drawString(messageText[3], 75, 695);
	}
	
	public void setPortrait(BufferedImage portrait)
	{
		portraitActive = true;
		portraitImage = portrait;
	}
	
	public void setSpeaker(String speaker)
	{
		speakerActive = true;
		speakerText = speaker;
	}
}