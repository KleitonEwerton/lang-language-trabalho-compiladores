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

        System.out.println("Aqui - Add");

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

    public void visit(Sub sub) {
        sub.getLeft().accept(this);
        // Guarda o resultado da subárvore esquerda
        Object left = operands.pop();

        // Visita a subárvore direita
        sub.getRight().accept(this);
        // Guarda o resultado da subárvore direita
        Object right = operands.pop();

        // Supondo que left e right sejam números (por exemplo, inteiros)
        if (left instanceof Integer && right instanceof Integer) {
            int result = (Integer) left - (Integer) right;
            // Armazena o resultado na pilha de operandos
            operands.push(result);
        } else {
            // Tratamento de erro ou outras operações, se necessário
            throw new RuntimeException("Operação Sub com operandos incompatíveis");
        }
    }

    public void visit(Mul mul) {
        mul.getLeft().accept(this);
        // Guarda o resultado da subárvore esquerda
        Object left = operands.pop();

        // Visita a subárvore direita
        mul.getRight().accept(this);
        // Guarda o resultado da subárvore direita
        Object right = operands.pop();

        // Supondo que left e right sejam números (por exemplo, inteiros)
        if (left instanceof Integer && right instanceof Integer) {
            int result = (Integer) left * (Integer) right;
            // Armazena o resultado na pilha de operandos
            operands.push(result);
        } else {
            // Tratamento de erro ou outras operações, se necessário
            throw new RuntimeException("Operação Mul com operandos incompatíveis");
        }
    }

    public void visit(Div div) {
        div.getLeft().accept(this);
        // Guarda o resultado da subárvore esquerda
        Object left = operands.pop();

        // Visita a subárvore direita
        div.getRight().accept(this);
        // Guarda o resultado da subárvore direita
        Object right = operands.pop();

        // Supondo que left e right sejam números (por exemplo, inteiros)
        if (left instanceof Integer && right instanceof Integer) {
            int result = (Integer) left / (Integer) right;
            // Armazena o resultado na pilha de operandos
            operands.push(result);
        } else {
            // Tratamento de erro ou outras operações, se necessário
            throw new RuntimeException("Operação Mul com operandos incompatíveis");
        }
    }

    @Override
    public void visit(Param param) {
        // Implementação do método visit para Param
        // Aqui você pode definir o comportamento específico ao visitar um nó de Param
        // Por exemplo, talvez você queira armazenar ou processar o parâmetro
        String paramName = param.toString();
        // Supondo que você tenha uma lógica para trabalhar com parâmetros, pode usar o
        // env
        Object paramValue = env.peek().get(paramName);
        operands.push(paramValue);
    }

    @Override
    public void visit(Cmd cmd) {
        // Implementação do método visit para Cmd
        // Dependendo da lógica de interpretação, você pode definir o comportamento
        // desejado aqui
        // Por exemplo, você pode decidir como tratar comandos genéricos.
        // Este é um ponto de extensão, caso existam subclasses específicas de Cmd.
        // Por enquanto, vamos apenas imprimir ou tratar de forma genérica.
        System.out.println("Visiting Cmd: " + cmd.toString());
    }

    @Override
    public void visit(Func func) {
        System.out.println("Aqui - Fun");
        // Implementação do método visit para Func
        // Exemplo: Adicionar a função ao mapa de funções
        funcs.put(func.getId(), func);

        // Aqui você pode definir o comportamento específico ao visitar um nó de Func
    }

    @Override
    public void visit(And and) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(ArrayType arrayType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(BinOP binOP) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(BlockCmd blockCmd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(CharDexp charDexp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Equals equals) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Expr expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(False false1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(FloatDexp floatDexp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(FuncCallCmd funcCallCmd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(IdType idType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(If if1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(IfElse ifElse) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(IntDexp intDexp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Iterate iterate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(LessThan lessThan) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(LValue lValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(LvalueCmd lvalueCmd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Mod mod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(NameType nameType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Neg neg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Not not) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(NotEquals notEquals) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Null null1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Paren paren) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Print print) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Read read) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Return return1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(True true1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(TyBool tyBool) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(TyChar tyChar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(TyFloat tyFloat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(TyInt tyInt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Type type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

}
