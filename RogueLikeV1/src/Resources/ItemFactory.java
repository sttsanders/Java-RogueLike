package Resources;

import java.awt.event.KeyEvent;
import java.util.Random;

import Screen.LoseScreen;
import Screen.MenuScreen;
import asciiPanel.AsciiPanel;

public class ItemFactory {
	private World world;
	
	public ItemFactory(World world){
		this.world = world;
	}
	
	public void createItems() 
	{
		// TODO Auto-generated method stub
		for (int z = 0; z < world.getDepth(); z++){
	        for(int i = 0; i <= 4; i++)
	        {
	        	int itemGen = new Random().nextInt(16) + 1;
	        	
	        	switch (itemGen)
		        {
			         case 1 	: newWoodenSword(z)		; break;
			         case 2 	: newIronSword(z)		; break;
			         case 3 	: newSteelSword(z)		; break;
			         case 4 	: newDragonSword(z)		; break;
			         case 5 	: newWoodenShield(z)	; break;
			         case 6 	: newIronShield(z)		; break;
			         case 7 	: newSteelShield(z)		; break;
			         case 8 	: newDragonShield(z)	; break;
			         case 9 	: newLeatherArmor(z)	; break;
			         case 10 	: newIronArmor(z)		; break;
			         case 11 	: newSteelArmor(z)		; break;
			         case 12 	: newDragonArmor(z)		; break;
			         case 13 	: newLeatherHelmet(z)	; break;
			         case 14 	: newIronHelmet(z)		; break;
			         case 15 	: newSteelHelmet(z)		; break;
			         case 16 	: newDragonHelmet(z)	; break;
			         
		        }
	        }
	       
	    }
		
		//adds victory condition to random floor. Find it to win. 
		int randomLevel = new Random().nextInt(world.getDepth());
		
		newEpicSpoon(randomLevel);
	}
	
	//-----------------------------Weapons
	public Item newWoodenSword(int depth)
	{
        Item sword = new Item('w', AsciiPanel.green, "wooden sword",ItemType.WEAPON, 1, 0);
        world.addAtEmptyLocation(sword, depth);
        return sword;
    }
	
	public Item newIronSword(int depth)
	{
        Item sword = new Item('w', AsciiPanel.green, "iron sword",ItemType.WEAPON, 2, 0);
        world.addAtEmptyLocation(sword, depth);
        return sword;
    }
	
	public Item newSteelSword(int depth)
	{
        Item sword = new Item('w', AsciiPanel.green, "steel sword",ItemType.WEAPON, 4, 0);
        world.addAtEmptyLocation(sword, depth);
        return sword;
    }
	
	public Item newDragonSword(int depth)
	{
        Item sword = new Item('w', AsciiPanel.green, "dragon sword",ItemType.WEAPON, 8, 0);
        world.addAtEmptyLocation(sword, depth);
        return sword;
    }
		
	
	//-----------------------------Shield
	public Item newWoodenShield(int depth)
	{
        Item shield = new Item('s', AsciiPanel.green, "wooden shield",ItemType.SHIELD, 0,1);
        world.addAtEmptyLocation(shield, depth);
        return shield;
    }
	
	public Item newIronShield(int depth)
	{
        Item shield = new Item('s', AsciiPanel.green, "iron shield",ItemType.SHIELD, 0,2);
        world.addAtEmptyLocation(shield, depth);
        return shield;
    }
	
	public Item newSteelShield(int depth)
	{
        Item shield = new Item('s', AsciiPanel.green, "steel shield",ItemType.SHIELD, 0,4);
        world.addAtEmptyLocation(shield, depth);
        return shield;
    }
	
	public Item newDragonShield(int depth)
	{
        Item shield = new Item('s', AsciiPanel.green, "dragon shield",ItemType.SHIELD, 0,8);
        world.addAtEmptyLocation(shield, depth);
        return shield;
    }
	
	
	//-----------------------------Armor
	public Item newLeatherArmor(int depth)
	{
        Item armor = new Item('a', AsciiPanel.green, "leather armor",ItemType.ARMOR, 0,1);
        world.addAtEmptyLocation(armor, depth);
        return armor;
    }
	
	public Item newIronArmor(int depth)
	{
        Item armor = new Item('a', AsciiPanel.green, "iron armor",ItemType.ARMOR, 0,2);
        world.addAtEmptyLocation(armor, depth);
        return armor;
    }
	
	public Item newSteelArmor(int depth)
	{
        Item armor = new Item('a', AsciiPanel.green, "steel armor",ItemType.ARMOR, 0,4);
        world.addAtEmptyLocation(armor, depth);
        return armor;
    }
	
	public Item newDragonArmor(int depth)
	{
        Item armor = new Item('a', AsciiPanel.green, "dragon armor",ItemType.ARMOR, 0, 8);
        world.addAtEmptyLocation(armor, depth);
        return armor;
    }
		
	
	//-----------------------------Helmet
		public Item newLeatherHelmet(int depth)
		{
	        Item helmet = new Item('h', AsciiPanel.green, "leather helmet",ItemType.HELMET, 0,1);
	        world.addAtEmptyLocation(helmet, depth);
	        return helmet;
	    }
		
		public Item newIronHelmet(int depth)
		{
	        Item helmet = new Item('h', AsciiPanel.green, "iron helmet",ItemType.HELMET, 0,2);
	        world.addAtEmptyLocation(helmet, depth);
	        return helmet;
	    }
		
		public Item newSteelHelmet(int depth)
		{
	        Item helmet = new Item('h', AsciiPanel.green, "steel helmet",ItemType.HELMET, 0,4);
	        world.addAtEmptyLocation(helmet, depth);
	        return helmet;
	    }
		
		public Item newDragonHelmet(int depth)
		{
	        Item helmet = new Item('h', AsciiPanel.green, "dragon helmet",ItemType.HELMET, 0, 8);
	        world.addAtEmptyLocation(helmet, depth);
	        return helmet;
	    }
	
	//------------------------------Special
	public Item newEpicSpoon(int depth)
	{
        Item newEpicSpoon = new Item('S', AsciiPanel.red, "The magic Spoon", ItemType.VICTORY, 20, 20);
        world.addAtEmptyLocation(newEpicSpoon, depth);
        return newEpicSpoon;
    }
	
	
	
}
