package Screen;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		// TODO Auto-generated method stub
		sketchTerminal(terminal);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new MenuScreen() : this;
	}
	
    public static void sketchTerminal(AsciiPanel p)
    {
    	int x = 44;
    	int y = 10;
    	
    	p.write("", 26, ++y);
    	p.write("                             Welcome            ", 26, ++y);
    	p.write("                               to            ", 26, ++y);
    	p.write("                             CULTIST            ", 26, ++y);
    	p.write("       _______________             ", x, ++y);
    	p.write("      /               \\            ", x, ++y);
    	p.write("     /                 \\           ", x, ++y);
    	p.write("    /                   \\          ", x, ++y);
    	p.write("    |    ##       ##    |          ", x, ++y);
    	p.write("    |   ####     ####   |          ", x, ++y);
    	p.write("    |    ##       ##    |          ", x, ++y);
    	p.write("    |         #         |", x, ++y);
    	p.write("    \'__      ###     __/'           ", x, ++y);
    	p.write("      |\\     ###     /|            ", x, ++y);
    	p.write("      | |           | |            ", x, ++y);
    	p.write("      | I I I I I I I |            ", x, ++y);
    	p.write("      |  I I I I I I  |            ", x, ++y);
    	p.write("      \\               /             ", x, ++y);
    	p.write("        \\           /              ", x, ++y);
    	p.write("          \\_______/                ", x, ++y);
    	p.write("", 29, ++y);
    	p.write("", 29, ++y);
    	p.write("", 29, ++y);
    	p.write("", 29, ++y);
    	p.write("", 29, ++y);
    	p.write("", 29, ++y);
    	p.write("                   Press Enter to Start", 29, ++y);
    	


    	
    }
    


}
