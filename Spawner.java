/**
 * Spawner Class
 * Creates new Pix objects of a certain type
 * @author Nic Manoogian <zimmoz3@verizon.net>
 * @author Mike Lyons
 */
public class Spawner
{
	private boolean needRespawn;
	private int respawnCounter;
	private int respawnMax;
	private int numSpawn;
	private Class<?> spawnClass;

	/**
	 * Creates a generic Spawner that spawns 10 random of the given class
	 */
	public Spawner()
	{
		needRespawn = false;
		respawnCounter = 0;
		respawnMax = 0;
		numSpawn = 10;
		spawnClass = Pix.class;
	}

	/**
	 * Creates a Spawner that spawns 10 of a specific class
	 * @param c Class to spawn (PulsePix.class)
	 */
	public Spawner(Class<?> c)
	{
		needRespawn = false;
		respawnCounter = 0;
		respawnMax = 0;
		numSpawn = 10;
		this.spawnClass = c;
	}

	/**
	 * Spawns to a PixGrid
	 */
	public void spawn(PixGrid grid)
	{
		if(Pix.class.isAssignableFrom(spawnClass))
		{
			for(int i = 0; i < numSpawn; i ++)
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
}