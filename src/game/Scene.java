package game;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Scene {

	private SceneLayout scene;
	private Bullet bullet;
	
	public Scene() {
		
	}

	public boolean checkTerrainCollisions(Entity player) {
		Rectangle rect = player.getBox();
		Direction direction = scene.checkCollisions(player);
		if (direction == Direction.NO_DIRECTION)
			return false;
		else
			return true;
	}
	
	

}
