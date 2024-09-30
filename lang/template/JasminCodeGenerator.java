/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.template;

import lang.ast.Node;
import lang.semantic.SemanticVisitor;
import lang.semantic.types.LocalEnv;
import lang.semantic.types.SemanticType;
import lang.semantic.types.SemanticTypeEnv;

import java.io.FileWriter;
import java.io.IOException;

public class JasminCodeGenerator {

    private String fileName;
    private String filePath;
    private SemanticTypeEnv<LocalEnv<SemanticType>> env;
    private Node rootNode;
    private SemanticVisitor semanticVisitor;

    public JasminCodeGenerator(String fileName, String filePath, Node rootNode, SemanticVisitor semanticVisitor) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.rootNode = rootNode;
        this.semanticVisitor = semanticVisitor;

        env = semanticVisitor.getEnv();

    }

    public void generateJasminCode(String[] args) {
        System.out.println("Analisando o Arquivo: \"" + filePath + "\"\n");

        // Executa a análise semântica
        rootNode.accept(semanticVisitor);

        if (semanticVisitor.getNumErrors() != 0) {
            System.out.println("Erros na Análise Semântica");
            semanticVisitor.printErrors();
            System.exit(1);
        }

        System.out.println("Traduzindo o Arquivo: \"" + filePath + " para Jasmin\"\n");

        JasminVisitor jv;

        // Checa os argumentos para gerar o arquivo
        if (args.length > 2) {
            if (args.length == 3) {
                if (args[2].equals("-genFile")) {
                    jv = new JasminVisitor(fileName, env, semanticVisitor.getDatas());
                    rootNode.accept(jv);
                    String generatedFilePath = getPathFile(filePath) + fileName + ".j";
                    System.out.println("Arquivo gerado: \"" + generatedFilePath + "\"\n");
                    writeFile(generatedFilePath, jv.getTemplate());
                } else {
                    System.out.println("Parâmetro '" + args[2] + "' incorreto");
                    System.exit(1);
                }
            } else {
                if (args[2].equals("-genFile")) {
                    jv = new JasminVisitor(fileName, env, semanticVisitor.getDatas());
                    rootNode.accept(jv);
                    String generatedFilePath = getPathFile(args[3]) + fileName + ".j";
                    System.out.println("Arquivo gerado: \"" + generatedFilePath + "\"\n");
                    writeFile(generatedFilePath, jv.getTemplate());
                } else {
                    System.out.println("Parâmetro '" + args[2] + "' incorreto");
                    System.exit(1);
                }
            }
        } else {
            System.out.println("Parâmetro '-genFile' não foi passado");
            System.exit(1);
        }
    }

    private static String getPathFile(String path) {
        return path.substring(0, path.lastIndexOf('/') != -1 ? path.lastIndexOf('/') + 1 : 0);
    }

    private static void writeFile(String pathFile, String content) {
        try {
            FileWriter writer = new FileWriter(pathFile);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro no método 'writeFile()'");
            e.printStackTrace();
        }
    }
}
