package Creatures;

import java.awt.Color;

import Ai.CreatureAi;
import Resources.Dice;
import Resources.World;

public class Creature {
private World world;
	
	public int x;
	public int y;
	
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
	
	public void attack(Creature opponent){
        int damageDone = (dice.rollDice(1, 6) + getAttackValue() ) - opponent.getDefenseValue();
        if(damageDone < 0)
        {
        	damageDone = 0;
        }
        notify("You hit " + opponent.getName() + " for " + damageDone + " damage");
        opponent.modifyEnemyHp(damageDone);
        
    }
	
	public void counterAttack(Creature opponent){
		int damageDone = (dice.rollDice(1, 6) + getAttackValue() ) - opponent.getDefenseValue();
        if(damageDone < 0)
        {
        	damageDone = 0;
        }
        opponent.modifyHp(damageDone);
        
    }

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
    
    public void modifyHp(int amount) {
        currentHealth = currentHealth - amount;
        notify("You took " + amount + " damage from the counter attack!");
        //ded
        if (currentHealth < 1)
        {
        	notify("You ded GG");
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
	
	public void moveBy(int mx, int my){
		Creature other = world.creature(x+mx, y+my);
		
		if (other == null)
		{
			ai.onEnter(x+mx, y+my, world.returnTile(x+mx, y+my));

		}
		else
		{
			attack(other);
			other.counterAttack(this);
		}
	}
	
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


	public void dig(int wx, int wy) {
		world.dig(wx, wy);
	}
	
	public boolean canEnter(int wx, int wy) {
		return world.returnTile(wx, wy).isGround() && world.creature(wx, wy) == null;
	}
}
