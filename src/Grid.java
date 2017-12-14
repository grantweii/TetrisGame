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
	public int[][] gridPoints = { {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
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
	
	public Grid() {
		activeBlock = false;
	}
	
	//global coordinates as points
//	public boolean checkLeftEdge(int[][] points) {
//		for (int i = 0; i < points.length; i++) {
//			if (points[i][0] == 0) {
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public boolean checkRightEdge(int[][] points) {
//		for (int i = 0; i < points.length; i++) {
//			if (points[i][0] == 10) {
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	//returns false if hits bottom edge
//	public boolean checkBottomEdge(int[][] points) {
//		for (int i = 0; i < points.length; i++) {
//			if (points[i][1] == -20) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	public boolean checkLeftEdge(ArrayList<Integer[]> gridCoords) {
		for (Integer[] coord: gridCoords) {
			System.out.println(coord[0]);
			if (coord[0] == 0) {
				return true;
			}
		}
		return false;
	}

	public boolean checkRightEdge(ArrayList<Integer[]> gridCoords) {
		for (Integer[] coord: gridCoords) {
			if (coord[0] == 9) {
				return true;
			}
		}
		return false;
	}

	//returns true if hits bottom edge
	public boolean checkBottomEdge(ArrayList<Integer[]> gridCoords) {
		for (Integer[] coord: gridCoords) {
			if (coord[1] == -19) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * true if collides
	 * @param lowestCoordinates
	 * @return
	 */
//	public boolean collision(ArrayList<Integer[]> lines) {			
//		for (int i = 0; i < lines.size(); i++) {
//			int x1 = lines.get(i)[0];
//			int y1 = lines.get(i)[1];
//			int x2 = lines.get(i)[2];
//			int y2 = lines.get(i)[3];
//			
//			if (gridPoints[-y1][x1] == 1 && gridPoints[-y2][x2] == 1) {
//				System.out.println("x1: " + x1 + " y1: " + y1);
//				System.out.println("x2: " + x2 + " y2: " + y2);
//				return true;
//			}
//		}
//		return false;
//	}
	
	public boolean collisionDown(ArrayList<Integer[]> gridCoords) {			
		for (Integer[] coord: gridCoords) {
			if (grid[-(coord[1]-1)][coord[0]] == 1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean collisionLeft(ArrayList<Integer[]> gridCoords) {			
		for (Integer[] coord: gridCoords) {
			if (grid[-(coord[1])][coord[0]-1] == 1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean collisionRight(ArrayList<Integer[]> gridCoords) {			
		for (Integer[] coord: gridCoords) {
			if (grid[-(coord[1])][coord[0]+1] == 1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean collisionRotation(ArrayList<Integer[]> gridCoords) {			
		for (Integer[] coord: gridCoords) {
			if (grid[-(coord[1])][coord[0]] == 1) {
				return true;
			}
		}
		return false;
	}
	
	
//	public void fillGrid(int[][] globalCoordinates) {
//		for (int i = 0; i < globalCoordinates.length; i++) {
//			gridPoints[-globalCoordinates[i][1]][globalCoordinates[i][0]] = 1;
//		}
//		activeBlock = false;
//	}
	
	public void fillGrid(ArrayList<Integer[]> gridCoords) {
		for (Integer[] coords: gridCoords) {
			grid[-coords[1]][coords[0]] = 1;
		}
		activeBlock = false;
	}
}
