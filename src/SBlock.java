import com.jogamp.opengl.GL2;

public class SBlock extends TetrisBlock {
	
	//green
	private static final double[] colour = { 0, 0.9, 0 };
	private static final double[] myTranslation = { 4, -1 };

	private static final double[][] coordinates0 = { {0, 1}, {1, 1}, {1, 0}, {0, 0},
												     {1, 1}, {2, 1}, {2, 0}, {1, 0}, 
												     {0, 0}, {1, 0}, {1, -1}, {0, -1},
											 	     {-1, 0}, {0, 0}, {0, -1}, {-1, -1} }; 
	private static final double[][] coordinates90 = { {0, 2}, {1, 2}, {1, 1}, {0, 1},
										  	          {1, 2}, {2, 2}, {2, 1}, {1, 1}, 
											          {0, 1}, {1, 1}, {1, 0}, {0, 0},
											          {-1, 1}, {0, 1}, {0, 0}, {-1, 0} }; 
	private static final double[][] coordinates180 = { {-1, 2}, {0, 2}, {0, 1}, {-1, 1},
										 	           {0, 2}, {1, 2}, {1, 1}, {0, 1}, 
											           {-2, 1}, {-1, 1}, {-1, 0}, {-2, 0},
											           {-1, 1}, {0, 1}, {0, 0}, {-1, 0} }; 
	private static final double[][] coordinates270 = { {-1, 1}, {0, 1}, {0, 0}, {-1, 0},
											   	       {0, 1}, {1, 1}, {1, 0}, {0, 0}, 
												       {-1, 0}, {0, 0}, {0, -1}, {-1, -1},
												       {-2, 0}, {-1, 0}, {-1, -1}, {-2, -1} }; 

	
	public SBlock(Grid grid) {
		super(grid, myTranslation, colour, coordinates0, coordinates90, coordinates180, coordinates270);
	}

	@Override
	public void draw(GL2 gl) {
		gl.glPushMatrix();
		
		gl.glTranslated(myTranslation[0], myTranslation[1], 0);
		gl.glRotated(myRotation, 0, 0, 1);
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
		
		gl.glBegin(GL2.GL_QUADS);
			gl.glColor3d(colour[0], colour[1], colour[2]);
			
			
			if (myRotation == 0) {
				for (int i = 0; i < coordinates0.length; i++) {
					gl.glVertex2d(coordinates0[i][0], coordinates0[i][1]);
				}
			} else if (myRotation == -90 ) {
				for (int i = 0; i < coordinates90.length; i++) {
					gl.glVertex2d(coordinates90[i][0], coordinates90[i][1]);
				}
			} else if (myRotation == -180) {
				for (int i = 0; i < coordinates180.length; i++) {
					gl.glVertex2d(coordinates180[i][0], coordinates180[i][1]);
				}
			} else if (myRotation == -270) {
				for (int i = 0; i < coordinates270.length; i++) {
					gl.glVertex2d(coordinates270[i][0], coordinates270[i][1]);
				}
			}
			
		gl.glEnd();
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
		
		gl.glBegin(GL2.GL_QUADS);
			gl.glColor3d(1, 1, 1);
			
			if (myRotation == 0) {
				for (int i = 0; i < coordinates0.length; i++) {
					gl.glVertex2d(coordinates0[i][0], coordinates0[i][1]);
				}
			} else if (myRotation == -90 ) {
				for (int i = 0; i < coordinates90.length; i++) {
					gl.glVertex2d(coordinates90[i][0], coordinates90[i][1]);
				}
			} else if (myRotation == -180) {
				for (int i = 0; i < coordinates180.length; i++) {
					gl.glVertex2d(coordinates180[i][0], coordinates180[i][1]);
				}
			} else if (myRotation == -270) {
				for (int i = 0; i < coordinates270.length; i++) {
					gl.glVertex2d(coordinates270[i][0], coordinates270[i][1]);
				}
			}
			
		gl.glEnd();
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
		
		gl.glPopMatrix();
		
		updateGlobalCoordinates();
		findLowestYCoord();
		
	}
}
