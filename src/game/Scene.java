package game;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Scene {

	private ArrayList<SceneLayout> scene;
	
	public Scene() {
		scene = new ArrayList<SceneLayout>();
	}

	public boolean checkTerrainCollisions(Entity player, int sceneNum) {
		Rectangle rect = player.getBox();
		Direction direction = scene.get(sceneNum).checkCollisions(player);
		if (direction == Direction.NO_DIRECTION)
			return false;
		else
			return true;
	}

}
