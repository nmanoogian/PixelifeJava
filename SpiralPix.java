/**
 * Class SpiralPix
 * Pixels that create a spiral pattern
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */

public class SpiralPix extends DirectedPix
{
	/*
	 * Length of growth
	 */
	private int length;
	private int startinglength;

	/**
	 * Constructs a SpiralPix with a random direction
	 */
	public SpiralPix()
	{	
		super();
		startinglength = 0;
		length = startinglength;
	}
	/**
	 * Constructs a SpiralPix with a specific direction and color
	 */
	public SpiralPix(int r, int g, int b, int direction)
	{
		super(r,g,b,direction);
		startinglength = 0;
		length = startinglength;
	}

	public void setLengths(int l, int sl)
	{
		length = l;
		startinglength = sl;
	}


	/**
	 * Transitions a Pix from one location to another
	 * If the Pix is white, the Pix is moved. Otherwise, one Pix interacts with the other
 	 * @param ix inital x location
	 * @param ix inital y location
	 * @param x ending x location
	 * @param y ending y location
	 */
	public void trans(Pix[][] grid, int ix, int iy, int x, int y)
	{
		if (length > 0)
		{
			length--;
			// Didn't try to move out of bounds
			if (!(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length))
			{
				// If trans location is white, move Pix
				if (grid[x][y].isWhite())
				{
					Spawner.spawnXY( grid[ix][iy].getClass(), x, y ); 
					grid[x][y].setPix(grid[ix][iy]);
					((SpiralPix)grid[x][y]).setDir(direction);
					((SpiralPix)grid[x][y]).setLengths(length, startinglength);
					grid[ix][iy] = new StaticPix(grid[ix][iy].getRed(),grid[ix][iy].getGreen(),grid[ix][iy].getBlue());
				}
			}
		}
		else
		{
			if (direction == 3)
			{
				direction = 0;
			}
			else
			{
				direction++;
			}
			startinglength += 4;
			length = startinglength;
		}
	}
}