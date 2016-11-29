package game;
/**
 * Block.java
 * @author jackthias
 * Created 11/7/16
 * Block represents a single "tile" of terrain in a scene.
 */

import java.util.List;
import java.awt.Rectangle;
import java.util.ArrayList;

import acm.graphics.GImage;

/**
 * Block represents a single "tile" of terrain in a scene.
 * @author jackthias
 */
public class Block extends GImage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_X = 0;
	private static final int BUFFER_Y = 0;

	private boolean isBlockSolid;
	
	public Block(String imageName, double x, double y) {
		super(imageName, x, y);
		isBlockSolid = true;
	}
	
	public boolean isSolid() {
		return isBlockSolid;
	}
	
	public void setSolid(boolean isSolid) {
		isBlockSolid = isSolid;
	}
	
	public List<Direction> getDirectionComingFrom(Rectangle character) {
		List<Direction> list = new ArrayList<Direction>();
		if(character.intersectsLine(getX(), getY() + BUFFER_Y, getX()+getWidth(), getY() + BUFFER_Y)) {
//			System.out.println("N");
			list.add(Direction.NORTH);
		}
		if(character.intersectsLine(getX(), getY()+getHeight(), getX()+getWidth(), getY()+getHeight())) {
//			System.out.println("S");
			list.add(Direction.SOUTH);
		}
		if(character.intersectsLine(getX()+getWidth(), getY(), getX()+getWidth(), getY()+getHeight())) {
//			System.out.println("E");
			list.add(Direction.EAST);
		}
		
		if(character.intersectsLine(getX(), getY(), getX(), getY()+getHeight())) {
//			System.out.println("W");
			list.add(Direction.WEST);
		}
		if (list.isEmpty()) {
			list.add(Direction.NO_DIRECTION);
		}
		return list;
	}
}
