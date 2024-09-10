
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic;

public class STyCharacter extends SType {

    private static STyCharacter st = new STyCharacter();

    private STyCharacter() {
    }

    public static STyCharacter newSTyCharacter() {
        return st;
    }

    public boolean match(SType v) {
        return (v instanceof STyErr) || (v instanceof STyCharacter);
    }

    public String toString() {
        return "Char";
    }

}
