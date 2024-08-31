package lang;

import java.io.*;

import lang.ast.*;
import lang.parser.*;
import lang.visitors.*;

public class LangCompiler {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Lang compiler v 0.0.1 - Agosto de 2024");
            System.out.println("Use java -cp . Lang ação <Caminho para código Fonte> ");
            System.out.println("Ação (uma das seguintes possibilidades): ");
            System.out.println(" -bs : Executa uma bateria de testes sintáticos");
            System.out.println(" -byt : Executa uma bateria de testes no interpretador");
            System.out.println(" -i : Apenas interpretar");
        }

        try {
            ParseAdaptor langParser = new ParserSyntactic();
            InterpreterAdaptor interpreterAdaptor = new InterpreterSyntactic();

            if (args[0].equals("-bs")) {
                System.out.println("Executando bateria de testes sintáticos:");
                TestParser tp = new TestParser(langParser);
                return;
            }

            if (args[0].equals("-byt")) {
                System.out.println("Executando bateria de testes interpretador:");
                TestVisitor tv = new TestVisitor(interpreterAdaptor);
                return;
            }
            if (args.length != 2) {
                System.out.println("Para usar essa opção, especifique um nome de arquivo");
                return;
            }
            SuperNode result = langParser.parseFile(args[1]);

            if (result == null) {
                System.err.println("Aborting due to syntax error(s)");
                System.exit(1);
            } else if (args[0].equals("-i")) {

                InterpretVisitor interpretVisitor = new InterpretVisitor();
                Node nodeResult = (Node) result;
                nodeResult.accept(interpretVisitor);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
