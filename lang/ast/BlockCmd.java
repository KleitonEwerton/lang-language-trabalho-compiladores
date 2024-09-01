/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

import java.util.ArrayList;
import java.util.List;
import lang.visitors.*;

/*
 * Esta classe representa um bloco de comandos, que contém zero ou mais comandos.
 */

public class BlockCmd extends Cmd {

    private List<Cmd> cmds;

    public BlockCmd(int line, int column) {
        super(line, column);
        this.cmds = new ArrayList<Cmd>();
    }

    public BlockCmd(int line, int column, List<Cmd> cmds) {
        super(line, column);
        this.cmds = cmds;
    }

    public List<Cmd> getCmds() {
        return cmds;
    }

    public void addCmd(Cmd cmd) {
        cmds.add(cmd);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (Cmd cmd : cmds) {
            sb.append(cmd.toString()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}