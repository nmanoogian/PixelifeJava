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

	public PixGrid()
	{
		// Defaults to 640x480
		grid = new Pix[640][480];
	}

	public PixGrid(int xsize, int ysize)
	{
		grid = new Pix[xsize][ysize];
		generate_blank_world();
		generate_world(10);
	}

	public PixGrid(int xsize, int ysize, int n)
	{
		grid = new Pix[xsize][ysize];
		generate_blank_world();
		generate_world(n);
	}

	public void generate_blank_world()
	{
		for( int i = 0; i < grid.length; i++ )
		{
			for( int j = 0; j < grid[0].length; j ++ )
			{
				grid[i][j] = new NonconformingPix(255,255,255);
			}
		}
	}

	public void generate_world(int number)
	{
		for(int i = 0; i < number; i ++)
		{
			grid[(int)(Math.random() * grid.length)][(int)(Math.random() * 
				grid[0].length)] = new NonconformingPix();
		}
	}


	public Pix[][] getGrid()
	{
		return grid;
	}

	public String get_pixel_at(int x, int y)
	{
		return "";
	}

	public void trans(int ix, int iy, int x, int y)
	{
		// Didn't try to move out of bounds
		if (!(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length))
		{
			// If trans location is white, move Pix
			if (grid[x][y].isWhite())
			{
				movePixel(ix, iy, x, y);
			}
			else
			{
				grid[ix][iy].interact(grid[x][y]);
			}


		}
	}

	public void update()
	{
		for( int i = 0; i < grid.length; i++ )
		{
			for( int j = 0; j < grid[0].length; j ++ )
			{
				if( !grid[i][j].isWhite() )
				{
					int direction = (int)(Math.random() * 4);
					//System.out.println(direction);
					switch(direction)
					{
						case 0:
							trans(i,j,i+1,j);
							break;
						case 1:
							trans(i,j,i,j+1);
							break;
						case 2:
							trans(i,j,i-1,j);
							break;
						case 3:
							trans(i,j,i,j-1);
							break;
						default:
							break;
					}
				}
			}
		}
	}

	/**
	 * Moves a Pix
	 * @param ix inital x location
	 * @param ix inital y location
	 * @param x ending x location
	 * @param y ending y location
	 */
	public void movePixel(int ix, int iy, int x, int y)
	{
		grid[x][y].setPix(grid[ix][iy]);
		//Uncomment to remove spread
		//grid[ix][iy] = new NonconformingPix(255,255,255);
	}

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