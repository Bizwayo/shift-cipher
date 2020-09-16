all: main.class Vigenere.class

main.class: main.java
	javac -g main.java

Vigenere.class: Vigenere.java
	javac -g Vigenere.java

clean:
	rm -rf *.class 



