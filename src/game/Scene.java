package game;

import java.awt.Rectangle;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import acm.graphics.GImage;

import acm.graphics.GObject;


import java.awt.event.KeyEvent;


import utilities.MainApplication;

public class Scene implements ActionListener {

	private MainApplication program;
	private SceneLayout layout;
	private List<Bullet> bullets;
	private Entity player;
	private List<Entity> npcs;
	private Direction playerWalkDirection;
	private int timerNum;
	public static int TILE_WIDTH;
	public static int TILE_HEIGHT;
	
	Timer enemyMovementTimer = new Timer(10, this);
	
	public Scene(int tileWidth, int tileHeight) {
		TILE_WIDTH = tileWidth;
		TILE_HEIGHT = tileHeight;
		layout = new SceneLayout(tileWidth, tileHeight);
		player = new Player("sprite", 1000, MainApplication.WINDOW_HEIGHT - 200, 3);
		center(player);
		bullets = new ArrayList<Bullet>();
		npcs = new ArrayList<Entity>();
		Enemy e = new Enemy("sprite", 1001, MainApplication.WINDOW_HEIGHT - 200, 3);
		npcs.add(e);
		timerNum = 0;
		enemyMovementTimer.start();
	}

	public void tick(Direction walk) {
		Block ground = findGround(player);
		Entity e = npcs.get(0);
		if(ground == null) {
			player.setJumping(true);
			e.setJumping(true);
		} else {
			player.setLocation((int) player.getX(), (int) (ground.getY() - player.getHeight()));
			player.setJumping(false);
			e.setLocation((int) e.getX(), (int) (ground.getY() - e.getHeight()));
			e.setJumping(false);
		}
		if (walk == Direction.WEST) {
			player.walk(walk);
		} else if (walk == Direction.EAST) {
			player.walk(walk);
		}
		checkTerrainCollisions(player);
		checkTerrainCollisions(e);
		player.walkMovement();
		e.walkMovement();
		handleScrolling();
	}
	
//	private boolean checkRightLeft(List<Integer> keysDown) {
//		if (keysDown.contains(KeyEvent.VK_LEFT)) {
//			return true;
//		}
//		if (keysDown.contains(KeyEvent.VK_RIGHT)) {
//			return true;
//		}
//		return false;
//	}
	
	private void handleScrolling() {
		if (checkForVerticalScrolling() == Direction.NORTH) {
//			System.out.println("Scroll up!");
			vertScroll(amountToScroll(Direction.NORTH));
			
		} else if (checkForVerticalScrolling() == Direction.SOUTH) {
//			System.out.println("Scroll down!");
			vertScroll(amountToScroll(Direction.SOUTH));
		}
		if (checkForHorizontalScrolling() == Direction.WEST) {
//			System.out.println("Scroll left!");
			horzScroll(amountToScroll(Direction.WEST));
		} else if (checkForHorizontalScrolling() == Direction.EAST) {
//			System.out.println("Scroll right!");
			horzScroll(amountToScroll(Direction.EAST));
		}
	}
	
	private double amountToScroll(Direction d) {
		if (d == Direction.WEST) {
			return Game.leftThreshold() - player.getX() - 1;
		}
		if (d == Direction.EAST) {
			return Game.rightThreshold() - player.getX() + 1;
		}
		if (d == Direction.NORTH) {
			return Game.topThreshold() - player.getY() - 1;
		}
		if (d == Direction.SOUTH) {
			return Game.bottomThreshold() - player.getY() + 1;
		}
		return 0;
	}
	
	private Direction checkForHorizontalScrolling() {
		if (player.getX() < Game.leftThreshold()) {
			return Direction.WEST;
		}
		if (player.getX() > Game.rightThreshold()) {
			return Direction.EAST;
		}
		return Direction.NO_DIRECTION;
	}
	
	private Direction checkForVerticalScrolling() {
		if (player.getY() < Game.topThreshold()) {
			return Direction.NORTH;
		}
		if (player.getY() > Game.bottomThreshold()) {
			return Direction.SOUTH;
		}
		return Direction.NO_DIRECTION;
	}
	
	public Direction checkTerrainCollisions(Entity e) {
		return layout.checkCollisions(e);
	}
	
	public Block findGround(Entity e) {
		return layout.findGround(e);
	}
	
	public List<List<Block>> getTerrain() {
		return layout.getTerrain();
	}
	
	public Enemy addEnemy(String sprite, int startX, int startY, int imgsToAnimate) {
		Enemy enemy = new Enemy(sprite, startX, startY, imgsToAnimate);
		GImage e = enemy.getSprite();
		e.setLocation(startX, startY);
		enemy.move();
		npcs.add(enemy);
		return enemy;
	}
	
	public Bullet addBullet(String sprite, Entity owner, double x, double y, Direction d) {
		Bullet bullet = new Bullet(sprite, owner, d);
		GImage b = bullet.getSprite();
		b.setLocation(x, y);
		bullet.move();
		bullets.add(bullet);
		return bullet;
	}
	
	public void removeBullet(Bullet bullet) {
		bullets.remove(bullet);
	}
	
	public void horzScroll(double distance) {
		player.horzScroll(distance);
		if (bullets != null) {
			for (Bullet b : bullets) {
				if (b != null) {
					b.move(distance, 0.0);
				}
			} 
		}
		layout.horzScroll(distance);
	}
	
	public void vertScroll(double distance) {
		player.vertScroll(distance);
		if (bullets != null) {
			for (Bullet b : bullets) {
				if (b != null) {
					b.move(0.0, distance);
				}
			} 
		}
		layout.vertScroll(distance);
	}
	
	public void center(Entity focus) {
		double xShift = focus.horzCenterDifference();
		double yShift = focus.vertCenterDifference();
		horzScroll(xShift);
		vertScroll(yShift);
	}
	
	public void playerWalk(Direction d) {
		player.walk(d);
	}
	
	public boolean isPlayerJumping() {
		return player.amIJumping();
	}
	
	public void playerJump() {
		player.jump();
	}

	public Entity getPlayer() {
		return player;
	}
	
	public List<Bullet> getBullets() {
		return bullets;
	}

	public Direction getPlayerWalkDirection() {
		return playerWalkDirection;
	}

	public void setPlayerWalkDirection(Direction playerWalkDirection) {
		this.playerWalkDirection = playerWalkDirection;
	}
	
	public Entity getNPCAtIndex(int i) {
		return npcs.get(i);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
