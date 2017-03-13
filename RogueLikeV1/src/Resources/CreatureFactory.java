package Resources;

import java.io.Serializable;
import java.util.List;

import Ai.BeeAi;
import Ai.BeeNestAi;
import Ai.CopyCatAi;
import Ai.CopyCatCloneAi;
import Ai.DragonAi;
import Ai.GhoulAi;
import Ai.KoboldAi;
import Ai.PlayerAi;
import Ai.QuillBoarAi;
import Creatures.Creature;
import asciiPanel.AsciiPanel;

public class CreatureFactory implements Serializable {
	private World world;
	private Creature player;
	private List<String> messages;
	
	public CreatureFactory(World world, List<String> m){
		this.world = world;
		this.messages = m;
	}
	
	/**
	 * 
	 * @param messages
	 * @return
	 */
	public Creature newPlayer(List<String> messages){
		Creature player = new Creature(world, (char)1,"You", AsciiPanel.brightWhite, 400, 0, 0);

		
		world.addAtEmptyLocation(player, 0);
		new PlayerAi(player, messages);

		this.player = player;
		return player;
	}
	
	/**
	 * Creates new Ghoul object and inserts it into the world
	 * @return
	 */
	public Creature newGhoul(int depth)
	{
		Creature ghoul = new Creature(world, 'G',"Ghoul", AsciiPanel.brightGreen, 70, 15, 5);
		world.addAtEmptyLocation(ghoul, depth);
		new GhoulAi(ghoul, player);
		return ghoul;
	}
	
	/**
	 * Creates new CopyCat object and inserts it into the world
	 * @return
	 */
	public Creature newCopyCat(int depth)
	{
		Creature copyCat = new Creature(world, 'C',"Copy Cat", AsciiPanel.brightRed, 20, 5, 1);
		world.addAtEmptyLocation(copyCat, depth);
		new CopyCatAi(copyCat, this);
		return copyCat;
	}
	
	public Creature newDragon(int depth, Creature p)
	{
		Creature dragon = new Creature(world, 'D',"Dragon of Ultimate Awesomeness", AsciiPanel.brightRed, 300, 40, 10);
		world.addAtEmptyLocation(dragon, depth);
		new DragonAi(dragon, p);
		return dragon;
	}
	
	/**
	 * Creates new CopyCatClone object and inserts it into the world
	 * @return
	 */
	public Creature newCopyCatCopy(int depth)
	{
		Creature copyCatClone = new Creature(world, 'c',"Copy Cat Clone", AsciiPanel.brightRed, 20, 5, 1);
		world.addAtEmptyLocation(copyCatClone, depth);
		new CopyCatCloneAi(copyCatClone);
		return copyCatClone;
	}
	
	/**
	 * Creates new Kobold object and inserts it into the world
	 * @return
	 */
	public Creature newKobold(int depth, Creature p)
	{
		Creature kobold = new Creature(world, 'K',"Kobold", AsciiPanel.brightYellow, 15, 6, 0);
		world.addAtEmptyLocation(kobold, depth);
		new KoboldAi(kobold, p);
		return kobold;
	}
	
	/**
	 * Creates new Quillboar object and inserts it into the world
	 * @return
	 */
	public Creature newQuillBoar(int depth)
	{
		Creature quillBoar = new Creature(world, 'Q',"Quillboar", AsciiPanel.brightMagenta, 80, 12, 4);
		world.addAtEmptyLocation(quillBoar, depth);
		new QuillBoarAi(quillBoar);
		return quillBoar;
	}
	
	/**
	 * Creates new Beenest object and inserts it into the world
	 * @return
	 */
	public Creature newBeeNest(int depth)
	{
		Creature beeNest = new Creature(world, 'B',"Bee Nest", AsciiPanel.brightCyan, 120, 0, 8);
		world.addAtEmptyLocation(beeNest, depth);
		new BeeNestAi(beeNest,this);
		return beeNest;
	}

	/**
	 * Creates creatures for world seeding
	 * @param cF
	 */
	public void createCreatures() {
		// TODO Auto-generated method stub
		newPlayer(messages);
		for (int z = 0; z < world.getDepth(); z++)
		{
//			for (int i = 0; i < 1; i++){
//		        newGhoul(z);
//		    }
//		
		    for (int i = 0; i < 15; i++){
		        newQuillBoar(z);
		    }
		    
//		    for (int i = 0; i < 0; i++){
//		        newCopyCat(z);
//		    }
		    
		    for (int i = 0; i < 15; i++){
		        newKobold(z, player);
		    }
//		    
		    for (int i = 0; i < 4; i++){
		        newBeeNest(z);
		    }
		    
		    
		}
		
		newDragon(5, player);
	}

	/**
	 * Creates new Bee object and inserts it into the world
	 * @return
	 */
	public Creature newBee(int depth) {
		// TODO Auto-generated method stub
		Creature bee = new Creature(world, 'b',"Bee", AsciiPanel.cyan, 5, 20, 0);
		world.addAtEmptyLocation(bee, depth);
		new BeeAi(bee);
		return bee;
	}
	
	
	
}

