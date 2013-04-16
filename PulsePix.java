/**
 * PulsePix Class
 * Pix set their default value to 100 after reaching maximum
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */



public class PulsePix extends Pix
{
	/**
	 * Constructs a PulsePix with random RGB values using super class
	 */
	public PulsePix()
	{
		super();
	}

	/**
	 * Constructs a PulsePix with given RGB values using the super class
	 * @param r red channel
	 * @param g green channel
	 * @param b blue channel
	 */
	public PulsePix(int r, int g, int b)
	{
		super(r,g,b);

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
	 * Increases dominant channel, does not decrease non-dom
	 * @param channel dominant channel
	 */
	public void changeWithChannel(int channel)
	{
		switch (channel)
		{
			case 0:
				//Inc dominant
				if (red + 1 <= 255)
				{
					red += 1;
				}
				else
				{
					setPix(100,0,0);
				}

				break;
			case 1:
				//Inc dominant
				if (blue + 1 <= 255)
				{
					blue += 1;
				}
				else
				{
					setPix(0,0,100);
				}
				break;
			case 2:
				//Inc dominant
				if (green + 1 <= 255)
				{
					green += 1;
				}
				else
				{
 					setPix(0,100,0);
				}

				break;
			case -1:
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
				break;
		}

	}
}