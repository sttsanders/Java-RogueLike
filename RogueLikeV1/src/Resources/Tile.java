package Resources;

import java.awt.Color;
import asciiPanel.AsciiPanel;

public enum Tile {
	FLOOR((char)' ', AsciiPanel.white),
	TILEDFLOOR((char)10, AsciiPanel.white),
    TILEDWALL((char)8, AsciiPanel.brown),
    WALL((char)'|', AsciiPanel.brown),
    WATER((char)254, AsciiPanel.blue),
    BOUNDS('x', AsciiPanel.brightBlack),
    STAIRS_UP('>', AsciiPanel.white),
	STAIRS_DOWN('<', AsciiPanel.white),
	PLAYER((char)22, AsciiPanel.blue);

    private char glyph;
    public char getGlyph() { return glyph; }

    private Color color;
    public Color getColor() { return color; }

    public boolean isGround() {
		return this != WALL && this != BOUNDS;
	}

	public boolean isDiggable() {
		return this == Tile.WALL;
	}

    
    Tile(char glyph, Color color){
        this.glyph = glyph;
        this.color = color;
    }
}
