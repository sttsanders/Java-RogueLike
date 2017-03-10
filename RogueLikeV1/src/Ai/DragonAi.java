package Ai;

import java.util.List;

import Creatures.Creature;
import Resources.Coordinate;
import Resources.Path;

public class DragonAi extends CreatureAi 
{
	
	private Creature target;
	public DragonAi(Creature creature, Creature target)
	{
		super(creature);
		this.target = target;
		System.out.println(target);
	}
	
	public void onUpdate(){
		if (target != null && creature.canSee(target.x, target.y, target.z))
	          hunt(target);
	      else
	          wanderAround();
    }
	
	public void hunt(Creature target){
	      List<Coordinate> points = new Path(creature, target.x, target.y).points();
	  
	      int mx = points.get(0).x - creature.x;
	      int my = points.get(0).y - creature.y;
	  
	      creature.moveBy(mx, my, 0);
	  }
}
