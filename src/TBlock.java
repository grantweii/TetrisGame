import com.jogamp.opengl.GL2;

public class TBlock extends TetrisBlock {

	//purple block
	private double[] colour = { 0.5, 0, 1 };
//	private double[] myTranslation = { 4, 19 };
	
	public TBlock() {
		super(new double[] { 4, 19 });
	}

	@Override
	public void draw(GL2 gl) {
		gl.glPushMatrix();
		
		gl.glTranslated(myTranslation[0], myTranslation[1], 0);
//		gl.glTranslated(1, -1, 0);
		gl.glRotated(myRotation, 0, 0, 1);
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
		
		gl.glBegin(GL2.GL_QUADS);
			gl.glColor3d(colour[0], colour[1], colour[2]);
			
			if (myRotation == 0) {
				gl.glVertex2d(0, 2);
				gl.glVertex2d(1, 2);
				gl.glVertex2d(1, 1);
				gl.glVertex2d(0, 1);
				
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(-1, 0);
				
				gl.glVertex2d(0, 1);
				gl.glVertex2d(1, 1);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(0, 0);
				
				gl.glVertex2d(1, 1);
				gl.glVertex2d(2, 1);
				gl.glVertex2d(2, 0);
				gl.glVertex2d(1, 0);
			} else if (myRotation == -90) {
				gl.glVertex2d(-1, 2);
				gl.glVertex2d(0, 2);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(-1, 1);
				
				gl.glVertex2d(-2, 1);
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(-1, 0);
				gl.glVertex2d(-2, 0);
				
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(-1, 0);
				
				gl.glVertex2d(0, 1);
				gl.glVertex2d(1, 1);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(0, 0);
			} else if (myRotation == -180) {
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(-1, 0);
				
				gl.glVertex2d(-2, 0);
				gl.glVertex2d(-1, 0);
				gl.glVertex2d(-1, -1);
				gl.glVertex2d(-2, -1);
				
				gl.glVertex2d(-1, 0);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(0, -1);
				gl.glVertex2d(-1, -1);
				
				gl.glVertex2d(0, 0);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(1, -1);
				gl.glVertex2d(0, -1);
			} else if (myRotation == -270) {
				gl.glVertex2d(0, 1);
				gl.glVertex2d(1, 1);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(0, 0);
				
				gl.glVertex2d(-1, 0);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(0, -1);
				gl.glVertex2d(-1, -1);
				
				gl.glVertex2d(0, 0);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(1, -1);
				gl.glVertex2d(0, -1);
				
				gl.glVertex2d(1, 0);
				gl.glVertex2d(2, 0);
				gl.glVertex2d(2, -1);
				gl.glVertex2d(1, -1);
			}
			
		gl.glEnd();
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
		
		gl.glBegin(GL2.GL_QUADS);
			gl.glColor3d(1, 1, 1);
			
			if (myRotation == 0) {
				gl.glVertex2d(0, 2);
				gl.glVertex2d(1, 2);
				gl.glVertex2d(1, 1);
				gl.glVertex2d(0, 1);
				
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(-1, 0);
				
				gl.glVertex2d(0, 1);
				gl.glVertex2d(1, 1);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(0, 0);
				
				gl.glVertex2d(1, 1);
				gl.glVertex2d(2, 1);
				gl.glVertex2d(2, 0);
				gl.glVertex2d(1, 0);
			} else if (myRotation == -90) {
				gl.glVertex2d(-1, 2);
				gl.glVertex2d(0, 2);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(-1, 1);
				
				gl.glVertex2d(-2, 1);
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(-1, 0);
				gl.glVertex2d(-2, 0);
				
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(-1, 0);
				
				gl.glVertex2d(0, 1);
				gl.glVertex2d(1, 1);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(0, 0);
			} else if (myRotation == -180) {
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(-1, 0);
				
				gl.glVertex2d(-2, 0);
				gl.glVertex2d(-1, 0);
				gl.glVertex2d(-1, -1);
				gl.glVertex2d(-2, -1);
				
				gl.glVertex2d(-1, 0);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(0, -1);
				gl.glVertex2d(-1, -1);
				
				gl.glVertex2d(0, 0);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(1, -1);
				gl.glVertex2d(0, -1);
			} else if (myRotation == -270) {
				gl.glVertex2d(0, 1);
				gl.glVertex2d(1, 1);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(0, 0);
				
				gl.glVertex2d(-1, 0);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(0, -1);
				gl.glVertex2d(-1, -1);
				
				gl.glVertex2d(0, 0);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(1, -1);
				gl.glVertex2d(0, -1);
				
				gl.glVertex2d(1, 0);
				gl.glVertex2d(2, 0);
				gl.glVertex2d(2, -1);
				gl.glVertex2d(1, -1);
			}
		gl.glEnd();
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
		
	gl.glPopMatrix();
		
	}
}
