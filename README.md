<h1>Pixelife Java</h1>
A Pixel simulator written with Java's Graphics2D libraries
<ul>
	<li>Pixels are representated by objects called Pix</li>
	<li>There are different kinds of Pix objects, each with their own attributes</li>
	<li>Pix objects interact with each other, growing and shrinking in their environment</li>
</ul>

The basic Pix object follows these rules:
<ul>
	<li>Each Pix object has red, green, and blue values ranging from 0 to 255. These values are called <i>channels</i></li>
	<li>Usually, Pix objects are generated with three random channels such that no two channels are the same</li>
	<li>When it is a Pix object's turn to move, it chooses a random direction: north, south, east, or west</li>
	<ul>
		<li>If the space is empty, the Pix is duplicated to this location</li>
		<li>If the space occupied, the two objects <i>interact</i></li>
	</ul>
	<li>If two Pixels have the same highest channel, then they are said to have the same <i>dominant channel</i></li>
	<li>If two Pixels have the same dominant channel and they interact, both increase that channel by 2 points and both decrease each of the <i>non-dominant</i> channels by 1</li>
	<li>If two Pixels interact, but do not have the same dominant channel, they both remain unchanged</li>
</ul>

To observe different Pix objects and their interactions, add a Spawner or modify the default in the Pixelife class:
```Java
spawner = new Spawner(AgingPix.class, myGrid);
spawner.spawn(100);
```

To compile and run:
```java
javac *.java && java Pixelife
```
Or simply:
```
make life
```

A few of the more notable classes:
<ul>
	<li><i>RainbowPix</i> - Generates a rainbow pattern</li>
	<li><i>PulsePix</i> - Pulses from the center</li>
	<li><i>AgingPix</i> - Pixels "grow old" and become white</li>
	<li><i>SpiralPix</i> - Forms a spiral pattern</li>
	<li><i>WallPix</i> - Multiple form a maze pattern which contains Pix growth</li>
	<li><i>ScaredPix</i> - Recedes away from other Pix</li>
	<li><i>ConformingPix</i> - Change to the color of the Pix around them (causes blurring)</li>
	<li><i>AvgPix</i> - Change to the color of the average of the current color and the color of the interacting Pix</li>
</ul>
