/**
 * Class StaticPix
 * Pixels do not update
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */
public class StaticPix extends Pix
{
	/**
	 * Default constructor
	 * Calls Pix()
	 */
	public StaticPix(int r, int g, int b)
	{
		super(r,g,b);
	}

	/**
	 * Default constructor
	 * Calls Pix()
	 */
	public StaticPix()
	{
		super();
	}

	/**
	 * Updates this specific Pix, choosing a direction and moving it randomly
	 * @param i x location
	 * @param j y location
	 */
	public void update(int i, int j)
	{
		// I don't think so, Tim
	}
}