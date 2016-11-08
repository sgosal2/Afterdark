/**
 * SceneLayout.java
 * @author jackthias
 * Created 11/7/16
 * Holds all of the blocks in a scene, holds the backgrounds for a scene. Holds methods for reading
 * in terrain information from a file.
 */

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
		// TODO Look at how .csv files are read-in and modify appropriately.
		ArrayList<String> data = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			for (int i = 0; i < reader.lines().toArray().length; i++) {
				data.add(reader.readLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		for (int i = 0; i < data.size(); i++) {
			terrain.add(new ArrayList<Block>());
			for (int j = 0; j < data.get(i).length(); j++) {
				// TODO Set-up proper column iteration. Look into how .csv files are read in.
				terrain.get(i).add(null);
			}
		}
		
		return true;
	}
	
}
