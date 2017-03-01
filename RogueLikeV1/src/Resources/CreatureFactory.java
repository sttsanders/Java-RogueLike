package Resources;

import java.util.List;

import Ai.CopyCatAi;
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
	
	public Creature newQuillBoar()
	{
		Creature quillBoar = new Creature(world, 'Q',"Quillboar", AsciiPanel.brightMagenta, 80, 12, 4);
		world.addAtEmptyLocation(quillBoar);
		new QuillBoarAi(quillBoar);
		return quillBoar;
	}

	public void createCreatures(CreatureFactory cF) {
		// TODO Auto-generated method stub
	    for (int i = 0; i < 8; i++){
	        cF.newGhoul();
	    }
	    
	    for (int i = 0; i < 12; i++){
	        cF.newQuillBoar();
	    }
	    
//	    for (int i = 0; i < 2; i++){
//	        cF.newCopyCat();
//	    }
	    
	    for (int i = 0; i < 10; i++){
	        cF.newKobold();
	    }
	}
	
	
	
}

