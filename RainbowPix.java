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
		super();
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
		super(r, g, b);
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
		if (newr == 255 && newg < 255)
		{
			newg++;
		}
		else if (newg == 255 && newr > 0)
		{
			newr--;
		}
		else if (newg == 255 && newr == 0 && newb < 255)
		{
			newb++;
		}
		else if (newb == 255 && newg > 0)
		{
			newg--;
		}
		else if (newb == 255 && newr < 255)
		{
			newr++;
		}
		grid[x][y].setPix(newr, newg, newb);
	}
}