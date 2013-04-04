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
	 * Constructs with RGB values
	 * Calls Pix(r, g, b)
	 * @param r red channel
	 * @param g green channel
	 * @param b blue channel
	 */
	public ScaredPix(int r, int g, int b)
	{
		super(r, g, b);
	}

	/**
	 * Disintegrate if not interacting with another ScaredPix
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