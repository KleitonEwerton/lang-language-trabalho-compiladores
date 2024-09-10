
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic;

import java.util.ArrayList;
import java.util.TreeMap;

public class TyEnv<A> {

    private TreeMap<String, A> typeEnv;
    private ArrayList<A> typeEnvFuncoes;

    public TyEnv() {
        typeEnv = new TreeMap<String, A>();
        typeEnvFuncoes = new ArrayList<A>();
    }

    public void set(String id, A t) {
        typeEnv.put(id, t);
    }

    public A get(String id) {
        return typeEnv.get(id);
    }

    public void add(A t) {
        typeEnvFuncoes.add(t);
    }

    public ArrayList<A> getFuncoes(String id) {
        ArrayList<A> sobrecargaFuncoes = new ArrayList<A>();
        for (int i = 0; i < typeEnvFuncoes.size(); i++) {
            LocalAmbiente funcao = (LocalAmbiente) typeEnvFuncoes.get(i);
            if (funcao.getFuncID().equals(id)) { // Se o nome da função for igual, coloca na lista
                sobrecargaFuncoes.add(typeEnvFuncoes.get(i));
            }
        }
        return sobrecargaFuncoes;
    }

    public void printTable() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String s = "";
        return s;
    }

}
