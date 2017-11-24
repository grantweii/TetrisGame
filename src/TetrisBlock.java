import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.jogamp.opengl.GL2;


public abstract class TetrisBlock implements KeyListener {

	//these are global coordinates
	public double x;
	public double y;
	
	//starting translation and rotation
	protected double[] myTranslation = { 3, 20 };
	protected double myRotation = 0;
	
	
	/**
	 * gets called every frame, it should only be translated by 1 grid unit at a time
	 * @param gl
	 */
	public abstract void draw(GL2 gl);
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			
			//rotate
			case KeyEvent.VK_UP:
		
			//increase speed down temporarily
			case KeyEvent.VK_DOWN:
			
			//strafe left
			case KeyEvent.VK_LEFT:
				
			//strafe right
			case KeyEvent.VK_RIGHT:
				
			//drop down
			case KeyEvent.VK_SPACE:		
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
	
}
