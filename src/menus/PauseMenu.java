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
	
	public static final double EM_HEIGHT_OFFSET = 5.7;
	public static final double EM_WIDTH = 4.4;
	public static final double EM_HEIGHT = 19.2;
	
	public static final double EG_HEIGHT_OFFSET = 4.3;
	public static final double EG_WIDTH = 5.4;
	public static final double EG_HEIGHT = 19.2;
	
	public static final double C_HEIGHT_OFFSET = 3.4;
	public static final double C_WIDTH = 6.61;
	public static final double C_HEIGHT = 25;
	
	public PauseMenu(MainApplication app) {
		program = app;
		background = new GImage("Pause.png", 0, 0);
		resumeButton = new GButton(program.WINDOW_WIDTH/WIDTH_OFFSET, 
				program.WINDOW_HEIGHT/RG_HEIGHT_OFFSET,
				program.WINDOW_WIDTH/RG_WIDTH, 
				program.WINDOW_HEIGHT/RG_HEIGHT, true);
		exitToMenuButton = new GButton(program.WINDOW_WIDTH/WIDTH_OFFSET, 
				program.WINDOW_HEIGHT/EM_HEIGHT_OFFSET, 
				program.WINDOW_WIDTH/EM_WIDTH, 
				program.WINDOW_HEIGHT/EM_HEIGHT, true);
		exitGameButton = new GButton(program.WINDOW_WIDTH/WIDTH_OFFSET, 
				program.WINDOW_HEIGHT/EG_HEIGHT_OFFSET, 
				program.WINDOW_WIDTH/EG_WIDTH, 
				program.WINDOW_HEIGHT/EG_HEIGHT, true);
		controlsButton = new GButton(program.WINDOW_WIDTH/WIDTH_OFFSET, 
				program.WINDOW_HEIGHT/C_HEIGHT_OFFSET, 
				program.WINDOW_WIDTH/C_WIDTH, 
				program.WINDOW_WIDTH/C_HEIGHT, true);
		
	}
	
	public void showContents() {
		program.add(background);
		program.add(resumeButton);
		program.add(exitToMenuButton);
		program.add(exitGameButton);
		program.add(controlsButton);
	}

	public void hideContents() {
		program.remove(background);
		program.remove(resumeButton);
		program.remove(exitToMenuButton);
		program.remove(exitGameButton);
		program.remove(controlsButton);
	}

	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == resumeButton) {
			program.switchToGame();
		}
	}
}
