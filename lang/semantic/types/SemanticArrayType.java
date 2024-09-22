
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

public class SemanticArrayType extends SemanticType {

    private SemanticType a;

    public SemanticArrayType(SemanticType t) {
        a = t;
    }

    public SemanticType getArg() {
        return a;
    }

    @Override
    public boolean match(SemanticType v) {
        return (v instanceof SemanticTypeError)
                || (v instanceof SemanticArrayType) && (a.match(((SemanticArrayType) v).getArg()));
    }

    @Override
    public String toString() {
        return a.toString() + "[]";
    }
}
