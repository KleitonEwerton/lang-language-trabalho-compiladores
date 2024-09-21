
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

public class STyChar extends SType {

    private static STyChar st = new STyChar();

    private STyChar() {
    }

    public static STyChar newSTyCharacter() {
        return st;
    }

    public boolean match(SType v) {
        return (v instanceof STyErr) || (v instanceof STyChar);
    }

    public String toString() {
        return "Char";
    }

}
