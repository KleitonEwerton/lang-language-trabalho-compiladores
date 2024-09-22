
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.semantic;

import java.io.File;

public class TestSemantic {
    private SemanticAdaptor sdp;
    private String okSrcs = "testes/semantica/certo";
    private File f;

    public TestSemantic(SemanticAdaptor sdp) {
        this.sdp = sdp;
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

                    if (sdp.parseFile(s.getPath()) != null) {

                        System.out.println("  OK  ]");

                        flips++;
                    } else {
                        System.out.println("\nTeste " + pth + filler(50 - pth.length()) + " FALHOU ]\n");
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
