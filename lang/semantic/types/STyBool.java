
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

public class STyBool extends SType {
    
    private static STyBool st = new STyBool();

    private STyBool() {
    }

    public static STyBool newSTyBool() {
        return st;
    }

    public boolean match(SType v) {
        return (v instanceof STyErr) || (v instanceof STyBool);
    }

    public String toString() {
        return "Bool";
    }
}
