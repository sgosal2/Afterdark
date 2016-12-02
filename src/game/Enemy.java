package game;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.*;

public class Enemy extends Entity implements ActionListener{
	
	Timer movementTimer = new Timer(10, this);
	private int timerNum;
	
	public Enemy(String imgName, int startX, int startY, int imagesInAnimation) {
		super(imgName, startX, startY, imagesInAnimation);
		this.sprite.setSize(24, 24);
	}
	
	public void attack() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		timerNum++;
		if (timerNum % 400 < 200) {
			sprite.move(1, 0);
		}
		else {
			sprite.move(-1, 0);
		}
	}
	
	public void move() {
		movementTimer.start();
	}
	
}
