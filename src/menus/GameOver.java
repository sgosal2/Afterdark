package menus;

import acm.graphics.GLabel;
import acm.graphics.GObject;

import java.awt.Color;
import java.awt.event.MouseEvent;

import utilities.GButton;
import utilities.GraphicsPane;
import utilities.MainApplication;

public class GameOver extends GraphicsPane {
	private GLabel methodOfDeath;
	private GLabel gameOver;
	private GButton returnToHome;
	private MainApplication program;
	
	/*
	 * This is the constructor that adds the various buttons and labels to
	 * our screen in the correct positions.
	 */
	public GameOver(MainApplication main) {
		program = main;
		returnToHome = new GButton("Return to Main", (double) MainApplication.WINDOW_WIDTH / 4 + 50, (double) MainApplication.WINDOW_HEIGHT / 10, 400, 100, Color.DARK_GRAY);
		returnToHome.setColor(Color.WHITE);
		methodOfDeath = new GLabel("", MainApplication.WINDOW_WIDTH / 3 - 40, MainApplication.WINDOW_HEIGHT / 3);
		methodOfDeath.setFont("Sans Serif-30");
		gameOver = new GLabel("Game Over!", MainApplication.WINDOW_WIDTH / 3 + 20, MainApplication.WINDOW_HEIGHT / 2 + 20);
		gameOver.setFont("Comic Sans MS-60");
		
		
	}
	
	public void setDeath(String death) {
		methodOfDeath.setLabel(death);
	}
	
	public String getDeath() {
		return methodOfDeath.getLabel();
	}
	
	@Override
	public void showContents() {
		program.setBackground(Color.DARK_GRAY);
		program.add(methodOfDeath);
		program.add(gameOver);
		program.add(returnToHome);
	}
	
	/*
	 * This method will take in the click of the mouse, find its location
	 * and then see if it is on a particular button. If the mouse clicks
	 * on the button then the screen will change.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == returnToHome) {
			program.resetGame();
			program.switchToMenu();
		}
	}

	@Override
	public void hideContents() {
		program.remove(methodOfDeath);
		program.remove(gameOver);
		program.remove(returnToHome);
	}

}
