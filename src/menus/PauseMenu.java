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
	
	public static final double WIDTH_OFFSET = 51.2;
	public static final double RG_HEIGHT_OFFSET = 8.53;
	public static final double RG_WIDTH = 3.9;
	public static final double RG_HEIGHT = 19.2;
	
	public PauseMenu(MainApplication app) {
		program = app;
		background = new GImage("Pause.png", 0, 0);
		resumeButton = new GButton(program.WINDOW_WIDTH/WIDTH_OFFSET, 
				program.WINDOW_HEIGHT/RG_HEIGHT_OFFSET,
				program.WINDOW_WIDTH/RG_WIDTH, 
				program.WINDOW_HEIGHT/RG_HEIGHT, true);
		
	}
	
	public void showContents() {
		program.add(background);
		program.add(resumeButton);
	}

	public void hideContents() {
		program.remove(background);
		program.remove(resumeButton);
	}

	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == resumeButton) {
			program.switchToGame();
		}
	}
}
