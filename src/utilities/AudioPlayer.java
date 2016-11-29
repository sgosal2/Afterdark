package utilities;
// Maximo Macchi v2

import java.net.URL;
import java.util.ArrayList;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
//This is how you commit and push in Eclipse.
public class AudioPlayer {
	private ArrayList<MediaPlayer> players;
	private static AudioPlayer somePlayer;
	
	public AudioPlayer() {
		JFXPanel fxPanel = new JFXPanel();
		players = new ArrayList<MediaPlayer>();
	}
	
	public static AudioPlayer getInstance() {
		if(somePlayer == null) {
			somePlayer = new AudioPlayer();
		}
		return somePlayer;
	}
	
	public void playSound(String folder, String filename) {
		MediaPlayer mPlayer = findSound(folder, filename);
		if(mPlayer == null) {
			mPlayer = createMediaPlayer(folder, filename);
		}
		if(mPlayer.getCycleDuration().lessThanOrEqualTo(mPlayer.getCurrentTime())) {
			mPlayer.seek(Duration.ZERO);
		}
		mPlayer.play();
	}
	
	public void playSound(String filepath) {
		MediaPlayer mPlayer = findSound(filepath);
		if(mPlayer == null) {
			mPlayer = createMediaPlayer(filepath);
		}
		if(mPlayer.getCycleDuration().lessThanOrEqualTo(mPlayer.getCurrentTime())) {
			mPlayer.seek(Duration.ZERO);
		}
		mPlayer.play();
	}
	
	private MediaPlayer createMediaPlayer(String folder, String filename) {
		Media sound = new Media(buildResourcePath(folder, filename));
		MediaPlayer mPlayer = new MediaPlayer(sound);
		players.add(mPlayer);
		return mPlayer;
	}
	
	private MediaPlayer createMediaPlayer(String filepath) {
		Media sound = new Media(buildResourcePath(filepath));
		MediaPlayer mPlayer = new MediaPlayer(sound);
		players.add(mPlayer);
		return mPlayer;
	}
	
	private String buildResourcePath(String folder, String filename) {
		if(folder != null && folder.length() > 0) {
			folder += "/";
		}
		final URL resource = getClass().getResource(folder+filename);
		try {
			String result = resource.toString();
			return result;
		}catch(NullPointerException ex) {
			ex.printStackTrace();
			System.out.println("MEDIA FILE NOT FOUND: " + folder+filename + "...Exiting");
			System.exit(0);
		}
		return resource.toString();
	}
	
	private String buildResourcePath(String filepath) {
		final URL resource = getClass().getResource(filepath);
		try {
			String result = resource.toString();
			return result;
		}catch(NullPointerException ex) {
			ex.printStackTrace();
			System.out.println("MEDIA FILE NOT FOUND: " + filepath + "...Exiting");
			System.exit(0);
		}
		return resource.toString();
	}
	
	private MediaPlayer findSound(String folder, String filename) {
		String path = buildResourcePath(folder, filename);
		for(MediaPlayer mP : players) {
			if(mP.getMedia().getSource().equals(path)) {
				return mP;
			}
		}
		return null;
	}
	
	private MediaPlayer findSound(String filepath) {
		String path = buildResourcePath(filepath);
		for(MediaPlayer mP : players) {
			if(mP.getMedia().getSource().equals(path)) {
				return mP;
			}
		}
		return null;
	}
	
	public void stopSound(String folder, String filename) {
		MediaPlayer mp = findSound(folder, filename);
		if(mp != null) {
			mp.stop();
		}
	}
	
	public void pauseSound(String folder, String filename) {
		MediaPlayer mp = findSound(folder, filename);
		if(mp != null) {
			mp.pause();
		}
	}
}
