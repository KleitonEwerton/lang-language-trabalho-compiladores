
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

public class STyNull extends SType {

    private static STyNull st = new STyNull();

    private STyNull() {
    }

    public static STyNull newSTyNull() {
        return st;
    }

    @Override
    public boolean match(SType v) {
        return (v instanceof STyErr) || (v instanceof STyNull);
    }

    @Override
    public String toString() {
        return "Null";
    }
}
