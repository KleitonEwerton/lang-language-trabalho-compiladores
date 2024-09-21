
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

public class LocalEnv<A> extends STyEnv<A> {
    private String id;
    private SType t;

    public LocalEnv(String id, SType t) {
        this.t = t;
        this.id = id;
    }

    public String getFuncID() {
        return id;
    }

    public SType getFuncType() {
        return t;
    }

    @Override
    public String toString() {
        String s = "--------------- (" + id + "," + t.toString() + ") ---------------\n";
        s += super.toString();
        return s;
    }
}
