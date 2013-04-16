/**
 * Class RainbowPix
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */
public class RainbowPix extends NonconformingPix
{

	/**
	 * Default constructor
	 * Calls Pix()
	 */
	public RainbowPix()
	{
		int choosecolor = (int) (Math.random() * 3);
		switch (choosecolor)
		{
			case 0:
				red = 255;
				green = 0;
				blue = 0;
				break;
			case 1:
				red = 0;
				green = 255;
				blue = 0;
				break;
			case 2:
				red = 0;
				green = 0;
				blue = 255;
				break;
		}
	}

	/**
	 * Constructs with RGB values
	 * Calls Pix(r, g, b)
	 * @param r red channel
	 * @param g green channel
	 * @param b blue channel
	 */
	public RainbowPix(int r, int g, int b)
	{
		this();
	}

	/**
	 * Moves a Pix
	 * @param ix inital x location
	 * @param ix inital y location
	 * @param x ending x location
	 * @param y ending y location
	 */
	public void movePixel(Pix[][] grid, int ix, int iy, int x, int y)
	{
		Spawner.spawnXY( grid[ix][iy].getClass(), x, y );
		int newr = red;
		int newg = green;
		int newb = blue;
		int growth = 5;
		if (newr == 255 && newg + growth <= 255 && newb == 0)
		{
			newg += growth;
		}
		else if (newr >= growth && newg == 255 && newb == 0)
		{
			newr -= growth;
		}
		else if (newr == 0 && newg == 255 && newb + growth <= 255)
		{
			newb += growth;
		}
		else if (newr == 0 && newg >= growth && newb == 255)
		{
			newg -= growth;
		}
		else if (newr + growth <= 255 && newg == 0 && newb == 255)
		{
			newr += growth;
		}
		else if (newr == 255 && newg == 0 && newb >= growth)
		{
			newb -= growth;
		}
		// Possible Inversion
		// newr = 255-newr;
		// newg = 255-newg;
		// newb = 255-newb;
		grid[x][y].setPix(newr, newg, newb);
	}
}