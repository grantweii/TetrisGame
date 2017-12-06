import java.util.ArrayList;

public class Grid {
	
	public final static double leftEdge = 0;
	public final static double rightEdge = 10;
	public final static double topEdge = 0;
	public final static double bottomEdge = -20;

	
	//make bottom left 0,0 
	public double[] myTranslation = { -5, 10 };
	
	//10 x 20 grid 
	public int[][] grid = { {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0} };
	
	public Grid() {}
	
	//global coordinates as points
	public boolean checkLeftEdge(int[][] points) {
		for (int i = 0; i < points.length; i++) {
//			System.out.println("x: " + points[i][0]);
//			System.out.println("y: " + points[i][1]);
//			System.out.println("---");
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
	
	public boolean checkBottomEdge(int[][] points) {
		for (int i = 0; i < points.length; i++) {
			if (points[i][1] == -20) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * true if hits
	 * @param lowestCoordinates
	 * @return
	 */
	public boolean collision(ArrayList<Integer[]> lowestCoordinates) {
	
		for (int i = 0; i < lowestCoordinates.size(); i++) {
			int x1 = lowestCoordinates.get(i)[0];
			int x2 = lowestCoordinates.get(i)[2];
			int y1 = lowestCoordinates.get(i)[1];
			int y2 = lowestCoordinates.get(i)[3];
			
			
			if (grid[x1][y1] == 1 && grid[x2][y2] == 1) {
				return true;
			}
		}
		return false;
	}
}
