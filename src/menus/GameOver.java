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
	
	public GameOver(MainApplication main) {
		program = main;
		gameOver = new GLabel("Game Over", MainApplication.WINDOW_WIDTH / 2 - 10, MainApplication.WINDOW_HEIGHT / 2 + 20);
		methodOfDeath = new GLabel("", MainApplication.WINDOW_WIDTH / 2 - 10, MainApplication.WINDOW_HEIGHT / 2);
		returnToHome = new GButton("Return to Main", (double) MainApplication.WINDOW_WIDTH / 2 - 10, (double) MainApplication.WINDOW_HEIGHT / 10, 20.0, 12.0, Color.BLUE);
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
