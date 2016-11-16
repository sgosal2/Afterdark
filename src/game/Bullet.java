package game;
import acm.graphics.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import utilities.MainApplication;

import java.awt.Rectangle;
import acm.graphics.*;

public class Bullet implements ActionListener {
	
	private GImage sprite;
	private Entity sender;
	private Direction direction;
	private int damage;
	private MainApplication program;
	private static final int DAMAGE = 1;
	private static final int SPEED = 1;
	
	Timer someTimer = new Timer(100, this);
	
	private Bullet(GImage sp, Entity se, Direction d, int dam) {
		sprite = sp;
		sender = se;
		direction = d;
		damage = dam;
	}
	
	public void actionPerformed(ActionEvent e) {
		sprite.move(5, 0);
	}
	
	public GImage getSprite() {
		return sprite;
	}
	
	public void setSprite(GImage s) {
		sprite = s;
	}
	
	public Entity getSender() {
		return sender;
	}
	
	public void setDamage(int d) {
		damage = d;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	private void setDirection(Direction d) {
		direction = d;
	}
	
	private Boolean destroy(Entity e) {
		program.remove(e.getSprite());
		return true;
	}
	
	private void move() {
		someTimer.start();
	}
	
}
