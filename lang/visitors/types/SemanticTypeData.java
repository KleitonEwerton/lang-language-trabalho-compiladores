
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.visitors.types;

public class SemanticTypeData extends SemanticType {
    private String name;

    @Override
    public boolean match(SemanticType v) {
        return (v instanceof SemanticTypeError) || (v instanceof SemanticTypeData);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SemanticTypeData(String name) {
        this.name = name;
    }
}
