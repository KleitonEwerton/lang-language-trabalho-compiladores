package antlrGrammar.lang.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import antlrGrammar.lang.ast.SuperNode;

public class ParserSyntactic implements ParseAdaptor {

    @Override
    public SuperNode parseFile(String path) {
        // Leitura da entrada
        CharStream input = CharStreams.fromFileName("input.txt");

        // Criação do lexer e parser
        lang1Lexer lexer = new lang1Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        lang1Parser parser = new lang1Parser(tokens);

        // Parsing
        ParseTree tree = parser.prog(); // ou o nome da regra inicial

        // Visitação
        MyVisitor visitor = new MyVisitor();
        Integer result = visitor.visit(tree);
        System.out.println("Result: " + result);
    }


}
