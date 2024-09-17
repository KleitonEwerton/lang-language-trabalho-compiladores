
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.visitors.types;

public class SemanticTypeNull extends SemanticType {
    private static SemanticTypeNull st = new SemanticTypeNull();

    private SemanticTypeNull() {
    }

    public static SemanticTypeNull newSTyNull() {
        return st;
    }

    @Override
    public boolean match(SemanticType v) {
        return (v instanceof SemanticTypeError) || (v instanceof SemanticTypeNull);
    }

    @Override
    public String toString() {
        return "Null";
    }
}
