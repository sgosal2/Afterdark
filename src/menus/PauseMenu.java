package menus;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import utilities.GButton;
import utilities.GraphicsPane;
import utilities.MainApplication;

public class PauseMenu extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GImage background;
	private GButton resumeButton;
	private GButton exitToMenuButton;
	private GButton exitGameButton;
	private GButton controlsButton;
	private GButton musicButtonON;
	private GButton musicButtonOFF;
	private GButton soundEffectsON;
	private GButton soundEffectsOFF;
	
	public static final double WIDTH_OFFSET = 51.2;
	public static final double RG_HEIGHT_OFFSET = 8.53;
	public static final double RG_WIDTH = 3.9;
	public static final double RG_HEIGHT = 19.2;
	
	public static final double EM_HEIGHT_OFFSET = 5.7;
	public static final double EM_WIDTH = 4.4;
	public static final double EM_HEIGHT = 19.2;
	
	public static final double EG_HEIGHT_OFFSET = 4.3;
	public static final double EG_WIDTH = 5.4;
	public static final double EG_HEIGHT = 19.2;
	
	public static final double C_HEIGHT_OFFSET = 3.4;
	public static final double C_WIDTH = 6.61;
	public static final double C_HEIGHT = 25;
	
	public static final double BOX_FACTOR = 29.26;
	public static final double MUSIC_BUTTON_WIDTH_ON = 9.8;
	public static final double MUSIC_BUTTON_WIDTH_OFF = 6.6;
	public static final double MUSIC_BUTTON_HEIGHT = 2.4;
	
	public static final double SOUND_BUTTON_WIDTH_ON = 2.3;
	public static final double SOUND_BUTTON_WIDTH_OFF = 2.1;
	public static final double SOUND_BUTTON_HEIGHT = 2.4;
	
	
	public PauseMenu(MainApplication app) {
		program = app;
		background = new GImage("Pause.png", 0, 0);
		resumeButton = new GButton(program.WINDOW_WIDTH/WIDTH_OFFSET, 
				program.WINDOW_HEIGHT/RG_HEIGHT_OFFSET,
				program.WINDOW_WIDTH/RG_WIDTH, 
				program.WINDOW_HEIGHT/RG_HEIGHT, false);
		exitToMenuButton = new GButton(program.WINDOW_WIDTH/WIDTH_OFFSET, 
				program.WINDOW_HEIGHT/EM_HEIGHT_OFFSET, 
				program.WINDOW_WIDTH/EM_WIDTH, 
				program.WINDOW_HEIGHT/EM_HEIGHT, false);
		exitGameButton = new GButton(program.WINDOW_WIDTH/WIDTH_OFFSET, 
				program.WINDOW_HEIGHT/EG_HEIGHT_OFFSET, 
				program.WINDOW_WIDTH/EG_WIDTH, 
				program.WINDOW_HEIGHT/EG_HEIGHT, false);
		controlsButton = new GButton(program.WINDOW_WIDTH/WIDTH_OFFSET, 
				program.WINDOW_HEIGHT/C_HEIGHT_OFFSET, 
				program.WINDOW_WIDTH/C_WIDTH, 
				program.WINDOW_WIDTH/C_HEIGHT, false);
		musicButtonON = new GButton("ON", program.WINDOW_WIDTH/MUSIC_BUTTON_WIDTH_ON, 
				program.WINDOW_HEIGHT/MUSIC_BUTTON_HEIGHT, 
				program.WINDOW_WIDTH/BOX_FACTOR, 
				program.WINDOW_HEIGHT/BOX_FACTOR, Color.DARK_GRAY);
		musicButtonOFF = new GButton("OFF", program.WINDOW_WIDTH/MUSIC_BUTTON_WIDTH_OFF, 
				program.WINDOW_HEIGHT/MUSIC_BUTTON_HEIGHT, 
				program.WINDOW_WIDTH/BOX_FACTOR, 
				program.WINDOW_HEIGHT/BOX_FACTOR, Color.DARK_GRAY);
		soundEffectsON = new GButton("ON", program.WINDOW_WIDTH/SOUND_BUTTON_WIDTH_ON, 
				program.WINDOW_HEIGHT/SOUND_BUTTON_HEIGHT, 
				program.WINDOW_WIDTH/BOX_FACTOR, 
				program.WINDOW_HEIGHT/BOX_FACTOR, Color.DARK_GRAY);
		soundEffectsOFF = new GButton("OFF", program.WINDOW_WIDTH/SOUND_BUTTON_WIDTH_OFF, 
				program.WINDOW_HEIGHT/SOUND_BUTTON_HEIGHT, 
				program.WINDOW_WIDTH/BOX_FACTOR, 
				program.WINDOW_HEIGHT/BOX_FACTOR, Color.DARK_GRAY);
	}
	
	public void showContents() {
		program.add(background);
		program.add(resumeButton);
		program.add(exitToMenuButton);
		program.add(exitGameButton);
		program.add(controlsButton);
		program.add(musicButtonON);
		program.add(musicButtonOFF);
		program.add(soundEffectsON);
		program.add(soundEffectsOFF);
	}

	public void hideContents() {
		program.remove(background);
		program.remove(resumeButton);
		program.remove(exitToMenuButton);
		program.remove(exitGameButton);
		program.remove(controlsButton);
		program.remove(musicButtonON);
		program.remove(musicButtonOFF);
		program.remove(soundEffectsON);
		program.remove(soundEffectsOFF);
		
	}

	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == resumeButton) {
			program.switchToGame();
		}
		if(obj == exitToMenuButton){
			program.switchToMenu();
		}
		if(obj == controlsButton){
			program.switchToControlsMenu();
		}
	}
}
