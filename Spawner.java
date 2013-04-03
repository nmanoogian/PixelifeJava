
public class Spawner
{
	private boolean needRespawn;
	private int respawnCounter;
	private int respawnMax;
	private int numSpawn;
	private Class<?> spawnClass;

	/**
	 * Creates a generic spawner that spawns 10 ranom of the given
	 */
	public Spawner()
	{
		needRespawn = false;
		respawnCounter = 0;
		respawnMax = 0;
		numSpawn = 10;
		spawnClass = Pix.class;
	}

	public Spawner(Class<?> c)
	{
		needRespawn = false;
		respawnCounter = 0;
		respawnMax = 0;
		numSpawn = 10;
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
}