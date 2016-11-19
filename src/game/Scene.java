package game;

import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.List;

import utilities.MainApplication;

public class Scene {

	private MainApplication program;
	private SceneLayout layout;
	private Bullet bullet;
	private Player player;
	private List<Entity> npcs;
	public static int TILE_WIDTH;
	public static int TILE_HEIGHT;
	
	public Scene(int tileWidth, int tileHeight) {
		TILE_WIDTH = tileWidth;
		TILE_HEIGHT = tileHeight;
		layout = new SceneLayout(tileWidth, tileHeight);
	}

	public void tick() {
		if(findGround(player) == null) {
			player.fall(this);
		}else{
			player.setLocation((int) player.getX(), (int) (findGround(player).getY() - player.getHeight()));
			player.setJumping(false);
		}
		checkTerrainCollisions(player);
		player.walkMovement();
		if (checkForVerticalScrolling() == Direction.NORTH) {
			System.out.println("Scroll up!");
			vertScroll(amountToScroll(Direction.NORTH));
			
		} else if (checkForVerticalScrolling() == Direction.SOUTH) {
			System.out.println("Scroll down!");
			vertScroll(amountToScroll(Direction.SOUTH));
		}
		if (checkForHorizontalScrolling() == Direction.WEST) {
			System.out.println("Scroll left!");
			horzScroll(amountToScroll(Direction.WEST));
		} else if (checkForHorizontalScrolling() == Direction.EAST) {
			System.out.println("Scroll right!");
			horzScroll(amountToScroll(Direction.EAST));
		}
	}
	
	public double amountToScroll(Direction d) {
		if (d == Direction.WEST) {
			return player.getX() - Game.leftThreshold();
		}
		if (d == Direction.EAST) {
			return player.getX() - Game.rightThreshold();
		}
		if (d == Direction.NORTH) {
			return player.getY() - Game.topThreshold();
		}
		if (d == Direction.SOUTH) {
			return player.getY() - Game.bottomThreshold();
		}
		return 0;
	}
	
	public Direction checkForHorizontalScrolling() {
		if (player.getX() < Game.leftThreshold()) {
			return Direction.WEST;
		}
		if (player.getX() > Game.rightThreshold()) {
			return Direction.EAST;
		}
		return Direction.NO_DIRECTION;
	}
	
	public Direction checkForVerticalScrolling() {
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
	
	public void addBullet(int x, int y) {
		program.add(bullet.getSprite());
	}
	
	public void horzScroll(double distance) {
		layout.horzScroll(distance);
	}
	
	public void vertScroll(double distance) {
		layout.vertScroll(distance);
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
}
