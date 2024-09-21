
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

import java.util.Arrays;

public class STyFunc extends SType {

    private SType[] paramTypes;
    private SType[] retTypes;
    private String[] paramNames;

    public STyFunc(SType[] paramTypes, SType[] retTypes) {
        this.paramTypes = paramTypes;
        this.retTypes = retTypes;
    }

    public STyFunc(SType[] paramTypes, SType[] retTypes, String[] paramNames) {
        this(paramTypes, retTypes); // Chama o outro construtor
        this.paramNames = paramNames;
    }

    public SType[] getParamTypes() {
        return paramTypes;
    }

    public SType[] getReturnTypes() {
        return retTypes;
    }

    public String[] getParamNames() {
        return paramNames;
    }

    public boolean match(SType v) {
        if (v instanceof STyFunc) {
            STyFunc otherFunc = (STyFunc) v;
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
