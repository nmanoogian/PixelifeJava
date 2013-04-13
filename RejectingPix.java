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
		// Get further from red
		if (p.getRed() > red && red > 0)
		{
			red--;
		}
		else if (p.getRed() < red && red < 255)
		{
			red++;
		}
		// Get further from green
		if (p.getGreen() > green && green > 0)
		{
			green--;
		}
		else if (p.getGreen() < green && green < 255)
		{
			green++;
		}
		// Get further from blue
		if (p.getBlue() > blue && blue > 0)
		{
			blue--;
		}
		else if (p.getBlue() < blue && blue < 255)
		{
			blue++;
		}

	}
}
