package menus;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import utilities.AudioPlayer;
import utilities.GButton;
import utilities.GraphicsPane;
import utilities.MainApplication;

public class MenuPane extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GImage background;
	private GButton playButton;
	private GButton settingsButton;
	private GButton controlsButton;
	private static final double WIDTH_FACTOR = 25.6;
	private static final double PLAY_HEIGHT_FACTOR = 24;
	private static final double SETTINGS_HEIGHT_FACTOR = 7.45;
	private static final double CONTROLS_HEIGHT_FACTOR = 5.29;
	private static final double PLAY_SIZE_WIDTH = 4.68;
	private static final double PLAY_SIZE_HEIGHT = 10.97;
	private static final double OTHER_SIZE_HEIGHT = 19.2;
	private static final double OTHER_SIZE_WIDTH = 4.57;
	
	private final double WIDTH_OFFSET= program.WINDOW_WIDTH/WIDTH_FACTOR;
	private final double PLAY_HEIGHT_OFFSET = program.WINDOW_HEIGHT/PLAY_HEIGHT_FACTOR;
	private final double SETTINGS_HEIGHT_OFFSET = program.WINDOW_HEIGHT/SETTINGS_HEIGHT_FACTOR;
	private final double CONTROLS_HEIGHT_OFFSET = program.WINDOW_HEIGHT/CONTROLS_HEIGHT_FACTOR;

	private AudioPlayer music;
	
	
	public MenuPane(MainApplication app) {
		program = app;
		background = new GImage("images/Main Menu.png", 0, 0);
		playButton = new GButton(WIDTH_OFFSET, PLAY_HEIGHT_OFFSET, 
						program.WINDOW_WIDTH/PLAY_SIZE_WIDTH,
						program.WINDOW_HEIGHT/PLAY_SIZE_HEIGHT, false);
		settingsButton = new GButton(WIDTH_OFFSET, SETTINGS_HEIGHT_OFFSET,
						program.WINDOW_WIDTH/OTHER_SIZE_WIDTH,
						program.WINDOW_HEIGHT/OTHER_SIZE_HEIGHT, false);
		controlsButton = new GButton(WIDTH_OFFSET, CONTROLS_HEIGHT_OFFSET,
						program.WINDOW_WIDTH/OTHER_SIZE_WIDTH,
						program.WINDOW_HEIGHT/OTHER_SIZE_HEIGHT, false);
		music = new AudioPlayer();
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(playButton);
		program.add(settingsButton);
		program.add(controlsButton);
		
//		music.playSound("../media/sounds/menu_music.mp3");
	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(playButton);
		program.remove(settingsButton);
		program.remove(controlsButton);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == playButton) {
			program.switchToGame();
		}
		if(obj == settingsButton){
			program.switchToSettingsMenu();
		}
		if(obj == controlsButton){
			program.switchToControlsMenu();
		}
	}
}
