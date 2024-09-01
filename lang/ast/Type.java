/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

/*
 * Esta classe representa um tipo.
 */
public abstract class Type extends Node {
    public Type(int line, int column) {
        super(line, column);
    }
}