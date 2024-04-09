 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
 
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TesteAllFiles {

    public static void main(String args[]) throws IOException {
        File pasta = new File(args[0]);
        File[] arquivos = pasta.listFiles((dir, nome) -> nome.endsWith(".lan"));

        if (arquivos != null) {
            for (File arquivo : arquivos) {
                Lext lx = new Lext(new FileReader(arquivo));
                Token t = lx.nextToken();
                while (t != null) {
                    System.out.println(t.toString());
                    t = lx.nextToken();
                }
                System.out.println("Total de tokens lidos em " + arquivo.getName() + ": " + lx.readedTokens());
            }
        } else {
            System.out.println("Nenhum arquivo .lan encontrado na pasta especificada.");
        }
    }
}
