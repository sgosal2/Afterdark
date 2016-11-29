package game;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.*;

public class Enemy extends Entity implements ActionListener {

	Timer enemyTimer = new Timer(4000, this);
	int directionNum;
	
	public Enemy(String imgName, int startX, int startY, int imagesInAnimation) {
		super(imgName, startX, startY, imagesInAnimation);
		directionNum = 0;
	}
	
	public void actionPerformed(ActionEvent e) {
		if ((directionNum % 2) == 1) {
			this.walk(Direction.EAST);
		}
		else {
			this.walk(Direction.WEST);
		}
		directionNum++;
	}
	
	public void attack() {
		
	}
	
	
	
}
