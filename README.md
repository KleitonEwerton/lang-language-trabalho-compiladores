<h1 align="center">Linguagem Lang</h1>

<p align="center">Trabalho desenvolvido em Java durante a disciplina de Teoria dos Compiladores, ministrada pelo professor Leonardo Vieira dos Santos Reis</p>

## 🎮 Rodando aplicação no Linux

```bash
# Abra o terminal e instale o JFlex
sudo apt-get install jflex

# Clone este repositório
git clone https://github.com/KleitonEwerton/lang-language-trabalho-compiladores.git

# Acesse a pasta do projeto no terminal/cmd
cd lang-language-trabalho-compiladores

# Execute o JFlex
jflex lang.flex

# Compile
javac Teste.java

# Rode o programa
java Teste sample1.txt

```
## 🎮 Rodando aplicação no Windows

```bash
# Clone este repositório
git clone https://github.com/KleitonEwerton/lang-language-trabalho-compiladores.git

# Acesse a pasta do projeto no terminal/cmd
cd lang-language-trabalho-compiladores

# Execute o JFlex
java -jar jflex-full-1.9.1.jar lang.flex

# Compile
javac Teste.java

# Rode o programa, subistitua sample1.txt para o arquivo de preferência
java Teste sample1.txt
```

## 🎮 Rodando Todos os arquivos .lan de uma pasta na aplicação no Linux

```bash
# Abra o terminal e instale o JFlex
sudo apt-get install jflex

# Clone este repositório
git clone https://github.com/KleitonEwerton/lang-language-trabalho-compiladores.git

# Acesse a pasta do projeto no terminal/cmd
cd lang-language-trabalho-compiladores

# Execute o JFlex
jflex lang.flex

# Compile
javac TesteAllFiles.java

# Rode o programa
java TesteAllFiles exemplos/semantica/certo

```
## 🎮 Rodando Todos os arquivos .lan de uma pasta na aplicação no Windows

```bash
# Clone este repositório
git clone https://github.com/KleitonEwerton/lang-language-trabalho-compiladores.git

# Acesse a pasta do projeto no terminal/cmd
cd lang-language-trabalho-compiladores

# Execute o JFlex
java -jar jflex-full-1.9.1.jar lang.flex

# Compile
javac TesteAllFiles.java

# Rode o programa, subistitua sample1.txt para o arquivo de preferência
java TesteAllFiles exemplos/semantica/certo
```


