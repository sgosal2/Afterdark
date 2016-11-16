package utilities;
/*
 * Ali Noorani
 * This is my second commit.
 */

import javax.swing.Timer;

import game.Game;
import menus.MenuPane;
import menus.PauseMenu;
import menus.Settings;
import menus.Controls;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;
	
	//private SomePane somePane;
	private GraphicsPane menu;
	private GraphicsPane game;
	private GraphicsPane pauseMenu;
	private GraphicsPane settings;
	private GraphicsPane controls;
	private int count = 0;
	//private Timer gameLoop;
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public void run() {
		//System.out.println("Hello, world!");
		//somePane = new SomePane(this);
		menu = new MenuPane(this);
		game = new Game(this);
		pauseMenu = new PauseMenu(this);
		settings = new Settings(this);
		controls = new Controls(this);
		setupInteractions();
		switchToMenu();
		//gameLoop = new Timer(50, this);
	}
	
	/* Method: setupInteractions
	 * -------------------------
	 * must be called before switching to another
	 * pane to make sure that interactivity
	 * is setup and ready to go.
	 */
	private void setupInteractions() {
		requestFocus();
		addKeyListeners();
		addMouseListeners();
	}
	
	public void switchToMenu() {
//		AudioPlayer audio = AudioPlayer.getInstance();
//		switch(count % 2) {
//			case 0: audio.stopSound("sounds", "r2d2.mp3"); break;
//			case 1: audio.stopSound("sounds", "somethinlikethis.mp3"); break;
//		}
//		count++;
		switchToScreen(menu);
	}
	
	public void switchToGame() {
//		AudioPlayer audio = AudioPlayer.getInstance();
//		switch(count % 2) {
//			case 0: audio.playSound("sounds", "r2d2.mp3"); break;
//			case 1: audio.playSound("sounds", "somethinlikethis.mp3"); break;
//		}
		switchToScreen(game);
	}
	
	public void switchToPauseMenu(){
		switchToScreen(pauseMenu);
	}
	
	public void switchToSettingsMenu(){
		switchToScreen(settings);
	}
	
	public void switchToControlsMenu(){
		switchToScreen(controls);
	}
}
