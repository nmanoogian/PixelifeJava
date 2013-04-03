
public class Spawner
{
	private boolean needRespawn;
	private int respawnCounter;
	private int respawnMax;
	private int numSpawn;
	private Class<?> spawnClass;

	/**
	 * Creates a generic spawner that spawns 10 random of the given
	 */
	public Spawner()
	{
		needRespawn = false;
		respawnCounter = 0;
		respawnMax = 100;
		numSpawn = 10;
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

	public void spawn(PixGrid grid)
	{
		if(Pix.class.isAssignableFrom(spawnClass))
		{
			for(int i = 0; i < numSpawn; i ++)
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
	}

	public boolean needRespawn()
	{
		if( needRespawn )
		{
			needRespawn = false;
			return true;
		}
		return false;
	}
}