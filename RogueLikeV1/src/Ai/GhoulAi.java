package Ai;

import java.util.List;

import Creatures.Creature;
import Resources.Coordinate;
import Resources.Path;

public class GhoulAi extends CreatureAi {
	
	private Creature target;
	public GhoulAi(Creature creature, Creature target)
	{
		super(creature);
		this.target = target;
	}
	
	
	public void onUpdate()
	{
		wanderAround();
    }
	
	public void hunt(Creature target)
	{

	}
	
}
