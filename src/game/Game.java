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
		player = new Entity("sprite", 64, program.WINDOW_HEIGHT - 128, 3, this);
		System.out.print("Game ran.");
		sceneNum = 0;
		scenes = new ArrayList<Scene>();
		scenes.add(new Scene(TILE_WIDTH, TILE_HEIGHT));
	}

//	public static void main(String[] args) {
//		MainApplication p = new MainApplication();
//		Game game = new Game(p);
//		game.run();
//	}
	
	public static final int TILE_WIDTH = 32;
	public static final int TILE_HEIGHT = 32;
	public static final int MOVEMENT = 5;
	public static final int GROUND_HEIGHT = 100;
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
	
	public void init() {
	}
	
	@Override
	public void run() {
		player = new Entity("sprite", 0, 450, 3, this);
		scenes = new ArrayList<Scene>();
		gameLoop = new Timer(50, this);
		System.out.print("Game made.");
		sceneNum = 0;
		scenes.add(new Scene(TILE_WIDTH, TILE_HEIGHT));
	}
	
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
		if(player.getY() + player.getHeight() < GROUND_Y) {
//			System.out.println(sprite.getY());
			player.fall();
		}else{
			player.setLocation((int) player.getX(), (int) (GROUND_Y - player.getHeight()));
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
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		
	}
}
