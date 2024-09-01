/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.parser;

import lang.ast.SuperNode;
// Adaptador para classe de parser. a Função parseFile deve retornar null caso o parser resulte em erro. 

public interface ParseAdaptor {
   public abstract SuperNode parseFile(String path);
}
