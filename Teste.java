 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
 
import java.io.FileReader;
import java.io.IOException;

public class Teste {
     public static void main(String args[]) throws IOException {
          Lext lx = new Lext(new FileReader(args[0]));
          Token t = lx.nextToken();
          while (t != null) {
               System.out.println(t.toString());
               t = lx.nextToken();
          }
          System.out.println("Total de tokens lidos " + lx.readedTokens());
     }

}
