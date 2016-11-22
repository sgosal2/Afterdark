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
	private GButton musicButtonON;
	private GButton musicButtonOFF;
	private GButton soundEffectsButtonOn;
	private GButton soundEffectsButtonOff;
	private GButton easyButton;
	private GButton mediumButton;
	private GButton hardButton;
	
	public static final double MUSIC_WIDTH_FACTOR_Y = 2.41;
	public static final double MUSIC_HEIGHT_FACTOR_Y = 4.52;
	public static final double MUSIC_WIDTH_FACTOR_N = 2.06;
	public static final double MUSIC_HEIGHT_FACTOR_N = 4.52;
	public static final double BOX_FACTOR = 29.26;
	public static final double SOUND_EFFECTS_BOX_FACTOR = 33;
	public static final double SOUND_EFFECTS_WIDTH_ON = 1.35;
	public static final double SOUND_EFFECTS_WIDTH_OFF = 1.275;
	public static final double SOUND_EFFECTS_HEIGHT = 4.52;
	public static final double EASY_DIFF_W = 2.2;
	public static final double EASY_DIFF_H = 3.35;
	public static final double MEDIUM_DIFF_W = 1.93;
	public static final double MEDIUM_DIFF_H = 3.35;
	public static final double MEDIUM_BOX_FACTOR = 23;
	public static final double HARD_DIFF_W = 1.68;
	public static final double HARD_DIFF_H = 3.35;



	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GImage background;

	public Settings(MainApplication app) {
		program = app;
		background = new GImage("images/Settings.png", 0, 0);
		musicButtonON = new GButton("ON",program.WINDOW_WIDTH/MUSIC_WIDTH_FACTOR_Y,
								program.WINDOW_HEIGHT/MUSIC_HEIGHT_FACTOR_Y,
								program.WINDOW_WIDTH/BOX_FACTOR,
								program.WINDOW_HEIGHT/BOX_FACTOR, Color.DARK_GRAY);
		musicButtonOFF = new GButton("OFF", program.WINDOW_WIDTH/MUSIC_WIDTH_FACTOR_N,
								program.WINDOW_HEIGHT/MUSIC_HEIGHT_FACTOR_N,
								program.WINDOW_WIDTH/BOX_FACTOR,
								program.WINDOW_HEIGHT/BOX_FACTOR, Color.DARK_GRAY);
		soundEffectsButtonOn = new GButton("ON", program.WINDOW_WIDTH/SOUND_EFFECTS_WIDTH_ON,
								program.WINDOW_HEIGHT/SOUND_EFFECTS_HEIGHT, 
								program.WINDOW_WIDTH/SOUND_EFFECTS_BOX_FACTOR, 
								program.WINDOW_HEIGHT/SOUND_EFFECTS_BOX_FACTOR, 
								Color.DARK_GRAY);
		soundEffectsButtonOff = new GButton("OFF",program.WINDOW_WIDTH/SOUND_EFFECTS_WIDTH_OFF,
								program.WINDOW_HEIGHT/SOUND_EFFECTS_HEIGHT, 
								program.WINDOW_WIDTH/SOUND_EFFECTS_BOX_FACTOR, 
								program.WINDOW_HEIGHT/SOUND_EFFECTS_BOX_FACTOR, 
								Color.DARK_GRAY);
		easyButton = new GButton("EASY", program.WINDOW_WIDTH/EASY_DIFF_W,
								program.WINDOW_HEIGHT/EASY_DIFF_H, 
								program.WINDOW_WIDTH/BOX_FACTOR,
								program.WINDOW_HEIGHT/BOX_FACTOR,
								Color.DARK_GRAY);
		mediumButton = new GButton("MEDIUM", program.WINDOW_WIDTH/MEDIUM_DIFF_W, 
									program.WINDOW_HEIGHT/MEDIUM_DIFF_H, 
									program.WINDOW_WIDTH/MEDIUM_BOX_FACTOR, 
									program.WINDOW_HEIGHT/BOX_FACTOR, 
									Color.DARK_GRAY);
		hardButton = new GButton("HARD",program.WINDOW_WIDTH/HARD_DIFF_W,
									program.WINDOW_HEIGHT/HARD_DIFF_H,
									program.WINDOW_WIDTH/BOX_FACTOR,
									program.WINDOW_HEIGHT/BOX_FACTOR,
									Color.DARK_GRAY);
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(musicButtonON);
		program.add(musicButtonOFF);
		program.add(soundEffectsButtonOn);
		program.add(soundEffectsButtonOff);
		program.add(easyButton);
		program.add(mediumButton);
		program.add(hardButton);
	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(musicButtonON);
		program.remove(musicButtonOFF);
		program.remove(soundEffectsButtonOn);
		program.remove(soundEffectsButtonOff);
		program.remove(easyButton);
		program.remove(mediumButton);
		program.remove(hardButton);
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
