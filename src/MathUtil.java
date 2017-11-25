/**
 * A collection of useful math methods
 *
 */
public class MathUtil {

	/**
	 * Normalise an angle to the range [-180, 180)
	 * 
	 * @param angle
	 * @return
	 */
	static public double normaliseAngle(double angle) {
		return ((angle + 180.0) % 360.0 + 360.0) % 360.0 - 180.0;
	}

	/**
	 * Clamp a value to the given range
	 * 
	 * @param value
	 * @param min
	 * @param max
	 * @return
	 */

	public static double clamp(double value, double min, double max) {
		return Math.max(min, Math.min(max, value));
	}

	/**
	 * Multiply two matrices
	 * 
	 * @param p
	 *            A 3x3 matrix
	 * @param q
	 *            A 3x3 matrix
	 * @return
	 */
	public static double[][] multiply(double[][] p, double[][] q) {

		double[][] m = new double[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				m[i][j] = 0;
				for (int k = 0; k < 3; k++) {
					m[i][j] += p[i][k] * q[k][j];
				}
			}
		}

		return m;
	}

	/**
	 * Multiply a vector by a matrix
	 * 
	 * @param m
	 *            A 3x3 matrix
	 * @param v
	 *            A 3x1 vector
	 * @return
	 */
	public static double[] multiply(double[][] m, double[] v) {

		double[] u = new double[3];

		for (int i = 0; i < 3; i++) {
			u[i] = 0;
			for (int j = 0; j < 3; j++) {
				u[i] += m[i][j] * v[j];
			}
		}

		return u;
	}

	/**
	 * 
	 * @param pos
	 * @return
	 */
	public static double[][] translationMatrix(double[] v) {
		double[][] matrix = new double[3][3];
		matrix[0][0] = 1;
		matrix[0][1] = 0;
		matrix[0][2] = v[0];
		matrix[1][0] = 0;
		matrix[1][1] = 1;
		matrix[1][2] = v[1];
		matrix[2][0] = 0;
		matrix[2][1] = 0;
		matrix[2][2] = 1;

		return matrix;
	}

	/**
	 * 
	 * @param angle
	 *            in degrees
	 * @return
	 */
	public static double[][] rotationMatrix(double angle) {
		double[][] matrix = new double[3][3];
		matrix[0][0] = Math.cos(Math.toRadians(angle));
		matrix[0][1] = -Math.sin(Math.toRadians(angle));
		matrix[0][2] = 0;
		matrix[1][0] = Math.sin(Math.toRadians(angle));
		matrix[1][1] = Math.cos(Math.toRadians(angle));
		matrix[1][2] = 0;
		matrix[2][0] = 0;
		matrix[2][1] = 0;
		matrix[2][2] = 1;

		return matrix;
	}

	/**
	 * 
	 * @param scale
	 * @return
	 */
	public static double[][] scaleMatrix(double scale) {
		double[][] matrix = new double[3][3];
		matrix[0][0] = scale;
		matrix[0][1] = 0;
		matrix[0][2] = 0;
		matrix[1][0] = 0;
		matrix[1][1] = scale;
		matrix[1][2] = 0;
		matrix[2][0] = 0;
		matrix[2][1] = 0;
		matrix[2][2] = 1;

		return matrix;
	}

}
