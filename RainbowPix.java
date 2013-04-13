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
		super(255, 0, 0);
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
		int growth = 3;
		if (newr == 255 && newg + growth <= 255)
		{
			newg += growth;
		}
		else if (newg == 255 && newr >= growth)
		{
			newr -= growth;
		}
		else if (newg == 255 && newr == 0 && newb + growth <= 255)
		{
			newb += growth;
		}
		else if (newb == 255 && newg >= growth)
		{
			newg -= growth;
		}
		else if (newb == 255 && newr + growth <= 255)
		{
			newr += growth;
		}
		else if (newb >= growth && newr == 255)
		{
			newb -= growth;
		}

		grid[x][y].setPix(newr, newg, newb);
	}
}