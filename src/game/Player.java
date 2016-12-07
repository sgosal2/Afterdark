package game;
import acm.program.GraphicsProgram;

public class Player extends Entity {

	public Player(String imgName, int x, int y, int walkImages, int idleImages) {
		super(imgName, x, y, walkImages, idleImages);
	}
	
	public Player(String string, int i, int j, double d, double e, int k, int l) {
		super(string, i, j, d, e, k, l);
	}

	public void shoot() {
		
	}

}
