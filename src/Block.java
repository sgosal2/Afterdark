/**
 * Block.java
 * @author jackthias
 * Created 11/7/16
 * Block represents a single "tile" of terrain in a scene.
 */

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

	private boolean isBlockSolid;
	
	public Block(String imageName, double x, double y) {
		super(imageName, x, y);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSolid() {
		return isBlockSolid;
	}
	
	public void setSolid(boolean isSolid) {
		isBlockSolid = isSolid;
	}
}
