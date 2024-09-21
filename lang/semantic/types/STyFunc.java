
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

public class STyFunc extends SType {

    private SType parameterType[]; // Tipos do parametro
    private String nameParams[]; // Nome dos parametros
    private SType returnType[]; // Tipos de retorno

    public STyFunc(SType t[], SType retornos[]) {
        parameterType = t;
        returnType = retornos;
    }

    public STyFunc(SType t[], SType retornos[], String[] names, String nomeFuncao) {
        parameterType = t;
        returnType = retornos;
        nameParams = names;
    }

    public SType[] getTypes() {
        return parameterType;
    }

    public SType[] getReturnTypes() {
        return returnType;
    }

    public String[] getTypesName() {
        return nameParams;
    }

    public boolean match(SType v) {
        boolean r = false;
        if (v instanceof STyFunc) {
            if (((STyFunc) v).getTypes().length == parameterType.length) {
                r = true;
                for (int i = 0; i < parameterType.length; i++) {
                    r = r && parameterType[i].match(((STyFunc) v).getTypes()[i]);
                }
            }
        }
        return r;
    }

    @Override
    public String toString() {
        String s = "";
        if (parameterType.length > 0) {
            s = parameterType[0].toString();
            for (int i = 1; i < parameterType.length; i++) {
                s += "->" + parameterType[i].toString();
            }
        }
        return s;
    }
}
