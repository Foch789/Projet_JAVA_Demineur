JC = javac

demarre: default
	java Demineur

default: 
	$(JC) *.java

clean:
	rm *.class
