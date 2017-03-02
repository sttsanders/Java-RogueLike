package Ai;

import Creatures.Creature;
import Resources.Tile;

public class CreatureAi {
	protected Creature creature;
	
	public CreatureAi(Creature creature){
		this.creature = creature;
		this.creature.setCreatureAi(this);
	}
	
	public void onEnter(int x, int y, int z, Tile tile)
	{
		if (tile.isGround()){
	         creature.x = x;
	         creature.y = y;
	         creature.z = z;
	    }
	}
	
	public void onUpdate(){
		
	}

	public void wanderAround(){
	    int mx = (int)(Math.random() * 3) - 1;
	    int my = (int)(Math.random() * 3) - 1;
	    creature.moveBy(mx, my, 0);
	}
	
	public void onNotify(String format) {
		// TODO Auto-generated method stub
		
	}
	
	
}
