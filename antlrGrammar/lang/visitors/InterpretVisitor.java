package lang.visitors;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

import lang.ast.*;

public class InterpretVisitor extends Visitor {

    private Stack<HashMap<String, Object>> env;
    private HashMap<String, Func> funcs;
    private HashMap<String, Data> datas;

    private Stack<Object> operands;
    private boolean retMode, debug;
    Node main;

    public InterpretVisitor() {
        env = new Stack<HashMap<String, Object>>();
        env.push(new HashMap<String, Object>());
        funcs = new HashMap<String, Func>();
        datas = new HashMap<String, Data>();
        operands = new Stack<Object>();
        // retMode = false;
        // debug = false;
    }

    @Override
    public void visit(Prog prog) {

        // [ X ] Implementar o método visit para Prog

        for (Node def : prog.getDefs()) {
            if (def instanceof Func) {

                Func func = (Func) def;
                funcs.put(func.getId(), func);

                if (func.getId().equals("main")) {
                    main = def;
                }

            } else if (def instanceof Data) {

                Data data = (Data) def;
                datas.put(data.getName(), data);

            } else {
                throw new RuntimeException("Tipo de definição desconhecido: " + def.getClass().getName());
            }

        }

        if (main != null) {
            main.accept(this);
        } else {
            throw new RuntimeException("Função main não encontrada");
        }

    }

    public void visit(Add add) {

        // [ ] Implementar o método visit para Prog

        System.out.println("Visit Add in InterpretVisitor");

        add.getLeft().accept(this);
        Object left = operands.pop();

        add.getRight().accept(this);
        Object right = operands.pop();

        if (left instanceof Integer && right instanceof Integer) {
            int result = (Integer) left + (Integer) right;

            operands.push(result);

        } else {
            throw new RuntimeException("Operação Add com operandos incompatíveis");
        }
    }

    public void visit(Sub sub) {
        sub.getLeft().accept(this);
        Object left = operands.pop();

        sub.getRight().accept(this);
        Object right = operands.pop();

        if (left instanceof Integer && right instanceof Integer) {
            int result = (Integer) left - (Integer) right;
            operands.push(result);
        } else {
            throw new RuntimeException("Operação Sub com operandos incompatíveis");
        }
    }

    public void visit(Mul mul) {
        mul.getLeft().accept(this);
        Object left = operands.pop();

        System.out.println("Visit Mul in InterpretVisitor");

        mul.getRight().accept(this);
        Object right = operands.pop();

        if (left instanceof Integer && right instanceof Integer) {
            int result = (Integer) left * (Integer) right;
            operands.push(result);
        } else {
            throw new RuntimeException("Operação Mul com operandos incompatíveis");
        }
    }

    public void visit(Div div) {
        div.getLeft().accept(this);
        Object left = operands.pop();

        div.getRight().accept(this);
        Object right = operands.pop();

        if (left instanceof Integer && right instanceof Integer) {
            int result = (Integer) left / (Integer) right;
            operands.push(result);
        } else {
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

        System.out.println("Visiting Cmd: " + cmd.toString());
    }

    @Override
    public void visit(Func func) {

        for (Cmd cmd : func.getCommands()) {

            System.out.println("Visiting func: " + cmd.toString());

            cmd.accept(this);

            // System.out.println("Env: " + env);

        }

    }

    @Override
    public void visit(And and) {
        try {
            // Avaliar a expressão à esquerda do operador &&
            and.getLeft().accept(this);
            Object leftValue = operands.pop();

            // Verifica se o valor à esquerda é um booleano
            if (!(leftValue instanceof Boolean)) {
                throw new RuntimeException(
                        "Erro: Operador && requer operandos booleanos. Operando à esquerda é de tipo inválido: "
                                + leftValue);
            }

            // Avaliar a expressão à direita do operador &&
            and.getRight().accept(this);
            Object rightValue = operands.pop();

            // Verifica se o valor à direita é um booleano
            if (!(rightValue instanceof Boolean)) {
                throw new RuntimeException(
                        "Erro: Operador && requer operandos booleanos. Operando à direita é de tipo inválido: "
                                + rightValue);
            }

            // Resultado final do operador &&
            operands.push((Boolean) leftValue && (Boolean) rightValue);

        } catch (Exception e) {
            throw new RuntimeException(" (" + and.getLine() + ", " + and.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(ArrayType arrayType) {
        System.out.println("Visit ArrayType in InterpretVisitor");
    }

    @Override
    public void visit(BinOP binOP) {

        System.out.println("Visit BinOP in InterpretVisitor");
    }

    @Override
    public void visit(BlockCmd blockCmd) {
        System.out.println("Visit BlockCmd in InterpretVisitor");
    }

    @Override
    public void visit(CharDexp charDexp) {
        System.out.println("Visit CharDexp in InterpretVisitor");
        try {
            // Obter o valor do caractere da instância CharDexp
            String value = charDexp.getValue();

            // Empurrar o valor do caractere para a pilha de operandos
            operands.push(value);
        } catch (Exception e) {
            throw new RuntimeException(" (" + charDexp.getLine() + ", " + charDexp.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Equals equals) {
        System.out.println("Visit Equals in InterpretVisitor");
        System.out.println(equals.toString());
        try {
            // Visitando as expressões da esquerda e da direita
            equals.getLeft().accept(this); // Isso empurra o valor da expressão esquerda para a pilha
            equals.getRight().accept(this); // Isso empurra o valor da expressão direita para a pilha

            // Obter os valores das expressões do topo da pilha
            Object rightValue = operands.pop();
            Object leftValue = operands.pop();

            // Verificar se ambos são do mesmo tipo para comparação
            if (leftValue.getClass() == rightValue.getClass()) {
                boolean result;

                // Comparar com base no tipo de valor
                if (leftValue instanceof Integer) {
                    result = (Integer) leftValue == (Integer) rightValue;
                } else if (leftValue instanceof Float) {
                    result = (Float) leftValue == (Float) rightValue;
                } else if (leftValue instanceof Character) {
                    result = (Character) leftValue == (Character) rightValue;
                } else if (leftValue instanceof Boolean) {
                    result = (Boolean) leftValue == (Boolean) rightValue;
                } else {
                    result = leftValue.equals(rightValue);
                }
                // Empurrar o resultado booleano para a pilha
                operands.push(result);
            } else {
                throw new RuntimeException(
                        "Type mismatch: cannot compare " + leftValue.getClass() + " with " + rightValue.getClass());
            }
        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + equals.getLine() + ", " + equals.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Expr expr) {
        System.out.println("Visit Expr in InterpretVisitor");
    }

    @Override
    public void visit(False false1) {
        System.out.println("Visit False in InterpretVisitor");
    }

    @Override
    public void visit(FloatDexp floatDexp) {
        System.out.println("Visit FloatDexp in InterpretVisitor");
        try {
            // Obter o valor float da instância FloatDexp
            float value = floatDexp.getValue();

            // Empurrar o valor do float para a pilha de operandos
            operands.push(value);
        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + floatDexp.getLine() + ", " + floatDexp.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(FuncCallCmd funcCallCmd) {
        System.out.println("Visit FuncCallCmd in InterpretVisitor");
    }

    @Override
    public void visit(IdType idType) {
        System.out.println("Visit IdType in InterpretVisitor");
    }

    @Override
    public void visit(If if1) {
        System.out.println("Visit If in InterpretVisitor");
    }

    @Override
    public void visit(IfElse ifElse) {
        System.out.println("Visit IfElse in InterpretVisitor");
    }

    @Override
    public void visit(IntDexp intDexp) {

        System.out.println("Visit IntDexp in InterpretVisitor " + intDexp);
        try {
            // Obter o valor float da instância FloatDexp
            int value = intDexp.getValue();

            // Empurrar o valor do float para a pilha de operandos
            operands.push(value);
        } catch (Exception e) {
            throw new RuntimeException(" (" + intDexp.getLine() + ", " + intDexp.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Iterate iterate) {
        System.out.println("Visit Iterate in InterpretVisitor");
    }

    @Override
    public void visit(LessThan lessThan) {
        System.out.println("Visit LessThan in InterpretVisitor");
        try {
            // Visitando as expressões da esquerda e da direita
            lessThan.getLeft().accept(this); // Empurra o valor da expressão esquerda para a pilha
            lessThan.getRight().accept(this); // Empurra o valor da expressão direita para a pilha

            // Obter os valores das expressões do topo da pilha
            Object rightValue = operands.pop();
            Object leftValue = operands.pop();

            // Verificar se ambos são do mesmo tipo para comparação
            if (leftValue.getClass() == rightValue.getClass()) {
                boolean result;

                // Comparar com base no tipo de valor
                if (leftValue instanceof Integer) {
                    result = (Integer) leftValue < (Integer) rightValue;
                } else if (leftValue instanceof Float) {
                    result = (Float) leftValue < (Float) rightValue;
                } else if (leftValue instanceof Character) {
                    result = (Character) leftValue < (Character) rightValue;
                } else {
                    throw new RuntimeException("Tipo não suportado para comparação '<': " + leftValue.getClass());
                }

                // Empurrar o resultado booleano para a pilha
                operands.push(result);

                // Mensagem opcional de depuração
                System.out.println("Visit LessThan in InterpretVisitor: Comparison result is " + result);
            } else {
                throw new RuntimeException("Incompatibilidade de tipos: não é possível comparar " + leftValue.getClass()
                        + " com " + rightValue.getClass());
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + lessThan.getLine() + ", " + lessThan.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(LValue lValue) {
        System.out.println("Visit LValue in InterpretVisitor");
    }

    @Override
    public void visit(LvalueCmd lvalueCmd) {
        System.out.println("Visit LvalueCmd in InterpretVisitor " + lvalueCmd);
        lvalueCmd.getLvalue().accept(this);
        lvalueCmd.getExpr().accept(this);

    }

    @Override
    public void visit(Mod mod) {
        System.out.println("Visit Mod in InterpretVisitor");
        try {
            // Visitar as expressões da esquerda e da direita
            mod.getLeft().accept(this); // Empurra o valor da expressão esquerda para a pilha
            mod.getRight().accept(this); // Empurra o valor da expressão direita para a pilha

            // Obter os valores das expressões do topo da pilha
            Object rightValue = operands.pop();
            Object leftValue = operands.pop();

            // Verificar se ambos são do mesmo tipo para operação de módulo
            if (leftValue.getClass() == rightValue.getClass()) {
                Object result;

                // Realizar a operação de módulo com base no tipo de valor
                if (leftValue instanceof Integer) {
                    if ((Integer) rightValue == 0) {
                        throw new ArithmeticException("Divisão por zero ao calcular módulo.");
                    }
                    result = (Integer) leftValue % (Integer) rightValue;
                } else if (leftValue instanceof Float) {
                    if ((Float) rightValue == 0.0f) {
                        throw new ArithmeticException("Divisão por zero ao calcular módulo.");
                    }
                    result = (Float) leftValue % (Float) rightValue;
                } else {
                    throw new RuntimeException("Tipo não suportado para operação '%': " + leftValue.getClass());
                }

                // Empurrar o resultado para a pilha
                operands.push(result);

                // Mensagem opcional de depuração
                System.out.println(
                        "Visit Mod in InterpretVisitor: Result of " + leftValue + " % " + rightValue + " is " + result);
            } else {
                throw new RuntimeException("Incompatibilidade de tipos: não é possível calcular o módulo de "
                        + leftValue.getClass() + " com " + rightValue.getClass());
            }
        } catch (Exception e) {
            // Tratamento de exceção genérica
            System.err.println("Erro ao executar Mod: " + e.getMessage());
            e.printStackTrace(); // Útil para depuração
        }
    }

    @Override
    public void visit(NameType nameType) {
        System.out.println("Visit NameType in InterpretVisitor");
    }

    @Override
    public void visit(Neg neg) {
        System.out.println("Visit Neg in InterpretVisitor");
    }

    @Override
    public void visit(Not not) {
        System.out.println("Visit Not in InterpretVisitor");
    }

    @Override
    public void visit(NotEquals notEquals) {
        System.out.println("Visit NotEquals in InterpretVisitor");
    }

    @Override
    public void visit(Null null1) {
        System.out.println("Visit Null in InterpretVisitor");
    }

    @Override
    public void visit(Paren paren) {
        System.out.println("Visit Paren in InterpretVisitor");
    }

    @Override
    public void visit(Print print) {
        System.out.println("Visit Print in InterpretVisitor");
        try {
            // Avalia a expressão associada ao comando print
            print.getExpression().accept(this);
            // O resultado da expressão estará no topo da pilha de operandos
            Object value = operands.pop();

            // Imprime o valor avaliado
            System.out.println(value);
        } catch (Exception e) {
            throw new RuntimeException(" (" + print.getLine() + ", " + print.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Read read) {
        System.out.println("Visit Read in InterpretVisitor");
    }

    @Override
    public void visit(Return return1) {
        System.out.println("Visit Return in InterpretVisitor");
    }

    @Override
    public void visit(True true1) {
        System.out.println("Visit True in InterpretVisitor");
    }

    @Override
    public void visit(TyBool tyBool) {
        System.out.println("Visit TyBool in InterpretVisitor");
    }

    @Override
    public void visit(TyChar tyChar) {
        System.out.println("Visit TyChar in InterpretVisitor");
    }

    @Override
    public void visit(TyFloat tyFloat) {
        System.out.println("Visit TyFloat in InterpretVisitor");
    }

    @Override
    public void visit(TyInt tyInt) {
        System.out.println("Visit TyInt in InterpretVisitor");
    }

    @Override
    public void visit(Type type) {
        System.out.println("Visit Type in InterpretVisitor");
    }

    @Override
    public void visit(ArrayLValue arrayLValue) {
        System.out.println("Visit ArrayLValue in InterpretVisitor");
    }

    @Override
    public void visit(Data data) {
        System.out.println("Visit Data in InterpretVisitor");
    }

    @Override
    public void visit(Decl decl) {
        System.out.println("Visit Decl in InterpretVisitor");
    }

    @Override
    public void visit(Dot dot) {
        System.out.println("Visit Dot in InterpretVisitor");
    }

    @Override
    public void visit(Exprs exprs) {
        System.out.println("Visit Exprs in InterpretVisitor");
    }

    @Override
    public void visit(FuncCall funcCall) {
        System.out.println("Visit FuncCall in InterpretVisitor");
    }

    @Override
    public void visit(IdLValue idLValue) {

        System.out.println("Visit IdLValue in InterpretVisitor " + idLValue);

        // salvando o que vai receber o valor
        // operands.push(idLValue);

    }

    @Override
    public void visit(NewExp newExp) {
        System.out.println("Visit NewExp in InterpretVisitor");
    }

    @Override
    public void visit(FuncArgs funcArgs) {
        System.out.println("Visit FuncArgs in InterpretVisitor");
    }

}
