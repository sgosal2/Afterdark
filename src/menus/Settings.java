package menus;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import game.Difficulty;
import utilities.AudioPlayer;
import utilities.GButton;
import utilities.GraphicsPane;
import utilities.MainApplication;

// Settings class

/*
 * PSUEDO CODE FOR MUSIC INSTRUCTIONS
 * 
 * Create new button for music instructions
 * 
 * initalize button with instructions inside
 * 
 * show contents of button
 */


/*
 * Settings will hold our settings for the game. 
 * Volume will be determined by the user.
 */
public class Settings extends GraphicsPane {

	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	
	private GButton musicButtonON;
	private GButton musicButtonOFF;
	private GButton soundEffectsButtonOn;
	private GButton soundEffectsButtonOff;
	private GButton easyButton;
	private GButton mediumButton;
	private GButton hardButton;
	private GButton controlsButton;
	private GButton playButton;
	private GButton xButton;
	
	private static final String PURPLE = ("#e23fff");
	
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
	public static final double CONTROLS_X_FACTOR = 25.6;
	public static final double CONTROLS_Y_FACTOR = 5.5;
	private static final double OTHER_SIZE_HEIGHT = 19.2;
	private static final double OTHER_SIZE_WIDTH = 4.57;
	
	private static final double WIDTH_FACTOR = 25.6;
	private static final double PLAY_HEIGHT_FACTOR = 24;
	private static final double PLAY_SIZE_WIDTH = 4.68;
	private static final double PLAY_SIZE_HEIGHT = 10.97;

	private static final double X_WIDTH_FACTOR = 34.13;
	private static final double X_HEIGHT_FACTOR = 25.6;
	private static final double X_XCORD_FACTOR = 1.29;
	private static final double X_YCORD_FACTOR = 5.37;
	private final double X_XCORD= program.WINDOW_WIDTH/X_XCORD_FACTOR;
	private final double X_YCORD = program.WINDOW_HEIGHT/X_YCORD_FACTOR;
	private final double X_SIZEX = program.WINDOW_WIDTH/X_WIDTH_FACTOR;
	private final double X_SIZEY = program.WINDOW_HEIGHT/X_HEIGHT_FACTOR;

	private GImage background;
	private AudioPlayer music;

	/*
	 * Creating various buttons below and adding them to the settings pane.
	 * Each button is made in such a way that as the background image 
	 * expands the buttons will too.
	 */
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
		turnMusicOnOff();
		turnSoundOnOff();
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
		controlsButton = new GButton(program.WINDOW_WIDTH/CONTROLS_X_FACTOR, 
								program.WINDOW_HEIGHT/CONTROLS_Y_FACTOR, 
								program.WINDOW_WIDTH/OTHER_SIZE_WIDTH, 
								program.WINDOW_HEIGHT/OTHER_SIZE_HEIGHT, false);
		playButton = new GButton(program.WINDOW_WIDTH/WIDTH_FACTOR, 
								program.WINDOW_HEIGHT/PLAY_HEIGHT_FACTOR, 
								program.WINDOW_WIDTH/PLAY_SIZE_WIDTH, 
								program.WINDOW_HEIGHT/PLAY_SIZE_HEIGHT, false);
		xButton = new GButton("X", X_XCORD, X_YCORD, X_SIZEX, X_SIZEY, false);
		music = AudioPlayer.getInstance();
	}
	
	@Override
	/*
	 * Adding the various items to the screen
	 */
	public void showContents() {
		program.add(background);
		program.add(musicButtonON);
		program.add(musicButtonOFF);
		program.add(soundEffectsButtonOn);
		program.add(soundEffectsButtonOff);
		program.add(easyButton);
		program.add(mediumButton);
		program.add(hardButton);
		program.add(controlsButton);
		program.add(playButton);	
		program.add(xButton);
		
		turnMusicOnOff();
		turnSoundOnOff();
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
		program.remove(controlsButton);
		program.remove(playButton);
		program.remove(xButton);
	}

	@Override
	/*
	 * This method does the appropriate task depending on what
	 * button the user clicks on.
	 */
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == controlsButton){
			program.switchToControlsMenu();
		}
		if(obj == playButton){
			program.switchToGame();
		}
		if(obj == xButton){
			program.switchToMenu();
		}
		
		//the checks below activate the corresponding buttons and 
		//change the look of the buttons also
		
		if(obj == musicButtonON){
			musicButtonON.setFillColor(Color.decode("#e23fff"));
			musicButtonOFF.setFillColor(Color.DARK_GRAY);
			music.playSound("../sounds", "menu_music.mp3");
			program.setMusicIsOn(true);
		}
		if(obj == musicButtonOFF){
			musicButtonOFF.setFillColor(Color.decode("#e23fff"));
			musicButtonON.setFillColor(Color.DARK_GRAY);
			music.stopSound("../sounds", "menu_music.mp3");
			//if off is clicked change to false
			program.setMusicIsOn(false);
		}
		
		if(obj == soundEffectsButtonOn){
			soundEffectsButtonOn.setFillColor(Color.decode("#e23fff"));
			soundEffectsButtonOff.setFillColor(Color.DARK_GRAY);
			program.setSoundIsOn(true);
		}
		if(obj == soundEffectsButtonOff){
			soundEffectsButtonOff.setFillColor(Color.decode("#e23fff"));
			soundEffectsButtonOn.setFillColor(Color.DARK_GRAY);
			program.setSoundIsOn(false);
		}
		if(obj == easyButton){
			easyButton.setFillColor(Color.decode("#e23fff"));
			mediumButton.setFillColor(Color.DARK_GRAY);
			hardButton.setFillColor(Color.DARK_GRAY);
			program.setDifficulty(Difficulty.EASY);
		}
		if(obj == mediumButton){
			mediumButton.setFillColor(Color.decode("#e23fff"));
			easyButton.setFillColor(Color.DARK_GRAY);
			hardButton.setFillColor(Color.DARK_GRAY);
			program.setDifficulty(Difficulty.MEDIUM);
		}
		if(obj == hardButton){
			hardButton.setFillColor(Color.decode("#e23fff"));
			easyButton.setFillColor(Color.DARK_GRAY);
			mediumButton.setFillColor(Color.DARK_GRAY);
			program.setDifficulty(Difficulty.HARD);
		}
		
	}
	/*
	 * When various keys are pressed throughout the game different
	 * actions will be performed, such as turning the music on or off.
	 */
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_X){
			program.switchToMenu();
		}

		// User presses M: turns default game music on
		if(e.getKeyCode() == KeyEvent.VK_M){
			program.setMusicIsOn(true);
			music.playSound("../sounds", "menu_music.mp3");
			program.switchToSettingsMenu();
		}
		
		//User presses B: turns music off
		if(e.getKeyCode() == KeyEvent.VK_B){
			program.setMusicIsOn(false);
			music.stopSound("../sounds", "menu_music.mp3");
			program.switchToSettingsMenu();
		}
		
		// User presses V: turns sound on or off
		if(e.getKeyCode() == KeyEvent.VK_V){
			if(program.isSoundOn() == true){
				program.setSoundIsOn(false);
			}
			else{
				program.setSoundIsOn(true);
			}
			program.switchToSettingsMenu();
		}
	}
	/*
	 * This method is in charge of setting the music boolean to true
	 * or false and also changes the various colors of the button
	 * to represent which option is active.
	 */
	public void turnMusicOnOff(){
		if(program.isMusicOn() == true){
			musicButtonON.setFillColor(Color.decode(PURPLE));
			musicButtonOFF.setFillColor(Color.DARK_GRAY);
		}
		else {
			musicButtonON.setFillColor(Color.DARK_GRAY);
			musicButtonOFF.setFillColor(Color.decode(PURPLE));
		}
	}

	/*
	 * This method is in charge of setting the sound boolean to true
	 * or false and also changes the various colors of the button
	 * to represent which option is active.
	 */
	public void turnSoundOnOff(){
		if(program.isSoundOn() == true){
			soundEffectsButtonOn.setFillColor(Color.decode(PURPLE));
			soundEffectsButtonOff.setFillColor(Color.DARK_GRAY);
		}
		else {
			soundEffectsButtonOn.setFillColor(Color.DARK_GRAY);
			soundEffectsButtonOff.setFillColor(Color.decode(PURPLE));
		}
	}

	public void getDifficultLevel(){

	}

	public void setDifficultyLevel(String s){

	}

}
