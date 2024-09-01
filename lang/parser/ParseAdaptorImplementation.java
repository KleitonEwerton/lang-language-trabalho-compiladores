/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.parser;

import lang.ast.SuperNode;
import lang.visitors.*;
import lang.ast.Node;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class ParseAdaptorImplementation implements ParseAdaptor {

    @Override
    public SuperNode parseFile(String path) {
        try {

            CharStream stream = CharStreams.fromFileName(path);

            LangLexer lexer = new LangLexer(stream);

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            LangParser parser = new LangParser(tokens);

            lexer.removeErrorListeners();
            lexer.addErrorListener(new BaseErrorListener() {

                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
                        int charPositionInLine, String msg, RecognitionException e) {
                    System.out.println("line " + line + ":" + charPositionInLine + " -- " + msg);
                    throw new RuntimeException(e.getCause());
                }
            });

            ParseTree tree = parser.prog();

            if (parser.getNumberOfSyntaxErrors() != 0) {
                return null;
            }

            MyVisitor ast = new MyVisitor();
            Node node = ast.visit(tree);

            return node;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}