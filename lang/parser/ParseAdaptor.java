/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.parser;

import lang.ast.SuperNode;
public interface ParseAdaptor {
   public abstract SuperNode parseFile(String path);
}
