package Resources;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Creatures.Creature;

public class World {
	private Tile[][] tiles;
	private int width;
	private int height;
	public List<Creature> creatures;
	
	
	public int getWidth()
	{ 
		return this.width; 
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public Creature creature(int x, int y){
	    for (Creature c : creatures){
	        if (c.x == x && c.y == y)
	            return c;
	    }
	    return null;
	}

	public void remove(Creature other) {
	    creatures.remove(other);
	}
	
	public World(Tile[][] t)
	{
		this.tiles = t;
		this.width = tiles.length;
		this.height = tiles[0].length;
		
		creatures = new ArrayList<Creature>();
		
	}
	
	public void update(){
		List<Creature> toUpdate = new ArrayList<Creature>(creatures);
		for (Creature creature : toUpdate){
			creature.update();
		}
	}

	
	public Tile returnTile(int x, int y)
	{
		if (x < 0 || x >= width || y < 0 || y >= height)
			return Tile.BOUNDS;
		else
			return tiles[x][y];

	}
	
	public char returnGlyph(int x, int y)
	{
		return returnTile(x,y).getGlyph();
	}
	
	public Color returnColor(int x, int y)
	{
		return returnTile(x,y).getColor();
	}
	
	public void dig(int x, int y) {
	    if (returnTile(x,y).isDiggable())
	    {
	    	tiles[x][y] = Tile.FLOOR;
		}
	}
	
	/**
	 * adds creature to random location on the grid.
	 * @param creature
	 */
	public void addAtEmptyLocation(Creature creature){
		int x;
		int y;
		
		
		//create random coordinate between 0 and screen width and 0 and screen height
		do {
			x = (int)(Math.random() * width);
			y = (int)(Math.random() * height);
		} 
		while (!returnTile(x,y).isGround());
		
		creature.x = x;
		creature.y = y;
		creatures.add(creature);
	}

	
	
}
