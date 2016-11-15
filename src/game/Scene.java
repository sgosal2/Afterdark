package game;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Scene {

	private SceneLayout scene;
	private Bullet bullet;
	private Player player;
	public static int TILE_WIDTH;
	public static int TILE_HEIGHT;

	
	private SceneLayout layout;
	
	public Scene(int tileWidth, int tileHeight) {
		TILE_WIDTH = tileWidth;
		TILE_HEIGHT = tileHeight;
		layout = new SceneLayout(tileWidth, tileHeight);
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
	
	public void removeEntity(Entity e) {
		
	}
	
	
	
}
