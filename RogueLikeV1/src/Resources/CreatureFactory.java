package Resources;

import java.util.List;

import Ai.CopyCatAi;
import Ai.GhoulAi;
import Ai.KoboldAi;
import Ai.PlayerAi;
import Creatures.Creature;
import asciiPanel.AsciiPanel;

public class CreatureFactory {
	private World world;
	
	public CreatureFactory(World world){
		this.world = world;
	}
	
	public Creature newPlayer(List<String> messages){
		Creature player = new Creature(world, '@',"You", AsciiPanel.brightWhite, 150, 10, 10);
		world.addAtEmptyLocation(player);
		new PlayerAi(player, messages);
		return player;
	}
	
	public Creature newGhoul()
	{
		Creature ghoul = new Creature(world, 'G',"Ghoul", AsciiPanel.brightGreen, 70, 15, 5);
		world.addAtEmptyLocation(ghoul);
		new GhoulAi(ghoul);
		return ghoul;
	}
	
	public Creature newCopyCat()
	{
		Creature copyCat = new Creature(world, 'C',"Copy Cat", AsciiPanel.brightRed, 20, 5, 1);
		System.out.println("adding copyCat");
		world.addAtEmptyLocation(copyCat);
		new CopyCatAi(copyCat, this);
		return copyCat;
	}
	
	public Creature newKobold()
	{
		Creature kobold = new Creature(world, 'K',"Kobold", AsciiPanel.brightYellow, 15, 6, 0);
		world.addAtEmptyLocation(kobold);
		new KoboldAi(kobold);
		return kobold;
	}
	
	
}

