<h1>Pixelife Java</h1>
A Pixel simulator written with Java's Graphics2D libraries
<ul>
	<li>Pixels are representated by objects called Pix</li>
	<li>There are different kinds of Pix objects, each with their own attributes</li>
	<li>Pix objects interact with each other, growing and shrinking in their environment</li>
</ul>

To observe different Pix objects and their interactions, add a <pre>Spawner</pre> or modify the default in the <pre>Pixelife</pre> class:

<pre><code>spawner = new Spawner(AgingPix.class, myGrid);</code></pre>