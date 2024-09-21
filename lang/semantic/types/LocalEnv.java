
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

public class LocalEnv<A> extends TyEnv<A> {
    private String funcID;
    private SType funcType;

    public LocalEnv(String funcID, SType funcType) {
        this.funcID = funcID;
        this.funcType = funcType;
    }

    public String getFuncID() {
        return funcID;
    }

    public SType getFuncType() {
        return funcType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Function ID: ").append(funcID).append(", Type: ").append(funcType.toString()).append("\n");
        sb.append(super.toString());
        return sb.toString();
    }
}
