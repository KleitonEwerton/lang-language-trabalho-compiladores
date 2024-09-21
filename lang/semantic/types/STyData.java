
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

public class STyData extends SType {
    private String name;

    @Override
    public boolean match(SType v) {
        return (v instanceof STyErr) || (v instanceof STyData);
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

    public STyData(String name) {
        this.name = name;
    }
}
