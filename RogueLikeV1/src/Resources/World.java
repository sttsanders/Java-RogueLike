package Resources;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.GuardedObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import Creatures.Creature;

public class World implements Serializable{
	public Tile[][][] tiles;
	public Item[][][] items;
	private int width;
	private int height;
	private int depth;
	private int currentDepth;
	public List<Creature> creatures;
	
	public void saveWorld()
	{
		 try {
		        FileOutputStream fos = new FileOutputStream("lvlSave.xml");
		        ObjectOutputStream oos = new ObjectOutputStream(fos);
		        oos.writeObject(this.tiles);
				System.out.println("Saved world");

		        oos.writeObject(this.items);
				System.out.println("Saved items");
				
		        oos.writeObject(this.creatures);
				System.out.println("Saved creatures");

				fos.close();
			
		    } catch (Exception e) {
		    	System.out.println("Fail: " + e);
		    }
	}
	
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
	
	public int getCurrentDepth()
	{
		return currentDepth;
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
		this.items = new Item[width][height][depth];
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
		{
			return Tile.BOUNDS;
		}
		else
		{
			currentDepth = z;
			return tiles[x][y][z];
		}
	}

	public char returnGlyph(int x, int y, int z){
	    Creature creature = returnCreature(x, y, z);
	    if (creature != null)
	        return creature.getGlyph();
	    
	    if (returnItem(x,y,z) != null)
	        return returnItem(x,y,z).getGlyph();
	    
	    return returnTile(x, y, z).getGlyph();
	}
	
	public Color returnColor(int x, int y, int z){
	    Creature creature = returnCreature(x, y, z);
	    if (creature != null)
	        return creature.getColor();
	    
	    if (returnItem(x,y,z) != null)
	        return returnItem(x,y,z).getColor();
	    
	    return returnTile(x, y, z).getColor();
	}
	
	public void dig(int x, int y,int z) {
	    if (returnTile(x,y,z).isDiggable())
	    {
	    	//tiles[x][y][z] = Tile.FLOOR;
		}
	}
	
	public void remove(int x, int y, int z) {
	    items[x][y][z] = null;
	}
	
	public void addAtEmptySpace(Item item, int x, int y, int z){
	    if (item == null)
	        return;
	    
	    List<Coordinate> points = new ArrayList<Coordinate>();
	    List<Coordinate> checked = new ArrayList<Coordinate>();
	    
	    points.add(new Coordinate(x, y, z));
	    
	    while (!points.isEmpty()){
	    	Coordinate p = points.remove(0);
	        checked.add(p);
	        
	        if (!returnTile(p.x, p.y, p.z).isGround())
	            continue;
	         
	        if (items[p.x][p.y][p.z] == null){
	            items[p.x][p.y][p.z] = item;
	            Creature c = this.returnCreature(p.x, p.y, p.z);
	            if (c != null)
	                c.notify("A %s lands between your feet.", item.getName());
	            return;
	        } else {
	            List<Coordinate> neighbors = p.whichEightNeighbors();
	            neighbors.removeAll(checked);
	            points.addAll(neighbors);
	        }
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

	public void addAtEmptyLocation(Item item, int depth) {
	    int x;
	    int y;
	    
	    do {
	        x = (int)(Math.random() * width);
	        y = (int)(Math.random() * height);
	    }
	    while (!returnTile(x,y,depth).isGround() || returnItem(x,y,depth) != null);
	    
	    	items[x][y][depth] = item;
	}
	
	public Item returnItem(int x, int y, int z){
	    return items[x][y][z];
	}

	public void save() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
