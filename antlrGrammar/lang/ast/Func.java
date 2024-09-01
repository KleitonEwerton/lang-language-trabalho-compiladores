/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

import java.util.ArrayList;

/*
 * Esta classe representa um comando de atribuição.
 * ID = Expr
 */

import java.util.List;

import lang.visitors.*;
/*
 * fun: ID TYPE_OPEN_PARENTHESIS params? TYPE_CLOSE_PARENTHESIS (TYPE_COLON type (TYPE_COMMA type)*)? 
 * TYPE_OPEN_BRACE cmd* TYPE_CLOSE_BRACE #funName
 */

public class Func extends Node {

    private String id; // Representa o ID da função
    private Param params; // Representa os parâmetros (opcional)
    private List<Type> additionalTypes; // Representa tipos adicionais após o TYPE_COLON (opcional)
    private List<Cmd> commands; // Representa os comandos dentro da função

    // Função com parâmetros
    public Func(int line, int col, String id, Param param) {
        super(line, col);
        this.id = id;
        this.params = param;
        this.additionalTypes = new ArrayList<Type>(); // Inicializa lista se for nula
        this.commands = new ArrayList<Cmd>(); // Inicializa lista se for nula
    }

    // Função sem parâmetros - main()
    public Func(int line, int col, String id) {
        super(line, col);
        this.id = id;
        this.params = new Param(line, col);
        this.additionalTypes = new ArrayList<Type>();
        this.commands = new ArrayList<Cmd>();
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Type> getAdditionalTypes() {
        return additionalTypes;
    }

    public void setAdditionalTypes(List<Type> additionalTypes) {
        this.additionalTypes = additionalTypes;
    }

    public List<Cmd> getCommands() {
        return commands;
    }

    public void setCommands(List<Cmd> commands) {
        this.commands = commands;
    }

    public Param getParam() {
        return params;
    }

    public void setParam(Param param) {
        this.params = param;
    }

    public void addCmd(Cmd cmd) {
        this.commands.add(cmd);
    }

    public void addTypes(Type type) {
        this.additionalTypes.add(type);
    }

    @Override
    public String toString() {
        return String.format(
                "Func[id=%s, params=%s, additionalTypesSize=%d, commandsSize=%d]",
                id,
                params.toString(),
                additionalTypes.size(),
                commands.size());
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
