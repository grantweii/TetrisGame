import com.jogamp.opengl.GL2;

public class ZBlock extends TetrisBlock {

	//red block
	private double[] colour = { 1, 0, 0 };
	
	public ZBlock() {}

	@Override
	public void draw(GL2 gl) {
		gl.glPushMatrix();
		
		gl.glTranslated(myTranslation[0], myTranslation[1], 0);
		gl.glTranslated(2, -1, 0);
		gl.glRotated(myRotation, 0, 0, 1);
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
		
		gl.glBegin(GL2.GL_QUADS);
			gl.glColor3d(colour[0], colour[1], colour[2]);
			
			if (myRotation == 0) {
				gl.glVertex2d(-2, 1);
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(-1, 0);
				gl.glVertex2d(-2, 0);
				
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(-1, 0);
				
				gl.glVertex2d(-1, 0);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(0, -1);
				gl.glVertex2d(-1, -1);
				
				gl.glVertex2d(0, 0);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(1, -1);
				gl.glVertex2d(0, -1);
			} else if (myRotation == -90 || myRotation == -180) {
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(-1, 0);
				
				gl.glVertex2d(0, 1);
				gl.glVertex2d(1, 1);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(0, 0);
				
				gl.glVertex2d(0, 0);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(1, -1);
				gl.glVertex2d(0, -1);
				
				gl.glVertex2d(1, 0);
				gl.glVertex2d(2, 0);
				gl.glVertex2d(2, -1);
				gl.glVertex2d(1, -1);
			} else if (myRotation == -270) {
				gl.glVertex2d(-2, 2);
				gl.glVertex2d(-1, 2);
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(-2, 1);
				
				gl.glVertex2d(-1, 2);
				gl.glVertex2d(0, 2);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(-1, 1);
				
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(-1, 0);
				
				gl.glVertex2d(0, 1);
				gl.glVertex2d(1, 1);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(0, 0);
			}
		gl.glEnd();
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
		
		gl.glBegin(GL2.GL_QUADS);
			gl.glColor3d(1, 1, 1);
			
			if (myRotation == 0) {
				gl.glVertex2d(-2, 1);
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(-1, 0);
				gl.glVertex2d(-2, 0);
				
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(-1, 0);
				
				gl.glVertex2d(-1, 0);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(0, -1);
				gl.glVertex2d(-1, -1);
				
				gl.glVertex2d(0, 0);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(1, -1);
				gl.glVertex2d(0, -1);
			} else if (myRotation == -90 || myRotation == -180) {
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(-1, 0);
				
				gl.glVertex2d(0, 1);
				gl.glVertex2d(1, 1);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(0, 0);
				
				gl.glVertex2d(0, 0);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(1, -1);
				gl.glVertex2d(0, -1);
				
				gl.glVertex2d(1, 0);
				gl.glVertex2d(2, 0);
				gl.glVertex2d(2, -1);
				gl.glVertex2d(1, -1);
			} else if (myRotation == -270) {
				gl.glVertex2d(-2, 2);
				gl.glVertex2d(-1, 2);
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(-2, 1);
				
				gl.glVertex2d(-1, 2);
				gl.glVertex2d(0, 2);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(-1, 1);
				
				gl.glVertex2d(-1, 1);
				gl.glVertex2d(0, 1);
				gl.glVertex2d(0, 0);
				gl.glVertex2d(-1, 0);
				
				gl.glVertex2d(0, 1);
				gl.glVertex2d(1, 1);
				gl.glVertex2d(1, 0);
				gl.glVertex2d(0, 0);
			}
		gl.glEnd();
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
	}

}
