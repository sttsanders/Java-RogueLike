package Ai;

import java.util.List;

import Creatures.Creature;
import Resources.Coordinate;
import Resources.Path;

public class KoboldAi extends CreatureAi {

	private Creature target;
	public KoboldAi(Creature creature, Creature target) {
		super(creature);
		this.target = target;
		// TODO Auto-generated constructor stub
	}
	
	public void onUpdate()
	{
	          wanderAround();
    }
	
	public void hunt(Creature target)
	{

	}

}
