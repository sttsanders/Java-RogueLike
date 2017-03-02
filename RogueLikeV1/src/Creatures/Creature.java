package Creatures;

import java.awt.Color;

import Ai.CreatureAi;
import Resources.Dice;
import Resources.Tile;
import Resources.World;
import Screen.GameScreen;
import asciiPanel.AsciiPanel;
import java.awt.Container;
import java.io.IOException;

public class Creature {
private World world;

	public int x;
	public int y;
	public int z;
	
	private char glyph;
	private Color color;
	private CreatureAi ai;
	
	private String name;
	private int maxHealth;
	private int currentHealth;
	private int attackValue;
	private int defenseValue;
	private Dice dice = new Dice();
	
    public int getMaxHealth() 
    { 
    	return maxHealth; 
    }
    
    public String getName()
    {
    	return name;
    }

    
    public int getHealth() 
    { 
    	return currentHealth; 
    }

    
    public int getAttackValue() 
    { 
    	return attackValue; 
    }

    
    public int getDefenseValue() 
    { 
    	return defenseValue; 
    }
    
	public char getGlyph()
	{
		return this.glyph;
	}
	
	public Color getColor()
	{
		return this.color;
	}
	
	/**
	 * method for attacking the opponent. Calculates damage (from Dice method) and allows for monster status
	 * @param opponent
	 */
	public void attack(Creature opponent){
        int damageDone = (dice.rollDice(1, 6) + getAttackValue() ) - opponent.getDefenseValue();
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
        notify(this.getName() + " took " + amount + " damage from the counter attack!");
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
	}
	

	/**
	 * allows entity to enter new square. On enter checks if new square contains enemy. If so, attacks enemy
	 * @param mx
	 * @param my
	 */
	public void moveBy(int mx, int my, int mz){
		if (mx==0 && my==0 && mz==0) {
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
			counterAttack(this);
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
	    //heal();
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


}
