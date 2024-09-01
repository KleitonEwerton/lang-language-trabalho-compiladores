/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.parser;

import java.io.IOException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import lang.ast.*;
import lang.visitors.MyVisitor;

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
        LangLexer lexer = new LangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LangParser parser = new LangParser(tokens);

        // Parsing
        ParseTree tree = parser.prog(); // ou o nome da regra inicial

        return (SuperNode) new MyVisitor().visit(tree);
    }
}
