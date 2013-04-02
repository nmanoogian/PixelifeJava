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

		PixGrid myGrid = new PixGrid(w,h);
		//generatePixels(n);
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
		myGrid.draw(canvas);
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			System.out.println("interrupted");
		}
		repaint();
	}

	public static void main(String [] args)
	{
		int width = 640;
		int height = 480;
		JFrame frame = new JFrame("test");

		Pixelife plife = new Pixelife(width, height, 100000);


		frame.add(plife);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//myGrid.draw(canvas);

		//plife.run();



	}

}
	// /**
	//  * Creates a set number pixels
	//  * @param numPixels number of pixels
	//  */
	// public void generatePixels(int numPixels)
	// {
	// 	System.out.println("Generating Pixels");

	// 	for (int i = 0; i < numPixels; i++)
	// 	{
	// 		//Choose some random colors
	// 		int red = (int)(Math.random() * 256);
	// 		int green = (int)(Math.random() * 256);
	// 		int blue = (int)(Math.random() * 256);

	// 		//Choose some random positions
	// 		int x = (int)(Math.random()*width);
	// 		int y = (int)(Math.random()*height);


	// 		//Make sure locations are different
	// 		while (canvas.getRGB(x,y) != (Color.WHITE).getRGB())
	// 		{
	// 			x = (int)(Math.random()*width);
	// 			y = (int)(Math.random()*height);
	// 		}


	// 		//Make sure colors are different
	// 		while (red == green || green == blue || blue == red)
	// 		{
	// 			red = (int)(Math.random() * 256);
	// 			green = (int)(Math.random() * 256);
	// 			blue = (int)(Math.random() * 256);
	// 		}

	// 		//set canvas
	// 		setPixel(x, y, red, green, blue);
	// 		//canvas.setRGB(x, y, (new Color(red,green,blue)).getRGB());
	// 	}

	// }


	// /**
	//  * 
	//  * @param i row
	//  * @param j column
	//  * @param r red integer
	//  * @param b blue integer
	//  * @param g green integer
	//  */
	// public void setPixel(int i, int j, int r, int g, int b)
	// {
	// 	canvas.setRGB(i, j, (new Color(r,g,b)).getRGB());
	// }

	// /**
	//  * Determine if a pixel is in bounds
	//  * @param i row
	//  * @param j column
	//  */
	// public boolean inBounds(int i, int j)
	// {
	// 	return (i >= 0 && i < height && j >= 0 && j < width);
	// }

	// /**
	//  * Determine if a pixel is in bounds and non-white
	//  * @param i row
	//  * @param j column
	//  */
	// public boolean isPixel(int i, int j)
	// {
	// 	if (inBounds(i,j))
	// 	{
	// 		return (canvas.getRGB(i, j) != (Color.WHITE).getRGB());
	// 	}
	// 	else
	// 	{
	// 		return false;
	// 	}
	// }

	// /**
	//  * Run the main loop
	//  * 
	//  */
	// public void run()
	// {
	// 	for (int i = 0; i < width; i++)
	// 	{
	// 		for (int j = 0; j < height; j++)
	// 		{
	// 			if (isPixel(i,j))
	// 			{
	// 				//Select a direction and calculate coordinates
	// 				int dir = (int)(Math.random()*4);
	// 				int interi = i;
	// 				int interj = j;
	// 				if (dir == 0)
	// 				{
	// 					interi--;
	// 				}
	// 				else if (dir == 1)
	// 				{
	// 					interi++;

	// 				}
	// 				else if (dir == 2)
	// 				{
	// 					interj--;
	// 				}
	// 				else
	// 				{
	// 					interj++;
	// 				}

	// 				if (isPixel(interi, interj))
	// 				{
	// 					//Interact with pixel
	// 				}
	// 				else 
	// 				{
	// 					if (inBounds(interi,interj))
	// 					{
	// 						//canvas.setRGB();
	// 					}

	// 				}
	// 			}

	// 		}
	// 	}
	// 	try
	// 	{
	// 		Thread.sleep(1000);
	// 	}
	// 	catch(InterruptedException e)
	// 	{
	// 		System.out.println("interrupted");
	// 	}
	// 	repaint();
	// }


