/**
 * NonconformingPix Class
 * Pixels do not interact
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */

public class NonconformingPix extends Pix
{
	/**
	 * Constructs a NonconformingPix with random RGB values using super class
	 */
	public NonconformingPix()
	{
		super();
	}

	/**
	 * Constructs a NonconformingPix with given RGB values using the super class
	 * @param r red channel
	 * @param g green channel
	 * @param b blue channel
	 */
	public NonconformingPix(int r, int g, int b)
	{
		super(r,g,b);

	}
	public void changeWithChannel(int channel)
	{
	}

	/**
	 * Ignores interaction request
	 * @param p Pix interactee
	 */
	public void interact(Pix p)
	{
	}


}