generate:
	java -jar antlr-4.8-complete.jar -visitor -Dlanguage=Java lang1.g4
	

compile:
	javac -cp .:antlr-4.8-complete.jar *.java

run:
	java -cp .:antlr-4.8-complete.jar Main input.txt

clean:
	rm -f *.class *.tokens Example*.java Example*.tokens lang1BaseListener.java lang1Lexer.java lang1Listener.java lang1Parser.java lang1.interp lang1BaseVisitor.java lang1Lexer.interp lang1Visitor.java