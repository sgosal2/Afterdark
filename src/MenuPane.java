// Sahib Gosal.
// Ali Noorani

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;

public class MenuPane extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GImage background;
	
	public MenuPane(MainApplication app) {
		program = app;
		background = new GImage("images/Main Menu.png", 0, 0);
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
		if(obj == background) {
			program.switchToSome();
		}
	}
}
