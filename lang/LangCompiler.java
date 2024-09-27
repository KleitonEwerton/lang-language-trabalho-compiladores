/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang;

import lang.ast.*;
import lang.parser.*;
import lang.semantic.*;
import lang.semantic.types.LocalEnv;
import lang.semantic.types.SemanticType;
import lang.semantic.types.SemanticTypeEnv;
import lang.template.JavaVisitor;
import lang.visitors.*;

import java.io.*;
import java.util.Scanner;

public class LangCompiler {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Lang compiler v 0.0.1 - Maio de 2020");
            System.out.println("Use java -cp . Lang ação <Caminho para código Fonte> ");
            System.out.println("Ação (uma das seguintes possibilidades): ");

            System.out.println(" -bs : Executa uma bateria de testes sintáticos");
            System.out.println(" -bsm : Executa uma bateria de testes no interpretador");
            System.out.println(" -byt : Executa uma bateria de testes no sistemas de tipos na analise semantica");

            System.out.println(" -pp: Pretty print program.");
            System.out.println(" -tp: Verficar tipos e imprimir o ambiente de tipos");
            System.out.println(" -i : Apenas interpretar");

            System.out.println(" -ti: Verificar tipos e depois interpretar");
            System.out.println(" -dti: Verificar tipos, imprimir o ambiente de tipos e depois interpretar");
            System.out.println(
                    " -gvz: Create a dot file. (Feed it to graphviz dot tool to generate graphical representation of the AST)");

            System.out.println(" -Java : Executa a geraçao de codigo para Java");
        }
        try {
            ParseAdaptor langParser = new ParserSyntactic();
            InterpreterAdaptor interpreterAdaptor = new InterpreterSyntactic();
            SemanticAdaptor semanticAdaptor = new SemanticAnalysis();

            if (args[0].equals("-bs")) {
                System.out.println("Executando bateria de testes sintáticos:");
                TestParser tp = new TestParser(langParser);
                return;
            }

            if (args[0].equals("-bsm")) {
                System.out.println("Executando bateria de testes no interpretador:");
                TestInterpreter tv = new TestInterpreter(interpreterAdaptor);
                return;
            }
            if (args[0].equals("-byt")) {
                System.out.println("Executando bateria de testes no semântico:");
                TestSemantic tp = new TestSemantic(semanticAdaptor);
                return;
            }

            SuperNode result = langParser.parseFile(args[1]);

            if (result == null) {
                System.err.println("Aborting due to syntax error(s)");
                System.exit(1);

            } else if (args[0].equals("-Java")) {

                System.out.println("Analisando o Arquivo: \"" + args[1] + "\"\n");

                SemanticVisitor v = new SemanticVisitor();

                ((Node) result).accept(v);

                if (v.getNumErrors() != 0) {
                    System.out.println(" Erros ocorreram durante a Analise Semantica.\nAbortando");
                    v.printErrors();
                    System.exit(1);
                }

                System.out.println("Traduzindo o Arquivo: \"" + args[1] + " para Java\"\n");

                SemanticTypeEnv<LocalEnv<SemanticType>> env = v.getEnv();

                String nomeArquivo = getFileName(args[1]);

                JavaVisitor jv;

                if (args.length > 2) {
                    if (args.length == 3) {
                        if (args[2].equals("-genFile")) {
                            jv = new JavaVisitor(nomeArquivo, env, v.getDatas());
                            ((Node) result).accept(jv);
                            String caminhoEArquivo = getPathFile(args[1]) + nomeArquivo + ".java";
                            System.out.println("Arquivo de codigo em java gerado: \"" + caminhoEArquivo + "\"\n");
                            writeFile(caminhoEArquivo, jv.getTemplate());
                        } else {
                            System.out.println("Parametro \'" + args[2]
                                    + "\' eh incorreto, o certo eh \'-genFile\' !!!\n");
                            System.exit(1);
                        }
                    } else {
                        if (args[2].equals("-genFile")) {
                            jv = new JavaVisitor(nomeArquivo, env, v.getDatas());
                            ((Node) result).accept(jv);
                            String caminhoEArquivo = getPathFile(args[3]) + nomeArquivo + ".java";
                            System.out.println("Arquivo de codigo em java gerado: \"" + caminhoEArquivo + "\"\n");
                            writeFile(caminhoEArquivo, jv.getTemplate());
                        } else {
                            System.out.println("Parametro \'" + args[2]
                                    + "\' eh incorreto, o certo eh \'-genFile\' !!!\n");
                            System.exit(1);
                        }
                    }

                } else {
                    System.out.println("Parametro \'-genFile\' nao foi passado, o arquivo nao sera gerado !!!\n");
                    System.exit(1);
                }
            }

            else if (args[0].equals("-i")) {
                InterpretVisitor interpretVisitor = new InterpretVisitor();
                Node nodeResult = (Node) result;
                nodeResult.accept(interpretVisitor);
            } else if (args[0].equals("-ii")) {
                // iv = new InteractiveInterpreterVisitor();
                // result.accept(iv);
            } else if (args[0].equals("-tp")) {
                // iv = new TypeChecker();
                // result.accept(iv);
            } else if (args[0].equals("-pp")) {
                // iv = new PPrint();
                // result.accept(iv);
                // ((PPrint)iv).print();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getPathFile(String path) {
        String caminhoArquivo = path.substring(0, path.lastIndexOf('/') != -1 ? path.lastIndexOf('/') + 1 : 0);
        return caminhoArquivo;
    }

    public static String getFileName(String path) {
        String nomeArquivo = path.substring(path.lastIndexOf('/') != -1 ? path.lastIndexOf('/') + 1 : 0,
                path.lastIndexOf('.') != -1 ? path.lastIndexOf('.') : path.length());
        return nomeArquivo;
    }

    public static void writeFile(String pathFile, String information) {
        try {
            FileWriter myWriter = new FileWriter(pathFile);
            myWriter.write(information);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro no metodo \'writeFile()\'");
            e.printStackTrace();
        }
    }
}
