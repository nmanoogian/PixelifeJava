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
 */
public class Pixelife extends JPanel
{
	private BufferedImage canvas;
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
		fillCanvas(Color.WHITE);
		generatePixels(n);
	}

	/**
	 * Fills the canvas with a color
	 * @param c color
	 */
	public void fillCanvas(Color c)
	{
		int color = c.getRGB();
		for (int x = 0; x < canvas.getWidth(); x++)
		{
			for (int y = 0; y < canvas.getHeight(); y++)
			{
				canvas.setRGB(x, y, color);
			}
		}
		repaint();
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

	/**
	 * Creates a set number pixels
	 * @param numPixels number of pixels
	 */
	public void generatePixels(int numPixels)
	{
		System.out.println("Generating Pixels");

		for (int i = 0; i < numPixels; i++)
		{
			//Choose some random colors
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);

			//Choose some random positions
			int x = (int)(Math.random()*width);
			int y = (int)(Math.random()*height);


			//Make sure locations are different
			while (canvas.getRGB(x,y) != (Color.WHITE).getRGB())
			{
				x = (int)(Math.random()*width);
				y = (int)(Math.random()*height);
			}


			//Make sure colors are different
			while (red == green || green == blue || blue == red)
			{
				red = (int)(Math.random() * 256);
				green = (int)(Math.random() * 256);
				blue = (int)(Math.random() * 256);
			}

			//set canvas
			canvas.setRGB(x, y, (new Color(red,green,blue)).getRGB());
		}

	}


	public static void main(String [] args)
	{
		int width = 640;
		int height = 480;
		JFrame frame = new JFrame("test");

		Pixelife pix = new Pixelife(width, height, 100000);


		frame.add(pix);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}