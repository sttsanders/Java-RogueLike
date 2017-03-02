package Resources;

import java.awt.Color;

public class Item {
	private char glyph;
    private Color color;
    private String name;
    
    
    public String getName() 
    { 
    	return name; 
    }
    
    public char getGlyph() 
    { 
    	return glyph; 
    }
    
    public Color getColor() 
    { 
    	return color; 
    }
    
    
    
    public Item(char glyph, Color color, String name){
        this.glyph = glyph;
        this.color = color;
        this.name = name;
    }
}
