package menus;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import utilities.GButton;
import utilities.GraphicsPane;
import utilities.MainApplication;

public class pauseControlsMenu extends GraphicsPane{
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private Settings setting;
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
	
	private static final String MOVE_LEFT_KEY = "Left Arrow/A";
	private static final String MOVE_RIGHT_KEY = "Right Arrow/D";
	private static final String JUMP_KEY = "Up Arrow/Space/W";
	private static final String ATTACK_KEY = "Enter/V";
	private static final String PAUSE_KEY = "P/Esc";
	
	private static final double BUTTON_WIDTH_FACTOR = 5.54;
	private static final double BUTTON_HEIGHT_FACTOR = 17.07;
	private static final double BUTTON_XCORD_FACTOR = 2.84;
	private static final double BUTTON_YCORD_FACTOR = 3.77;
	private final double BUTTON_XCORD= program.WINDOW_WIDTH/BUTTON_XCORD_FACTOR;
	private final double BUTTON_YCORD = program.WINDOW_HEIGHT/BUTTON_YCORD_FACTOR;
	private final double BUTTON_SIZEX = program.WINDOW_WIDTH/BUTTON_WIDTH_FACTOR;
	private final double BUTTON_SIZEY = program.WINDOW_HEIGHT/BUTTON_HEIGHT_FACTOR;
	private static final double NEXT_BUTTON_OFFSET = 62;

	
	/*
	 * Creating various buttons below and adding them to the controls pane
	 * that will show up when the game is paused.
	 * Each button is made in such a way that as the background image 
	 * expands the buttons will too.
	 */
	public pauseControlsMenu(MainApplication app) {
		program = app;
		background = new GImage("images/Pause Controls.png", 0, 0);
		xButton = new GButton(X_XCORD, X_YCORD, X_SIZEX, X_SIZEY, false);
		leftKeyButton = new GButton(MOVE_LEFT_KEY, BUTTON_XCORD, BUTTON_YCORD, BUTTON_SIZEX, BUTTON_SIZEY, true);
		rightKeyButton = new GButton(MOVE_RIGHT_KEY, BUTTON_XCORD, (BUTTON_YCORD + NEXT_BUTTON_OFFSET), BUTTON_SIZEX, BUTTON_SIZEY, true);
		jumpKeyButton = new GButton(JUMP_KEY, BUTTON_XCORD, (BUTTON_YCORD + (2*NEXT_BUTTON_OFFSET)), BUTTON_SIZEX, BUTTON_SIZEY, true);
		attackKeyButton = new GButton(ATTACK_KEY, BUTTON_XCORD, (BUTTON_YCORD + (3*NEXT_BUTTON_OFFSET)), BUTTON_SIZEX, BUTTON_SIZEY, true);
		pauseKeyButton = new GButton(PAUSE_KEY, BUTTON_XCORD, (BUTTON_YCORD + (4*NEXT_BUTTON_OFFSET)), BUTTON_SIZEX, BUTTON_SIZEY, true);
	}
	
	@Override
	/*
	 * Adding the various items to the screen
	 */
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

	/*
	 * When various keys are pressed throughout the game different
	 * actions will be performed, which in this case is a switch to the
	 * pause menu.
	 */
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_X || e.getKeyCode() == KeyEvent.VK_ESCAPE){
			program.switchToPauseMenu();
		}
	}
	@Override
	/*
	 * This method does the appropriate task depending on what
	 * button the user clicks on.
	 */
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == xButton){
			program.switchToPauseMenu();
		}
	}
}