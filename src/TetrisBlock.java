import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import com.jogamp.opengl.GL2;


public abstract class TetrisBlock implements KeyListener {

	protected Grid grid;
	
	protected double[] colour;
	protected int[][] coordinates0;
	protected int[][] coordinates90;
	protected int[][] coordinates180;
	protected int[][] coordinates270;
	protected int[][] globalCoordinates0;
	protected int[][] globalCoordinates90;
	protected int[][] globalCoordinates180;
	protected int[][] globalCoordinates270;
	protected int lowestY0;
	protected int lowestY90;
	protected int lowestY180;
	protected int lowestY270;
	protected int lowestX0;
	protected int lowestX90;
	protected int lowestX180;
	protected int lowestX270;
	protected int highestX0;
	protected int highestX90;
	protected int highestX180;
	protected int highestX270;


	
	//starting translation and rotation
	protected int myRotation = 0;
	protected int[] myTranslation;
	
	public TetrisBlock(Grid grid, int[] translation, double[] colour, int[][] coordinates0, 
			int[][] coordinates90, int[][] coordinates180, int[][] coordinates270,
			int lowestY0, int lowestY90, int lowestY180, int lowestY270, 
			int lowestX0, int lowestX90, int lowestX180, int lowestX270,
			int highestX0, int highestX90, int highestX180, int highestX270) {
		this.grid = grid;
		this.myTranslation = translation;
		this.colour = colour;
		this.coordinates0 = coordinates0;
		this.coordinates90 = coordinates90;
		this.coordinates180 = coordinates180;
		this.coordinates270 = coordinates270;
		this.globalCoordinates0 = new int[16][2];
		this.globalCoordinates90 = new int[16][2];
		this.globalCoordinates180 = new int[16][2];
		this.globalCoordinates270 = new int[16][2];
		this.lowestY0 = lowestY0;
		this.lowestY90 = lowestY90;
		this.lowestY180 = lowestY180;
		this.lowestY270 = lowestY270;
		this.lowestX0 = lowestX0;
		this.lowestX90 = lowestX90;
		this.lowestX180 = lowestX180;
		this.lowestX270 = lowestX270;
		this.highestX0 = highestX0;
		this.highestX90 = highestX90;
		this.highestX180 = highestX180;
		this.highestX270 = highestX270;
	}
	
	
	/**
	 * gets called every frame, it should only be translated by 1 grid unit at a time
	 * @param gl
	 */
	public abstract void draw(GL2 gl);
	
	
	/**
	 * gets called every frame by draw
	 * @return
	 */
	public void updateGlobalCoordinates() {		
		//grid matrix is only the translation matrix
		int[][] myTranslationMatrix = MathUtil.translationMatrix(myTranslation);
		int[][] myRotationMatrix = MathUtil.rotationMatrix(myRotation);
		int[][] myScaleMatrix = MathUtil.scaleMatrix(1);
		int[][] TRMatrix = MathUtil.multiply(myTranslationMatrix, myRotationMatrix);
		int[][] matrix = MathUtil.multiply(TRMatrix, myScaleMatrix);
		
//		System.out.println("x---- ");
//		System.out.println(matrix[0][0]);
//		System.out.println(matrix[0][1]);
//		System.out.println(matrix[0][2]);
//		System.out.println("y---- ");
//		System.out.println(matrix[1][0]);
//		System.out.println(matrix[1][1]);
//		System.out.println(matrix[1][2]);
//		System.out.println("phi---- ");
//		System.out.println(matrix[2][0]);
//		System.out.println(matrix[2][1]);
//		System.out.println(matrix[2][2]);
//
//		System.out.println("DONE");

				
		if (myRotation == 0) {
			for (int i = 0; i < coordinates0.length; i++) {
				int[] localPosition = { (int) coordinates0[i][0], (int) coordinates0[i][1], 1 };
				int[] globalPosition = MathUtil.multiply(matrix, localPosition);
				globalCoordinates0[i][0] = (int) globalPosition[0];
				globalCoordinates0[i][1] = (int) globalPosition[1];
			}
		} else if (myRotation == -90) {
			for (int i = 0; i < coordinates90.length; i++) {
				int[] localPosition = { (int) coordinates90[i][0], (int) coordinates90[i][1], 1 };
				int[] globalPosition = MathUtil.multiply(matrix, localPosition);
				globalCoordinates90[i][0] = (int) globalPosition[0];
				globalCoordinates90[i][1] = (int) globalPosition[1];
//				System.out.println("x: " + globalCoordinates90[i][0]);
//				System.out.println("y: " + globalCoordinates90[i][1]);
//				System.out.println("---");
			}
//			System.out.println("DONE");
		} else if (myRotation == -180) {
			for (int i = 0; i < coordinates180.length; i++) {
				int[] localPosition = { (int) coordinates180[i][0], (int) coordinates180[i][1], 1 };
				int[] globalPosition = MathUtil.multiply(matrix, localPosition);
				globalCoordinates180[i][0] = (int) globalPosition[0];
				globalCoordinates180[i][1] = (int) globalPosition[1];
			}
		} else if (myRotation == -270) {
			for (int i = 0; i < coordinates270.length; i++) {
				int[] localPosition = { (int) coordinates270[i][0], (int) coordinates270[i][1], 1 };
				int[] globalPosition = MathUtil.multiply(matrix, localPosition);
				globalCoordinates270[i][0] = (int) globalPosition[0];
				globalCoordinates270[i][1] = (int) globalPosition[1];
			}
		}
		
	}
	
	//main function
	public ArrayList<Integer[]> findLowestYCoord() {
		//initialise all x global coords into a matrix
		ArrayList<Integer[]> lowestCoordinates = initialiseXCoords();
		
		for (Integer[] xCoord: lowestCoordinates) {
			int lowestY = 20;
			int x = xCoord[0];
			if (myRotation == 0) {
				for (int i = 0; i < globalCoordinates0.length; i++) {
					if (globalCoordinates0[i][0] == x) {
						if (globalCoordinates0[i][1] < lowestY) {
							xCoord[1] = globalCoordinates0[i][1];
							lowestY = globalCoordinates0[i][1];
						}
					}
				}
			} else if (myRotation == -90) {
				for (int i = 0; i < globalCoordinates90.length; i++) {
					if (globalCoordinates90[i][0] == x) {
						if (globalCoordinates90[i][1] < lowestY) {
							xCoord[1] = globalCoordinates90[i][1];
							lowestY = globalCoordinates90[i][1];
						}
					}
				}
			} else if (myRotation == -180) {
				for (int i = 0; i < globalCoordinates180.length; i++) {
					if (globalCoordinates180[i][0] == x) {
						if (globalCoordinates180[i][1] < lowestY) {
							xCoord[1] = globalCoordinates180[i][1];
							lowestY = globalCoordinates180[i][1];
						}
					}
				}
			} else if (myRotation == -270) {
				for (int i = 0; i < globalCoordinates270.length; i++) {
					if (globalCoordinates270[i][0] == x) {
						if (globalCoordinates270[i][1] < lowestY) {
							xCoord[1] = globalCoordinates270[i][1];
							lowestY = globalCoordinates270[i][1];
						}
					}
				}
			}
		}
//		for (Integer[] coord: lowestCoordinates) {
//			System.out.println("x " + coord[0]);
//			System.out.println("y " + coord[1]);
//			
//		}
//		System.out.println(myTranslation[1]);
		
		Comparator<Integer[]> c = new Comparator<Integer[]>() {
			public int compare(Integer[] coord1, Integer[] coord2) {
				if (coord1[0] < coord2[0]) {
					return -1;
				} else if (coord1[0] > coord2[0]) {
					return 1;
				} else {
					return 0;
				}
			}
		};
		
		Collections.sort(lowestCoordinates, c);
		
		return lowestCoordinates;
	}
	
	//helper function
	public ArrayList<Integer[]> initialiseXCoords() {
		ArrayList<Integer[]> globalCoordinates = new ArrayList<Integer[]>();
		Set<Integer> xCoords = new TreeSet<Integer>(); 
		if (myRotation == 0) {
			for (int i = 0; i < globalCoordinates0.length; i++) {
				xCoords.add(globalCoordinates0[i][0]);
			}
		} else if (myRotation == -90) {
			for (int i = 0; i < globalCoordinates90.length; i++) {
				xCoords.add(globalCoordinates90[i][0]);
			}
		} else if (myRotation == -180) {
			for (int i = 0; i < globalCoordinates180.length; i++) {
				xCoords.add(globalCoordinates180[i][0]);
			}
		} else if (myRotation == -270) {
			for (int i = 0; i < globalCoordinates270.length; i++) {
				xCoords.add(globalCoordinates270[i][0]);
			}
		}
		
		for (int x: xCoords) {
			Integer[] tuple = new Integer[2];
			tuple[0] = x;
			tuple[1] = null;
			globalCoordinates.add(tuple);
		}
		
		return globalCoordinates;
	}
	
	public ArrayList<Integer[]> lines(ArrayList<Integer[]> coords) {
		ArrayList<Integer[]> line = new ArrayList<Integer[]>();
		for (int i = 0; i < coords.size()-1; i++) {
			// Y COORDS MUST BE SAME
			// X COORDS MUST BE INCREMENTAL
			if (coords.get(i)[1] < coords.get(i+1)[1]) {
				Integer[] points = new Integer[4];
				points[0] = coords.get(i)[0];
				points[1] = coords.get(i)[1];
				points[2] = coords.get(i+1)[0];
				//y coord of second point is y coord of first point
				points[3] = coords.get(i)[1];
				line.add(points);
			} else if (coords.get(i)[1] > coords.get(i+1)[1]) {
				Integer[] points = new Integer[4];
				//x coord of first point is the same
				points[0] = coords.get(i)[0];
				//y coord of first point is y coord of next point
				points[1] = coords.get(i+1)[1];
				points[2] = coords.get(i+1)[0];
				points[3] = coords.get(i+1)[1];
				line.add(points);
			} else {
				Integer[] points = new Integer[4];
				points[0] = coords.get(i)[0];
				points[1] = coords.get(i)[1];
				points[2] = coords.get(i+1)[0];
				points[3] = coords.get(i+1)[1];
				line.add(points);
			}
		}
		return line;
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			
			//rotate
			case KeyEvent.VK_UP:
				myRotation -= 90;
				if (myRotation == -360) {
					myRotation = 0;
				}
				
				//bottom edge
				if (myRotation == 0 && myTranslation[1] < lowestY0) {
					myTranslation[1] = lowestY0;
				} else if (myRotation == -90 && myTranslation[1] < lowestY90) {
					myTranslation[1] = lowestY90;
				} else if (myRotation == -180 && myTranslation[1] < lowestY180) {
					myTranslation[1] = lowestY180;
				} else if (myRotation == -270 && myTranslation[1] < lowestY270) {
					myTranslation[1] = lowestY270;
				}
				
				//left edge
				if (myRotation == 0 && myTranslation[0] < lowestX0) {
					myTranslation[0] = lowestX0;
				} else if (myRotation == -90 && myTranslation[0] < lowestX90) {
					myTranslation[0] = lowestX90;
				} else if (myRotation == -180 && myTranslation[0] < lowestX180) {
					myTranslation[0] = lowestX180;
				} else if (myRotation == -270 && myTranslation[0] < lowestX270) {
					myTranslation[0] = lowestX270;
				}
				
				//right edge
				if (myRotation == 0 && myTranslation[0] > highestX0) {
					myTranslation[0] = highestX0;
				} else if (myRotation == -90 && myTranslation[0] > highestX90) {
					myTranslation[0] = highestX90;
				} else if (myRotation == -180 && myTranslation[0] > highestX180) {
					myTranslation[0] = highestX180;
				} else if (myRotation == -270 && myTranslation[0] > highestX270) {
					myTranslation[0] = highestX270;
				}
				break;
			//increase speed down temporarily
			case KeyEvent.VK_DOWN:
				if (myRotation == 0) {
					if (grid.checkBottomEdge(globalCoordinates0)) {
						myTranslation[1] += -1;
					}
					break;
				}
				
				if (myRotation == -90) {
					if (grid.checkBottomEdge(globalCoordinates90)) {
						myTranslation[1] += -1;
					}
					break;
				}
				
				if (myRotation == -180) {
					if (grid.checkBottomEdge(globalCoordinates180)) {
						myTranslation[1] += -1;
					}
					break;
				}
				
				if (myRotation == -270) {
					if (grid.checkBottomEdge(globalCoordinates270)) {
						myTranslation[1] += -1;
					}
					break;
				}
				break;
			//strafe left
			case KeyEvent.VK_LEFT:
				if (myRotation == 0) {
					if (grid.checkLeftEdge(globalCoordinates0)) {
						myTranslation[0] += -1;
					}
					break;
				}
				
				if (myRotation == -90) {
					if (grid.checkLeftEdge(globalCoordinates90)) {
						myTranslation[0] += -1;
					}
					break;
				}
				
				if (myRotation == -180) {
					if (grid.checkLeftEdge(globalCoordinates180)) {
						myTranslation[0] += -1;
					}
					break;
				}
				
				if (myRotation == -270) {
					if (grid.checkLeftEdge(globalCoordinates270)) {
						myTranslation[0] += -1;
					}
					break;
				}
				break;
			//strafe right
			case KeyEvent.VK_RIGHT:
				if (myRotation == 0) {
					if (grid.checkRightEdge(globalCoordinates0)) {
						myTranslation[0] += 1;
					}
					break;
				}
				
				if (myRotation == -90) {
					if (grid.checkRightEdge(globalCoordinates90)) {
						myTranslation[0] += 1;
					}
					break;
				}
				
				if (myRotation == -180) {
					if (grid.checkRightEdge(globalCoordinates180)) {
						myTranslation[0] += 1;
					}
					break;
				}
				
				if (myRotation == -270) {
					if (grid.checkRightEdge(globalCoordinates270)) {
						myTranslation[0] += 1;
					}
					break;
				}
				break;
			//drop down
			case KeyEvent.VK_SPACE:
				break;
		}
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}


//	public void move() {
//		if (grid.collision(lowestCoordinates))
//		myTranslation[1]--;
//	}
	
}
