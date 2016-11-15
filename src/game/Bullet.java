package game;
import acm.graphics.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import java.awt.Rectangle;
import acm.graphics.*;

public class Bullet implements ActionListener {
	
	private GImage sprite;
	private Entity sender;
	private Direction direction;
	private int damage;
	private static final int DAMAGE = 1;
	private static final int SPEED = 1;
	
	Timer someTimer = new Timer(200, this);
	
	private Bullet(GImage sp, Entity se, Direction d, int dam) {
		sprite = sp;
		sender = se;
		direction = d;
		damage = dam;
	}
	
	public void actionPerformed(ActionEvent e) {
		sprite.move(5, 0);
	}
	
	private GImage getSprite() {
		return sprite;
	}
	
	private void setSprite(GImage s) {
		sprite = s;
	}
	
	private Entity getSender() {
		return sender;
	}
	
	private void setDamage(int d) {
		damage = d;
	}
	
	private int getDamage() {
		return damage;
	}
	
	private Direction getDirection() {
		return direction;
	}
	
	private void setDirection(Direction d) {
		direction = d;
	}
	
	private Boolean destroy(Entity e) {
		return true;
	}
	
	private void move() {
		
		someTimer.start();
	}
	
}
