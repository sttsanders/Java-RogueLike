package Screen;

import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.sun.glass.events.WindowEvent;

import Resources.World;
import asciiPanel.AsciiPanel;

public class MenuScreen implements Screen {
	
	GameScreen g = new GameScreen();
	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		// TODO Auto-generated method stub

		terminal.write("(N)ew Game", 1, 3);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()){
	        case KeyEvent.VK_N: return new GameScreen();

	        default : return this;
        }	
	}
	
	
}
