package lang.ast;

import lang.ast.Cmd;
import lang.visitors.Visitor;

import java.util.List;
import java.util.ArrayList;

public class CmdsList extends Cmd {
    /**
     * ---- Regra
     * cmd: OPEN_BRACES cmd* CLOSE_BRACES # CommandsList
     */

    private List<Cmd> commands;

    public CmdsList(int line, int column, List<Cmd> commands) {
        super(line, column);
        this.commands = commands;
    }

    public CmdsList(int line, int column) {
        super(line, column);
        this.commands = new ArrayList<Cmd>();
    }

    public List<Cmd> getCommands() {
        return (this.commands);
    }

    public void setCommands(List<Cmd> cmd) {
        this.commands = cmd;
    }

    public void addCommand(Cmd cmd) {
        commands.add(cmd);
    }

    @Override
    public String toString() {
        String text = " { ";
        for (Cmd command : commands) {
            text = text + command.toString();
        }
        text = text + " } ";
        return text;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
