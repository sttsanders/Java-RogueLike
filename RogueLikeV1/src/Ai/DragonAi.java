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
	
	public void onUpdate()
	{

	          wanderAround();
    }
	
	public void hunt(Creature target)
	{

	  }
}
