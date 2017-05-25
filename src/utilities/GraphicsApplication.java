package utilities;


import java.awt.event.KeyEvent;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import acm.program.GraphicsProgram;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import utilities.GraphicsPane;

public abstract class GraphicsApplication extends GraphicsProgram {
	private GraphicsPane curScreen;
	
	public GraphicsApplication() {
		super();
	}
	
	/* switchToScreen(newGraphicsPane)
	 * -------------------------------
	 * will simply switch from making one pane that was currently
	 * active, to making another one that is the active class.
	 */
	protected void switchToScreen(GraphicsPane newScreen) {
		if(curScreen != null) {
			curScreen.hideContents();
		}
		newScreen.showContents();
		newScreen.run();
		curScreen = newScreen;
	}
	
	/*
	 * These methods just override the basic
	 * mouse listeners to pass any information that
	 * was given to the application to a particular screen.
	 */
	public void actionPerformed(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mousePressed(e);
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mousePressed(e);
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseReleased(e);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseClicked(e);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseDragged(e);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseMoved(e);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(curScreen != null) {
			curScreen.keyPressed(e);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(curScreen != null) {
			curScreen.keyReleased(e);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(curScreen != null) {
			curScreen.keyTyped(e);
		}
	}
}
