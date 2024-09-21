
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

import java.util.ArrayList;

public class DataAttr {

    private String nomeData;
    private ArrayList<String> nomeVariaveis = new ArrayList<String>();
    private ArrayList<SType> tipos = new ArrayList<SType>();

    public DataAttr(String nomeData, ArrayList<String> nomeVariaveis, ArrayList<SType> tipos) {
        this.nomeData = nomeData;
        this.nomeVariaveis = nomeVariaveis;
        this.tipos = tipos;
    }

    public String getNomeData() {
        return this.nomeData;
    }

    public ArrayList<String> getVariaveis() {
        return this.nomeVariaveis;
    }

    public ArrayList<SType> getTipos() {
        return this.tipos;
    }

    public void addAttribute(String nome, SType tipo) {
        nomeVariaveis.add(nome);
        tipos.add(tipo);
    }

    @Override
    public String toString() {
        String texto = "data ";
        texto += nomeData + " {\n";
        if (this.tipos.size() != 0 && this.nomeVariaveis.size() != 0) {
            for (int i = 0; i < this.tipos.size(); i++) {
                texto += "\t" + this.nomeVariaveis.get(i).toString() + " :: ";
                texto += this.tipos.get(i).toString() + ";\n";
            }
        }
        texto += " } ";
        return texto;
    }

    public void printTable() {
        System.out.println(toString());
    }

}
