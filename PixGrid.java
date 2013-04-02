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
		canvas = new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);
		// Defaults to 640x480
		grid = new Pix[640][480];
	}

	public PixGrid(int xsize, int ysize)
	{
		canvas = new BufferedImage(xsize, ysize, BufferedImage.TYPE_INT_ARGB);
		grid = new Pix[xsize][ysize];
		generate_blank_world();
		generate_world(100000);
		//grid[0][0].set(0,0,0);
	}
	public void generate_blank_world()
	{
		for( int i = 0; i < grid.length; i++ )
		{
			for( int j = 0; j < grid[0].length; j ++ )
			{
				grid[i][j] = new Pix();
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

	public void draw(Graphics2D g2)
	{
		System.out.println(grid.length);
		for( int i = 0; i < grid.length; i++ )
		{
			for( int j = 0; j < grid[0].length; j ++ )
			{
				//canvas.setRGB(i, j, grid[i][j].getRGB());
				canvas.setRGB(i, j, (new Color(15,15,15)).getRGB());
			}
		}
		return canvas;
	}

	public String get_pixel_at(int x, int y)
	{
		return "";
	}

	/**
	 * Moves a Pix
	 * @param p Pix to move
	 * @param ix inital x location
	 * @param ix inital y location
	 * @param x ending x location
	 * @param y ending y location
	 */
	public void movePixel(Pix p, int ix, int iy, int x, int y)
	{
		grid[x][y].set(p);
		grid[ix][iy] = new Pix(0, 0, 0);
	}
}