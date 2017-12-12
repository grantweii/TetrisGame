import java.util.ArrayList;

public class Grid {
	
	public boolean activeBlock;
	
	public final static double leftEdge = 0;
	public final static double rightEdge = 10;
	public final static double topEdge = 0;
	public final static double bottomEdge = -20;

	
	//make bottom left 0,0 
	public double[] myTranslation = { -5, 10 };
	
	//10 x 20 grid 
	public int[][] grid = { {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0} };
	
	public Grid() {
		activeBlock = false;
	}
	
	//global coordinates as points
	public boolean checkLeftEdge(int[][] points) {
		for (int i = 0; i < points.length; i++) {
			if (points[i][0] == 0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkRightEdge(int[][] points) {
		for (int i = 0; i < points.length; i++) {
			if (points[i][0] == 10) {
				return false;
			}
		}
		return true;
	}
	
	//returns false if hits bottom edge
	public boolean checkBottomEdge(int[][] points) {
		for (int i = 0; i < points.length; i++) {
			if (points[i][1] == -20) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * true if collides
	 * @param lowestCoordinates
	 * @return
	 */
	public boolean collision(ArrayList<Integer[]> lines) {			
		for (int i = 0; i < lines.size(); i++) {
			int x1 = lines.get(i)[0];
			int y1 = lines.get(i)[1];
			int x2 = lines.get(i)[2];
			int y2 = lines.get(i)[3];
			
			if (grid[-y1][x1] == 1 && grid[-y2][x2] == 1) {
				return true;
			}
		}
		return false;
	}

	public void fillGrid(int[][] globalCoordinates) {
		for (int i = 0; i < globalCoordinates.length; i++) {
			grid[-globalCoordinates[i][1]][globalCoordinates[i][0]] = 1;
		}
		activeBlock = false;
	}
}
