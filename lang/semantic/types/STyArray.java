
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

public class STyArray extends SType {

    private SType a;

    public STyArray(SType t) {
        a = t;
    }

    public SType getArg() {
        return a;
    }

    @Override
    public boolean match(SType v) {
        return (v instanceof STyErr)
                || (v instanceof STyArray) && (a.match(((STyArray) v).getArg()));
    }

    @Override
    public String toString() {
        return a.toString() + "[]";
    }
}
