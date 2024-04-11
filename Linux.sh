echo "Deletando arquivos .class..."
rm -f *.class

echo "Deletando arquivo Lext"
rm -f Lext.*

echo "Executando o JFlex..."
java -jar jflex-full-1.9.1.jar lang.flex

echo "Compilando..."
javac Teste.java

echo "Rodando o programa..."
java Teste sample1.lan

read -p "Pressione Enter para continuar..."
