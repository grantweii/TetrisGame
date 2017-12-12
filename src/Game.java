import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Random;

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
	private double gameSpeed;
	private long lastTime;
	private GLJPanel panel;
	private ArrayList<TetrisBlock> gridBlocks;
	
	public Game() {
		game = this;
		grid = new Grid();
		gridBlocks = new ArrayList<TetrisBlock>();
		lastTime = System.currentTimeMillis();
	}
	
	public void run() {
		GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        panel = new GLJPanel();
        panel.addGLEventListener(this);
        
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
				
		gl.glTranslated(grid.myTranslation[0], grid.myTranslation[1], 0);
				
		long currentTime = System.currentTimeMillis();
		if (currentTime - lastTime > 1000) {
			if (!grid.activeBlock) {
				if (currentBlock != null) {
					panel.removeKeyListener(currentBlock);
				}
				Random rand = new Random();
				float num = rand.nextFloat();
				if (num < (float) 1/7) {
					currentBlock = new IBlock(grid);
				} else if (num < (float) 2/7) {
					currentBlock = new OBlock(grid);
				} else if (num < (float) 3/7) {
					currentBlock = new TBlock(grid);
				} else if (num < (float) 4/7) {
					currentBlock = new JBlock(grid);
				} else if (num < (float) 5/7) {
					currentBlock = new LBlock(grid);
				} else if (num < (float) 6/7) {
					currentBlock = new SBlock(grid);
				} else if (num < (float) 7/7) {
					currentBlock = new ZBlock(grid);
				} 
				grid.activeBlock = true;
				panel.addKeyListener(currentBlock);
				gridBlocks.add(currentBlock);				
			}
			currentBlock.move();
			lastTime = currentTime;
		}
				
		for (TetrisBlock block: gridBlocks) {
			block.draw(gl);
		}
		
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
