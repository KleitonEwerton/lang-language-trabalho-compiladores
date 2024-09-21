
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.semantic.types;

import java.util.ArrayList;

public class DataAttr {

    private String dataName;
    private ArrayList<String> variableNames;
    private ArrayList<SType> dataTypes;

    public DataAttr(String dataName, ArrayList<String> variableNames, ArrayList<SType> dataTypes) {
        this.dataName = dataName;
        this.variableNames = new ArrayList<>(variableNames);
        this.dataTypes = new ArrayList<>(dataTypes);
    }

    public String getDataName() {
        return this.dataName;
    }

    public ArrayList<String> getVariableNames() {
        return new ArrayList<>(variableNames);
    }

    public ArrayList<SType> getDataTypes() {
        return new ArrayList<>(dataTypes);
    }

    public void appendAttribute(String variableName, SType type) {
        if (variableName != null && type != null) {
            this.variableNames.add(variableName);
            this.dataTypes.add(type);
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("data ");
        output.append(dataName).append(" {\n");
        for (int i = 0; i < variableNames.size(); i++) {
            output.append("\t").append(variableNames.get(i))
                    .append(" :: ").append(dataTypes.get(i).toString())
                    .append(";\n");
        }
        output.append("}");
        return output.toString();
    }

}
