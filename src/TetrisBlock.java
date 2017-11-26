import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.jogamp.opengl.GL2;


public abstract class TetrisBlock implements KeyListener {

	//these are global coordinates
	public double x;
	public double y;
	
	//starting translation and rotation
	protected double myRotation = 0;
	protected double[] myTranslation;
	
	public TetrisBlock(double[] translation) {
		this.myTranslation = translation;
	}
	
	
	/**
	 * gets called every frame, it should only be translated by 1 grid unit at a time
	 * @param gl
	 */
	public abstract void draw(GL2 gl);
	
//	public double[] getGlobalPosition() {
//		double[] globalPosition = new double[3];
//		
//		
//	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			
			//rotate
			case KeyEvent.VK_UP:
				myRotation -= 90;
				if (myRotation == -360) {
					myRotation = 0;
				}
				break;
			//increase speed down temporarily
			case KeyEvent.VK_DOWN:
				myTranslation[1] += -1;
				break;
			//strafe left
			case KeyEvent.VK_LEFT:
				myTranslation[0] += -1;
				break;
			//strafe right
			case KeyEvent.VK_RIGHT:
				myTranslation[0] += 1;
				break;
			//drop down
			case KeyEvent.VK_SPACE:
				break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
	
}
