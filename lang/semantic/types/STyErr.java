
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

public class STyErr extends SType {

    private static STyErr st = new STyErr();

    private STyErr() {
    }

    public static STyErr newSTyErr() {
        return st;
    }

    @Override
    public boolean match(SType v) {
        return true;
    }

    @Override
    public String toString() {
        return "TyError";
    }

}
