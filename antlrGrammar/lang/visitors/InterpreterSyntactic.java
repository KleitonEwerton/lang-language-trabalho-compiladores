/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.visitors;

import java.io.IOException;

import lang.ast.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import lang.parser.*;

public class InterpreterSyntactic implements InterpreterAdaptor {

    @Override
    public SuperNode interpretFile(String path) {
        // Leitura da entrada
        CharStream input;
        try {
            input = CharStreams.fromFileName(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Retorna null em caso de erro ao ler o arquivo
        }

        // Criação do lexer e parser
        langLexer lexer = new langLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        langParser parser = new langParser(tokens);

        // Parsing
        ParseTree tree = parser.prog(); // ou o nome da regra inicial

        // Visitação
        MyVisitor visitor = new MyVisitor();
        Node result = visitor.visit(tree);
        InterpretVisitor interpretVisitor = new InterpretVisitor();

        return result; // Retorna o resultado da visitação
    }

}
