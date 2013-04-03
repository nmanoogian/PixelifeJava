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
		// switch (channel)
		// {
		// 	case 0:
		// 		//Inc dominant
		// 		if (red + 1 <= 255)
		// 		{
		// 			red += 1;
		// 		}
		// 		else
		// 		{
		// 			red = 100;
		// 		}

		// 		break;
		// 	case 1:
		// 		//Inc dominant
		// 		if (blue + 1 <= 255)
		// 		{
		// 			blue += 1;
		// 		}
		// 		else
		// 		{
		// 			blue = 100;
		// 		}

		// 		break;
		// 	case 2:
		// 		//Inc dominant
		// 		if (green + 1 <= 255)
		// 		{
		// 			green += 1;
		// 		}
		// 		else
		// 		{
		// 			green = 100;
		// 		}

		// 		break;
		// 	case -1:
		// 		//green--;
		// 		break;
		// }
		switch (channel)
		{
			case 0:
				//Inc dominant
				if (red + 2 <= 255)
				{
					red += 2;
				}
				else
				{
					red = 100;
				}

				//Dec mins
				if (blue - 1 >= 0)
				{
					blue--;
				}
				else
				{
					blue = 255;
				}

				if (green - 1 >= 0)
				{
					green--;
				}
				else
				{
					green = 255;
				}
				break;
			case 1:
				//Inc dominant
				if (blue + 2 <= 255)
				{
					blue += 2;
				}
				else
				{
					blue = 100;
				}

				//Dec mins
				if (green - 1 >= 0)
				{
					green--;
				}
				else
				{
					green = 255;
				}

				if (red - 1 >= 0)
				{
					red--;
				}
				else
				{
					red = 255;
				}
				break;
			case 2:
				//Inc dominant
				if (green + 2 <= 255)
				{
					green += 2;
				}
				else
				{
					green = 100;
				}

				//Dec mins
				if (red - 1 >= 0)
				{
					red--;
				}
				else
				{
					red = 255;
				}

				if (blue - 1 >= 0)
				{
					blue--;
				}
				else
				{
					red = 255;
				}
				break;
			case -1:
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