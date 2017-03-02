package Ai;

import Creatures.Creature;
import Resources.CreatureFactory;

public class BeeNestAi extends CreatureAi{
	public CreatureFactory f;
	private int cloneCounter;
	
	public BeeNestAi(Creature c,CreatureFactory factory) {
		super(c);
		this.f = factory;
	}
	
	public void onUpdate(){
        if (cloneCounter < 30 && Math.random() < 0.5)
            multiply();
    }
 
    private void multiply(){
        int x = creature.x + (int)(Math.random() * 11) - 5;
        int y = creature.y + (int)(Math.random() * 11) - 5;
  
        if (creature.canEnter(x, y, creature.z))
        {
            Creature child = f.newBee(creature.z);
            
            child.x = x;
            child.y = y;
            child.z = creature.z;
            cloneCounter++;
        }
        else
        {
        	return;
        }
    }
}
