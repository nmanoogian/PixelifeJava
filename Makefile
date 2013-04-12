build:
	javac *java

clean:
	rm *.class

life:
	make build
	java Pixelife
