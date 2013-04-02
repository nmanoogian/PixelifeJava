import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		generate_world(50000);
	}
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

	public void generate_world(int number)
	{
		for(int i = 0; i < number; i ++)
		{
			grid[(int)(Math.random() * grid.length)][(int)(Math.random() * 
				grid[0].length)] = new Pix();
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

	public void update()
	{
		for( int i = 0; i < grid.length; i++ )
		{
			for( int j = 0; j < grid[0].length; j ++ )
			{
				if( !grid[i][j].isWhite() )
				{
					int direction = (int)(Math.random() * 4)
					int new_x, new_y;
					switch(direction)
					{
						case 1:
							
						case 2:
						case 3:
						case 4:
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
		grid[ix][iy].setPix(255,255,255);
	}
}