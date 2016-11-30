package game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import menus.*;
import java.util.List;
import javax.swing.Timer;

import acm.graphics.GImage;
import utilities.AudioPlayer;
import utilities.GraphicsPane;
import utilities.MainApplication;

public class Game extends GraphicsPane implements ActionListener {
	public static final int TILE_WIDTH = 16;
	public static final int TILE_HEIGHT = 16;
	public static final int GROUND_HEIGHT = 0;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final int GROUND_Y = HEIGHT - GROUND_HEIGHT;
	public static final int BLOCK_HEIGHT = GROUND_HEIGHT/7;
	public static final int BLOCK_WIDTH = GROUND_HEIGHT;
	private static final double VERTICAL_SCROLL_RATIO = 8;
	private static final double HORIZONTAL_SCROLL_RATIO = 3;
	private static final String BULLET_EAST = "bullet_east.png";
	private static final String BULLET_WEST = "bullet_west.png";
	
	private MainApplication program;
	private Timer gameLoop;
	private List<Scene> scenes;
	private int sceneNum;
	private Direction walk;
	
	private AudioPlayer music;
	
	public Game(MainApplication app) {
		this.program = app;
		sceneNum = 0;
		scenes = new ArrayList<Scene>();
		scenes.add(new Scene(TILE_WIDTH, TILE_HEIGHT));
		gameLoop = new Timer(20, this);
		walk = Direction.NO_DIRECTION;
		music = AudioPlayer.getInstance();
		
	}
	
	static int leftThreshold() {
		return MainApplication.WINDOW_WIDTH / (int) HORIZONTAL_SCROLL_RATIO;
	}
	static int rightThreshold() {
		return MainApplication.WINDOW_WIDTH - (MainApplication.WINDOW_WIDTH / (int) HORIZONTAL_SCROLL_RATIO);
	}
	static int topThreshold() {
		return (MainApplication.WINDOW_HEIGHT / (int) VERTICAL_SCROLL_RATIO);
	}
	static int bottomThreshold() {
		return MainApplication.WINDOW_HEIGHT - (MainApplication.WINDOW_HEIGHT / (int) VERTICAL_SCROLL_RATIO);
	}
	static int horzCenter() {
		return MainApplication.WINDOW_WIDTH / 2;
	}
	static int vertCenter() {
		return MainApplication.WINDOW_HEIGHT / 2;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		Scene curScene = scenes.get(sceneNum);
		Entity player = curScene.getPlayer();
		if(e.getKeyCode() == KeyEvent.VK_P || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			program.switchToPauseMenu();
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_V) {
			program.add(curScene.addBullet(BULLET_EAST, curScene.getPlayer(), player.getX(), player.getY(), Direction.EAST).getSprite());
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			walk = Direction.EAST;
			curScene.playerWalk(Direction.EAST);
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			walk = Direction.WEST;
			curScene.playerWalk(Direction.WEST);
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			if(!curScene.isPlayerJumping()) {
				curScene.playerJump();
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D) {
			walk = Direction.NO_DIRECTION;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Scene curScene = scenes.get(sceneNum);
		curScene.tick(walk);
	}

	@Override
	public void showContents() {
		Scene curScene = scenes.get(sceneNum);
		program.add(curScene.getPlayer().getSprite());
		if (curScene.getEnemyAtIndex(0).getSprite() != null) {
			System.out.print("Enemy added");
			program.add(curScene.getEnemyAtIndex(0).getSprite());
		}
		for (List<Block> row: curScene.getTerrain()) {
			for (Block b: row) {
				if (b != null) {
					program.add(b);
				}
			}
		}
		
		gameLoop.start();
		
		//adding in the music
		if(program.isMusicOn()){
	    	music.stopSound("../sounds", "menu_music.mp3");
			music.playSound("../sounds", "game_music.mp3");
	    }
	    else{
	    	music.stopSound("../sounds", "game_music.mp3");
	    }
	}

	@Override
	public void hideContents() {
		program.removeAll();
		gameLoop.stop();
	}

}
