package menus;

import acm.graphics.GLabel;
import acm.graphics.GObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import utilities.GButton;
import utilities.GraphicsPane;
import utilities.MainApplication;


public class GameWon extends GraphicsPane {
	private GButton returnToMain;
	private GLabel congratMessage;
	private MainApplication program;
	
	public GameWon(MainApplication main){
		program = main;
		returnToMain = new GButton("Return to Main", (double) MainApplication.WINDOW_WIDTH / 5 + 100, (double) MainApplication.WINDOW_HEIGHT / 10, 400, 100, Color.DARK_GRAY);
		returnToMain.setColor(Color.WHITE);
		congratMessage = new GLabel("Congratulations you beat the Level!", MainApplication.WINDOW_WIDTH / 5, MainApplication.WINDOW_HEIGHT / 3 + 20);
		congratMessage.setFont("Comic Sans MS-36");
		congratMessage.setColor(Color.WHITE);
	}

	public void mousePressed(MouseEvent e){
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == returnToMain){
			program.resetGame();
			program.switchToMenu();
		}
	}

	@Override
	public void showContents() {
		program.add(returnToMain);
		program.add(congratMessage);
		program.setBackground(Color.DARK_GRAY);
		
	}

	@Override
	public void hideContents() {
		program.setBackground(null);
		program.remove(returnToMain);
		program.remove(congratMessage);
		
	}

}
