package menus;

import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import utilities.GButton;
import utilities.GraphicsPane;
import utilities.MainApplication;

public class Controls extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GImage background;
	
	private GButton xButton;
	private static final double X_WIDTH_FACTOR = 28.4;
	private static final double X_HEIGHT_FACTOR = 22.6;
	private static final double X_XCORD_FACTOR = 1.39;
	private static final double X_YCORD_FACTOR = 6.86;
	private final double X_XCORD= program.WINDOW_WIDTH/X_XCORD_FACTOR;
	private final double X_YCORD = program.WINDOW_HEIGHT/X_YCORD_FACTOR;
	private final double X_SIZEX = program.WINDOW_WIDTH/X_WIDTH_FACTOR;
	private final double X_SIZEY = program.WINDOW_HEIGHT/X_HEIGHT_FACTOR;
	
	private GButton leftKeyButton;
	private GButton rightKeyButton;
	private GButton jumpKeyButton;
	private GButton attackKeyButton;
	private GButton pauseKeyButton;
	
	private static final double BUTTON_WIDTH_FACTOR = 5.54;
	private static final double BUTTON_HEIGHT_FACTOR = 17.07;
	private static final double BUTTON_XCORD_FACTOR = 2.84;
	private static final double BUTTON_YCORD_FACTOR = 3.01;
	private final double BUTTON_XCORD= program.WINDOW_WIDTH/BUTTON_XCORD_FACTOR;
	private final double BUTTON_YCORD = program.WINDOW_HEIGHT/BUTTON_YCORD_FACTOR;
	private final double BUTTON_SIZEX = program.WINDOW_WIDTH/BUTTON_WIDTH_FACTOR;
	private final double BUTTON_SIZEY = program.WINDOW_HEIGHT/BUTTON_HEIGHT_FACTOR;
	
//	private final String moveLeftKey;
//	private final String moveRightKey;
//	private final String jumpKey;
//	private final String attackKey;
//	private final String pauseKey;
	
 
	public Controls(MainApplication app) {
		program = app;
		background = new GImage("images/Background Control Settings.png", 0, 0);
		xButton = new GButton(X_XCORD, X_YCORD, X_SIZEX, X_SIZEY, false);
		leftKeyButton = new GButton(BUTTON_XCORD, BUTTON_YCORD, BUTTON_SIZEX, BUTTON_SIZEY, false);
		
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(xButton);
		program.add(leftKeyButton);
	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(xButton);
		program.remove(leftKeyButton);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == xButton){
			program.switchToMenu();
		}
	}
	
	
	
	
	
}
