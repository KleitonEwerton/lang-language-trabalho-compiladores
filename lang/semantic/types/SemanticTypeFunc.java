/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

public class SemanticTypeFunc extends SemanticType {

    private SemanticType[] paramTypes;
    private SemanticType[] retTypes;
    private String[] paramNames;

    public SemanticTypeFunc(SemanticType[] paramTypes, SemanticType[] retTypes) {
        this.paramTypes = paramTypes;
        this.retTypes = retTypes;
    }

    public SemanticTypeFunc(SemanticType[] paramTypes, SemanticType[] retTypes, String[] paramNames) {
        this(paramTypes, retTypes); // Chama o outro construtor
        this.paramNames = paramNames;
    }

    public SemanticType[] getParamTypes() {
        return paramTypes;
    }

    public SemanticType[] getReturnTypes() {
        return retTypes;
    }

    public String[] getParamNames() {
        return paramNames;
    }

    public boolean match(SemanticType v) {
        if (v instanceof SemanticTypeFunc) {
            SemanticTypeFunc otherFunc = (SemanticTypeFunc) v;
            if (otherFunc.getParamTypes().length == paramTypes.length) {
                for (int i = 0; i < paramTypes.length; i++) {
                    if (!paramTypes[i].match(otherFunc.getParamTypes()[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (paramTypes.length > 0) {
            sb.append(paramTypes[0].toString());
            for (int i = 1; i < paramTypes.length; i++) {
                sb.append(" -> ").append(paramTypes[i].toString());
            }
        }
        return sb.toString();
    }

}
