package lang.visitors;

import java.util.HashMap;
import java.util.Stack;

import lang.ast.*;
import lang.visitors.*;

public class InterpretVisitor extends Visitor {

    private Stack<HashMap<String, Object>> env;
    private HashMap<String, Func> funcs;
    private Stack<Object> operands;
    private boolean retMode, debug;

    public InterpretVisitor() {
        env = new Stack<HashMap<String, Object>>();
        env.push(new HashMap<String, Object>());
        funcs = new HashMap<String, Func>();
        operands = new Stack<Object>();
        retMode = false;
        debug = false;
    }

    public void visit(Add add) {
        add.getLeft().accept(this);
        // Guarda o resultado da subárvore esquerda
        Object left = operands.pop();

        // Visita a subárvore direita
        add.getRight().accept(this);
        // Guarda o resultado da subárvore direita
        Object right = operands.pop();

        // Supondo que left e right sejam números (por exemplo, inteiros)
        if (left instanceof Integer && right instanceof Integer) {
            int result = (Integer) left + (Integer) right;
            // Armazena o resultado na pilha de operandos
            operands.push(result);
        } else {
            // Tratamento de erro ou outras operações, se necessário
            throw new RuntimeException("Operação Add com operandos incompatíveis");
        }
    }

    @Override
    public void visit(Param param) {
        // Implementação do método visit para Param
        // Aqui você pode definir o comportamento específico ao visitar um nó de Param
        // Por exemplo, talvez você queira armazenar ou processar o parâmetro
        String paramName = param.toString();
        // Supondo que você tenha uma lógica para trabalhar com parâmetros, pode usar o env
        Object paramValue = env.peek().get(paramName);
        operands.push(paramValue);
    }

    @Override
    public void visit(Cmd cmd) {
        // Implementação do método visit para Cmd
        // Dependendo da lógica de interpretação, você pode definir o comportamento desejado aqui
        // Por exemplo, você pode decidir como tratar comandos genéricos.
        // Este é um ponto de extensão, caso existam subclasses específicas de Cmd.
        // Por enquanto, vamos apenas imprimir ou tratar de forma genérica.
        System.out.println("Visiting Cmd: " + cmd.toString());
    }

    @Override
    public void visit(Func func) {
        // Implementação do método visit para Func
        // Exemplo: Adicionar a função ao mapa de funções
        funcs.put(func.getId(), func);

        // Se necessário, visitar os parâmetros da função
        for (Param param : func.getParams()) {
            param.accept(this);
        }

        // Visitar os comandos dentro da função
        for (Cmd cmd : func.getCommands()) {
            cmd.accept(this);
        }
        
        // Se necessário, processar o tipo de retorno ou outros detalhes
    }
}
