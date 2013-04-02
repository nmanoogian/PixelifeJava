

public class PixGrid 
{

	private Pix[][] grid;

	public PixGrid()
	{
		// Defaults to 640x480
		grid = new Pix[640][480]
	}

	public PixGrid(int xsize, int ysize)
	{
		grid = new Pix[xsize][ysize];
	}


	
}