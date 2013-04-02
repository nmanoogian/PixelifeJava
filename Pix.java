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

	/**
	 * Constructs a Pix using rgb values
	 * @param r red channel
	 * @param g green channel
	 * @param b blue channel
	 */
	public Pix(int r, int g, int b)
	{
		red = r;
		green = g;
		blue = b;
	}

	/**
	 * Constructs a Pix using non-duplicative random channels
	 */
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

	/**
	 * Sets a Pix using rgb values
	 * @param r red channel
	 * @param g green channel
	 * @param b blue channel
	 */
	public void setPix(int r, int g, int b)
	{
		red = r;
		green = g;
		blue = b;
	}

	/**
	 * Sets a Pix using another Pix
	 * @param p other Pix
	 */
	public void setPix(Pix p)
	{
		red = p.getRed();
		green = p.getGreen();
		blue = p.getBlue();
	}

	/**
	 * Return red channel
	 * @return red channel
	 */
	public int getRed()
	{
		return red;
	}

	/**
	 * Return green channel
	 * @return green channel
	 */
	public int getGreen()
	{
		return green;

	}

	/**
	 * Return blue channel
	 * @return blue channel
	 */
	public int getBlue()
	{
		return blue;
	}

	/**
	 * Increases dominant channel
	 */
	public void changeWithChannel(int channel)
	{
		switch (channel)
		{
			case 0:
				//Inc dominant
				if (red + 2 <= 255)
				{
					red += 2;
				}
				else
				{
					red = 255;
				}

				//Dec mins
				if (blue - 1 >= 0)
				{
					blue--;
				}

				if (green - 1 >= 0)
				{
					green--;
				}
				break;
			case 1:
				//Inc dominant
				if (green + 2 <= 255)
				{
					green += 2;
				}
				else
				{
					green = 255;
				}

				//Dec mins
				if (blue - 1 >= 0)
				{
					blue--;
				}

				if (red - 1 >= 0)
				{
					red--;
				}
				break;
			case 2:
				//Inc dominant
				if (blue + 2 <= 255)
				{
					blue += 2;
				}
				else
				{
					blue = 255;
				}

				//Dec mins
				if (red - 1 >= 0)
				{
					red--;
				}

				if (green - 1 >= 0)
				{
					green--;
				}
				break;
			case -1:
				System.out.println("No dominant channel");
				break;
		}

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
			changeWithChannel(getDomChannel());
			p.changeWithChannel(p.getDomChannel());
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