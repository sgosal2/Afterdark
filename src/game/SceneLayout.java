package game;
/**
 * SceneLayout.java
 * @author jackthias
 * Created 11/7/16
 * Holds all of the blocks in a scene, holds the backgrounds for a scene. Holds methods for reading
 * in terrain information from a file.
 */

import java.awt.Rectangle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import acm.graphics.GImage;

/**
 * Holds all of the blocks in a scene, holds the backgrounds for a scene. Holds methods for reading
 * in terrain information from a file.
 * @author jackthias
 */
public class SceneLayout {
	public static int TILE_WIDTH = 32;
	public static int TILE_HEIGHT = 32;
	private static final boolean PRINT_CONTENTS = false;
	public static final String LEVEL_PREFIX = "../media/levels/";
	public static final String SPRITE_PREFIX = "../media/images/";
	private List<List<Block>> terrain = new ArrayList<List<Block>>();
	private ArrayList<GImage> backgrounds;
	
	public SceneLayout(int tileWidth, int tileHeight) {
		backgrounds = new ArrayList<GImage>();
		readInData(LEVEL_PREFIX + "prototype1.csv");
	}
	
	public List<List<Block>> getTerrain() {
		return terrain;
	}

	public ArrayList<GImage> getBackgrounds() {
		return backgrounds;
	}

	public void setBackgrounds(ArrayList<GImage> backgrounds) {
		this.backgrounds = backgrounds;
	}

	private boolean readInData(String path) {
		List<String[]> data = new ArrayList<String[]>();
		String line = "";
		String cvsSplitBy = ",";
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			while ((line = reader.readLine()) != null) {
                // use comma as separator
				data.add(line.split(cvsSplitBy));
            }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		if (PRINT_CONTENTS) {
			for (int i = 0; i < data.size(); i++) {
				for (int j = 0; j < data.get(i).length; j++) {
					System.out.print(data.get(i)[j] + ", ");
				}
				System.out.print("\n");
			} 
		}
		
		for (int i = 0; i < data.size(); i++) {
			terrain.add(new ArrayList<Block>());
			for (int j = 0; j < data.get(i).length; j++) {
				if (!data.get(i)[j].equals("-1")) {
					terrain.get(i).add(new Block(SPRITE_PREFIX + "terrain_" + data.get(i)[j] + ".png", j*TILE_HEIGHT, i*TILE_WIDTH));
					terrain.get(i).get(j).setSize(TILE_WIDTH, TILE_HEIGHT);
				} else {
					terrain.get(i).add(null);
				}
			}
		}
		
		return true;
	}
	
	public void setBlock(int x, int y, Block b) {
		terrain.get(x).set(y, b);
	}
	
	
//	public static void main(String[] args) {
//		SceneLayout instance = new SceneLayout();
//		instance.readInData(LEVEL_PREFIX + "prototype.csv");
//	}
	
	public Set<Direction> checkCollisions(Entity e) {
		Rectangle personRect = e.getBox();
		Set<Direction> set = new HashSet<Direction>();
		for(List<Block> row:terrain) {
			for (Block b:row) {
				if (b != null) {
					List<Direction> d = b.getDirectionComingFrom(personRect);
					if (!d.contains(Direction.NO_DIRECTION)) {
						changeCharacter(e, d);
						//changeBlock(b);
						for (Direction dir: d) {
							set.add(dir);
						}
					} 
				} 
			}
		}
		if (set.isEmpty()) {
			set.add(Direction.NO_DIRECTION);
		}
		return set;
	}
	
//	public void changeBlock(Block b) {
//		b.setColor(Color.RED);
//	}
	
	public void changeCharacter(Entity e, List<Direction> d) {
		if(d.contains(Direction.NORTH)) {
			e.setJumping(false);
		} else if(d.contains(Direction.SOUTH)) {
			e.reflectVertically();
		} else if(d.contains(Direction.EAST) || d.contains(Direction.WEST)) {
			e.reflectHorizontally();
		}
	}

	public Block findGround(Entity e) {
		Rectangle personRect = e.getBox();
		for(List<Block> row:terrain) {
			for (Block b:row) {
				if (b != null) {
					List<Direction> d = b.getDirectionComingFrom(personRect);
					if (d.contains(Direction.NORTH)) {
						return b;
					} 
				} 
			}
		}
		return null;
	}
	
	public void horzScroll(double distance) {
		for (List<Block> row:terrain) {
			for (Block b: row) {
				if (b != null) {
					b.move(distance, 0);
				}
			}
		}
	}
	
	public void vertScroll(double distance) {
		for (List<Block> row:terrain) {
			for (Block b: row) {
				if (b != null) {
					b.move(0, distance);
				}
			}
		}
	}
}
