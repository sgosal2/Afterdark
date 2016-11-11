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
		player = new Entity("sprite", 64, MainApplication.WINDOW_HEIGHT - 500, 3, this);
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
	
	private MainApplication program;
	private Entity player;
	private Timer gameLoop;
	private ArrayList<Scene> scenes;
	private int sceneNum;
	
	@Override
	public void keyPressed(KeyEvent e) {
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
			//player.setLocation((int) player.getX(), (int) (player.getHeight() + scenes.get(sceneNum).findGround(player).getY() + 20));
			player.setJumping(false);
		}
		scenes.get(sceneNum).checkTerrainCollisions(player);
		player.walkMovement();
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
