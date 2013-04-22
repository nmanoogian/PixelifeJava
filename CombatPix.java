/**
 * CombatPix Class
 * The large grouping of Pix overcomes the small
 * Still working on implementation:
 *   - How do we count the Pix objects in a cluster?
 *   - How do we keep the algorithm fast?
 * @author Nic Manoogian
 */
// import java.util.ArrayList;

public class CombatPix extends NonconformingPix
{
	// Possibly keep track of strength at the edges
	private int strength;
	// Possibly keep track of children
	// private ArrayList<CombatPix> children;

	public CombatPix()
	{
		super();
		strength = 0;
	}
	public CombatPix(int r, int g, int b)
	{
		super(r,g,b);
		strength = 0;
	}
	public void setStrength(int s)
	{
		strength = s;
	}
	public int getStrength()
	{
		return strength;
	}

	/**
	 * Disintegrate if not interacting with another ScaredPix
	 */
	public void interact(Pix p)
	{
		if (p instanceof CombatPix && !equal(p))
		{
			if (((CombatPix)p).getStrength() > getStrength())
			{
				setPix(255,255,255);
				strength--;
			}
		}
	}
	
	/**
	 * Copies a Pix to a new location and increases strength
	 */
	public void movePixel(Pix[][] grid, int ix, int iy, int x, int y)
	{
		Spawner.spawnXY( grid[ix][iy].getClass(), x, y );
		grid[x][y].setPix(grid[ix][iy]);
		strength++;
		((CombatPix)grid[x][y]).setStrength(strength);
	}
	
}
