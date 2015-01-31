package dev.tilegame.scenery;

import dev.tilegame.Game;
import dev.tilegame.gfx.Assets;

public class scnJvGateWooden
{
	public scnJvGateWooden()
	{
		
	}
	
	public void interact()
	{
		Game.world.setTile(57, 9, Assets.tlsFenceWooden[33], 1);
		Game.world.setTile(58, 9, Assets.tlsFenceWooden[34], 1);
		Game.world.setTile(59, 9, Assets.tlsFenceWooden[35], 1);
		Game.world.setTile(57, 9, Assets.tlsFenceWooden[45], 1);
		Game.world.setTile(58, 10, Assets.tlsFenceWooden[46], 1);
		Game.world.setTile(59, 10, Assets.tlsFenceWooden[47], 1);
	}
}