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
	PLAYER((char)22, AsciiPanel.blue);

    private char glyph;
    public char getGlyph() { return glyph; }

    private Color color;
    public Color getColor() { return color; }

    Tile(char glyph, Color color){
        this.glyph = glyph;
        this.color = color;
    }
}
