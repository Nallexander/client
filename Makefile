# Makefile for client side
JAVAC = javac -d . -classpath .

CLASS_FILES = \
	SocketClient.class RMIClient.class Tester.class

all: $(CLASS_FILES)

SocketClient.class:	DISClient.class
RMIClient.class:	DISClient.class

clean:
	-rm -f *.class *~

# Rule for compiling a normal .java file
%.class: %.java
	javac -d . -classpath . $<
