package game;
import java.awt.Rectangle;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Entity {
	public static final String PATH = "../media/images/";
	public static final String EXTENSION = ".png";
	public static final int MOVEMENT = 5;
	public static final double GRAVITY = 1;
	public static final double FRICTION = .3;
	public static final int JUMP_VELOCITY = -7;
	private static final double MAX_GRAVITY = 7;
	private static final double MAX_SPEED = 5;
	
	private String imageName;
	private boolean amIJumping;
	private int currentStep;
	private int numImages;
	private GImage img;
	private Game window;
	private double dy;
	private double dx;
	
	public Entity(String imgName, int x, int y, int nImages, Game gp) {
		imageName = imgName;
		currentStep = 0;
		numImages = nImages;
		img = new GImage(getCorrectSprite(), x, y);
		amIJumping = false;
		window = gp;
		dy = 0;
		dx = 0;
		//window.add(img);
	}
	
	public boolean amIJumping() {
		return amIJumping;
	}

	public void setJumping(boolean amIJumpin) {
		this.amIJumping = amIJumpin;
	}

	public void move(int x, int y) {
		img.move(x, y);
		System.out.println("Y: " + y);
		if(x != 0) {
			currentStep++;
		}
		img.setImage(getCorrectSprite());
	}
	
	private String getCorrectSprite() {
		int imgToGet = currentStep % numImages;
		return PATH + imageName+imgToGet+EXTENSION;
	}
	
	public void jump() {
		dy = JUMP_VELOCITY;
		setJumping(true);
		move(0, -1);
	}
	
	public void reflectHorizontally() {
		dx = -1 * dx;
	}
	
	public void reflectVertically() {
		dy = -1 * dy;
	}
	
	public void setLocation(int x, int y) {
		img.setLocation(x, y);
	}
	
	public double getX() {
		return img.getX();
	}
	
	public double getY() {
		return img.getY();
	}
	
	public Rectangle getBox() {
		return new Rectangle((int) img.getX(), (int) img.getY(), (int) img.getWidth(), (int) img.getHeight());
	}

	public void fall(Scene s) {
		move(0, (int) Math.round(dy));
		
		dy += FRICTION;
		dy = Math.min(dy, MAX_GRAVITY);
		dy = Math.max(dy, -MAX_GRAVITY);
	}
	
	public void walk(Direction d) {
		if(d == Direction.EAST) {
			dx += GRAVITY;
			dx = Math.min(dx, MAX_SPEED);
		}else if(d == Direction.WEST) {
			dx -= GRAVITY;
			dx = Math.max(dx, -MAX_SPEED);
		}
	}
	
	public void walkMovement() {
		move((int) Math.round(dx), 0);
		if(dx > 0) {
			dx -= FRICTION;
			dx = Math.max(dx, 0);
		}else if(dx < 0) {
			dx += FRICTION;
			dx = Math.min(dx, 0);
		}
	}

	public double getHeight() {
		// TODO Auto-generated method stub
		return img.getHeight();
	}
	
	public GImage getSprite() {
		return img;
	}
}
