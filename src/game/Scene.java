package game;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Scene {

	private SceneLayout scene;
	private Bullet bullet;
	public static int TILE_WIDTH;
	public static int TILE_HEIGHT;

	
	private SceneLayout layout;
	
	public Scene(int tileWidth, int tileHeight) {
		TILE_WIDTH = tileWidth;
		TILE_HEIGHT = tileHeight;
		layout = new SceneLayout(tileWidth, tileHeight);
	}

	public boolean checkTerrainCollisions(Entity player) {
		Rectangle rect = player.getBox();
		Direction direction = layout.checkCollisions(player);
		if (direction == Direction.NO_DIRECTION)
			return false;
		else
			return true;
	}
	
	public List<List<Block>> getTerrain() {
		return layout.getTerrain();
	}
	
}
