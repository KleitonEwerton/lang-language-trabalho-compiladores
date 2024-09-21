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
        LangLexer lexer = new LangLexer(input);
        lexer.removeErrorListeners(); // Remove o listener padrão de erros
        lexer.addErrorListener(new CustomErrorListener()); // Adiciona o listener personalizado

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LangParser parser = new LangParser(tokens);
        parser.removeErrorListeners(); // Remove o listener padrão de erros sintáticos
        parser.addErrorListener(new CustomSyntaxErrorListener()); // Adiciona o listener personalizado de erros
                                                                  // sintáticos

        // Parsing
        ParseTree tree = parser.prog(); // ou o nome da regra inicial

        // verifica se o analisador sintativo encontrou algum erro
        if (parser.getNumberOfSyntaxErrors() != 0) {
            return null;
        }

        // Visitação
        MyVisitor visitor = new MyVisitor();
        Node result = visitor.visit(tree);
        InterpretVisitor interpretVisitor = new InterpretVisitor();

        return result; // Retorna o resultado da visitação
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

    class CustomSyntaxErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                int line, int charPositionInLine,
                String msg, RecognitionException e) {
            throw new RuntimeException("Erro sintático na linha " + line + ":" + charPositionInLine + " - " + msg);
        }
    }

}
