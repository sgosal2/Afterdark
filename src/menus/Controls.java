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
	private static final double NEXT_BUTTON_OFFSET = 62;
	
//	private final String moveLeftKey;
//	private final String moveRightKey;
//	private final String jumpKey;
//	private final String attackKey;
//	private final String pauseKey;
	
 
	public Controls(MainApplication app) {
		program = app;
		background = new GImage("images/Background Control Settings.png", 0, 0);
		xButton = new GButton(X_XCORD, X_YCORD, X_SIZEX, X_SIZEY, false);
		leftKeyButton = new GButton("left arrow", BUTTON_XCORD, BUTTON_YCORD, BUTTON_SIZEX, BUTTON_SIZEY, true);
		rightKeyButton = new GButton("right arrow", BUTTON_XCORD, (BUTTON_YCORD + NEXT_BUTTON_OFFSET), BUTTON_SIZEX, BUTTON_SIZEY, true);
		jumpKeyButton = new GButton("spacebar", BUTTON_XCORD, (BUTTON_YCORD + (2*NEXT_BUTTON_OFFSET)), BUTTON_SIZEX, BUTTON_SIZEY, true);
		attackKeyButton = new GButton("enter", BUTTON_XCORD, (BUTTON_YCORD + (3*NEXT_BUTTON_OFFSET)), BUTTON_SIZEX, BUTTON_SIZEY, true);
		pauseKeyButton = new GButton("p", BUTTON_XCORD, (BUTTON_YCORD + (4*NEXT_BUTTON_OFFSET)), BUTTON_SIZEX, BUTTON_SIZEY, true);

		
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(xButton);
		program.add(leftKeyButton);
		program.add(rightKeyButton);
		program.add(jumpKeyButton);
		program.add(attackKeyButton);
		program.add(pauseKeyButton);
	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(xButton);
		program.remove(leftKeyButton);
		program.remove(rightKeyButton);
		program.remove(jumpKeyButton);
		program.remove(attackKeyButton);
		program.remove(pauseKeyButton);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == xButton){
			program.switchToMenu();
		}
	}
	
	
	
	
	
}
