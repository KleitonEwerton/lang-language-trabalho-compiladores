generate:
	java -jar antlr-4.8-complete.jar -visitor -Dlanguage=Java lang/parser/lang.g4
	

compile:
	javac -cp .:antlr-4.8-complete.jar lang/parser/*.java lang/ast/*.java *.java

run:
	java -cp .:antlr-4.8-complete.jar LangCompiler -bs lang/parser/input.txt

clean:
	rm -f lang/parser/*.class \
	lang/parser/*.tokens \
	lang/parser/Example*.java \
	lang/parser/Example*.tokens \
	lang/parser/langBaseListener.java \
	lang/parser/langLexer.java \
	lang/parser/langListener.java \
	lang/parser/langParser.java \
	lang/parser/lang.interp \
	lang/parser/langBaseVisitor.java \
	lang/parser/langLexer.interp \
	lang/parser/langVisitor.java \
	lang/ast/*.class \
	*.class