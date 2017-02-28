package Creatures;

import java.awt.Color;

import Ai.CreatureAi;
import Resources.World;

public class Creature {
private World world;
	
	public int x;
	public int y;
	
	private char glyph;
	private Color color;
	private CreatureAi ai;
	
	private int maxHealth;
	private int currentHealth;
	private int attackValue;
	private int defenseValue;
	
    public int getMaxHealth() 
    { 
    	return maxHealth; 
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
	
	public void setCreatureAi(CreatureAi ai) 
	{ 
		this.ai = ai; 
	}
	
	public Creature(World world, char glyph, Color color){
		this.world = world;
		this.glyph = glyph;
		this.color = color;
	}
	
	public void moveBy(int mx, int my){
	    Creature other = world.creature(x+mx, y+my);
	  
	    if (other == null)
	        ai.onEnter(x+mx, y+my, world.returnTile(x+mx, y+my));
	    else
	        attack(other);
	}

	public void update(){   
	    ai.onUpdate();  
	}
	
	public void attack(Creature other){
	    world.remove(other);
	}

	public void dig(int wx, int wy) {
		world.dig(wx, wy);
	}
	
	public boolean canEnter(int wx, int wy) {
		return world.returnTile(wx, wy).isGround() && world.creature(wx, wy) == null;
	}
}
