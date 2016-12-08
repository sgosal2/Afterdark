package menus;

import acm.graphics.GLabel;
import acm.graphics.GObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import utilities.GButton;
import utilities.GraphicsPane;
import utilities.MainApplication;

/*
 * This is a pane that shows up when the player has won the game! The only way the user can win the game is 
 * if the user passes the level.
 */
public class GameWon extends GraphicsPane {
	private GButton returnToMain;
	private GLabel congratMessage;
	private MainApplication program;
	
//	Adds buttons and labels on the screen that is shows
	public GameWon(MainApplication main){
		program = main;
		returnToMain = new GButton("Return to Main", (double) MainApplication.WINDOW_WIDTH / 5 + 100, (double) MainApplication.WINDOW_HEIGHT / 10, 400, 100, Color.DARK_GRAY);
		returnToMain.setColor(Color.WHITE);
		congratMessage = new GLabel("Congratulations you beat the Level!", MainApplication.WINDOW_WIDTH / 5, MainApplication.WINDOW_HEIGHT / 3 + 20);
		congratMessage.setFont("Comic Sans MS-36");
		congratMessage.setColor(Color.WHITE);
	}

//	If the user clicks on the button, it takes it to the location it needs to go
//	In this case, it goes back to menu
	public void mousePressed(MouseEvent e){
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == returnToMain){
			program.resetGame();
			program.switchToMenu();
		}
	}

	
//	Shows all buttons and labels made for this class
	@Override
	public void showContents() {
		program.add(returnToMain);
		program.add(congratMessage);
		program.setBackground(Color.DARK_GRAY);
		
	}

//	Hides all buttons and labels made for this class
	@Override
	public void hideContents() {
		program.setBackground(null);
		program.remove(returnToMain);
		program.remove(congratMessage);
		
	}

}
