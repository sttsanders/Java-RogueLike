package Resources;

public class WorldBuilder {
	
	private int width;
	private int height;
	private Tile[][] tiles;
	
	public WorldBuilder(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.tiles = new Tile[width][height];
	}
	
	public World buildWorld()
	{
		return new World(tiles);
	}
	
	private WorldBuilder randomizeWorldTiles()
	{
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				tiles[x][y] = Math.random() < 0.5 ? Tile.FLOOR : Tile.WALL;
				
			}
		}
		return this;
	}
	
	public WorldBuilder makeCaves() {
	    return randomizeWorldTiles().smoothGeneratedMap(9);
	}
	
	// TO CHANGE (mogelijk kamers)?
	public WorldBuilder smoothGeneratedMap(int times)
	{
		Tile[][] tempTiles = new Tile[width][height];
	
		// loop times
		for(int time = 0; time < times; time ++)
		{
	
		// loop tiles
			for(int x = 0; x < width; x++)
			{
				for(int y = 0; y < height; y++)
				{
					int floors = 0;
					int rocks = 0;
	
					//[x-1,y+1][x,y+1][x+1,y+1]
					//[ x-1,y ][ x,y ][ x+1,y ]
					//[x-1,y-1][x,y-1][x+1,y-1]
					for (int xNeighbour = -1; xNeighbour <= 1; xNeighbour++)
					{
						for (int yNeighbour = -1; yNeighbour <= 1; yNeighbour++)
						{
							// if the neighbour position is out of bound just continue 
							if (x + xNeighbour < 0 || x + xNeighbour >= width ||
									y + yNeighbour < 0 || y + yNeighbour >= height)
							{
								continue; 
							}
		
							// count if the neighbour tiles are floors or rocks
							if(tiles[x + xNeighbour][y + yNeighbour] == Tile.FLOOR)
							{
								floors++;
							}
							else
							{
								rocks++;
							}
						} 
					} 
					// if the neighbour tiles are mostly floors make current tile floor
					tempTiles[x][y] = floors >= rocks ? Tile.FLOOR : Tile.WALL;
				}
			}
			tiles = tempTiles;
		}
		return this;
	}
	
	
}
