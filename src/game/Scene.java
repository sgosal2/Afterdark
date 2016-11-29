package game;

import java.awt.Rectangle;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import acm.graphics.GImage;

import acm.graphics.GObject;


import java.awt.event.KeyEvent;


import utilities.MainApplication;

public class Scene {

	private MainApplication program;
	private SceneLayout layout;
	private Bullet bullet;
	private Entity player;
	private List<Entity> npcs;
	public static int TILE_WIDTH;
	public static int TILE_HEIGHT;
	
	public Scene(int tileWidth, int tileHeight) {
		TILE_WIDTH = tileWidth;
		TILE_HEIGHT = tileHeight;
		layout = new SceneLayout(tileWidth, tileHeight);
		player = new Player("sprite", 1000, MainApplication.WINDOW_HEIGHT - 200, 3);
		center(player);
		bullet = new Bullet("robot head.jpg", player, Direction.EAST);
	}

	public void tick() {
		Block ground = findGround(player);
		if(ground == null) {
			player.fall(this);
		}else{
			player.setLocation((int) player.getX(), (int) (ground.getY() - player.getHeight()));
			player.setJumping(false);
		}
		checkTerrainCollisions(player);
		player.walkMovement();
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
	
	public void addEntity(Entity e, int x, int y) {
		program.add(e.getSprite());
	}
	
	public void removeEntity(Entity e) {
		program.remove(e.getSprite());
	}
	
	public void addBullet(double d, double e) {
		if (bullet != null) {
			GImage b = bullet.getSprite();
			program.add(b);
			b.setLocation(d, e);
		}
	}
	
	public void horzScroll(double distance) {
		player.horzScroll(distance);
		layout.horzScroll(distance);
	}
	
	public void vertScroll(double distance) {
		player.vertScroll(distance);
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
	
	public Bullet getBullet() {
		return bullet;
	}
}
