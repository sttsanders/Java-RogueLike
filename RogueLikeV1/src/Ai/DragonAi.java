package Ai;

import Creatures.Creature;

public class DragonAi extends CreatureAi {
	
	public DragonAi(Creature creature)
	{
		super(creature);
	}
	
	public void onUpdate(){
        wanderAround();
    }
}
