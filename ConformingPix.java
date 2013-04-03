/**
 * Class ConformingPix
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */
public class ConformingPix extends Pix
{

	/**
	 * Default constructor
	 * Calls Pix()
	 */
	public ConformingPix()
	{
		super();
	}

	/**
	 * Gets closer to interacted Pix color
	 * Causes blurring...
	 */
	public void interact(Pix p)
	{
		// Get closer to red
		if (p.getRed() > red)
		{
			red++;
		}
		if (p.getRed() < red)
		{
			red--;
		}
		// Get closer to green
		if (p.getGreen() > green)
		{
			green++;
		}
		if (p.getGreen() < green)
		{
			green--;
		}
		// Get closer to blue
		if (p.getBlue() > blue)
		{
			blue++;
		}
		if (p.getBlue() < blue)
		{
			blue--;
		}

	}
}