
package lang.ast;

import java.util.ArrayList;
import java.util.List;
import lang.visitors.Visitor;

public class Func extends Node {

    private String id;
    private Param params;
    private List<Type> returnTypes;
    private List<Cmd> commands;

    public Func(int line, int column, String id, Param params) {
        super(line, column);
        this.id = id;
        this.params = params;
        this.returnTypes = new ArrayList<Type>();
        this.commands = new ArrayList<Cmd>();
    }

    public Func(int line, int column, String id) {
        super(line, column);
        this.id = id;
        this.params = new Param(line, column);
        this.returnTypes = new ArrayList<Type>();
        this.commands = new ArrayList<Cmd>();
    }

    public String getId() {
        return id;
    }

    public Param getParams() {
        return params;
    }

    public List<Type> getReturnTypes() {
        return returnTypes;
    }

    public List<Cmd> getCommands() {
        return commands;
    }

    public void addCommand(Cmd cmd) {
        this.commands.add(cmd);
    }

    public void addReturnTypes(Type returnType) {
        this.returnTypes.add(returnType);
    }

    @Override
    public String toString() {
        String s = id.toString() + "(";
        s += params.toString();
        if (returnTypes.size() > 0) {
            s += ") : ";
            for (int i = 0; i < returnTypes.size() - 1; i++) {
                String typeAux = returnTypes.get(i).toString();
                s += typeAux.toString() + ", ";
            }
            s += returnTypes.get(returnTypes.size() - 1).toString();
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

    public void setCommands(List<Cmd> commands) {
        this.commands = commands;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setParams(Param parameters) {
        this.params = parameters;
    }

    public void setReturnTypes(List<Type> returnTypes) {
        this.returnTypes = returnTypes;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}
