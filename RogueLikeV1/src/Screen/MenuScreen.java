package Screen;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class MenuScreen implements Screen {
	@Override
	public void displayOutput(AsciiPanel terminal) {
		// TODO Auto-generated method stub

		terminal.write("(N)ew Game", 1, 3);
		terminal.write("(C)ontinue", 1, 5);
		terminal.write("(O)ptions", 1, 7);
		terminal.write("(E)xit", 1, 9);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()){
	        case KeyEvent.VK_ESCAPE: return new StartScreen();
	        case KeyEvent.VK_N: return new GameScreen();
	        case KeyEvent.VK_C: return new GameScreen();
	        case KeyEvent.VK_O: return new GameScreen();
	        //case KeyEvent.VK_E: return new GameScreen();
	        default : return this;
        }
		
		
	}
}
