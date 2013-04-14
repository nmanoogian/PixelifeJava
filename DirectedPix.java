/**
 * Class Directed Pix
 * Pixel only move in one direction
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */

public class DirectedPix extends NonconformingPix
{
	/*
	 * Numerical direction 0,1,2,3
	 */
	private int direction;

	/**
	 * Constructs a DirectedPix with a random direction
	 */
	public DirectedPix()
	{
		this(254,254,254,(int)(Math.random()*2));
	}
	public DirectedPix(int r, int g, int b, int direction)
	{
		super(254,254,254);
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
}