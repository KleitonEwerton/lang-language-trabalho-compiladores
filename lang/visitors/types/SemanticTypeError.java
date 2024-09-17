
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.visitors.types;

public class SemanticTypeError extends SemanticType {

    private static SemanticTypeError st = new SemanticTypeError();

    private SemanticTypeError() {
    }

    public static SemanticTypeError newSTyErr() {
        return st;
    }

    @Override
    public boolean match(SemanticType v) {
        return true;
    }

    @Override
    public String toString() {
        return "TyError";
    }

}
