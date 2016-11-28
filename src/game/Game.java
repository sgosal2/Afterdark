package game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import menus.*;
import java.util.List;
import javax.swing.Timer;

import utilities.GraphicsPane;
import utilities.MainApplication;

public class Game extends GraphicsPane implements ActionListener {
	public static final int TILE_WIDTH = 16;
	public static final int TILE_HEIGHT = 16;
	public static final int MOVEMENT = 5;
	public static final int GROUND_HEIGHT = 0;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final int GROUND_Y = HEIGHT - GROUND_HEIGHT;
	public static final int BLOCK_HEIGHT = GROUND_HEIGHT/7;
	public static final int BLOCK_WIDTH = GROUND_HEIGHT;
	private static final double VERTICAL_SCROLL_RATIO = 8;
	private static final double HORIZONTAL_SCROLL_RATIO = 3;
	
	private MainApplication program;
	private Timer gameLoop;
	private List<Scene> scenes;
	private List<Integer> keysDown;
	private int sceneNum;
	
	public Game(MainApplication app) {
		this.program = app;
		sceneNum = 0;
		scenes = new ArrayList<Scene>();
		keysDown = new ArrayList<Integer>();
		scenes.add(new Scene(TILE_WIDTH, TILE_HEIGHT));
		gameLoop = new Timer(30, this);
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
		if(e.getKeyCode() == KeyEvent.VK_P) {
			program.switchToPauseMenu();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			curScene.playerWalk(Direction.EAST);
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			curScene.playerWalk(Direction.WEST);
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(!curScene.isPlayerJumping()) {
				curScene.playerJump();
			}
		}else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			curScene.addBullet(curScene.getPlayer().getX(), curScene.getPlayer().getY());
		}
		if (!keysDown.contains(e.getKeyCode())) {
			keysDown.add(e.getKeyCode());
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		List<Integer> dummyList = new ArrayList<Integer>();
		dummyList.add(e.getKeyCode());
		keysDown.removeAll(dummyList);
	}
	
	public void actionPerformed(ActionEvent e) {
		Scene curScene = scenes.get(sceneNum);
		curScene.tick(keysDown);
	}

	@Override
	public void showContents() {
		Scene curScene = scenes.get(sceneNum);
		program.add(curScene.getPlayer().getSprite());
		for (List<Block> row: curScene.getTerrain()) {
			for (Block b: row) {
				if (b != null) {
					program.add(b);
				}
			}
		}
		gameLoop.start();
	}

	@Override
	public void hideContents() {
		program.removeAll();
		gameLoop.stop();
	}
}
