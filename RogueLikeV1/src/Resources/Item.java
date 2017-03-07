package Resources;

import java.awt.Color;

public class Item {
	private char glyph;
    private Color color;
    private String name;
    private int attackBonus;
    private int defenseBonus;
    private ItemType type;
    
    public int getAttackBonus()
    {
    	return this.attackBonus;
    }
    
    public int getDefenseBonus()
    {
    	return this.defenseBonus;
    }
    
    public ItemType getType()
    {
    	return this.type;
    }
    
    public String getName() 
    { 
    	return this.name; 
    }
    
    public char getGlyph() 
    { 
    	return this.glyph; 
    }
    
    public Color getColor() 
    { 
    	return this.color; 
    }
    
    
    
    public Item(char glyph, Color color, String name, ItemType type, int attack, int defense){
        this.glyph = glyph;
        this.color = color;
        this.name = name;
        this.type = type;
        this.attackBonus = attack;
        this.defenseBonus = defense;
    }
}
