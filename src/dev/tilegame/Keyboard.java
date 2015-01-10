package dev.tilegame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener
{
	private static String keyPressed = "None";
	
	public static String getKeyPressed()
	{
		return keyPressed;
	}

    public void keyTyped(KeyEvent e)
    {
        System.out.println("Key typed: " + e.getKeyChar());
    }

    public void keyPressed(KeyEvent e)
    {
        System.out.println("Key pressed: " + e.getKeyChar());
        if(e.getKeyCode() == KeyEvent.VK_UP){keyPressed = "Up";}
        if(e.getKeyCode() == KeyEvent.VK_DOWN){keyPressed = "Down";}
        if(e.getKeyCode() == KeyEvent.VK_LEFT){keyPressed = "Left";}
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){keyPressed = "Right";}
    }

    public void keyReleased(KeyEvent e)
    {
        System.out.println("Key released: " + e.getKeyChar());
    }
    
	public static void setKeyDone()
	{
		keyPressed = "none";
	}
}