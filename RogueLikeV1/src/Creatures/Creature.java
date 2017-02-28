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
		ai.onEnter(x+mx, y+my, world.returnTile(x+mx, y+my));
	}

	public void dig(int wx, int wy) {
		world.dig(wx, wy);
	}
}
