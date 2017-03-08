package Screen;

import java.awt.event.KeyEvent;

import com.sun.glass.events.WindowEvent;

import asciiPanel.AsciiPanel;

public class MenuScreen implements Screen {
	@Override
	public void displayOutput(AsciiPanel terminal) {
		// TODO Auto-generated method stub

		terminal.write("(N)ew Game", 1, 3);

		terminal.write("(E)xit", 1, 5);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()){
	        case KeyEvent.VK_N: return new GameScreen();
	        //case KeyEvent.VK_E: return new GameScreen();
	        default : return this;
        }
		
		
	}
}
