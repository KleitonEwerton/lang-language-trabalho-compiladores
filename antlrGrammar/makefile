generate:
	java -jar antlr-4.8-complete.jar -visitor -Dlanguage=Java lang/parser/lang1.g4
	

compile:
	javac -cp .:antlr-4.8-complete.jar lang/parser/*.java lang/ast/*.java *.java

run:
	java -cp .:antlr-4.8-complete.jar LangCompiler -i lang/parser/input.txt

clean:
	rm -f lang/parser/*.class \
	lang/parser/*.tokens \
	lang/parser/Example*.java \
	lang/parser/Example*.tokens \
	lang/parser/lang1BaseListener.java \
	lang/parser/lang1Lexer.java \
	lang/parser/lang1Listener.java \
	lang/parser/lang1Parser.java \
	lang/parser/lang1.interp \
	lang/parser/lang1BaseVisitor.java \
	lang/parser/lang1Lexer.interp \
	lang/parser/lang1Visitor.java \
	lang/ast/*.class