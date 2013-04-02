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

	public void set(int r, int g, int b)
	{
		red = r;
		green = g;
		blue = b;
	}

	public void getDomChannel()
	{

	}

	public void interact(Pix p)
	{

	}

}