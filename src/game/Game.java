package game;
import utilities.MainApplication;
import utilities.GraphicsPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.GImage;

public class Game extends GraphicsPane implements ActionListener {
	
	public Game(MainApplication app) {
		this.program = app;
		player = new Entity("sprite", 0, 450, 3, this);
		System.out.print("Game ran.");
	}

//	public static void main(String[] args) {
//		MainApplication p = new MainApplication();
//		Game game = new Game(p);
//		game.run();
//	}

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
	private ArrayList<Scene> env;
	private int sceneNum;
	
	public void init() {
	}
	
	public void run() {
		player = new Entity("sprite", 0, 450, 3, this);
		env = new ArrayList<Scene>();
		gameLoop = new Timer(50, (ActionListener) this);
		System.out.print("Game made.");
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
	
	//@Override
	public void actionPerformed(ActionEvent e) {
		if(player.getY() + player.getHeight() < GROUND_Y) {
//			System.out.println(sprite.getY());
			player.fall();
		}else{
			player.setLocation((int) player.getX(), (int) (GROUND_Y - player.getHeight()));
			player.setJumping(false);
		}
		env.get(sceneNum).checkTerrainCollisions(player);
		player.walkMovement();
	}

	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		
	}
}
