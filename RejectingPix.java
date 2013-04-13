/**
 * Class RejectingPix
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */
public class RejectingPix extends Pix
{

	/**
	 * Default constructor
	 * Calls Pix()
	 */
	public RejectingPix()
	{
		super();
	}

	/**
	 * Gets closer to interacted Pix color
	 * Causes blurring...
	 */
	public void interact(Pix p)
	{
		// Get further to red
		if (p.getRed() > red && red > 0)
		{
			red--;
		}
		if (p.getRed() < red && red < 255)
		{
			red++;
		}
		// Get further to green
		if (p.getGreen() > green && green > 0)
		{
			green--;
		}
		if (p.getGreen() < green && green < 255)
		{
			green++;
		}
		// Get further to blue
		if (p.getBlue() > blue && blue > 0)
		{
			blue--;
		}
		if (p.getBlue() < blue && blue < 255)
		{
			blue++;
		}

	}
}
