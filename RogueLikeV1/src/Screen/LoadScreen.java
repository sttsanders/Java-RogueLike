package Screen;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class LoadScreen implements Screen {
	@Override
	public void displayOutput(AsciiPanel terminal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()){
	        case KeyEvent.VK_ESCAPE: return new MenuScreen();
	        default : return this;
		}
	}
}
