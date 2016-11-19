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
	
	public Game(MainApplication app) {
		this.program = app;
		player = new Entity("sprite", 34, MainApplication.WINDOW_HEIGHT - 72, 3, this);
		sceneNum = 0;
		scenes = new ArrayList<Scene>();
		scenes.add(new Scene(TILE_WIDTH, TILE_HEIGHT));
		gameLoop = new Timer(20, this);
	}
	
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
	private Entity player;
	private Timer gameLoop;
	private ArrayList<Scene> scenes;
	private int sceneNum;
	
	private int leftThreshold() {
		return MainApplication.WINDOW_WIDTH / (int) HORIZONTAL_SCROLL_RATIO;
	}
	
	private int rightThreshold() {
		return MainApplication.WINDOW_WIDTH - (MainApplication.WINDOW_WIDTH / (int) HORIZONTAL_SCROLL_RATIO);
	}
	
	private int topThreshold() {
		return (MainApplication.WINDOW_HEIGHT / (int) VERTICAL_SCROLL_RATIO);
	}
	
	private int bottomThreshold() {
		return MainApplication.WINDOW_HEIGHT - (MainApplication.WINDOW_HEIGHT / (int) VERTICAL_SCROLL_RATIO);
	}
	
	private double amountToScroll(Direction d) {
		if (d == Direction.WEST) {
			return player.getX() - leftThreshold();
		}
		if (d == Direction.EAST) {
			return player.getX() - rightThreshold();
		}
		if (d == Direction.NORTH) {
			return player.getY() - topThreshold();
		}
		if (d == Direction.SOUTH) {
			return player.getY() - bottomThreshold();
		}
		return 0;
	}
	
	private Direction checkForHorizontalScrolling() {
		if (player.getX() < leftThreshold()) {
			return Direction.WEST;
		}
		if (player.getX() > rightThreshold()) {
			return Direction.EAST;
		}
		return Direction.NO_DIRECTION;
	}
	
	private Direction checkForVerticalScrolling() {
		if (player.getY() < topThreshold()) {
			return Direction.NORTH;
		}
		if (player.getY() > bottomThreshold()) {
			return Direction.SOUTH;
		}
		return Direction.NO_DIRECTION;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_P) {
			program.switchToPauseMenu();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.walk(Direction.EAST);
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.walk(Direction.WEST);
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(!player.amIJumping()) {
				player.jump();
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(scenes.get(sceneNum).findGround(player) == null) {
			player.fall(scenes.get(sceneNum));
		}else{
			player.setLocation((int) player.getX(), (int) (scenes.get(sceneNum).findGround(player).getY() - player.getHeight()));
			player.setJumping(false);
		}
		scenes.get(sceneNum).checkTerrainCollisions(player);
		player.walkMovement();
		if (checkForVerticalScrolling() == Direction.NORTH) {
			System.out.println("Scroll up!");
		} else if (checkForVerticalScrolling() == Direction.SOUTH) {
			System.out.println("Scroll down!");
		}
		if (checkForHorizontalScrolling() == Direction.WEST) {
			System.out.println("Scroll left!");
		} else if (checkForHorizontalScrolling() == Direction.EAST) {
			System.out.println("Scroll right!");
		}
	}

	@Override
	public void showContents() {
		program.add(player.getSprite());
		for (List<Block> row: scenes.get(0).getTerrain()) {
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
		// TODO Auto-generated method stub
		gameLoop.stop();
	}
}
