/**
 * Class LinePix
 * Pixels that only move in one direction
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */

public class LinePix extends DirectedPix
{
	/*
	 * Prevents line from growing in one frame
	 */
	private boolean examined;

	/**
	 * Constructs a LinePix with a random direction
	 */
	public LinePix()
	{	
		super();
		direction = ((int)(Math.random()*4));
		examined = (direction >= 2);
	}
	/**
	 * Constructs a LinePix with a specific direction and color
	 */
	public LinePix(int r, int g, int b, int direction)
	{
		super(r,g,b, direction);
		this.direction = direction;
	}

	/**
	 * Sets the direction integer
	 * @param dir direction
	 */
	public void setDir(int dir)
	{
		direction = dir;
	}

	/**
	 * Updates specific Pix, moving it in it's direction using its location
	 * @param i x location
	 * @param j y location
	 */
	public void update(int i, int j)
	{
		moveDir(Pixelife.getGrid().getGrid(), direction, i, j);
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
		// If the Pix has been looked at
		if (examined)
		{
			// Didn't try to move out of bounds
			if (!(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length))
			{
				// If trans location is white, move Pix
				if (grid[x][y].isWhite())
				{
					Spawner.spawnXY( grid[ix][iy].getClass(), x, y ); 
					grid[x][y].setPix(grid[ix][iy]);
					((DirectedPix)grid[x][y]).setDir(direction);
				}
			}
		}
		else
		{
			examined = true;
		}
	}
}