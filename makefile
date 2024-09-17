generate:
	java -jar antlr-4.8-complete.jar -visitor lang/parser/Lang.g4
	

compile:
	javac -cp .:antlr-4.8-complete.jar lang/parser/*.java lang/ast/*.java lang/*.java lang/visitors/*.java

testSintatico:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -bs

testsInterpretador:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -bsm

testInterpretador:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i

testSemantic:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -byt

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
	lang/visitors/types/*.class \
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
ex10:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste10.lan
ex11:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste11.lan
ex12:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste12.lan
ex13:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste14.lan