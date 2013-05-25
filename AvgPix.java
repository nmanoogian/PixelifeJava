/**
 * Class AvgPix
 * @author Nic Manoogian <zimmoz3@verizon.net>
 */
public class AvgPix extends Pix
{

	/**
	 * Default constructor
	 * Calls Pix()
	 */
	public AvgPix()
	{
		super();
	}

	/**
	 * Changes colors of both Pix to the average of the two
     * Has a strange blurring effect
	 */
	public void interact(Pix p)
	{
        int newRed = (p.getRed() + getRed())/2;
        int newGreen = (p.getGreen() + getGreen())/2;
        int newBlue = (p.getBlue() + getBlue())/2;
        setPix(newRed,newGreen,newBlue);
        //p.setPix(newRed,newGreen,newBlue);
	}
}
