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


 
	public Controls(MainApplication app) {
		program = app;
		background = new GImage("images/Background Control Settings.png", 0, 0);
		xButton = new GButton(X_XCORD, X_YCORD, X_SIZEX, X_SIZEY, false);
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(xButton);
	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.add(xButton);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == xButton){
			program.switchToMenu();
		}
	}
}
