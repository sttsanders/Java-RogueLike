package Ai;

import Creatures.Creature;



public class BeeAi extends CreatureAi{

	public BeeAi(Creature creature) {
		super(creature);
		// TODO Auto-generated constructor stub
	}
	
	public void onUpdate(){
        wanderAround();
        wanderAround();
    }

}
