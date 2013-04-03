/**
 * Class ScaredPix
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */
public class ScaredPix extends Pix
{
	/**
	 * Default constructor
	 * Calls Pix()
	 */
	public ScaredPix()
	{
		super();
	}

	/**
	 * Gets closer to interacted Pix color
	 * Causes blurring...
	 */
	public void interact(Pix p)
	{
		if (!(p instanceof ScaredPix))
		{
			red = 255;
			green = 255;
			blue = 255;
		}	
	}
}