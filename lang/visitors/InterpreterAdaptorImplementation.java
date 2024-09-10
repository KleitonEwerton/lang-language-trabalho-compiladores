/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.visitors;

import lang.ast.SuperNode;
import lang.ast.Node;
import lang.parser.*;
import lang.visitors.InterpreterAdaptor;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class InterpreterAdaptorImplementation implements InterpreterAdaptor {

    @Override
    public SuperNode interpretFile(String path) {
        try {

            CharStream stream = CharStreams.fromFileName(path);
            LangLexer lexer = new LangLexer(stream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LangParser parser = new LangParser(tokens);

            ParseTree tree = parser.prog();

            MyVisitor ast = new MyVisitor();
            Node node = ast.visit(tree);

            InterpretVisitor interpreter = new InterpretVisitor();

            node.accept(interpreter);

            return node;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}