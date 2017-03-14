package Ai;

import java.io.Serializable;

import Creatures.Creature;
import Resources.Coordinate;
import Resources.Line;
import Resources.Tile;

public class CreatureAi implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Creature creature;
	
	public CreatureAi(Creature creature)
	{
		this.creature = creature;
		this.creature.setCreatureAi(this);
	}
	
	public void onEnter(int x, int y, int z, Tile tile)
	{
		if (tile.isGround())
		{
	         creature.x = x;
	         creature.y = y;
	         creature.z = z;
	    }
	}
	
	public void onUpdate()
	{
		
	}
	
	public boolean canSee(int wx, int wy, int wz) 
	{
		if (creature.z != wz)
		{
			return false;
		}
		if ((creature.x-wx)*(creature.x-wx) + (creature.y-wy)*(creature.y-wy) > creature.visionRadius()*creature.visionRadius())
		{
			return false;
		}
		for (Coordinate p : new Line(creature.x, creature.y, wx, wy)){
			if (creature.tile(p.x, p.y, wz).isGround() || p.x == wx && p.y == wy)
				continue;
			
			return false;
		}
		
		return true;
	}


	public void wanderAround()
	{
	    int mx = (int)(Math.random() * 3) - 1;
	    int my = (int)(Math.random() * 3) - 1;
	    
	    Creature other = creature.returnCreature(creature.x + mx, creature.y + my, creature.z);
	    
	    //if colliding monster = same type
	    if (other != null && other.getName().equals(creature.getName()))
	    {
	        return;
	    }
	    else
	    {
	        creature.moveBy(mx, my, 0);
	    }
	}
	
	public void onNotify(String format) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
}
