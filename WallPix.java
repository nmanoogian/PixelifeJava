/**
 * Class WallPix
 * Pixel only move in one direction and spawn instantly
 * WallPix are constantly moving
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */

public class WallPix extends DirectedPix
{
	/**
	 * Constructs a WallPix with a random direction
	 */
	public WallPix()
	{
		this(0,0,0,(int)(Math.random()*2));
	}
	/**
	 * Constructs a WallPix with a set direction
	 */
	public WallPix(int r, int g, int b, int direction)
	{
		super(0,0,0,direction);
	}

}