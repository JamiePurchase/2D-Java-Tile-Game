package dev.tilegame.states;
import java.awt.Graphics;

public abstract class State
{	
	public abstract void tick();
	public abstract void render(Graphics g);
	private static State currentState = null;
	
	public static State getState()
	{
		return currentState;
	}
	
	public static void setState(State state)
	{
		currentState = state;
	}
}