package game;
import utilities.MainApplication;
import utilities.SomePane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Timer;

public class Game extends SomePane {

	public Game(MainApplication app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static final int MOVEMENT = 5;
	public static final int GROUND_HEIGHT = 100;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final int GROUND_Y = HEIGHT - GROUND_HEIGHT;
	public static final int BLOCK_HEIGHT = GROUND_HEIGHT/7;
	public static final int BLOCK_WIDTH = GROUND_HEIGHT;
	
	private Entity player;
	private Timer gameLoop;
	private Scene env;
	
	public void init() {
		//setSize(WIDTH, HEIGHT);
	}
	
	public void run() {
		player = new Entity("sprite", 0, 450, 3, this);
		env = new Scene();
		//addKeyListeners();
		gameLoop = new Timer(50, (ActionListener) this);
		gameLoop.start();
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
		env.checkCollisions(player);
		player.walkMovement();
	}
	
	public void add() {
		
	}
}
