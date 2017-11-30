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
	
	//these are global coordinates
	protected double x;
	protected double y;
	
	protected double[] colour;
	protected double[][] coordinates0;
	protected double[][] coordinates90;
	protected double[][] coordinates180;
	protected double[][] coordinates270;
	protected int[][] globalCoordinates0;
	protected int[][] globalCoordinates90;
	protected int[][] globalCoordinates180;
	protected int[][] globalCoordinates270;

	
	//starting translation and rotation
	protected double myRotation = 0;
	protected double[] myTranslation;
	
	public TetrisBlock(Grid grid, double[] translation, double[] colour, double[][] coordinates0, double[][] coordinates90, double[][] coordinates180, double[][] coordinates270) {
		this.grid = grid;
		this.myTranslation = translation;
		this.colour = colour;
		this.coordinates0 = coordinates0;
		this.coordinates90 = coordinates90;
		this.coordinates180 = coordinates180;
		this.coordinates270 = coordinates270;
		globalCoordinates0 = new int[16][2];
		globalCoordinates90 = new int[16][2];
		globalCoordinates180 = new int[16][2];
		globalCoordinates270 = new int[16][2];
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
		double[][] myTranslationMatrix = MathUtil.translationMatrix(myTranslation);
		double[][] myRotationMatrix = MathUtil.rotationMatrix(myRotation);
		double[][] matrix = MathUtil.multiply(myTranslationMatrix, myRotationMatrix);
				
		if (myRotation == 0) {
			for (int i = 0; i < coordinates0.length; i++) {
				double[] localPosition = { coordinates0[i][0], coordinates0[i][1], 1 };
				double[] globalPosition = MathUtil.multiply(matrix, localPosition);
				globalCoordinates0[i][0] = (int) globalPosition[0];
				globalCoordinates0[i][1] = (int) globalPosition[1];
			}
		} else if (myRotation == -90) {
			for (int i = 0; i < coordinates90.length; i++) {
				double[] localPosition = { coordinates90[i][0], coordinates90[i][1], 1 };
				double[] globalPosition = MathUtil.multiply(matrix, localPosition);
				globalCoordinates90[i][0] = (int) globalPosition[0];
				globalCoordinates90[i][1] = (int) globalPosition[1];
			}
		} else if (myRotation == -180) {
			for (int i = 0; i < coordinates180.length; i++) {
				double[] localPosition = { coordinates180[i][0], coordinates180[i][1], 1 };
				double[] globalPosition = MathUtil.multiply(matrix, localPosition);
				globalCoordinates180[i][0] = (int) globalPosition[0];
				globalCoordinates180[i][1] = (int) globalPosition[1];
			}
		} else if (myRotation == -270) {
			for (int i = 0; i < coordinates270.length; i++) {
				double[] localPosition = { coordinates270[i][0], coordinates270[i][1], 1 };
				double[] globalPosition = MathUtil.multiply(matrix, localPosition);
				globalCoordinates270[i][0] = (int) globalPosition[0];
				globalCoordinates270[i][1] = (int) globalPosition[1];
			}
		}
	}
	
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
		for (Integer[] coord: lowestCoordinates) {
			System.out.println("x " + coord[0]);
			System.out.println("y " + coord[1]);
			
		}
		
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
				break;
			//increase speed down temporarily
			case KeyEvent.VK_DOWN:
				myTranslation[1] += -1;
				break;
			//strafe left
			case KeyEvent.VK_LEFT:
				myTranslation[0] += -1;
				break;
			//strafe right
			case KeyEvent.VK_RIGHT:
				myTranslation[0] += 1;
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
	
}
