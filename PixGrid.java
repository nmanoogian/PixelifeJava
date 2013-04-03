import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * PixGrid Class
 * Hold Pix objects and handles movement
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */
public class PixGrid
{
	private BufferedImage canvas;
	private Pix[][] grid;

	/**
	 * Constructs a PixGrid with size 640x480
	 */
	public PixGrid()
	{
		// Defaults to 640x480
		grid = new Pix[640][480];
	}

	/**
	 * Constructs a PixGrid with size and 10 Pix objects
	 * @param xsize width
	 * @param ysize height
	 */
	public PixGrid(int xsize, int ysize)
	{
		grid = new Pix[xsize][ysize];
		generate_blank_world();
	}

	/**
	 * Constructs a PixGrid with size and n Pix objects
	 * @param xsize width
	 * @param ysize height
	 * @param n number of Pix objects to add
	 */
	public PixGrid(int xsize, int ysize, int n)
	{
		grid = new Pix[xsize][ysize];
		generate_blank_world();
	}

	/**
	 * Fills grid with white Pix of a certain type
	 */
	public void generate_blank_world()
	{
		for( int i = 0; i < grid.length; i++ )
		{
			for( int j = 0; j < grid[0].length; j ++ )
			{
				grid[i][j] = new Pix(255,255,255);
			}
		}
	}

	/**
	 * Returns the grid
	 * @return grid
	 */
	public Pix[][] getGrid()
	{
		return grid;
	}

	/**
	 * Loops through all non-white Pix and transitions them in a random direction (N S E W)
	 */
	public void update()
	{
		for( int i = 0; i < grid.length; i++ )
		{
			for( int j = 0; j < grid[0].length; j ++ )
			{
				if( !grid[i][j].isWhite() )
				{
					grid[i][j].update( i , j );
				}
			}
		}
	}

	/**
	 * Returns a String representation of a PixGrid
	 * @return PixGrid String representation
	 */
	public String toString()
	{
		String new_string = "";
		for( int i = 0; i < grid.length; i++ )
		{
			for( int j = 0; j < grid[0].length; j ++ )
			{
				new_string += "(" + grid[i][j] + ") ";			
			}
			new_string += "\n";
		}
		return new_string;
	}
}