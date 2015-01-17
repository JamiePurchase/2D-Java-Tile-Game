package dev.tilegame.world;
import dev.tilegame.Game;
import dev.tilegame.Session;

public class Board01
{
	
	public Board01()
	{
		// Dimensions
		Session.world.setGridWidth(25);
		Session.world.setGridHeight(17);
		
		// Tiles
		Session.world.tileInit("Grass", 0);
		Session.world.setTile(1, 1, "Tree", 1);
		Session.world.setTile(2, 1, "Tree", 1);
		Session.world.setTile(3, 1, "Tree", 1);
		Session.world.setTile(4, 1, "Tree", 1);
		Session.world.setTile(5, 1, "Tree", 1);
		Session.world.setTile(6, 1, "Tree", 1);
		Session.world.setTile(7, 1, "TreesDR", 1);
		Session.world.setTile(8, 1, "TreesDL", 1);
		Session.world.setTile(9, 1, "Tree", 1);
		Session.world.setTile(10, 1, "Tree", 1);
		Session.world.setTile(11, 1, "Tree", 1);
		Session.world.setTile(12, 1, "Tree", 1);
		Session.world.setTile(13, 1, "Tree", 1);
		Session.world.setTile(14, 1, "Tree", 1);
		Session.world.setTile(15, 1, "Tree", 1);
		Session.world.setTile(16, 1, "Tree", 1);
		Session.world.setTile(17, 1, "Tree", 1);
		Session.world.setTile(18, 1, "Tree", 1);
		Session.world.setTile(19, 1, "Tree", 1);
		Session.world.setTile(20, 1, "Tree", 1);
		Session.world.setTile(21, 1, "Tree", 1);
		Session.world.setTile(22, 1, "Tree", 1);
		Session.world.setTile(23, 1, "Tree", 1);
		Session.world.setTile(24, 1, "Tree", 1);
		//Session.world.setTile(25, 1, "Tree", 1);
		//
		Session.world.setTile(1, 2, "Tree", 1);
		//Session.world.setTile(25, 2, "Tree", 1);
		//
		Session.world.setTile(1, 3, "Tree", 1);
		//Session.world.setTile(25, 3, "Tree", 1);
		//
		Session.world.setTile(1, 4, "Tree", 1);
		Session.world.setTile(21, 4, "Shrub", 1);
		Session.world.setTile(25, 4, "Tree", 1);
		//
		Session.world.setTile(1, 5, "Tree", 1);
		Session.world.setTile(25, 5, "Tree", 1);
		//
		Session.world.setTile(1, 6, "Tree", 1);
		Session.world.setTile(24, 6, "TreesCL", 1);
		Session.world.setTile(25, 6, "TreesCR", 1);
		//
		//Session.world.setTile(1, 7, "Tree", 1);
		Session.world.setTile(25, 7, "Tree", 1);
		//
		//Session.world.setTile(1, 8, "Tree", 1);
		Session.world.setTile(15, 8, "Tree7aT", 1);
		Session.world.setTile(25, 8, "Tree", 1);
		//
		Session.world.setTile(1, 9, "Fence1M", 1);
		Session.world.setTile(2, 9, "Fence1M", 1);
		Session.world.setTile(3, 9, "Fence1M", 1);
		Session.world.setTile(4, 9, "Fence1MS", 1);
		Session.world.setTile(5, 9, "Fence1M", 1);
		Session.world.setTile(6, 9, "Fence1M", 1);
		Session.world.setTile(7, 9, "Fence1R", 1);
		Session.world.setTile(11, 9, "Fence1L", 1);
		Session.world.setTile(12, 9, "Fence1M", 1);
		Session.world.setTile(13, 9, "Fence1M", 1);
		Session.world.setTile(14, 9, "Fence1R", 1);
		Session.world.setTile(15, 9, "Tree7aB", 1);
		Session.world.setTile(25, 9, "Tree", 1);
		//
		Session.world.setTile(1, 10, "Tree", 1);
		Session.world.setTile(25, 10, "Tree", 1);
		//
		Session.world.setTile(1, 11, "Tree", 1);
		Session.world.setTile(16, 11, "Tree6TL", 1);
		Session.world.setTile(17, 11, "Tree6TR", 1);
		Session.world.setTile(25, 11, "Tree", 1);
		//
		Session.world.setTile(1, 12, "Tree", 1);
		Session.world.setTile(16, 12, "Tree6BL", 1);
		Session.world.setTile(17, 12, "Tree6BR", 1);
		Session.world.setTile(25, 12, "Tree", 1);
		//
		Session.world.setTile(1, 13, "Tree", 1);
		Session.world.setTile(25, 13, "Tree", 1);
		//
		Session.world.setTile(1, 14, "Tree", 1);
		Session.world.setTile(25, 14, "Tree", 1);
		//
		Session.world.setTile(1, 15, "Tree", 1);
		Session.world.setTile(25, 15, "Tree", 1);
		//
		Session.world.setTile(1, 16, "Tree", 1);
		Session.world.setTile(25, 16, "Tree", 1);
		//
		Session.world.setTile(1, 17, "Tree", 1);
		Session.world.setTile(2, 17, "Tree", 1);
		Session.world.setTile(3, 17, "Tree", 1);
		Session.world.setTile(4, 17, "Tree", 1);
		Session.world.setTile(5, 17, "Tree", 1);
		Session.world.setTile(6, 17, "Tree", 1);
		Session.world.setTile(7, 17, "Tree", 1);
		Session.world.setTile(8, 17, "Tree", 1);
		Session.world.setTile(9, 17, "Tree", 1);
		Session.world.setTile(10, 17, "Tree", 1);
		Session.world.setTile(11, 17, "Tree", 1);
		Session.world.setTile(12, 17, "Tree", 1);
		Session.world.setTile(13, 17, "Tree", 1);
		Session.world.setTile(14, 17, "Tree", 1);
		Session.world.setTile(15, 17, "Tree", 1);
		Session.world.setTile(16, 17, "Tree", 1);
		Session.world.setTile(17, 17, "Tree", 1);
		Session.world.setTile(18, 17, "Tree", 1);
		Session.world.setTile(19, 17, "Tree", 1);
		Session.world.setTile(20, 17, "Tree", 1);
		Session.world.setTile(21, 17, "Tree", 1);
		Session.world.setTile(22, 17, "Tree", 1);
		Session.world.setTile(23, 17, "Tree", 1);
		Session.world.setTile(24, 17, "Tree", 1);
		Session.world.setTile(25, 17, "Tree", 1);
		
		// Treasure Chests
		Session.world.setTreasure(9,4);
		Session.world.setTreasure(21,13);
	}
}