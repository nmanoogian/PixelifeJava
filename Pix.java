import java.awt.Color;

/**
 * Pixel Class
 * with Red Green and Blue streams
 */
public class Pix
{
	private int red;
	private int green;
	private int blue;

	public Pix(int r, int g, int b)
	{
		red = r;
		green = g;
		blue = b;
	}

	public Pix()
	{
		int r = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);

		while (r == g || g == b || b == r)
		{
			r = (int)(Math.random() * 256);
			g = (int)(Math.random() * 256);
			b = (int)(Math.random() * 256);
		}
	}

	public void setPix(int r, int g, int b)
	{
		red = r;
		green = g;
		blue = b;
	}

	/**
	 * Increases dominant channel
	 */
	public void changeWithChannel(int channel)
	{

	}

	/**
	 * Returns the dominant channel
	 * 0 => Red; 1 => Blue; 2 => Green
	 * @return integer for channel
	 */
	public int getDomChannel()
	{
		if (red > green && red > blue)
		{
			return 0;
		}
		else if (blue > green && blue > red)
		{
			return 1;
		}
		else if (green > red && green > blue)
		{
			return 2;
		}
		else
		{
			return -1;
		}

	}

	public void interact(Pix p)
	{
		if (getDomChannel() == p.getDomChannel())
		{
			//changeWithChannel();

		}

	}

	public int getRGB()
	{
		return (new Color(red,green,blue)).getRGB();
	}

	public String toString()
	{
		return red + ", " + green + ", " + blue;
	}

}