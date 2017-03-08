package Screen;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class WinScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		int coordY = 10;

		
		terminal.writeCenter("____     ___                                                                 8 ",coordY++);
		terminal.writeCenter("`MM(     )M'                                            68b                 (M)",coordY++);
		terminal.writeCenter(" `MM.    d'                                             Y89                 (M)",coordY++);
		terminal.writeCenter("  `MM.  d'     _____   ___   ___       ____    _    ___ ___ ___  __         (M)",coordY++);
		terminal.writeCenter("   `MM d'     6MMMMMb  `MM    MM       `MM(   ,M.   )M' `MM `MM 6MMb         M ",coordY++);
		terminal.writeCenter("    `MM'     6M'   `Mb  MM    MM        `Mb   dMb   d'   MM  MMM9 `Mb        M ",coordY++);
		terminal.writeCenter("     MM      MM     MM  MM    MM         YM. ,PYM. ,P    MM  MM'   MM        M ",coordY++);
		terminal.writeCenter("     MM      MM     MM  MM    MM         `Mb d'`Mb d'    MM  MM    MM        8 ",coordY++);
		terminal.writeCenter("     MM      MM     MM  MM    MM          YM,P  YM,P     MM  MM    MM          ",coordY++);
		terminal.writeCenter("     MM      YM.   ,M9  YM.   MM          `MM'  `MM'     MM  MM    MM       68b",coordY++);
		terminal.writeCenter("    _MM_      YMMMMM9    YMMM9MM_          YP    YP     _MM__MM_  _MM_      Y89",coordY++);
		
		terminal.writeCenter("-- press [enter] to restart --", 25);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new GameScreen() : this;
	}

}
