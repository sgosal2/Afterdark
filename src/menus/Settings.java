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
	private GButton musicButton;
	private GButton soundEffectsButton;
	private GButton difficultyButton;
	public static final double MUSIC_WIDTH_FACTOR = 2.41;
	public static final double MUSIC_HEIGHT_FACTOR = 4.52;
	public static final double BOX_FACTOR = 29.26;
	public static final double SOUND_EFFECTS_WIDTH = 1.35;
	public static final double SOUND_EFFECTS_HEIGHT = 4.52;
	public static final double EASY_DIFF_W = 2.2;
	public static final double EASY_DIFF_H = 3.3;



	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GImage background;

	public Settings(MainApplication app) {
		program = app;
		background = new GImage("images/Settings.png", 0, 0);
//public GButton(String label, double x, double y, double width, double height, Color col)
		musicButton = new GButton("X",program.WINDOW_WIDTH/MUSIC_WIDTH_FACTOR,
								program.WINDOW_HEIGHT/MUSIC_HEIGHT_FACTOR,
								program.WINDOW_WIDTH/BOX_FACTOR,
								program.WINDOW_HEIGHT/BOX_FACTOR, Color.GREEN);
		soundEffectsButton = new GButton("X", program.WINDOW_WIDTH/SOUND_EFFECTS_WIDTH,
								program.WINDOW_HEIGHT/SOUND_EFFECTS_HEIGHT, 
								program.WINDOW_WIDTH/BOX_FACTOR, 
								program.WINDOW_HEIGHT/BOX_FACTOR, 
								Color.GREEN);
		difficultyButton = new GButton("EASY", program.WINDOW_WIDTH/EASY_DIFF_W,
										program.WINDOW_HEIGHT/EASY_DIFF_H, 
										program.WINDOW_WIDTH/BOX_FACTOR,
										program.WINDOW_HEIGHT/BOX_FACTOR,
										Color.GREEN);
		
		
		
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(musicButton);
		program.add(soundEffectsButton);

	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(musicButton);
		program.remove(soundEffectsButton);
		
	
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
