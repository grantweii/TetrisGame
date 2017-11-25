import javax.swing.JFrame;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

public class Game extends JFrame implements GLEventListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7476884465971461594L;
	private Game game;
	private Grid grid;
	private TetrisBlock currentBlock;
	public double gameSpeed;
	
	public Game() {
		game = this;
		grid = new Grid();
		currentBlock = new SBlock();
	}
	
	public void run() {
		GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLJPanel panel = new GLJPanel();
        panel.addGLEventListener(this);
        panel.addKeyListener(currentBlock);
        
        FPSAnimator animator = new FPSAnimator(60);
        animator.add(panel);
        animator.start();

        // JFrame set up
        getContentPane().add(panel);
        //this is size of the frame
        setSize(400, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();

		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		
		//make bottom left 0,0 
		gl.glTranslated(-5, -10, 0);
		
		currentBlock.draw(gl);

	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();

	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		
		GLU glu = new GLU();
		
        glu.gluOrtho2D(-5, 5, -10, 10);  

	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.run();
		
	}
	
	
	
}
