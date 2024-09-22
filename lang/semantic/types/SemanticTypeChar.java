
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

public class SemanticTypeChar extends SemanticType {

    private static SemanticTypeChar st = new SemanticTypeChar();

    private SemanticTypeChar() {
    }

    public static SemanticTypeChar newSTyCharacter() {
        return st;
    }

    public boolean match(SemanticType v) {
        return (v instanceof SemanticTypeError) || (v instanceof SemanticTypeChar);
    }

    public String toString() {
        return "Char";
    }

}
