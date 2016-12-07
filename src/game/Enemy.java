package game;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.*;

public class Enemy extends Entity{
	
	private int timerNum;
	
	public Enemy(String imgName, int startX, int startY, int imagesInAnimation) {
		super(imgName, startX, startY, imagesInAnimation);
		super.dx = 1;
		this.sprite.setSize(24, 24);
		timerNum = 0;
	}
	
	public void walkMovement() {
		super.walkMovement();
		System.out.print("Enemy");
		timerNum++;
		if ((timerNum % 20) == 1) {
			dx = dx * -1;
		}
	}

}
