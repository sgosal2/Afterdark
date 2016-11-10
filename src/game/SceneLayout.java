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
import java.util.List;

import acm.graphics.GImage;

/**
 * Holds all of the blocks in a scene, holds the backgrounds for a scene. Holds methods for reading
 * in terrain information from a file.
 * @author jackthias
 */
public class SceneLayout {
	public static final int TILE_WIDTH = 32;
	public static final int TILE_HEIGHT = 32;
	private static final boolean PRINT_CONTENTS = false;
	public static final String LEVEL_PREFIX = "./media/levels/";
	public static final String SPRITE_PREFIX = "./media/images/";
	private List<List<Block>> terrain = new ArrayList<List<Block>>();
	private ArrayList<GImage> backgrounds;
	
	public SceneLayout() {
		backgrounds = new ArrayList<GImage>();
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

	public boolean readInData(String path) {
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
					terrain.get(i).add(new Block(SPRITE_PREFIX + "terrain_" + data.get(i)[j] + ".png", i*TILE_WIDTH, j*TILE_HEIGHT));
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
	
	
	public static void main(String[] args) {
		SceneLayout instance = new SceneLayout();
		instance.readInData(LEVEL_PREFIX + "prototype.csv");
	}
	
	public Direction checkCollisions(Entity character) {
		Rectangle personRect = character.getBox();
		for(List<Block> row:terrain) {
			for (Block b:row) {
				Direction d = b.getDirectionComingFrom(personRect);
				if (d != Direction.NO_DIRECTION) {
					changeCharacter(character, d);
					//changeBlock(b);
					return d;
				} 
			}
		}
		return Direction.NO_DIRECTION;
	}
	
//	public void changeBlock(Block b) {
//		b.setColor(Color.RED);
//	}
	
	public void changeCharacter(Entity c, Direction d) {
		if(d == Direction.NORTH || d == Direction.SOUTH) {
			c.reflectVertically();
		}
		if(d == Direction.EAST || d == Direction.WEST) {
			c.reflectHorizontally();
		}
	}
}
