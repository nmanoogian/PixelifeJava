
/**
 * Class Spawner
 * object that is to be used to spawn new pix.
 * 
 * Tries to save framerate by spawning one per frame,
 * 		unless you call spawn(num)
 *
 *
 *
 *
 *
 */

public class Spawner
{
	private boolean needRespawn;

	private int respawnCounter;
	private int respawnMax;

	private int numSpawn;
	private int numSpawnMax;

	/*
	 * Default x and y, if none then == -1
	 */
	private int defaultX;
	private int defaultY;

	private Class<?> spawnClass;
	private static PixGrid grid;

	/**
	 * Creates a generic spawner that spawns 10 random of the given
	 */
	public Spawner()
	{
		needRespawn = false;
		respawnCounter = 0;
		respawnMax = 100;
		numSpawn = 10;
		numSpawnMax = 10;
		defaultX = -1;
		defaultY = -1;
		spawnClass = Pix.class;
	}

	/**
	 * Creates a spawner that will spawn the given class 10 times randomly
	 *
	 */
	public Spawner(Class<?> c)
	{
		this();
		this.spawnClass = c;
	}

	public Spawner(Class<?> c, PixGrid grid)
	{
		this();
		this.spawnClass = c;
		this.grid = grid;
	}
	public Spawner(Class<?> c, PixGrid grid, int dx, int dy)
	{
		this(c, grid);
		this.spawnClass = c;
		this.grid = grid;

		this.defaultX = dx;
		this.defaultY = dy;
	}

	public void spawn()
	{
		if(Pix.class.isAssignableFrom(spawnClass))
		{
			try {
				if( defaultX != -1 && defaultY != -1 )
				{
					grid.getGrid()[defaultX][defaultY] = (Pix)spawnClass.newInstance();
				}
				else
				{
					grid.getGrid()[(int)(Math.random() * grid.getGrid().length)][(int)(Math.random() * 
						grid.getGrid()[0].length)] = (Pix)spawnClass.newInstance();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Class not found");
		}
	}
	public void spawn(int num)
	{
		if(Pix.class.isAssignableFrom(spawnClass))
		{
			for( int i = 0; i < num; i ++ )
			{
				try {
					grid.getGrid()[(int)(Math.random() * grid.getGrid().length)][(int)(Math.random() * 
						grid.getGrid()[0].length)] = (Pix)spawnClass.newInstance();
				} catch(Exception e) {
					e.printStackTrace();
				}	
			}
		}
		else
		{
			System.out.println("Class not found");
		}
	}

	public static void spawnXY(Class<?> c, int x, int y)
	{
		if(Pix.class.isAssignableFrom(c))
		{
			try {
				grid.getGrid()[x][y] = (Pix)c.newInstance();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Class not found");
		}
	}

	public void update()
	{
		if( respawnMax != -1 )
		{
			respawnCounter++;
			if( respawnCounter > respawnMax )
			{
				needRespawn = true;
				respawnCounter = 0;
			}
		}

		if( needRespawn )
		{
			spawn();
			numSpawn--;
			if( numSpawn == 0 )
			{
				numSpawn = numSpawnMax;
				needRespawn = false;
			}
		}
	}
}