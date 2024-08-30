package lang;

import lang.parser.*;
import lang.visitors.*;
import lang.ast.*;

public class LangCompiler {
    public static void main(String[] args) {

        try {
            ParseAdaptor langParser = new ParseAdaptorImplementation();
            InterpreterAdaptorImplementation interpreterImplementation = new InterpreterAdaptorImplementation();

            if (args[0].equals("-bs")) {
                System.out.println("Executando bateria de testes sintáticos:");
                TestParser tp = new TestParser(langParser);
                return;
            }
            if (args[0].equals("-bsm")) {
                System.out.println("\nExecuta uma bateria de testes no interpretador:\n");
                TestVisitor tp = new TestVisitor(interpreterImplementation);
                System.out.println("\nFim da execucao.\n");
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

                InterpretVisitor interpreter = new InterpretVisitor();
                ((Node) result).accept(interpreter);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
