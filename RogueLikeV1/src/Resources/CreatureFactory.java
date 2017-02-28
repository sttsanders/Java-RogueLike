package Resources;

import Ai.GhoulAi;
import Ai.PlayerAi;
import Creatures.Creature;
import asciiPanel.AsciiPanel;

public class CreatureFactory {
	private World world;
	
	public CreatureFactory(World world){
		this.world = world;
	}
	
	public Creature newPlayer(){
		Creature player = new Creature(world, '@', AsciiPanel.brightWhite);
		world.addAtEmptyLocation(player);
		new PlayerAi(player);
		return player;
	}
	
	public Creature newGhoul()
	{
		Creature ghoul = new Creature(world, 'G', AsciiPanel.brightGreen);
		world.addAtEmptyLocation(ghoul);
		new GhoulAi(ghoul);
		return ghoul;
	}
	
}

