package menus;

import acm.graphics.GLabel;
import acm.graphics.GObject;

import java.awt.Color;
import java.awt.event.MouseEvent;

import utilities.GButton;
import utilities.GraphicsPane;
import utilities.MainApplication;

/*
 * This is the pane that shows up if the player has lost the game
 * Ways to lose the game: Fall of an edge and fall to your death or have an enemy hit you until you die
 */
public class GameOver extends GraphicsPane {
	private GLabel methodOfDeath;
	private GLabel gameOver;
	private GButton returnToHome;
	private MainApplication program;
	
	
//	Makes new buttons and labels for this pane
	public GameOver(MainApplication main) {
		program = main;
		returnToHome = new GButton("Return to Main", (double) MainApplication.WINDOW_WIDTH / 4 + 50, (double) MainApplication.WINDOW_HEIGHT / 10, 400, 100, Color.DARK_GRAY);
		returnToHome.setColor(Color.WHITE);
		methodOfDeath = new GLabel("", MainApplication.WINDOW_WIDTH / 3 - 40, MainApplication.WINDOW_HEIGHT / 3);
		methodOfDeath.setFont("Sans Serif-30");
		methodOfDeath.setColor(Color.WHITE);
		gameOver = new GLabel("Game Over!", MainApplication.WINDOW_WIDTH / 3 + 20, MainApplication.WINDOW_HEIGHT / 2 + 20);
		gameOver.setFont("Comic Sans MS-60");
		gameOver.setColor(Color.WHITE);
		
		
	}
	
	public void setDeath(String death) {
		methodOfDeath.setLabel(death);
	}
	
	public String getDeath() {
		return methodOfDeath.getLabel();
	}
	
	
//	Shows the content for this pane
	@Override
	public void showContents() {
		program.setBackground(Color.DARK_GRAY);
		program.add(methodOfDeath);
		program.add(gameOver);
		program.add(returnToHome);
	}
	
	
//	If the user presses this butotn, it will take them to the menu
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == returnToHome) {
			program.resetGame();
			program.switchToMenu();
		}
	}

//	Hides the contents when you leave the page.
	@Override
	public void hideContents() {
		program.setBackground(null);
		program.remove(methodOfDeath);
		program.remove(gameOver);
		program.remove(returnToHome);
	}

}
