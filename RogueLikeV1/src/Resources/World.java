package Resources;

import java.awt.Color;

public class World {
	private Tile[][] tiles;
	private int width;
	private int height;
	
	
	
	public int getWidth()
	{ 
		return this.width; 
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public World(Tile[][] t)
	{
		this.tiles = t;
		this.width = tiles.length;
		this.height = tiles[0].length;
	}
	
	public Tile returnTile(int x, int y)
	{
		if(x < 0 || x >= width || y < 0 || y >= height)
		{
			return Tile.BOUNDS;
		}
		else
		{
			return tiles[x][y];
		}
	}
	
	public char returnGlyph(int x, int y)
	{
		return returnTile(x,y).getGlyph();
	}
	
	public Color returnColor(int x, int y)
	{
		return returnTile(x,y).getColor();
	}
	
	
	
}
