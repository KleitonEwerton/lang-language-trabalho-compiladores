import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Lê o arquivo de entrada
        CharStream input = CharStreams.fromFileName("input.txt");

        // Cria o lexer e o stream de tokens
        ExampleLexer lexer = new ExampleLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Cria o parser e analisa a entrada
        ExampleParser parser = new ExampleParser(tokens);
        ParseTree tree = parser.prog(); // Inicia a análise pela regra inicial "prog"

        // Cria um visitante e o usa para visitar a árvore de parse
        MyVisitor visitor = new MyVisitor();
        Integer result = visitor.visit(tree); // Captura o resultado da visita

        // Exibe o resultado
        System.out.println("Resultado: " + result);
    }
}
