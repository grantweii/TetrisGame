import com.jogamp.opengl.GL2;

public class JBlock extends TetrisBlock {

	//blue block
	private double[] colour = { 0, 0, 1 };
//	private double[] myTranslation = { 4, 18 };
	
	public JBlock() {
		super(new double[] { 4, 18 });
	}

	@Override
	public void draw(GL2 gl) {
		gl.glPushMatrix();
		
		gl.glTranslated(myTranslation[0], myTranslation[1], 0);
//		gl.glTranslated(1, -2, 0);
		gl.glRotated(myRotation, 0, 0, 1);
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
		
		gl.glBegin(GL2.GL_QUADS);
			gl.glColor3d(colour[0], colour[1], colour[2]);
			
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
			
			gl.glVertex2d(1, 1);
			gl.glVertex2d(2, 1);
			gl.glVertex2d(2, 0);
			gl.glVertex2d(1, 0);
			
//			gl.glVertex2d(0, 0);
//			gl.glVertex2d(1, 0);
//			gl.glVertex2d(1, -1);
//			gl.glVertex2d(0, -1);
//			
//			gl.glVertex2d(0, -1);
//			gl.glVertex2d(1, -1);
//			gl.glVertex2d(1, -2);
//			gl.glVertex2d(0, -2);
//			
//			gl.glVertex2d(1, -1);
//			gl.glVertex2d(2, -1);
//			gl.glVertex2d(2, -2);
//			gl.glVertex2d(1, -2);
//			
//			gl.glVertex2d(2, -1);
//			gl.glVertex2d(3, -1);
//			gl.glVertex2d(3, -2);
//			gl.glVertex2d(2, -2);
		gl.glEnd();
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
		
		gl.glBegin(GL2.GL_QUADS);
			gl.glColor3d(1, 1, 1);
			
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
			
			gl.glVertex2d(1, 1);
			gl.glVertex2d(2, 1);
			gl.glVertex2d(2, 0);
			gl.glVertex2d(1, 0);
		gl.glEnd();
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
		
	gl.glPopMatrix();
		
	}
	
}
