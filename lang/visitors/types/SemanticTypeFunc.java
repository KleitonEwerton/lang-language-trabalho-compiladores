
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.visitors.types;

public class SemanticTypeFunc extends SemanticType {

    private SemanticType parameterType[]; // Tipos do parametro
    private String nameParams[]; // Nome dos parametros
    private SemanticType returnType[]; // Tipos de retorno

    public SemanticTypeFunc(SemanticType t[], SemanticType retornos[]) {
        parameterType = t;
        returnType = retornos;
    }

    public SemanticTypeFunc(SemanticType t[], SemanticType retornos[], String[] names, String nomeFuncao) {
        parameterType = t;
        returnType = retornos;
        nameParams = names;
    }

    public SemanticType[] getTypes() {
        return parameterType;
    }

    public SemanticType[] getReturnTypes() {
        return returnType;
    }

    public String[] getTypesName() {
        return nameParams;
    }

    public boolean match(SemanticType v) {
        boolean r = false;
        if (v instanceof SemanticTypeFunc) {
            if (((SemanticTypeFunc) v).getTypes().length == parameterType.length) {
                r = true;
                for (int i = 0; i < parameterType.length; i++) {
                    r = r && parameterType[i].match(((SemanticTypeFunc) v).getTypes()[i]);
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
