/**
 * Class QuickPix
 * Chooses a growth speed and moves a that pace
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */
public class QuickPix extends AgingPix
{
	private int growthspeed;
	/**
	 * Default constructor
	 * Calls Pix()
	 */
	public QuickPix()
	{
		super();
		growthspeed = (int)(Math.random()*4) + 1;
	}

	/**
	 * Constructs with RGB values
	 * Calls Pix(r, g, b)
	 * @param r red channel
	 * @param g green channel
	 * @param b blue channel
	 */
	public QuickPix(int r, int g, int b)
	{
		super(r, g, b);
		growthspeed = (int)(Math.random()*4) + 1;
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
	 * Moves the direction given (N S E W)
	 * Moves to spaces
	 * @param grid PixGrid object
	 * @param dirNum direction to move
	 * @param i x location of pixel
	 * @param j y location of pixel
	 */
	public void moveDir(Pix[][] grid, int dirNum, int i, int j)
	{
		switch(dirNum)
		{
			case 0:
				for (int n = 0; n < growthspeed; n++)
				{
					trans(grid, i,j,i+n,j);
				}
				break;
			case 1:
				for (int n = 0; n < growthspeed; n++)
				{
					trans(grid, i,j,i,j+n);
				}
				break;
			case 2:
				for (int n = 0; n < growthspeed; n++)
				{
					trans(grid, i,j,i-n,j);
				}
				break;
			case 3:
				for (int n = 0; n < growthspeed; n++)
				{
					trans(grid, i,j,i,j-n);
				}
				break;
			default:
				break;
		}
	}
}