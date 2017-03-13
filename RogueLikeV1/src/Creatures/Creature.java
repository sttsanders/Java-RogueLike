package Creatures;

import java.awt.Color;

import Ai.CreatureAi;
import Resources.Dice;
import Resources.Inventory;
import Resources.Item;
import Resources.ItemType;
import Resources.Tile;
import Resources.World;
import Screen.GameScreen;
import asciiPanel.AsciiPanel;
import java.awt.Container;
import java.io.IOException;
import java.io.Serializable;

public class Creature implements Serializable {
private World world;

	public int x;
	public int y;
	public int z;
	
	private char glyph;
	private Color color;
	private CreatureAi ai;
	private Inventory inventory;
	
	private String name;
	private int maxHealth;
	private int currentHealth;
	private int attackValue;
	private int defenseValue;
	
	private Item equippedWeapon;
	private Item equippedArmor;
	private Item equippedHelmet;
	private Item equippedShield;
	
	private int visionRadius;
	
	private Dice dice = new Dice();
	
	public int visionRadius() 
	{ 
		return this.visionRadius; 
	}
	
	public Item getEquippedShield()
	{
		return this.equippedShield;
	}
	
	public Item getEquippedWeapon()
	{
		return this.equippedWeapon;
	}
	
	public Item getEquippedArmor()
	{
		return this.equippedArmor;
	}
	
	public Item getEquippedHelmet()
	{
		return this.equippedHelmet;
	}
	
	
	public Inventory getInventory()
	{
		return this.inventory;
	}
	
    public int getMaxHealth() 
    { 
    	return this.maxHealth; 
    }
    
    public String getName()
    {
    	return this.name;
    }

    public int getHealth() 
    { 
    	return this.currentHealth; 
    }

    public int getAttackValue() 
    { 
    	return this.attackValue; 
    }

    public int getDefenseValue() 
    { 
    	return this.defenseValue; 
    }
	public char getGlyph()
	{
		return this.glyph;
	}
	public Color getColor()
	{
		return this.color;
	}
	public Creature returnCreature(int wx, int wy, int wz) 
	{
	    return world.returnCreature(wx, wy, wz);
	}
	
	public void unEquip(Item item)
	{
	      if (item == null)
	      {
	    	  return;
	      }
	  
	      if (item.getType() == ItemType.ARMOR){
	          this.equippedArmor = null;
	      } 
	      if (item.getType() == ItemType.WEAPON){
	    	  this.equippedWeapon = null;
	      } 
	      if (item.getType() == ItemType.HELMET){
	    	  this.equippedHelmet = null;
	      } 
	      if (item.getType() == ItemType.SHIELD){
	    	  this.equippedShield = null;
	      } 
	  }
	public void equip(Item item)
	{
			if (item == null)
			{
				return;
			}
			if (item.getType() == ItemType.ARMOR){
				this.equippedArmor = item;
			} 
			if (item.getType() == ItemType.WEAPON){
				System.out.println("equipping weapon");
				this.equippedWeapon = item;
			} 
			if (item.getType() == ItemType.HELMET){
				System.out.println("equipping helmet");
				this.equippedHelmet = item;
			} 
			if (item.getType() == ItemType.SHIELD){
				System.out.println("equipping shield");
				this.equippedShield = item;
			} 
		

	  }

	
	
	/**
	 * method for attacking the opponent. Calculates damage (from Dice method) and damage(reduction) from items and allows for monster status
	 * @param opponent
	 */
	public void attack(Creature opponent){
		int opponentDefense = opponent.getDefenseValue();
		if(opponent.getEquippedArmor() != null)
		{
			opponentDefense += opponent.getEquippedArmor().getDefenseBonus();
		}
		if(opponent.getEquippedShield() != null)
		{
			opponentDefense += opponent.getEquippedShield().getDefenseBonus();
		}
		
		int equipmentAttack = getAttackValue();
		if(getEquippedWeapon() != null)
		{
			equipmentAttack += getEquippedWeapon().getAttackBonus();
			
		}
        int damageDone = (dice.rollDice(1, 6) + equipmentAttack ) 
        		- opponentDefense;
        
        
        if(damageDone < 0)
        {
        	damageDone = 0;
        }
        
        int lifePercentage = calculatePercentage(opponent.getHealth(), opponent.getMaxHealth());
        String monsterStatus = "";
        if(lifePercentage > 50)
	    {
        	monsterStatus = "healthy.";
	    }
	    else if(lifePercentage > 25 && lifePercentage <= 50)
	    {
	    	monsterStatus = "wounded.";
	    }
	    else
	    {
	    	monsterStatus = "almost dead.";
	    }
        
        notify("You hit " + opponent.getName() + " for " + damageDone + " damage. " + opponent.getName() + " is " + monsterStatus);
        
        
        opponent.modifyEnemyHp(damageDone);
        
    }

	/**
	 * method for calculating life (currentHealth divided by maxHealth)
	 * @param cH
	 * @param mH
	 */
	private int calculatePercentage(int cH, int mH)
	{
		double result =  ((double)cH / (double)mH) * 100;
		return (int)result;
	}
	
	/**
	 * method for attacking the opponent. Used to attack the player. 
	 * @param opponent
	 */
	public void counterAttack(Creature opponent){
		int damageDone = (dice.rollDice(1, 6) + getAttackValue() ) - opponent.getDefenseValue();
        if(damageDone < 0)
        {
        	damageDone = 0;
        }
        opponent.modifyHp(damageDone);
        
    }

	/**
	 * modifies enemy hp and shows amount of damage on screen. on enemy death remove enemy
	 * @param amount
	 */
    public void modifyEnemyHp(int amount) {
        currentHealth = currentHealth - amount;
        notify(this.getName() + " took " + amount + " damage from the attack!");
        //ded
        if (currentHealth < 1)
        {
        	notify("The creature dies.");
         	world.remove(this);
        }
    }
    
    /**
     * modifies player hp and shows amount of damage on screen. on death remove enemy
     * @param amount
     */
    public void modifyHp(int amount) {
        
    	 	currentHealth -= amount;
    	 	notify("You took " + amount + " damage from the counter attack!");
    	    if (currentHealth < 1) {
    	        world.remove(this);
    	    }
    }
    
	
	public void setCreatureAi(CreatureAi ai) 
	{ 
		this.ai = ai; 
	}
	
	public Creature(World world, char glyph, String name, Color color, int maxHp, int attack, int defense){
	    this.world = world;
	    this.glyph = glyph;
	    this.color = color;
	    this.maxHealth = maxHp;
	    this.currentHealth = maxHp;
	    this.attackValue = attack;
	    this.defenseValue = defense;
	    this.name = name;
	    this.inventory = new Inventory(30);
	    this.visionRadius = 9;
	}
	

	/**
	 * allows entity to enter new square. On enter checks if new square contains enemy. If so, attacks enemy
	 * @param mx
	 * @param my
	 */
	public void moveBy(int mx, int my, int mz){
		if (mx==0 && my==0 && mz==0) 
		{
			return;
		}
		Tile tile = world.returnTile(x+mx, y+my, z+mz);
		
		Creature other = world.returnCreature(x+mx, y+my, z+mz);
		
		
		if (other == null)
		{
			ai.onEnter(x+mx, y+my, z+mz, tile);
		}
		else
		{
			attack(other);
		}

	}
	
	/**
	 * heals player 1 hp per method call. 
	 */
	public void heal()
	{
		if(currentHealth < maxHealth )
		{
			currentHealth++;
		}
	}

	public void notify(String message, Object ... params){
	    ai.onNotify(String.format(message, params));
	}

	public void update(){   
	    ai.onUpdate();  
	    heal();
	}

	/**
	 * allows player to dig through walls for debug purposes. Might become an item. 
	 * @param wx
	 * @param wy
	 */
	public void dig(int wx, int wy, int wz) {
		world.dig(wx, wy, wz);
	}
	
	/**
	 * checks if tile to enter is actually valid and doesn't contain a monster.
	 * @param wx
	 * @param wy
	 * @return
	 */
	public boolean canEnter(int wx, int wy, int wz) {
		return world.returnTile(wx, wy, wz).isGround() && world.returnCreature(wx, wy, wz) == null;
	}
	
	public void pickup(){
        Item item = world.returnItem(x, y, z);
    
        if (inventory.isFull() || item == null){

        } else {
            world.remove(x, y, z);
            if(item.getType() == ItemType.ARMOR)
            {
            	if(this.getEquippedArmor() != null)
            	{
	                if(item.getDefenseBonus() > this.getEquippedArmor().getDefenseBonus())
	                {
	                	this.equip(item);
	                }
	                else
	                {
	                	inventory.addToInventory(item);
	                }
            	}
            	else
            	{
            		this.equip(item);
            	}
            }
            if(item.getType() == ItemType.HELMET)
            {
            	if(this.getEquippedHelmet() != null)
            	{
	                if(item.getDefenseBonus() > this.getEquippedHelmet().getDefenseBonus())
	                {
	                	this.equip(item);
	                }
	                else
	                {
	                	inventory.addToInventory(item);
	                }
            	}
            	else
            	{
            		this.equip(item);
            	}
            }
            if(item.getType() == ItemType.WEAPON)
            {
            	if(this.getEquippedWeapon() != null)
            	{
	                if(item.getAttackBonus() > this.getEquippedWeapon().getAttackBonus())
	                {

	                	this.equip(item);
	                }
	                else
	                {
	                	inventory.addToInventory(item);
	                }
            	}
            	else
            	{

            		this.equip(item);
            	}
            }
            if(item.getType() == ItemType.SHIELD)
            {
            	if(this.getEquippedShield() != null)
            	{
	                if(item.getDefenseBonus() > this.getEquippedShield().getDefenseBonus())
	                {

	                	this.equip(item);
	                }
	                else
	                {
	                	inventory.addToInventory(item);
	                }
            	}
            	else
            	{

            		this.equip(item);
            	}
            }
            if(item.getType() == ItemType.VICTORY)
            {
            	notify(this.getName() + " found " + item.getName() + "! Now escape! (Stairs up on floor 1)");
            	inventory.addToInventory(item);
            }
            

        }
    }
	
	public void drop(Item item){
        inventory.removeFromInventory(item);
        world.addAtEmptySpace(item, x, y, z);
    }
	
	public boolean canSee(int wx, int wy, int wz){
		return ai.canSee(wx, wy, wz);
	}
	
	public Tile tile(int wx, int wy, int wz) {
		return world.returnTile(wx, wy, wz);
	}
	
	


}
