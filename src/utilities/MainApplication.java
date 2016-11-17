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

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;
	
	private GraphicsPane menu;
	private GraphicsPane game;
	private GraphicsPane pauseMenu;
	private GraphicsPane settings;
	private GraphicsPane controls;
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public void run() {
		menu = new MenuPane(this);
		game = new Game(this);
		pauseMenu = new PauseMenu(this);
		settings = new Settings(this);
		controls = new Controls(this);
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
}
