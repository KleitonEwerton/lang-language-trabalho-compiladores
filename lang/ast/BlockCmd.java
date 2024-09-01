 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
package lang.ast;

import lang.ast.Cmd;
import lang.visitors.Visitor;

import java.util.List;
import java.util.ArrayList;

public class BlockCmd extends Cmd {

    private List<Cmd> cmds;

    public BlockCmd(int line, int column, List<Cmd> commands) {
        super(line, column);
        this.cmds = commands;
    }

    public BlockCmd(int line, int column) {
        super(line, column);
        this.cmds = new ArrayList<Cmd>();
    }

    public List<Cmd> getCmds() {
        return (this.cmds);
    }

    public void setCmds(List<Cmd> cmd) {
        this.cmds = cmd;
    }

    public void addCommand(Cmd cmd) {
        cmds.add(cmd);
    }

    @Override
    public String toString() {
        String text = " { ";
        for (Cmd command : cmds) {
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
