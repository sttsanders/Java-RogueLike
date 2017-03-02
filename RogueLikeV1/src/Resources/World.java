package Resources;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Creatures.Creature;

public class World {
	private Tile[][][] tiles;
	private int width;
	private int height;
	private int depth;
	public List<Creature> creatures;
	
	public int getDepth()
	{
		return this.depth;
	}
	
	public int getWidth()
	{ 
		return this.width; 
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public Creature returnCreature(int x, int y, int z){
		for (Creature c : creatures){
			if (c.x == x && c.y == y && c.z == z){
				return c;
			}
		}
		return null;
	}

	public void remove(Creature other) {
	    creatures.remove(other);
	}
	
	public World(Tile[][][] t)
	{
		this.tiles = t;
		this.width = tiles.length;
		this.height = tiles[0].length;
		this.depth = tiles[0][0].length;
		
		creatures = new ArrayList<Creature>();
		
	}
	
	public void update(){
		List<Creature> toUpdate = new ArrayList<Creature>(creatures);
		for (Creature creature : toUpdate){
			creature.update();
		}
	}

	
	public Tile returnTile(int x, int y, int z)
	{
		if (x < 0 || x >= width || y < 0 || y >= height || z < 0 || z >= depth)
			return Tile.BOUNDS;
		else
			return tiles[x][y][z];
	}

	
	public char returnGlyph(int x, int y, int z)
	{
		return returnTile(x,y,z).getGlyph();
	}
	
	public Color returnColor(int x, int y, int z)
	{
		return returnTile(x,y,z).getColor();
	}
	
	public void dig(int x, int y,int z) {
	    if (returnTile(x,y,z).isDiggable())
	    {
	    	tiles[x][y][z] = Tile.FLOOR;
		}
	}
	
	/**
	 * adds creature to random location on the grid.
	 * @param creature
	 */
	public void addAtEmptyLocation(Creature creature, int z){
		int x;
		int y;
		
		//create random coordinate between 0 and screen width and 0 and screen height
		do {
			x = (int)(Math.random() * width);
			y = (int)(Math.random() * height);
		} 
		while (!returnTile(x,y,z).isGround());
		
		creature.x = x;
		creature.y = y;
		creature.z = z;
		creatures.add(creature);
	}

	
	
}
