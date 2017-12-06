import com.jogamp.opengl.GL2;

public class ZBlock extends TetrisBlock {

	//red block
	private static final double[] colour = { 1, 0, 0 };
	private static final int[] myTranslation = { 5, -1 };

	private static final int[][] coordinates0 = { {-2, 1}, {-1, 1}, {-1, 0}, {-2, 0},
												     {-1, 1}, {0, 1}, {0, 0}, {-1, 0}, 
												     {-1, 0}, {0, 0}, {0, -1}, {-1, -1},
											 	     {0, 0}, {1, 0}, {1, -1}, {0, -1} }; 
	private static final int[][] coordinates90 = { {-1, 1}, {0, 1}, {0, 0}, {-1, 0},
										   	          {0, 1}, {1, 1}, {1, 0}, {0, 0}, 
											          {0, 0}, {1, 0}, {1, -1}, {0, -1},
											          {1, 0}, {2, 0}, {2, -1}, {1, -1} }; 
	private static final int[][] coordinates180 = { {-1, 2}, {0, 2}, {0, 1}, {-1, 1},
										  	           {0, 2}, {1, 2}, {1, 1}, {0, 1}, 
											           {0, 1}, {1, 1}, {1, 0}, {0, 0},
											           {1, 1}, {2, 1}, {2, 0}, {1, 0} }; 
	private static final int[][] coordinates270 = { {-2, 2}, {-1, 2}, {-1, 1}, {-2, 1},
											   	       {-1, 2}, {0, 2}, {0, 1}, {-1, 1}, 
												       {-1, 1}, {0, 1}, {0, 0}, {-1, 0},
												       {0, 1}, {1, 1}, {1, 0}, {0, 0} }; 
	
	private static final int lowestY0 = -18; //-1
	private static final int lowestY90 = -18; //-1
	private static final int lowestY180 = -19; //0
	private static final int lowestY270 = -19; //0
	private static final int lowestX0 = 2; //-2
	private static final int lowestX90 = 1; //-1
	private static final int lowestX180 = 2; //-1
	private static final int lowestX270 = 2; //-2
	private static final int highestX0 = 9; //-2
	private static final int highestX90 = 9; //-1
	private static final int highestX180 = 9; //-1
	private static final int highestX270 = 9; //-2
	//^ have no idea how it works...

	public ZBlock(Grid grid) {
		super(grid, myTranslation, colour, coordinates0, coordinates90, coordinates180, coordinates270, 
				lowestY0, lowestY90, lowestY180, lowestY270, lowestX0, lowestX90, lowestX180, lowestX270,
				highestX0, highestX90, highestX180, highestX270);
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
