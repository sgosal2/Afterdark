package game;
import java.awt.Rectangle;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;
import utilities.MainApplication;

public class Entity {
	public static final String PATH = "../media/images/";
	public static final String EXTENSION = ".png";
	public final double MOVEMENT = 4;
	public final double GRAVITY = 3;
	public final double FRICTION = 1;
	public final int HEALTH_VALUE = 100;
	public final double JUMP_VELOCITY = 20;
	private final double MAX_GRAVITY = 50;
	private final double MAX_SPEED = 7;
	
	private boolean idle;
	
	protected Direction directionFacing;
	protected String imageName;
	protected boolean amIJumping;
	protected boolean amIWalking;
	protected int currentStep;
	protected int currentIdle;
	protected int walkImages;
	protected int idleImages;
	protected GImage sprite;
	protected double dy;
	protected double dx;
	protected int health;
	
	public Entity(String sprite, int startX, int startY, int imagesInWalk, int imagesInIdle) {
		idle = true;
		imageName = sprite;
		currentStep = 0;
		currentIdle = 0;
		walkImages = imagesInWalk;
		idleImages = imagesInIdle;
		this.sprite = new GImage(getCorrectSprite(), startX, startY);
		this.sprite.setSize(16, 16);
		amIJumping = true;
		amIWalking = false;
		dy = 0;
		dx = 0;
		health = HEALTH_VALUE;
		directionFacing = Direction.EAST;
	}
	
	public boolean amIJumping() {
		return amIJumping;
	}

	public void setJumping(boolean amIJumpin) {
		this.amIJumping = amIJumpin;
	}

	public void move(double x, double y) {
		if (x != 0 || y != 0) {
			//System.out.println("dx: " + x + ", dy: " + y);
		}
		sprite.move(x, y);
		if(x != 0) {
			currentStep++;
		}
		sprite.setImage(getCorrectSprite());
	}
	
	public void incrementIdle() {
		currentIdle++;
	}
	
	private String getCorrectSprite() {
		if (idleImages == 0) {
			int imgToGet = currentStep % walkImages;
			return PATH + imageName+imgToGet+EXTENSION;
		} else {
			if (idle) {
				int imgToGet = currentIdle % idleImages;
				if (directionFacing == Direction.WEST) {
					return PATH + imageName + "/idle/left/" + imageName + imgToGet + ".gif";
				} else {
					return PATH + imageName + "/idle/right/" + imageName + imgToGet + ".gif";
				}
			} else {
				int imgToGet = currentStep % walkImages;
				if (directionFacing == Direction.WEST) {
					return PATH + imageName + "/walk/left/" + imageName + imgToGet + ".gif";
				} else {
					return PATH + imageName + "/walk/right/" + imageName + imgToGet + ".gif";
				}
			}
		}
	}
	
	public void jump() {
//		System.out.println("Jump");
		dy = -JUMP_VELOCITY;
		setJumping(true);
		move(dx, -0.1);
	}
	
	public void reflectHorizontally() {
		dx = -1 * dx;
	}
	
	public void reflectVertically() {
		dy = -1 * dy;
	}
	
	public void setLocation(int x, int y) {
		sprite.setLocation(x, y);
	}
	
	public double getX() {
		return sprite.getX();
	}
	
	public double getY() {
		return sprite.getY();
	}
	
	public Rectangle getBox() {
		return new Rectangle((int) sprite.getX(), (int) sprite.getY(), (int) sprite.getWidth(), (int) sprite.getHeight());
	}

//	public void fall(Scene s) {
//		move(0, dy);
//		
//		dy += GRAVITY;
//		dy = Math.min(dy, MAX_GRAVITY);
//		dy = Math.max(dy, -JUMP_VELOCITY);
//	}
	
	public void walk(Direction d) {
//		System.out.println("Walk");
		directionFacing = d;
		if(d == Direction.EAST) {
//			System.out.println("dx: " + dx);
			dx += MOVEMENT;
			dx = Math.min(dx, MAX_SPEED);
		}else if(d == Direction.WEST) {
//			System.out.println("dx: " + dx);
			dx -= MOVEMENT;
			dx = Math.max(dx, -MAX_SPEED);
		}
		idle = false;
		amIWalking = true;
	}
	
	public void walkMovement() {
		move(dx, dy);
		if(dx > 0) {
			//System.out.println("Decay");
//			System.out.println("dx: " + dx);
			dx -= FRICTION;
			dx = Math.max(dx, 0);
			directionFacing = Direction.EAST;
		}else if(dx < 0) {
			//System.out.println("Decay");
//			System.out.println("dx: " + dx);
			dx += FRICTION;
			dx = Math.min(dx, 0);
			directionFacing = Direction.WEST;
		} else {
			idle = true;
			amIWalking = false;
		}
		if (amIJumping) {
			dy += GRAVITY;
			dy = Math.min(dy, MAX_GRAVITY);
			dy = Math.max(dy, -JUMP_VELOCITY);
		} else {
			dy = 0;
		}
	}
	
	public double horzCenterDifference() {
		return Game.horzCenter() - getX();
	}
	
	public double vertCenterDifference() {
		return Game.vertCenter() - getY();
	}
	
	public void horzScroll(double distance) {
		sprite.move(distance, 0);
	}
	
	public void vertScroll(double distance) {
		sprite.move(0, distance);
	}

	public double getHeight() {
		return sprite.getHeight();
	}
	
	public GImage getSprite() {
		return sprite;
	}

	public boolean isWalking() {
		return amIWalking;
	}

	public void setWalking(boolean amIWalking) {
		this.amIWalking = amIWalking;
	}
	
	public void setHealth(int h) {
		health = h;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void damage(int d) {
		health = Math.max(-1, health - d);
	}
	
	public Direction isDirectionFacing() {
		return directionFacing;
	}

	public void setDirectionFacing(Direction directionFacing) {
		this.directionFacing = directionFacing;
	}
	
	public boolean belowLevel() {
		if (getY() > MainApplication.WINDOW_HEIGHT) {
			return true;
		} else {
			return false;
		}
	}
}
