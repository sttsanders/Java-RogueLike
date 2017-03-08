package Screen;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import Creatures.Creature;
import Resources.CreatureFactory;
import Resources.Item;
import Resources.ItemFactory;
import Resources.ItemType;
import Resources.Tile;
import Resources.World;
import Resources.WorldBuilder;
import asciiPanel.AsciiPanel;

public class GameScreen implements Screen {
	private World world;
	private Creature player;
	private int screenWidth;
	private int screenHeight;
	private List<String> messages;
	private Screen subscreen;
	
	public GameScreen(){
		screenWidth = 100;
		screenHeight = 48;
		messages = new ArrayList<String>();
		createWorld();
		
		CreatureFactory cF = new CreatureFactory(world);
		cF.createCreatures();
		ItemFactory iF = new ItemFactory(world);
		iF.createItems();
		
		createPlayer(cF);
		
	}
	
	private void createPlayer(CreatureFactory cF) {
		player = cF.newPlayer(messages);
		
	}

	private void displayMessages(AsciiPanel terminal, List<String> messages) {
	    int top = screenHeight - messages.size();
	    top = top+2;
	    for (int i = 0; i < messages.size(); i++){
	        terminal.writeCenter(messages.get(i), top + i);
	    }
	    messages.clear();
	}
	
	private void createWorld(){
		world = new WorldBuilder(120, 68, 6)
					.makeCaves()
					.build();
	}
	
	public int getScrollX() { return Math.max(0, Math.min(player.x - screenWidth / 2, world.getWidth() - screenWidth)); }
	
	public int getScrollY() { return Math.max(0, Math.min(player.y - screenHeight / 2, world.getHeight() - screenHeight)); }
	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		int left = getScrollX();
		int top = getScrollY(); 
		
		displayTiles(terminal, left, top);
		
		terminal.write(player.getGlyph(), player.x - left, player.y - top, player.getColor());
		
		showUI(terminal);
		
		displayMessages(terminal, messages);
	}

	private void showUI(AsciiPanel terminal)
	{
		showHealth(terminal);
		showEquippedStuff(terminal);
		showLevel(terminal);
		showLegend(terminal);
	}
	private void showLegend(AsciiPanel terminal)
	{
		terminal.write(" - arrow keys to move ", 100, 10, AsciiPanel.white);
		terminal.write(" - (g) to pickup items ", 100, 11, AsciiPanel.white);
		terminal.write(" - (Shift)(<) to descend ", 100, 12, AsciiPanel.white);
		terminal.write(" - (Shift)(>) to ascend ", 100, 13, AsciiPanel.white);
		terminal.write(" - (e) to give up ", 100, 14, AsciiPanel.white);
		
		terminal.write(" Find the magic spoon ", 100, 17, AsciiPanel.white);
		terminal.write(" and escape! ", 100, 18, AsciiPanel.white);
	}
	
	private void showHealth(AsciiPanel terminal) 
	{
		int localHealth = player.getHealth();
		int localMaxhealth = player.getMaxHealth();
		int percentage = calculatePercentage(localHealth, localMaxhealth);
		
		String statistics = " Hitpoints: " + localHealth + "/" + localMaxhealth;
		
	    if(percentage > 50)
	    {
	    	terminal.write(statistics, 100, 1, AsciiPanel.white);
	    }
	    else if(percentage > 25 && percentage <= 50)
	    {
	    	terminal.write(statistics, 100, 1, AsciiPanel.yellow);
	    }
	    else
	    {
	    	terminal.write(statistics, 100, 1, AsciiPanel.red);
	    }
		
	}
	
	private void showEquippedStuff(AsciiPanel terminal) 
	{
		
		String equippedHelmet = "None";
		String equippedArmor = "None";
		String equippedWeapon = "None";
		String equippedShield = "None";
	
		int equippedHelmetBonus = 0;
		int equippedArmorBonus = 0;
		int equippedWeaponBonus = 0;
		int equippedShieldBonus = 0;
		
		if(player.getEquippedHelmet() != null)
		{
			equippedHelmet = player.getEquippedHelmet().getName();
			equippedHelmetBonus = player.getEquippedHelmet().getDefenseBonus();
		}
		
		if(player.getEquippedArmor() != null)
		{
			equippedArmor = player.getEquippedArmor().getName();
			equippedArmorBonus = player.getEquippedArmor().getDefenseBonus();
		}
		
		if(player.getEquippedWeapon() != null)
		{
			equippedWeapon = player.getEquippedWeapon().getName();
			equippedWeaponBonus = player.getEquippedWeapon().getAttackBonus();
		}
		
		if(player.getEquippedShield() != null)
		{
			equippedShield = player.getEquippedShield().getName();
			equippedShieldBonus = player.getEquippedShield().getDefenseBonus();
		}
		
	    
	    terminal.write(" Helmet: "   + equippedHelmet, 	100, 4, 	AsciiPanel.white);
	    terminal.write("(+"  + equippedHelmetBonus + ")",	122, 4, 	AsciiPanel.yellow);
	   	terminal.write(" Armor: " 	+ equippedArmor, 		100, 5, 	AsciiPanel.white);
	   	terminal.write("(+" + equippedArmorBonus+ ")",		122, 5, 	AsciiPanel.yellow);
	    terminal.write(" Weapon: " 	+ equippedWeapon, 		100, 6, 	AsciiPanel.white);
	    terminal.write("(+" + equippedWeaponBonus+ ")",		122, 6, 	AsciiPanel.yellow);
	    terminal.write(" Shield: " 	+ equippedShield, 		100, 7, 	AsciiPanel.white);
	    terminal.write("(+" + equippedShieldBonus+ ")",		122, 7, 	AsciiPanel.yellow);
		
	}

	private void showLevel(AsciiPanel terminal)
	{
		String statistics = " Current Floor: " + world.getCurrentDepth();

		terminal.write(statistics, 100, 8, AsciiPanel.white);
		terminal.write(" -------------------------", 100, 9, AsciiPanel.white);
	}
	
	private int calculatePercentage(int cH, int mH)
	{
		double result =  ((double)cH / (double)mH) * 100;
		return (int)result;
	}
	
	private void displayTiles(AsciiPanel terminal, int left, int top) {
		for (int x = 0; x < screenWidth; x++){
			for (int y = 0; y < screenHeight; y++){
				int wx = x + left;
				int wy = y + top;

				Creature creature = world.returnCreature(wx, wy, player.z);
				if (creature != null)
					terminal.write(creature.getGlyph(), creature.x - left, creature.y - top, creature.getColor());
				else
					terminal.write(world.returnGlyph(wx, wy, player.z), x, y, world.returnColor(wx, wy, player.z));
			}
		}
	}

	private boolean userIsTryingToWin(){
	    return player.z == 0 && world.returnTile(player.x, player.y, player.z) == Tile.STAIRS_UP;
	}

	private Screen userExits(){
		for(Item item : player.getInventory().getItems())
		{
			System.out.println(item);
		}
	    for (Item item : player.getInventory().getItems())
	    {
	    	System.out.println(item.getType());
	        if (item != null && item.getType() == ItemType.VICTORY)
	        {
	            return new WinScreen();
	        }
	    }
	    return this;
	}
	
	@Override
	public Screen respondToUserInput(KeyEvent key) {
		if (subscreen != null) {
	         subscreen = subscreen.respondToUserInput(key);
	     } else {
	         switch (key.getKeyCode())
	         {
	         case KeyEvent.VK_ESCAPE : return new MenuScreen();
	         case KeyEvent.VK_E : return new LoseScreen(); 
	         case KeyEvent.VK_LEFT:
	         case KeyEvent.VK_H: player.moveBy(-1, 0, 0); break;
	         case KeyEvent.VK_RIGHT:
	         case KeyEvent.VK_L: player.moveBy( 1, 0, 0); break;
	         case KeyEvent.VK_UP:
	         case KeyEvent.VK_K: player.moveBy( 0,-1, 0); break;
	         case KeyEvent.VK_DOWN:
	         case KeyEvent.VK_J: player.moveBy( 0, 1, 0); break;
//	         case KeyEvent.VK_Y: player.moveBy(-1,-1, 0); break;
//	         case KeyEvent.VK_U: player.moveBy( 1,-1, 0); break;
//	         case KeyEvent.VK_B: player.moveBy(-1, 1, 0); break;
//	         case KeyEvent.VK_N: player.moveBy( 1, 1, 0); break;
	         }
	        
	         switch (key.getKeyChar()){
	         case 'g':
	         case ',': player.pickup(); break;
	         case '<':
	             if (userIsTryingToWin())
	              return userExits();
	             else
	              player.moveBy( 0, 0, -1); 
	             break;
	         case '>': player.moveBy( 0, 0, 1); break;
	         }
	     }
	    
	     if (subscreen == null)
	         world.update();
	    
	     if (player.getHealth() < 1)
	         return new LoseScreen();
	    
	     return this;

	 }
}

