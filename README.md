<h1 align="center">Linguagem Lang</h1>

<p align="center">Trabalho desenvolvido em Java durante a disciplina de Teoria dos Compiladores, ministrada pelo professor Leonardo Vieira dos Santos Reis</p>

## 🎮 Rodando aplicação no Linux para um único arquivo .lan

```bash
# Acesse a pasta do projeto no terminal/cmd
cd lang-language-trabalho-compiladores

# Execute o Script
bash Linux.sh

```
## 🎮 Rodando aplicação no Windows para um único arquivo .lan

```bash
# Acesse a pasta do projeto no terminal/cmd
cd lang-language-trabalho-compiladores

# Execute o Script
Windows.bat
```

## 🎮 Rodando aplicação no Linux para múltiplos arquivos .lan

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

# Rode o programa, subistitua 'exemplos/semantica/certo' para o caminho de preferência contendo os arquvios .lan
java TesteAllFiles exemplos/semantica/certo

```
## 🎮 Rodando aplicação no Windowns para múltiplos arquivos .lan

```bash
# Clone este repositório
git clone https://github.com/KleitonEwerton/lang-language-trabalho-compiladores.git

# Acesse a pasta do projeto no terminal/cmd
cd lang-language-trabalho-compiladores

# Execute o JFlex
java -jar jflex-full-1.9.1.jar lang.flex

# Compile
javac TesteAllFiles.java

# Rode o programa, subistitua 'exemplos/semantica/certo' para o caminho de preferência contendo os arquvios .lan
java TesteAllFiles exemplos/semantica/certo
```

## 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:


- [Git](https://git-scm.com/)
- [JFlex](https://jflex.de/)
- [Java](https://www.java.com/pt-BR/)

## 👨‍💻 Autores
- Kleiton Ewerton de Oliveira - [GitHub](https://github.com/KleitonEwerton)
- Nikolas


## 📞 Contatos
- kleitonewertonoliveira@gmail.com  
- nikolasgenesio@gmail.com

