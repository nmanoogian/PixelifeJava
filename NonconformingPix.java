/**
 * NonconformingPix Class
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
					red = 100;
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
					blue = 100;
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
					green = 100;
				}

				break;
			case -1:
				//green--;
				break;
		}

	}

	/**
	 * Returns the dominant channel
	 * 0 => Red; 1 => Blue; 2 => Green
	 * @return integer for channel
	 */
	public int getDomChannel()
	{
		if (red > green && red > blue)
		{
			return 0;
		}
		else if (blue > green && blue > red)
		{
			return 1;
		}
		else if (green > red && green > blue)
		{
			return 2;
		}
		else
		{
			return -1;
		}

	}

}