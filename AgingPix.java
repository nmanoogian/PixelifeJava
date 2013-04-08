/**
 * Class AgingPix
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */
public class AgingPix extends Pix
{
	private boolean dying;

	/**
	 * Default constructor
	 * Calls Pix()
	 */
	public AgingPix()
	{
		super();
		dying = false;
	}

	/**
	 * Constructs with RGB values
	 * Calls Pix(r, g, b)
	 * @param r red channel
	 * @param g green channel
	 * @param b blue channel
	 */
	public AgingPix(int r, int g, int b)
	{
		super(r, g, b);
		dying = false;
	}

	/**
	 * Changes both Pix objects with respect to dominant channel
	 * @param p Pix interactee
	 */
	public void interact(Pix p)
	{
		changeWithChannel(getDomChannel());
		p.changeWithChannel(p.getDomChannel());
	}

	/**
	 * Increases dominant channel, but should slowly fade out
	 * @param channel dominant channel
	 */
	public void changeWithChannel(int channel)
	{
		int inc = 1;
		if (dying)
		{
			if (red < 255)
			{
				red++;
			}
			if (green < 255)
			{
				green++;
			}
			if (blue < 255)
			{
				blue++;
			}
		}
		switch (channel)
		{
			case 0:
				//Inc dominant
				if (red + inc <= 255)
				{
					red += inc;
				}
				else
				{
					//red = 100;
					dying = true;
				}

				break;
			case 1:
				//Inc dominant
				if (blue + inc <= 255)
				{
					blue += inc;
				}
				else
				{
					//blue = 100;
					dying = true;
				}

				break;
			case 2:
				//Inc dominant
				if (green + inc <= 255)
				{
					green += inc;
				}
				else
				{
					//green = 100;
					dying = true;
				}

				break;
			case -1:
				dying = true;
				break;
		}
	}
}