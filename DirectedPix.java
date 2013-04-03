
public class DirectedPix extends Pix
{
	private int direction; // (N E S W)

	public DirectedPix()
	{
		super();
		direction = 0;
	}
	public DirectedPix(int r, int g, int b, int direction)
	{
		super(r,g,b);
		this.direction = direction;
	}

	public void setDir(int dir)
	{
		direction = dir;
	}

	/**
	 * Updates this specific pix, moving it in it's direction
	 */
	public void update(int i, int j)
	{
		//int direction = (int)(Math.random() * 4);
		//System.out.println(direction);
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
			movePixel(grid, ix, iy, x, y);
		}
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
		// Moves it along
		Spawner.spawnXY( grid[ix][iy].getClass(), x, y ); 
		grid[x][y].setPix(grid[ix][iy]);

		// Duplicates upward and downward
		//Spawner.spawnXY( grid[ix][iy].getClass(), x, y-1 );
		//Spawner.spawnXY( grid[ix][iy].getClass(), x, y+1 );
		//grid[x][y-1].setPix(grid[ix][iy]);
		//grid[x][y+1].setPix(grid[ix][iy]);
		//((DirectedPix)grid[x][y-1]).setDir(0);
		//((DirectedPix)grid[x][y+1]).setDir(2);
		//Uncomment to remove spread
		//grid[ix][iy] = new Pix(255,255,255);
	}
}