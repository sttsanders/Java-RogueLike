package Ai;

import Creatures.Creature;

public class QuillBoarAi extends CreatureAi {

	public QuillBoarAi(Creature creature) {
		super(creature);
		// TODO Auto-generated constructor stub
	}
	
	public void onUpdate(){
        wanderAround();
    }

}
