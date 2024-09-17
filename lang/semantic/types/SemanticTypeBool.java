
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

public class SemanticTypeBool extends SemanticType {
    private static SemanticTypeBool st = new SemanticTypeBool();

    private SemanticTypeBool() {
    }

    public static SemanticTypeBool newSTyBool() {
        return st;
    }

    public boolean match(SemanticType v) {
        return (v instanceof SemanticTypeError) || (v instanceof SemanticTypeBool);
    }

    public String toString() {
        return "Bool";
    }
}
