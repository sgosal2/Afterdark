package game;
import acm.program.GraphicsProgram;

public class Player extends Entity {
	private static final int MAX_COOLDOWN = 50;
	private int cooldown;
	
	public Player(String imgName, int x, int y, double width, double height, int walkImages, int idleImages) {
		super(imgName, x, y, width, height, walkImages, idleImages);
		cooldown = 0;
	}

	public void goOnCooldown() {
		cooldown = MAX_COOLDOWN;
	}
	
	@Override
	public void tick() {
		super.tick();
		cooldown = Math.max(0, cooldown - 1);
	}
	
	public boolean isOnCooldown() {
		if (cooldown > 0) {
			return true;
		} else {
			return false;
		}
	}
}
