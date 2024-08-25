package lang.ast;

import java.util.ArrayList;

/*
 * Esta classe representa um comando de atribuição.
 * ID = Expr
 */
 
import java.util.HashMap;
import java.util.List;

import lang.visitors.*;
/*
 * fun: ID TYPE_OPEN_PARENTHESIS params? TYPE_CLOSE_PARENTHESIS (TYPE_COLON type (TYPE_COMMA type)*)? 
 * TYPE_OPEN_BRACE cmd* TYPE_CLOSE_BRACE #funName
 */

public class Func extends Node {
      
    private String id; // Representa o ID da função
    private List<Param> params; // Representa os parâmetros (opcional)
    private List<Type> additionalTypes; // Representa tipos adicionais após o TYPE_COLON (opcional)
    private List<Cmd> commands; // Representa os comandos dentro da função

    public Func(int line, int col, String id, List<Param> params, Type returnType, List<Type> additionalTypes, List<Cmd> commands) {
        super(line, col);
        this.id = id;
        this.params = params != null ? params : new ArrayList<>(); // Inicializa lista se for nula
        this.additionalTypes = additionalTypes != null ? additionalTypes : new ArrayList<>(); // Inicializa lista se for nula
        this.commands = commands != null ? commands : new ArrayList<>(); // Inicializa lista se for nula
    }

        // Getters e Setters
        public String getId() {
            return id;
        }
    
        public void setId(String id) {
            this.id = id;
        }
    
        public List<Param> getParams() {
            return params;
        }
    
        public void setParams(List<Param> params) {
            this.params = params;
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
    
        @Override
        public void accept(Visitor v) {
            v.visit(this);
        }
}
