package lang.parser;

import java.io.IOException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import lang.ast.SuperNode;

public class ParserSyntactic implements ParseAdaptor {

    @Override
    public SuperNode parseFile(String path) {
        // Leitura da entrada
        CharStream input;
        try {
            input = CharStreams.fromFileName(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Retorna null em caso de erro ao ler o arquivo
        }

        // Criação do lexer e parser
        lang1Lexer lexer = new lang1Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        lang1Parser parser = new lang1Parser(tokens);

        // Parsing
        ParseTree tree = parser.prog(); // ou o nome da regra inicial

        // Visitação
        MyVisitor visitor = new MyVisitor();
        SuperNode result = null;
        visitor.visit(tree);
        System.out.println("Result: " + result);

        return result; // Retorna o resultado da visitação
    }
}
