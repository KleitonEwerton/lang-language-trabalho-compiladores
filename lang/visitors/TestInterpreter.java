/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.visitors;

import java.io.*;

public class TestInterpreter {
    private InterpreterAdaptor adp;
    private String okSrcs = "testes/sintaxe/certo/";
    private File f;

    public TestInterpreter(InterpreterAdaptor adp) {
        this.adp = adp;
        f = new File(okSrcs);
        runOkTests();
    }

    private String filler(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += " ";
        }
        return s;
    }

    public void runOkTests() {
        File inst[];
        int flips, flops;
        flips = 0;
        flops = 0;
        try {
            if (f.isDirectory()) {
                String pth;
                inst = f.listFiles();
                for (File s : inst) {
                    pth = s.getPath();
                    System.out.print("Testando " + pth + filler(50 - pth.length()) + "[");
                    if (adp.interpretFile(s.getPath()) != null) {
                        System.out.println("  OK  ]");
                        flips++;
                    } else {
                        System.out.println(" FALHOU ]");
                        flops++;
                    }
                }
                System.out.println("Total de acertos: " + flips);
                System.out.println("Total de erros: " + flops);
            } else {
                System.out.println("O caminho " + f.getPath() + " não é um diretório ou não existe.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
