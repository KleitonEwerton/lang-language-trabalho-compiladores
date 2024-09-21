
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic;

import lang.ast.*;
import lang.parser.*;
import lang.semantic.*;
import lang.visitors.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class SemanticAnalysis implements SemanticAdaptor {

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
        lexer.removeErrorListeners(); // Remove o listener padrão de erros
        lexer.addErrorListener(new CustomErrorListener()); // Adiciona o listener personalizado

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LangParser parser = new LangParser(tokens);
        parser.removeErrorListeners(); // Remove o listener padrão de erros sintáticos
        parser.addErrorListener(new CustomSyntaxErrorListener()); // Adiciona o listener personalizado de erros
                                                                  // sintáticos
        ParseTree tree = parser.prog();

        // verifica se o analisador sintativo encontrou algum erro
        if (parser.getNumberOfSyntaxErrors() != 0) {
            return null;
        }

        MyVisitor myVisitor = new MyVisitor();
        Node node = myVisitor.visit(tree);

        SemanticVisitor semanticVisitor = new SemanticVisitor();

        node.accept(semanticVisitor);

        if (semanticVisitor.getNumErrors() > 0) {
            semanticVisitor.printErrors();
            return null;
        } else {
            // System.out.println("typing check ... [ ok ]");
            return node;
        }
    }

    // Classe para captura de erros léxicos
    class CustomErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                int line, int charPositionInLine,
                String msg, RecognitionException e) {
            throw new RuntimeException("Erro léxico na linha " + line + ":" + charPositionInLine + " - " + msg);
        }
    }

    // Classe para captura de erros sintáticos
    class CustomSyntaxErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                int line, int charPositionInLine,
                String msg, RecognitionException e) {
            throw new RuntimeException("Erro sintático na linha " + line + ":" + charPositionInLine + " - " + msg);
        }
    }
}
