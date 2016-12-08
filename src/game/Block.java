package game;
/**
 * Block.java
 * @author jackthias
 * Created 11/7/16
 * Block represents a single "tile" of terrain in a scene.
 */

import java.awt.Rectangle;

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

	protected boolean isBlockSolid;
	
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
	
	/*
	 * This method will determine the specific direction the character
	 * will be arriving from in order to initiate the next action.
	 */
	public Direction getDirectionComingFrom(Rectangle character) {
		if(character.intersectsLine(getX(), getY() + BUFFER_Y, getX()+getWidth(), getY() + BUFFER_Y)) {
//			System.out.println("N");
			return Direction.NORTH;
		}
		
		if(character.intersectsLine(getX()+getWidth(), getY(), getX()+getWidth(), getY()+getHeight())) {
//			System.out.println("E");
			return Direction.EAST;
		}
		
		if(character.intersectsLine(getX(), getY(), getX(), getY()+getHeight())) {
//			System.out.println("W");
			return Direction.WEST;
		}
		
		if(character.intersectsLine(getX(), getY()+getHeight(), getX()+getWidth(), getY()+getHeight())) {
//			System.out.println("S");
			return Direction.SOUTH;
		}
		
		return Direction.NO_DIRECTION;
	}
}
