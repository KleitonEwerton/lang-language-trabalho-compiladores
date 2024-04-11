@echo off

echo Deletando arquivos .class...
del *.class

echo Deletando arquivo Lext
del Lext.*

echo Executando o JFlex...
java -jar jflex-full-1.9.1.jar lang.flex

echo Compilando...
javac Teste.java

echo Rodando o programa...
java Teste sample1.lan

pause
