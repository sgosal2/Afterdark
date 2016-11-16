package menus;

import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import utilities.GButton;
import utilities.GraphicsPane;
import utilities.MainApplication;

public class PauseMenu extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GImage background;
	private GButton resumeButton;
	private GButton exitToMenuButton;
	private GButton exitGameButton;
	private GButton controlsButton;
	
	public PauseMenu(MainApplication app) {
		program = app;
		background = new GImage("Pause.png", 0, 0);
	}
	
	public void showContents() {
		program.add(background);
	}

	public void hideContents() {
		program.remove(background);
	}

	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		
	}
}
