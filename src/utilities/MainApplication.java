package utilities;
/*
 * Ali Noorani
 * This is my second commit.
 */

import game.Game;
import menus.MenuPane;
import menus.PauseMenu;
import menus.Settings;
import menus.Controls;
import menus.GameOver;
import menus.GameWon;
import menus.pauseControlsMenu;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;
	
	private GraphicsPane menu;
	private GraphicsPane game;
	private GraphicsPane pauseMenu;
	private GraphicsPane settings;
	private GraphicsPane controls;
	private GraphicsPane pauseControls;
	private GraphicsPane gameOver;
	private GraphicsPane gameWon;
	
	private boolean musicIsOn = true;
	private boolean soundIsOn = true;
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	/*
	 * This method is similar to a main method in a typical java application.
	 */
	public void run() {
		menu = new MenuPane(this);
		game = new Game(this);
		pauseMenu = new PauseMenu(this);
		settings = new Settings(this);
		controls = new Controls(this);
		pauseControls = new pauseControlsMenu(this);
		gameOver = new GameOver(this);
		gameWon = new GameWon(this);
		setupInteractions();
		switchToMenu();
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
	/*
	 * The various methods below call other methods that actually change
	 * the screen in the game.
	 */
	public void switchToMenu() {
		switchToScreen(menu);
	}
	
	public void switchToGame() {
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
	
	public void switchToPauseControlsMenu(){
		switchToScreen(pauseControls);
	}
	
	public void switchToGameOver(String methodOfDeath) {
		((GameOver) gameOver).setDeath(methodOfDeath);
		switchToScreen(gameOver);
	}
	
	public void switchToGameWon(){
		switchToScreen(gameWon);
	}

	public boolean isMusicOn() {
		return musicIsOn;
	}

	public void setMusicIsOn(boolean musicIsOn) {
		this.musicIsOn = musicIsOn;
	}
	
	public boolean isSoundOn(){
		return soundIsOn;
	}
	
	public void setSoundIsOn(boolean soundIsOn){
		this.soundIsOn = soundIsOn;
	}
	
	public void resetGame() {
		game = new Game(this);
	}
}
