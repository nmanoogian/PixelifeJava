import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PixGrid 
{

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

	public void draw(BufferedImage canvas)
	{
		for( int i = 0; i < grid.length; i++ )
		{
			for( int j = 0; j < grid[0].length; j ++ )
			{
				canvas.setRGB(i, j, grid[i][j].getRGB());
			}
		}
	}

	public String get_pixel_at(int x, int y)
	{
		return "";
	}
}