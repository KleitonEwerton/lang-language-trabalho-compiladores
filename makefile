
# Rodar tudo
# make clean && make generate && make compile
# make testSintatico && make testsInterpretador && make testSemantic 
# make ex1 && make ex1eMeio && make ex2 && make ex3 && make ex4 && make ex5 && make ex6 && make ex7 && make ex8 && make ex9 && make ex10 && make ex11 && make ex12 && make ex13 && make ex14
# make codeTeste0 && make codeTeste1 && make codeTeste1eMeio && make codeTeste2 && make codeTeste3 && make codeTeste4 && make codeTeste5 && make codeTeste6 && make codeTeste7 && make codeTeste8 && make codeTeste9 && make codeTeste10 && make codeTeste11 && make codeTeste12 && make codeTeste13 && make codeTeste14

generate:
	java -jar antlr-4.8-complete.jar -visitor lang/parser/Lang.g4
	
compile:
	javac -cp .:antlr-4.8-complete.jar lang/parser/*.java lang/ast/*.java lang/*.java lang/visitors/*.java lang/template/*.java
	javac -cp .:ST-4.3.1.jar lang/template/*.java

testSintatico:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -bs

testsInterpretador:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -bsm

testInterpretador:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i

testSemantic:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -byt

testJava: codeTeste0 codeTeste1 codeTeste1eMeio codeTeste2 codeTeste3 codeTeste4 codeTeste5 codeTeste6 codeTeste7 codeTeste8 codeTeste9 codeTeste10 codeTeste11 codeTeste12 codeTeste13 codeTeste14

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
	lang/visitors/*.class \
	lang/semantic/*.class \
	lang/semantic/types/*.class \
	lang/template/*.class \
	generatedCode/*.class \
	generatedCode/*.java \
	generatedCodeJasmin/*.j

ex1:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste1.lan
ex1eMeio:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste1eMeio.lan
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
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste13.lan
ex14:
	java -cp antlr-4.8-complete.jar:. lang/LangCompiler -i ./testes/semantica/certo/teste14.lan

codeTeste0:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste0.lan -genFile ./generatedCode/teste0.java
	javac ./generatedCode/teste0.java

codeTeste1:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste1.lan -genFile ./generatedCode/teste1.java
	javac ./generatedCode/teste1.java

codeTeste1eMeio:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste1eMeio.lan -genFile ./generatedCode/teste1eMeio.java
	javac ./generatedCode/teste1eMeio.java

codeTeste2:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste2.lan -genFile ./generatedCode/teste2.java
	javac ./generatedCode/teste2.java

codeTeste3:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste3.lan -genFile ./generatedCode/teste3.java
	javac ./generatedCode/teste3.java

codeTeste4:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste4.lan -genFile ./generatedCode/teste4.java
	javac ./generatedCode/teste4.java

codeTeste5:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste5.lan -genFile ./generatedCode/teste5.java
	javac ./generatedCode/teste5.java

codeTeste6:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste6.lan -genFile ./generatedCode/teste6.java
	javac ./generatedCode/teste6.java

codeTeste7:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste7.lan -genFile ./generatedCode/teste7.java
	javac ./generatedCode/teste7.java

codeTeste8:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste8.lan -genFile ./generatedCode/teste8.java
	javac ./generatedCode/teste8.java

codeTeste9:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste9.lan -genFile ./generatedCode/teste9.java
	javac ./generatedCode/teste9.java

codeTeste10:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste10.lan -genFile ./generatedCode/teste10.java
	javac ./generatedCode/teste10.java

codeTeste11:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste11.lan -genFile ./generatedCode/teste11.java
	javac ./generatedCode/teste11.java

codeTeste12:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste12.lan -genFile ./generatedCode/teste12.java
	javac ./generatedCode/teste12.java

codeTeste13:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste13.lan -genFile ./generatedCode/teste13.java
	javac ./generatedCode/teste13.java

codeTeste14:
	java -cp antlr-4.8-complete.jar:ST-4.3.1.jar:. lang/LangCompiler -Java ./testes/semantica/certo/teste14.lan -genFile ./generatedCode/teste14.java
	javac ./generatedCode/teste14.java


codeJasmin0:
	java -cp antlr-4.8-complete.jar:jasmin.jar:. lang/LangCompiler -Jasmin ./testes/semantica/certo/teste0.lan -genFile ./generatedCodeJasmin/teste0.j
	javac ./generatedCodeJasmin/teste0.j

codeJasmin1:
	java -cp antlr-4.8-complete.jar:jasmin.jar:. lang/LangCompiler -Jasmin ./testes/semantica/certo/teste1.lan -genFile ./generatedCodeJasmin/teste1.j
	javac ./generatedCodeJasmin/teste1.j