package Resources;

import asciiPanel.AsciiPanel;

public class ItemFactory {
	private World world;
	
	public ItemFactory(World world){
		this.world = world;
	}
	
	public void createItems() {
		// TODO Auto-generated method stub
		for (int z = 0; z < world.getDepth(); z++){
	        for (int i = 0; i < 2; i++){
	            newSpear(z);
	        }
	        
	        for (int i = 0; i < 2; i++){
	            newSword(z);
	        }
	        
	        for (int i = 0; i < 2; i++){
	        	newLeatherArmor(z);
	        }
	        
	        for (int i = 0; i < 2; i++){
	        	newIronArmor(z);
	        }
	        
	        for (int i = 0; i < 2; i++){
	        	newIronHelmet(z);
	        }
	        
	        for (int i = 0; i < 2; i++){
	        	newSteelPlate(z);
	        }
	    }
	}
	
	public Item newSpear(int depth){
        Item spear = new Item('i', AsciiPanel.green, "spear",ItemType.WEAPON, 2, 0);
        world.addAtEmptyLocation(spear, depth);
        return spear;
    }
	
	public Item newSword(int depth){
        Item sword = new Item('i', AsciiPanel.green, "sword",ItemType.WEAPON, 4, 0);
        world.addAtEmptyLocation(sword, depth);
        return sword;
    }
	
	public Item newDagger(int depth){
        Item dagger = new Item('i', AsciiPanel.green, "dagger", ItemType.WEAPON, 3, 0);
        world.addAtEmptyLocation(dagger, depth);
        return dagger;
    }
	
	public Item newLeatherArmor(int depth){
        Item leatherArmor = new Item('i', AsciiPanel.green, "leather armor", ItemType.ARMOR, 0, 2);
        world.addAtEmptyLocation(leatherArmor, depth);
        return leatherArmor;
    }
	
	public Item newIronArmor(int depth){
        Item ironArmor = new Item('i', AsciiPanel.green, "iron armor", ItemType.ARMOR, 0, 4);
        world.addAtEmptyLocation(ironArmor, depth);
        return ironArmor;
    }
	
	public Item newSteelPlate(int depth){
        Item steelPlate = new Item('i', AsciiPanel.green, "steel plate", ItemType.ARMOR, 0, 6);
        world.addAtEmptyLocation(steelPlate, depth);
        return steelPlate;
    }
	
	public Item newIronHelmet(int depth){
        Item ironHelmet = new Item('i', AsciiPanel.green, "iron helmet", ItemType.HELMET, 0, 3);
        world.addAtEmptyLocation(ironHelmet, depth);
        return ironHelmet;
    }
	
	public Item newRingOfPower(int depth){
        Item ringOfPower = new Item('o', AsciiPanel.green, "Ring of Ultimate Power", ItemType.VICTORY, 20, 20);
        world.addAtEmptyLocation(ringOfPower, depth);
        return ringOfPower;
    }
	
	
	
}
