import java.awt.Color;
/**
 * Pix Class
 * with Red Green and Blue streams
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */
public class Pix
{
	public static final int COMPARE_THRESHOLD = 0;

	/*
	 * Color channels
	 */
	protected int red;
	protected int green;
	protected int blue;

	/**
	 * Constructs a Pix using rgb values
	 * @param r red channel
	 * @param g green channel
	 * @param b blue channel
	 */
	public Pix(int r, int g, int b)
	{
		red = r;
		green = g;
		blue = b;
	}

	/**
	 * Constructs a Pix using non-duplicative random channels
	 */
	public Pix()
	{
		int r = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);

		while (r == g || g == b || b == r)
		{
			r = (int)(Math.random() * 256);
			g = (int)(Math.random() * 256);
			b = (int)(Math.random() * 256);
		}

		red = r;
		green = g;
		blue = b;
	}

	/**
	 * Sets a Pix using rgb values
	 * @param r red channel
	 * @param g green channel
	 * @param b blue channel
	 */
	public void setPix(int r, int g, int b)
	{
		red = r;
		green = g;
		blue = b;
	}

	/**
	 * Sets a Pix using another Pix
	 * @param p other Pix
	 */
	public void setPix(Pix p)
	{
		red = p.getRed();
		green = p.getGreen();
		blue = p.getBlue();
	}

	/**
	 * Sets a Pix using random values
	 */
	public void setPix()
	{

		int r = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);

		while (r == g || g == b || b == r)
		{
			r = (int)(Math.random() * 256);
			g = (int)(Math.random() * 256);
			b = (int)(Math.random() * 256);
		}

		red = r;
		green = g;
		blue = b;
	}

	/**
	 * Return red channel
	 * @return red channel
	 */
	public int getRed()
	{
		return red;
	}

	/**
	 * Return green channel
	 * @return green channel
	 */
	public int getGreen()
	{
		return green;

	}

	/**
	 * Return blue channel
	 * @return blue channel
	 */
	public int getBlue()
	{
		return blue;
	}

	/**
	 * Sets the red channel to value
	 * @param red int value to set red
	 */
	public void setRed(int red)
	{
		if (red >= 0 && red <= 255)
		{
			this.red = red;
		}
	}

	/**
	 * Sets the green channel to value
	 * @param green value to set green
	 */
	public void setGreen(int green)
	{
		if (green >= 0 && green <= 255)
		{
			this.green = green;
		}
	}

	/**
	 * Sets the blue channel to value
	 * @param blue value to set to blue
	 */
	public void setBlue(int blue)
	{
		if (green >= 0 && green <= 255)
		{
			this.blue = blue;
		}
	}

	/**
	 * Increases dominant channel by factor
	 * Decreases non-dominant channel by a factor
	 * @param channel dominant channel
	 */
	public void changeWithChannel(int channel)
	{
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
					red = 255;
				}

				//Dec mins
				if (blue - 1 >= 0)
				{
					blue--;
				}

				if (green - 1 >= 0)
				{
					green--;
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
					blue = 255;
				}

				//Dec mins
				if (green - 1 >= 0)
				{
					green--;
				}

				if (red - 1 >= 0)
				{
					red--;
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
					green = 255;
				}

				//Dec mins
				if (red - 1 >= 0)
				{
					red--;
				}

				if (blue - 1 >= 0)
				{
					blue--;
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
			//ystem.out.println("No dominant channel" + toString());
			return -1;
		}

	}

	/**
	 * Changes (or does not change) the Pix and Pix interactee
	 * @param p Pix interactee
	 */
	public void interact(Pix p)
	{
		//System.out.println(toString() + " and " + p.toString());
		//if (getDomChannel() == p.getDomChannel())
		if( !equal(p) )
		{
			changeWithChannel(getDomChannel());
			p.changeWithChannel(p.getDomChannel());
		}

	}

	/**
	 * Transitions a Pix from one location to another
	 * If the Pix is white, the Pix is moved. Otherwise, one Pix interacts with the other
 	 * @param ix inital x location
	 * @param ix inital y location
	 * @param x ending x location
	 * @param y ending y location
	 */
	public void trans(Pix[][] grid, int ix, int iy, int x, int y)
	{
		// Didn't try to move out of bounds
		if (!(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length))
		{
			// If trans location is white, move Pix
			if (grid[x][y].isWhite())
			{
				movePixel(grid, ix, iy, x, y);
			}
			else
			{
				grid[ix][iy].interact(grid[x][y]);
			}
		}
	}

	/**
	 * Updates this specific Pix, choosing a direction and moving it randomly
	 * @param i x location
	 * @param j y location
	 */
	public void update(int i, int j)
	{
		int direction = (int)(Math.random() * 4);
		//System.out.println(direction);
		moveDir(Pixelife.getGrid().getGrid(), direction, i, j);
	}

	/**
	 * Moves the direction given (N S E W)
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
				trans(grid, i,j,i+1,j);
				break;
			case 1:
				trans(grid, i,j,i,j+1);
				break;
			case 2:
				trans(grid, i,j,i-1,j);
				break;
			case 3:
				trans(grid, i,j,i,j-1);
				break;
			default:
				break;
		}
	}

	/**
	 * Moves a Pix
	 * @param ix inital x location
	 * @param ix inital y location
	 * @param x ending x location
	 * @param y ending y location
	 */
	public void movePixel(Pix[][] grid, int ix, int iy, int x, int y)
	{
		Spawner.spawnXY( grid[ix][iy].getClass(), x, y );
		grid[x][y].setPix(grid[ix][iy]);
		//Uncomment to remove spread
		//grid[ix][iy] = new Pix(255,255,255);
	}

	/**
	 * Returns RGB integer representation of a Pix
	 * @return integer RGB of Pix
	 */
	public int getRGB()
	{
		return (new Color(red,green,blue)).getRGB();
	}


	/**
	 * Returns if the Pix is white
	 * @return true if Pix is white, false otherwise
	 */
	public boolean isWhite()
	{
		return (red == 255 && blue == 255 && green == 255);
	}

	/**
	 * Represents a Pix as a string using RGB values
	 * @return integer representation
	 */
	public String toString()
	{
		return red + ", " + green + ", " + blue;
	}

	/**
	 * Determines if two Pix objects are "equal" based on a comparison threshold
	 * @param o Other object in question
	 * @return true if equal, false otherwise
	 */
	public boolean equal(Object o)
	{
		if( o instanceof Pix )
		{
			Pix p = (Pix)o;
			return !( Math.abs( red - p.getRed() ) > COMPARE_THRESHOLD || 
					  Math.abs( blue - p.getBlue() ) > COMPARE_THRESHOLD ||
					  Math.abs( green - p.getGreen() ) > COMPARE_THRESHOLD);
		} 
		return false;
	}

}