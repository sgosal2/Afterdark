package game;
import acm.graphics.*;

public class Bullet {
	
	private GImage sprite;
	private Entity sender;
	private Direction direction;
	private static final int DAMAGE = 1;
	private static final int SPEED = 1;
	
	private GImage getSprite() {
		return sprite;
	}
	
	private void setSprite(GImage s) {
		sprite = s;
	}
	
	private Entity getSender() {
		return sender;
	}
	
	private Direction getDirection() {
		return direction;
	}
	
	private void setDirection(Direction d) {
		direction = d;
	}
	
}
