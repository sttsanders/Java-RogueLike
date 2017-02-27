package Screen;

import java.awt.event.KeyEvent;

import Resources.World;
import Resources.WorldBuilder;
import asciiPanel.AsciiPanel;

public class GameScreen implements Screen {
	private World world;
    private int centerX;
    private int centerY;
    private int screenWidth;
    private int screenHeight;

    public GameScreen(){
        screenWidth = 80;
        screenHeight = 21;
        createWorld();
    }
	
    private void createWorld(){
        world = new WorldBuilder(90, 31).makeCaves().buildWorld();
    }
    
	@Override
	public void displayOutput(AsciiPanel terminal) {
		// TODO Auto-generated method stub
		int left = getScrollX();
        int top = getScrollY();
   
        displayTiles(terminal, left, top);
        //me
        terminal.write('@', centerX - left, centerY - top);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()){
		case KeyEvent.VK_ESCAPE: return new MenuScreen();
		//case KeyEvent.VK_ENTER: return new WinScreen();
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A: scrollBy(-1, 0); break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D: scrollBy( 1, 0); break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W: scrollBy( 0,-1); break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S: scrollBy( 0, 1); break;
		}
		
		return this;
	}
	
	private void scrollBy(int mx, int my){
        centerX = Math.max(0, Math.min(centerX + mx, world.getWidth() - 1));
        centerY = Math.max(0, Math.min(centerY + my, world.getHeight() - 1));
    }
	
	public int getScrollX() {
	    return Math.max(0, Math.min(centerX - screenWidth / 2, world.getWidth() - screenWidth));
	}
	
	public int getScrollY() {
	    return Math.max(0, Math.min(centerY - screenHeight / 2, world.getHeight() - screenHeight));
	}
	
	private void displayTiles(AsciiPanel terminal, int left, int top) 
	{
	    for (int x = 0; x < screenWidth; x++)
	    {
	        for (int y = 0; y < screenHeight; y++)
	        {
	            int wx = x + left;
	            int wy = y + top;

	            terminal.write(world.returnGlyph(wx, wy), x, y, world.returnColor(wx, wy));
	        }
	    }
	}

	
}
