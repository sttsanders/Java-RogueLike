import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;


import Screen.MenuScreen;
import Screen.Screen;
import Screen.StartScreen;
import asciiPanel.AsciiPanel;

public class ApplicationMain extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1060623638149583738L;

    private AsciiPanel terminal;
    private Screen screen;
    private static Random rnd = new Random();
    
    public ApplicationMain(){
        super();
        terminal = new AsciiPanel();
        add(terminal);
        pack();
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }

    public void repaint(){
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }
    
    public void deathScreen()
    {
    	screen = new MenuScreen();
    }
    

    public void keyReleased(KeyEvent e) 
    { 
    	
    }

    public void keyTyped(KeyEvent e) 
    { 
    	
    }

    public static void main(String[] args)
    {
    	ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        
        
    }
    
    
    
}