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
 * @author Mike Lyons
 */
public class Pixelife extends JPanel
{
	private BufferedImage canvas;
	private PixGrid myGrid;
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
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(canvas.getWidth(), canvas.getHeight());
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(canvas, null, null);
	}

	public void run()
	{
		while(true)
		{
			myGrid.update();
			
			draw();

			try
			{
				Thread.sleep(0);
			}
			catch(InterruptedException e)
			{
				System.out.println("interrupted");
			}
			repaint();
		}
	}

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
		int width = 640;
		int height = 480;
		// int width = 4;
		// int height = 4;

		// PixGrid testGrid = new PixGrid(width, height);

		// testGrid.getGrid()[1][1] = new Pix();
		// testGrid.getGrid()[2][1] = new Pix();

		// System.out.println( testGrid );

		// testGrid.update();

		// System.out.println( testGrid );

		JFrame frame = new JFrame("test");

		Pixelife plife = new Pixelife(width, height, 15);

		frame.add(plife);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		plife.run();
	}

}