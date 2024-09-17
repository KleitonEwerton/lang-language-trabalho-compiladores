
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

public class SemanticTypeFloat extends SemanticType {
    private static SemanticTypeFloat st = new SemanticTypeFloat();

    private SemanticTypeFloat() {
    }

    public static SemanticTypeFloat newSTyFloat() {
        return st;
    }

    @Override
    public boolean match(SemanticType v) {
        return (v instanceof SemanticTypeError) || (v instanceof SemanticTypeFloat);
    }

    @Override
    public String toString() {
        return "Float";
    }
}
