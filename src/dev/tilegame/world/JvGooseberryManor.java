package dev.tilegame.world;

import dev.tilegame.Game;
import dev.tilegame.Session;
import dev.tilegame.gfx.Assets;

public class JvGooseberryManor
{
	
	public JvGooseberryManor()
	{
		// Data
		Session.world.setName("JvGooseberryManor");
		Session.world.setLocation("Gooseberry Manor, Jharva Village");
		
		// Dimensions
		Session.world.setGridWidth(25);
		Session.world.setGridHeight(17);
		
		// Background
		Session.world.setBackground(Assets.bkgJvGooseberryManor);
		
		// Tiles
		Session.world.tileInit("", 0);
	}
}