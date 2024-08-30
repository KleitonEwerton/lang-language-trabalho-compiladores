generate:
	java -jar antlr-4.8-complete.jar -visitor lang/parser/Lang.g4
	

compile:
	javac -cp antlr-4.8-complete.jar:. -d . lang/ast/*.java
	javac -cp antlr-4.8-complete.jar:. -d . lang/parser/*.java
	javac -cp antlr-4.8-complete.jar:. -d . lang/LangCompiler.java
	javac -cp antlr-4.8-complete.jar:. -d . lang/visitors/*.java

run:
	java -cp antlr-4.8-complete.jar lang.LangCompiler -i lang/meu_teste/input.txt
	
clean:
	rm -f lang/parser/*.class \
	rm -f lang/visitors/*.class \
	lang/parser/*.tokens \
	lang/parser/langBaseListener.java \
	lang/parser/langLexer.java \
	lang/parser/langListener.java \
	lang/parser/langParser.java \
	lang/parser/lang.interp \
	lang/parser/langBaseVisitor.java \
	lang/parser/langLexer.interp \
	lang/parser/langVisitor.java \
	lang/ast/*.class \
	lang/*.class \
	lang/visitors/*.class

ex1:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste1.lan
ex2:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste2.lan
ex3:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste3.lan
ex4:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste4.lan
ex5:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste5.lan
ex6:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste6.lan
ex7:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste7.lan
ex8:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste8.lan
ex9:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste9.lan
