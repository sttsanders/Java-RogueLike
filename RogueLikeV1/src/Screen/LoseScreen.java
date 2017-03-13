package Screen;

import java.awt.event.KeyEvent;

import Resources.SaveState;
import asciiPanel.AsciiPanel;

public class LoseScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		int coordY = 10;
		terminal.writeCenter("____     ___                                                            ________                           ___ ", coordY++);
		terminal.writeCenter("`MM(     )M'                                                            `MMMMMMMb.                         `MM ", coordY++);
		terminal.writeCenter(" `MM.    d'                                                              MM    `Mb                          MM ", coordY++);
		terminal.writeCenter("  `MM.  d'     _____   ___   ___          ___    ___  __   ____          MM     MM   ____      ___      ____MM ", coordY++);
		terminal.writeCenter("   `MM d'     6MMMMMb  `MM    MM        6MMMMb   `MM 6MM  6MMMMb         MM     MM  6MMMMb   6MMMMb    6MMMMMM ", coordY++);
		terminal.writeCenter("    `MM'     6M'   `Mb  MM    MM       8M'  `Mb   MM69   6M'  `Mb        MM     MM 6M'  `Mb 8M'  `Mb  6M'  `MM ", coordY++);
		terminal.writeCenter("     MM      MM     MM  MM    MM           ,oMM   MM'    MM    MM        MM     MM MM    MM     ,oMM  MM    MM ", coordY++);
		terminal.writeCenter("     MM      MM     MM  MM    MM       ,6MM9'MM   MM     MMMMMMMM        MM     MM MMMMMMMM ,6MM9'MM  MM    MM ", coordY++);
		terminal.writeCenter("     MM      MM     MM  MM    MM       MM'   MM   MM     MM              MM     MM MM       MM'   MM  MM    MM ", coordY++);
		terminal.writeCenter("     MM      YM.   ,M9  YM.   MM       MM.  ,MM   MM     YM    d9        MM    .M9 YM    d9 MM.  ,MM  YM.  ,MM ",coordY++);
		terminal.writeCenter("    _MM_      YMMMMM9    YMMM9MM_      `YMMM9'Yb._MM_     YMMMM9        _MMMMMMM9'  YMMMM9  `YMMM9'Yb. YMMMMMM_",coordY++);
		
		terminal.writeCenter("-- press [enter] to restart --", 25);
		SaveState.deleteSave();
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new GameScreen() : this;
	}
}