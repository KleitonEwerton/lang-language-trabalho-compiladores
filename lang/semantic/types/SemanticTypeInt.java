
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

public class SemanticTypeInt extends SemanticType {

    private static SemanticTypeInt st = new SemanticTypeInt();

    private SemanticTypeInt() {
    }

    public static SemanticTypeInt newSTyInt() {
        return st;
    }

    @Override
    public boolean match(SemanticType v) {
        return (v instanceof SemanticTypeError) || (v instanceof SemanticTypeInt);
    }

    @Override
    public String toString() {
        return "Int";
    }

}
