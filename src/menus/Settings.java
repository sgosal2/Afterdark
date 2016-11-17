package menus;
import java.awt.Color;

import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import utilities.GButton;
import utilities.GraphicsPane;
import utilities.MainApplication;

// Settings class

/*
 * Settings will hold our settings for if the game sound is on or off as well as the music. 
 * Volume will be up to the hardware of the device the user is playing on.
 */
public class Settings extends GraphicsPane {

	private boolean isMusicOn = true;
	private boolean isSoundOn = true;



	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GImage background;

	public Settings(MainApplication app) {
		program = app;
		background = new GImage("images/Settings.png", 0, 0);
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


	public boolean getIsMusicOn(){
		return isMusicOn;
	}

	public boolean getIsSoundOn(){
		return isSoundOn;
	}

	public void setIsSoundOn(boolean s){
		isSoundOn = s;
	}

	public void setIsMusicOn(boolean m){
		isMusicOn = m;
	}

	public void getDifficultLevel(){

	}

	public void setDifficultyLevel(String s){

	}

	public void settingsMenu(){

	}

	public void settingsPause(){

	}
}
