package Screen;

import java.awt.Color;
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
    	String msiColored = "MSI";
    	
    	p.writeCenter("Welcome", ++y);
    	p.writeCenter("to", ++y);
    	p.writeCenter("Adventure Simulator", ++y);
    	p.writeCenter("", ++y);

    	p.writeCenter("\\                  /",  ++y, AsciiPanel.red);
    	p.writeCenter("_________))                ((__________",  ++y, AsciiPanel.red);
    	p.writeCenter("/.-------./\\\\    \\    /    //\\.--------.\\",  ++y, AsciiPanel.red);
    	p.writeCenter("//#######//##\\   ))  ((   //##\\########\\",  ++y, AsciiPanel.red);
    	p.writeCenter("//#######//###((  ((    ))  ))###\\########\\",  ++y, AsciiPanel.red);
    	p.writeCenter("((#######((#####\\  \\  //  //#####))########))",  ++y, AsciiPanel.red);
    	p.writeCenter("\\##' `###\\##MSI#\\\\  \\)(/  //######/####' `##/",  ++y, AsciiPanel.red);
    	p.writeCenter(")'    ``#)'  `##\\`->oo<-'/##'  `(#''     `(",  ++y, AsciiPanel.red);
    	p.writeCenter("(       ``\\`..'/''       )",  ++y, AsciiPanel.red);
    	p.writeCenter("\\" + "(",  ++y, AsciiPanel.red);
    	p.writeCenter("`- )",  ++y, AsciiPanel.red);
    	p.writeCenter("/ /",  ++y, AsciiPanel.red);
    	p.writeCenter("( /\\",  ++y, AsciiPanel.red);
    	p.writeCenter("/\\| \\",  ++y, AsciiPanel.red);
    	p.writeCenter("(  \\",  ++y, AsciiPanel.red);
    	p.writeCenter(")",  ++y, AsciiPanel.red);
    	p.writeCenter("/",  ++y, AsciiPanel.red);
    	p.writeCenter("(",  ++y, AsciiPanel.red);
    	p.writeCenter("`",  ++y, AsciiPanel.red);
    	p.writeCenter("",  ++y, AsciiPanel.red);
    	p.writeCenter("",  ++y, AsciiPanel.red);
    	p.writeCenter("Press Enter to Start",  ++y);
    	p.write(msiColored, 54, 21, AsciiPanel.brightBlack);

    	
    }
    


}
