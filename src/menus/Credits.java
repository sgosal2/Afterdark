package menus;
/*
 * This is a credits screen. All this class has is a few GLabels, a GImage, and a GButton that sends you back to the menu.
 * The GLabels are just the contributors names and the GImage is a picture of our group.
 */

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import utilities.GButton;
import utilities.GraphicsPane;
import utilities.MainApplication;

public class Credits extends GraphicsPane{
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	
	private final String FONT = "Sans Serif-50";

	
	private GLabel JackCredit;
	private GLabel AliCredit;
	private GLabel MaxCredit;
	private GLabel SahibCredit;
	private GLabel CreditTitle;
	
	private GButton returnToMenu;
	private GImage background;

	
//	Constructor that sets up all GLabels, background, GImage, and GButton for this screen.
	public Credits(MainApplication app) {
		program = app;
		background = new GImage("images/Group picture.jpg", 450, 200);
		background.setSize(5312/10, 2988/10);
		CreditTitle = new GLabel("Credits", 50, 100);
		CreditTitle.setFont("Sans Serif-100");
		CreditTitle.setColor(Color.WHITE);
		JackCredit = new GLabel("Jack Thias", MainApplication.WINDOW_WIDTH /3 - 200, MainApplication.WINDOW_HEIGHT / 3);
		JackCredit.setFont(FONT);
		JackCredit.setColor(Color.WHITE);
		AliCredit = new GLabel("Ali Noorani", MainApplication.WINDOW_WIDTH /3 - 200, MainApplication.WINDOW_HEIGHT / 3 + 50);
		AliCredit.setFont(FONT);
		AliCredit.setColor(Color.WHITE);
		MaxCredit = new GLabel("Max Macchi", MainApplication.WINDOW_WIDTH /3 - 200, MainApplication.WINDOW_HEIGHT / 3 + 100);
		MaxCredit.setFont(FONT);
		MaxCredit.setColor(Color.WHITE);
		SahibCredit = new GLabel("Sahib Gosal", MainApplication.WINDOW_WIDTH /3 - 200, MainApplication.WINDOW_HEIGHT / 3 + 150);
		SahibCredit.setFont(FONT);
		SahibCredit.setColor(Color.WHITE);
		returnToMenu = new GButton("Return to Main Menu", (double) MainApplication.WINDOW_WIDTH / 5 + 100, (double) MainApplication.WINDOW_HEIGHT / 1.25, 400, 100, Color.DARK_GRAY);
	}
	
// If the user presses the return to menu button, it will detect it and change screens
	public void mousePressed(MouseEvent e){
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == returnToMenu){
			program.switchToMenu();
		}
	}
	
	@Override
	/*
	 * Adding the various items to the screen
	 */
	public void showContents() {
		program.setBackground(Color.DARK_GRAY);
		program.add(background);
		program.add(CreditTitle);
		program.add(JackCredit);
		program.add(AliCredit);
		program.add(MaxCredit);
		program.add(SahibCredit);
		program.add(returnToMenu);
	}

	@Override
	public void hideContents() {
		program.setBackground(null);
		program.remove(background);
		program.remove(CreditTitle);
		program.remove(JackCredit);
		program.remove(AliCredit);
		program.remove(MaxCredit);
		program.remove(SahibCredit);
		program.remove(returnToMenu);
	}

	
}
