/**
 * Class Spawner
 * object that is to be used to spawn new pix.
 * 
 * Tries to save framerate by spawning one per frame,
 * 		unless you call spawn(num)
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
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
		respawnMax = 200;
		numSpawn = 5;
		numSpawnMax = 10;
		defaultX = -1;
		defaultY = -1;
		spawnClass = Pix.class;
	}

	/**
	 * Creates a spawner that will spawn the given class 10 times randomly
	 * @param c Class to spawn (PulsePix.class)
	 */
	public Spawner(Class<?> c)
	{
		this();
		this.spawnClass = c;
	}

	/**
	 * Creates a Spawner that will spawn a given class to a given grid
	 * @param c Class to spawn (PulsePix.class)
	 * @param grid PixGrid object
	 */
	public Spawner(Class<?> c, PixGrid grid)
	{
		this();
		this.spawnClass = c;
		this.grid = grid;
	}

	/**
	 * Creates a Spawner with a give class, grid and default x and y locations
	 * @param c Class to spawn
	 * @param grid PixGrid object
	 * @param dx default x
	 * @param dy default y
	 */
	public Spawner(Class<?> c, PixGrid grid, int dx, int dy)
	{
		this(c, grid);
		this.spawnClass = c;
		this.grid = grid;

		this.defaultX = dx;
		this.defaultY = dy;
	}

	/**
	 * Spawns random instances of the spawn class to the grid
	 */
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

	/**
	 * Spawns a number of instances of the spawn class to the grid
	 * @param num number of instances to spawn
	 */
	public void spawn(int num)
	{
		if(Pix.class.isAssignableFrom(spawnClass))
		{
			for( int i = 0; i < num; i ++ )
			{
				try
				{
					grid.getGrid()[(int)(Math.random() * grid.getGrid().length)][(int)(Math.random() * grid.getGrid()[0].length)] = (Pix)spawnClass.newInstance();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}	
			}
		}
		else
		{
			System.out.println("Class not found");
		}
	}

	/**
	 * Spawns a specific instance of a class to a specific x and y location
	 * @param c class to spawn
	 * @param x x location to spawn
	 * @param y y location to spawn
	 */
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

	/**
	 * Determines if a spawn is necessary, otherwise, increase counter
	 */
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