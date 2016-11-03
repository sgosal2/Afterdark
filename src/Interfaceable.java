//Interfaceable.java
//Provided by Osvaldo Jimenez
//Added on 11/3/17
//Maintained by Jack Thias

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface Interfaceable extends Displayable {
	public void mousePressed(MouseEvent e);
	public void mouseReleased(MouseEvent e);
	public void mouseClicked(MouseEvent e);
	public void mouseDragged(MouseEvent e);
	public void mouseMoved(MouseEvent e);
	public void keyPressed(KeyEvent e);
	public void keyReleased(KeyEvent e);
	public void keyTyped(KeyEvent e);
}
