
 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
package lang.ast;

import java.util.ArrayList;
import java.util.List;
import lang.visitors.Visitor;

public class Func extends Node {

    private String id;
    private Param params;
    private List<Type> additionalTypes;
    private List<Cmd> commands;

    public Func(int line, int column, String id, Param param) {
        super(line, column);
        this.id = id;
        this.params = param;
        this.additionalTypes = new ArrayList<Type>();
        this.commands = new ArrayList<Cmd>();
    }

    public Func(int line, int column, String id) {
        super(line, column);
        this.id = id;
        this.params = new Param(line, column);
        this.additionalTypes = new ArrayList<Type>();
        this.commands = new ArrayList<Cmd>();
    }

    public String getName() {
        return id;
    }

    public Param getParams() {
        return params;
    }

    public List<Type> getAdditionalTypes() {
        return additionalTypes;
    }

    public List<Cmd> getCmds() {
        return commands;
    }

    public void addCommand(Cmd cmd) {
        this.commands.add(cmd);
    }

    public void addReturnTypes(Type returnType) {
        this.additionalTypes.add(returnType);
    }

    @Override
    public String toString() {
        String s = id.toString() + "(";
        s += params.toString();
        if (additionalTypes.size() > 0) {
            s += ") : ";
            for (int i = 0; i < additionalTypes.size() - 1; i++) {
                String typeAux = additionalTypes.get(i).toString();
                s += typeAux.toString() + ", ";
            }
            s += additionalTypes.get(additionalTypes.size() - 1).toString();
        } else {
            s += ")";
        }
        s += "{\n";
        for (Cmd command : commands) {
            s += command.toString() + "\n";
        }
        s += " } ";
        return s;
    }

    public void setCmds(List<Cmd> commands) {
        this.commands = commands;
    }

    public void setFuncName(String id) {
        this.id = id;
    }

    public void setParams(Param parameters) {
        this.params = parameters;
    }

    public void setAdditionalTypes(List<Type> returnTypes) {
        this.additionalTypes = returnTypes;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
