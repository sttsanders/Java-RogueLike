package Resources;

import java.util.List;

import Ai.BeeAi;
import Ai.BeeNestAi;
import Ai.CopyCatAi;
import Ai.CopyCatCloneAi;
import Ai.GhoulAi;
import Ai.KoboldAi;
import Ai.PlayerAi;
import Ai.QuillBoarAi;
import Creatures.Creature;
import asciiPanel.AsciiPanel;

public class CreatureFactory {
	private World world;
	
	public CreatureFactory(World world){
		this.world = world;
	}
	
	/**
	 * 
	 * @param messages
	 * @return
	 */
	public Creature newPlayer(List<String> messages){
		Creature player = new Creature(world, '@',"You", AsciiPanel.brightWhite, 150, 10, 10);
		world.addAtEmptyLocation(player);
		new PlayerAi(player, messages);
		return player;
	}
	
	/**
	 * Creates new Ghoul object and inserts it into the world
	 * @return
	 */
	public Creature newGhoul()
	{
		Creature ghoul = new Creature(world, 'G',"Ghoul", AsciiPanel.brightGreen, 70, 15, 5);
		world.addAtEmptyLocation(ghoul);
		new GhoulAi(ghoul);
		return ghoul;
	}
	
	/**
	 * Creates new CopyCat object and inserts it into the world
	 * @return
	 */
	public Creature newCopyCat()
	{
		Creature copyCat = new Creature(world, 'C',"Copy Cat", AsciiPanel.brightRed, 20, 5, 1);
		world.addAtEmptyLocation(copyCat);
		new CopyCatAi(copyCat, this);
		return copyCat;
	}
	
	/**
	 * Creates new CopyCatClone object and inserts it into the world
	 * @return
	 */
	public Creature newCopyCatCopy()
	{
		Creature copyCatClone = new Creature(world, 'c',"Copy Cat Clone", AsciiPanel.brightRed, 20, 5, 1);
		world.addAtEmptyLocation(copyCatClone);
		new CopyCatCloneAi(copyCatClone);
		return copyCatClone;
	}
	
	/**
	 * Creates new Kobold object and inserts it into the world
	 * @return
	 */
	public Creature newKobold()
	{
		Creature kobold = new Creature(world, 'K',"Kobold", AsciiPanel.brightYellow, 15, 6, 0);
		world.addAtEmptyLocation(kobold);
		new KoboldAi(kobold);
		return kobold;
	}
	
	/**
	 * Creates new Quillboar object and inserts it into the world
	 * @return
	 */
	public Creature newQuillBoar()
	{
		Creature quillBoar = new Creature(world, 'Q',"Quillboar", AsciiPanel.brightMagenta, 80, 12, 4);
		world.addAtEmptyLocation(quillBoar);
		new QuillBoarAi(quillBoar);
		return quillBoar;
	}
	
	/**
	 * Creates new Beenest object and inserts it into the world
	 * @return
	 */
	public Creature newBeeNest()
	{
		Creature beeNest = new Creature(world, 'B',"Bee Nest", AsciiPanel.brightCyan, 120, 0, 8);
		world.addAtEmptyLocation(beeNest);
		new BeeNestAi(beeNest,this);
		return beeNest;
	}

	/**
	 * Creates creatures for world seeding
	 * @param cF
	 */
	public void createCreatures(CreatureFactory cF) {
		// TODO Auto-generated method stub
	    for (int i = 0; i < 20; i++){
	        cF.newGhoul();
	    }
	    
	    for (int i = 0; i < 12; i++){
	        cF.newQuillBoar();
	    }
	    
	    for (int i = 0; i < 2; i++){
	        cF.newCopyCat();
	    }
	    
	    for (int i = 0; i < 10; i++){
	        cF.newKobold();
	    }
	    
	    for (int i = 0; i < 2; i++){
	        cF.newBeeNest();
	    }
	}

	/**
	 * Creates new Bee object and inserts it into the world
	 * @return
	 */
	public Creature newBee() {
		// TODO Auto-generated method stub
		Creature bee = new Creature(world, 'b',"Bee", AsciiPanel.cyan, 5, 1, 0);
		world.addAtEmptyLocation(bee);
		new BeeAi(bee);
		return bee;
	}
	
	
	
}

