package Resources;

import AI.PlayerAI;
import Entities.Creature;
import asciiPanel.AsciiPanel;

public class CreatureFactory {
	private World world;
	
	public CreatureFactory(World world){
		this.world = world;
	}
	
	public Creature newPlayer(){
		Creature player = new Creature(world, '@', AsciiPanel.brightWhite);
		world.addAtEmptyLocation(player);
		new PlayerAI(player);
		return player;
	}
}

