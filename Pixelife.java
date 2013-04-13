import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Pixelife class
 * Manages GUI and pixel painting
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons <mdl0394@gmail.com>
 */
public class Pixelife extends JPanel
{
	/*
	 * Buffer that is painted to the screen
	 */
	private BufferedImage canvas;
	/*
	 * Grid containing Pix objects
	 */
	private static PixGrid myGrid;
	/*
	 * Creates Pix objects of a certain type
	 */
	private Spawner spawner;
	/*
	 * Screen dimentions
	 */
	private int width;
	private int height;

	/**
	 * Constructor with width and height
	 * @param w width in pixels
	 * @param h height in pixels
	 * @param n number of random pixels to generate
	 */
	public Pixelife(int w, int h, int n)
	{
		canvas = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		width = w;
		height = h;

		myGrid = new PixGrid(w, h, n);
		// Spawner vline_spawner = new Spawner(DirectedPix.class, myGrid, 2, h/2);
		// vline_spawner.spawn(5);
		// Spawner hline_spawner = new Spawner(DirectedPix.class, myGrid, 0, h/2);
		// hline_spawner.spawn(5);
		// Spawner lines = new Spawner(ScaredPix.class, myGrid);
		// lines.spawn(10);

		// spawner = new Spawner(DirectedPix.class, myGrid);
		// spawner.spawn(5);
		// spawner = new Spawner(RejectingPix.class, myGrid);
		// spawner.spawn(100);
		spawner = new Spawner(AgingPix.class, myGrid);
		spawner.spawn(100);
	}

	/**
	 * Required by 2DGraphics
	 */
	public Dimension getPreferredSize()
	{
		return new Dimension(canvas.getWidth(), canvas.getHeight());
	}

	/**
	 * Required by 2DGraphics
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(canvas, null, null);
	}

	/**
	 * Update and paint loop
	 */
	public void run()
	{
		while(true)
		{
			myGrid.update();
			// line_spawner.update();
			// spawner.update();

			draw();

			// Limit framerate
			// try
			// {
			// 	Thread.sleep(0);
			// }
			// catch(InterruptedException e)
			// {
			// 	System.out.println("interrupted");
			// }
			repaint();
		}
	}

	/**
	 * Draws Pix grid to the canvas object
	 */
	public void draw()
	{
		Pix[][] grid = myGrid.getGrid();
		for( int i = 0; i < grid.length; i++ )
		{
			for( int j = 0; j < grid[0].length; j ++ )
			{
				canvas.setRGB(i, j, grid[i][j].getRGB());
			}
		}
	}

	public static void main(String [] args)
	{
		//Set window size
		int width = 640;
		int height = 480;

		//Make new frame
		JFrame frame = new JFrame("main");

		//Make new Pixelife object
		Pixelife plife = new Pixelife(width, height, 15);

		//Add canvas to screen
		frame.add(plife);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Loop interaction
		plife.run();
	}

	public static PixGrid getGrid()
	{
		return myGrid;
	}

}
