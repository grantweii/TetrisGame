import com.jogamp.opengl.GL2;

public class LBlock extends TetrisBlock {
	
	//orange block
	private double[] colour = { 1, 0.5, 0 };
	
	public LBlock() {}
	
	@Override
	public void draw(GL2 gl) {
		gl.glPushMatrix();
		
		gl.glTranslated(myTranslation[0], myTranslation[1], 0);
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
		
		gl.glBegin(GL2.GL_QUADS);
			gl.glColor3d(colour[0], colour[1], colour[2]);
			
			gl.glVertex2d(2, 0);
			gl.glVertex2d(3, 0);
			gl.glVertex2d(3, -1);
			gl.glVertex2d(2, -1);
			
			gl.glVertex2d(2, -1);
			gl.glVertex2d(3, -1);
			gl.glVertex2d(3, -2);
			gl.glVertex2d(2, -2);
			
			gl.glVertex2d(1, -1);
			gl.glVertex2d(2, -1);
			gl.glVertex2d(2, -2);
			gl.glVertex2d(1, -2);
			
			gl.glVertex2d(0, -1);
			gl.glVertex2d(1, -1);
			gl.glVertex2d(1, -2);
			gl.glVertex2d(0, -2);
		gl.glEnd();
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
		
		gl.glBegin(GL2.GL_QUADS);
			gl.glColor3d(1, 1, 1);
			
			gl.glVertex2d(2, 0);
			gl.glVertex2d(3, 0);
			gl.glVertex2d(3, -1);
			gl.glVertex2d(2, -1);
			
			gl.glVertex2d(2, -1);
			gl.glVertex2d(3, -1);
			gl.glVertex2d(3, -2);
			gl.glVertex2d(2, -2);
			
			gl.glVertex2d(1, -1);
			gl.glVertex2d(2, -1);
			gl.glVertex2d(2, -2);
			gl.glVertex2d(1, -2);
			
			gl.glVertex2d(0, -1);
			gl.glVertex2d(1, -1);
			gl.glVertex2d(1, -2);
			gl.glVertex2d(0, -2);
		gl.glEnd();
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
		
	gl.glPopMatrix();
		
	}

}
