package game;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Scene {

	private SceneLayout layout;
	
	public Scene() {
		
	}

	public boolean checkTerrainCollisions(Entity player) {
		Rectangle rect = player.getBox();
		Direction direction = layout.checkCollisions(player);
		if (direction == Direction.NO_DIRECTION)
			return false;
		else
			return true;
	}

}
