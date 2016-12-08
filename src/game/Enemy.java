package game;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.*;

public class Enemy extends Entity{
	
	private int timerNum;

	public Enemy(String imgName, int startX, int startY, int imagesInWalk, int imagesInIdle) {
		super(imgName, startX, startY, imagesInWalk, imagesInIdle);
		this.sprite.setSize(64, 64);
		timerNum = 0;
		dx = 10;
	}
	
	public void walkMovement() {
		System.out.println("DX: " + dx);
		move(dx, dy);
		System.out.print("Enemy");
		timerNum++;
		if ((timerNum % 400) == 200) {
			dx = dx * -1;
		}
	}

}
