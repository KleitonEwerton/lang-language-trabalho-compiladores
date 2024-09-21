
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

import java.util.*;

public class TyEnv<A> {

    private HashMap<String, A> envTypes;
    private ArrayList<A> funcTypeList;

    public TyEnv() {
        envTypes = new HashMap<>();
        funcTypeList = new ArrayList<>();
    }

    public void set(String id, A type) {
        envTypes.put(id, type);
    }

    public A get(String id) {
        return envTypes.get(id);
    }

    public void add(A type) {
        funcTypeList.add(type);
    }

    public ArrayList<A> findFunctions(String id) {
        ArrayList<A> matchingFunctions = new ArrayList<A>();
        for (A func : funcTypeList) {
            if (((LocalEnv) func).getFuncID().equals(id)) {
                matchingFunctions.add(func);
            }
        }
        return matchingFunctions;
    }
}
