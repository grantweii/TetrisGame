import com.jogamp.opengl.GL2;

public class OBlock extends TetrisBlock {
	
	//yellow
	private static final double[] colour = { 0.9, 0.9, 0 };
	private static final int[] startingTranslation = { 5, -1 };

	private static final int[][] coordinates = { {-1, 1}, {0, 1}, {0, 0}, {-1, 0},
												    {0, 1}, {1, 1}, {1, 0}, {0, 0}, 
												    {0, 0}, {1, 0}, {1, -1}, {0, -1},
												    {-1, 0}, {0, 0}, {0, -1}, {-1, -1} }; 
	private static final int lowestY = -19;
	private static final int lowestX = 1;
	private static final int highestX = 9;

	
	public OBlock(Grid grid) {
		super(grid, startingTranslation.clone(), colour, coordinates, coordinates, coordinates, coordinates, 
				lowestY, lowestY, lowestY, lowestY, lowestX, lowestX, lowestX, lowestX,
				highestX, highestX, highestX, highestX);	
	}
	
	@Override
	public void draw(GL2 gl) {
		gl.glPushMatrix();
		
		gl.glTranslated(myTranslation[0], myTranslation[1], 0);
		gl.glRotated(myRotation, 0, 0, 1);
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
		
		gl.glBegin(GL2.GL_QUADS);
			gl.glColor3d(colour[0], colour[1], colour[2]);
			
			for (int i = 0; i < coordinates.length; i++) {
				gl.glVertex2d(coordinates[i][0], coordinates[i][1]);
			}

		gl.glEnd();
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
		
		gl.glBegin(GL2.GL_QUADS);
			gl.glColor3d(1, 1, 1);
			
			for (int i = 0; i < coordinates.length; i++) {
				gl.glVertex2d(coordinates[i][0], coordinates[i][1]);
			}
			
		gl.glEnd();
		
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
		
		gl.glPopMatrix();
	
		updateGlobalCoordinates();
		findLowestYCoord();
	
	}
	

}
