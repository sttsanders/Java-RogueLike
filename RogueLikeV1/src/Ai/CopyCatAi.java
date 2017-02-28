package Ai;

import Creatures.Creature;
import Resources.CreatureFactory;

public class CopyCatAi extends CreatureAi {
	public CreatureFactory f;
	private int cloneCounter;
	
	public CopyCatAi(Creature c,CreatureFactory factory) {
		super(c);
		this.f = factory;
	}
	
	public void onUpdate(){
        if (cloneCounter < 5 && Math.random() < 0.01)
            spread();
    }
 
    private void spread(){
        int x = creature.x + (int)(Math.random() * 11) - 5;
        int y = creature.y + (int)(Math.random() * 11) - 5;
  
        if (creature.canEnter(x, y))
        {
            Creature child = f.newCopyCat();
            
            child.x = x;
            child.y = y;
            cloneCounter++;
        }
        else
        {
        	return;
        }
    }
}
