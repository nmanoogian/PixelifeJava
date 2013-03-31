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

	public Pixelife(int w, int h)
	{
		canvas = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		fillCanvas(Color.WHITE);
	}

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


	public static void main(String [] args)
	{
		int width = 640;
        int height = 480;
        JFrame frame = new JFrame("test");

        Pixelife pix = new Pixelife(width, height);

        frame.add(pix);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}