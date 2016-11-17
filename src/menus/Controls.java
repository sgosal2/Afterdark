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

 
	public Controls(MainApplication app) {
		program = app;
		background = new GImage("images/Background Control Settings.png", 0, 0);
	}
	
	@Override
	public void showContents() {
		program.add(background);
	}

	@Override
	public void hideContents() {
		program.remove(background);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		
	}
}
