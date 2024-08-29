package lang.visitors;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
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
        retMode = false;
    }

    @Override
    public void visit(Prog prog) {
        System.out.println("Interpretando Program");
        try {
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
        } catch (Exception e) {
            throw new RuntimeException(" (" + prog.getLine() + ", " + prog.getColumn() + ") " + e.getMessage());
        }

    }

    public void visit(Add add) {

        try {
            add.getLeft().accept(this);

            // if add.getLeft IdLValue -> get value from env
            if (add.getLeft() instanceof IdLValue) {
                IdLValue idLValue = (IdLValue) add.getLeft();
                String varName = idLValue.getId();
                Object varValue = env.peek().get(varName);
                operands.push(varValue);
            }

            Object left = operands.pop();

            add.getRight().accept(this);

            // if add.getRight IdLValue -> get value from env
            if (add.getRight() instanceof IdLValue) {
                IdLValue idLValue = (IdLValue) add.getRight();
                String varName = idLValue.getId();
                Object varValue = env.peek().get(varName);
                operands.push(varValue);
            }

            Object right = operands.pop();

            if (left instanceof Integer && right instanceof Integer) {
                int result = (Integer) left + (Integer) right;

                operands.push(result);

            } else if (left instanceof Float && right instanceof Float) {

                Float result = (Float) left + (Float) right;

                operands.push(result);

            } else {
                throw new RuntimeException("Operação Add com operandos incompatíveis");
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + add.getLine() + ", " + add.getColumn() + ") " + e.getMessage());
        }
    }

    public void visit(Sub sub) {
        try {
            sub.getLeft().accept(this);

            // if sub.getLeft IdLValue -> get value from env
            if (sub.getLeft() instanceof IdLValue) {
                IdLValue idLValue = (IdLValue) sub.getLeft();
                String varName = idLValue.getId();
                Object varValue = env.peek().get(varName);
                operands.push(varValue);
            }

            Object left = operands.pop();

            sub.getRight().accept(this);

            // if sub.getRight IdLValue -> get value from env
            if (sub.getRight() instanceof IdLValue) {
                IdLValue idLValue = (IdLValue) sub.getRight();
                String varName = idLValue.getId();
                Object varValue = env.peek().get(varName);
                operands.push(varValue);
            }

            Object right = operands.pop();

            if (left instanceof Integer && right instanceof Integer) {
                int result = (Integer) left - (Integer) right;
                operands.push(result);

            } else if (left instanceof Float && right instanceof Float) {

                Float result = (Float) left - (Float) right;

                operands.push(result);

            } else {
                throw new RuntimeException("Operação Sub com operandos incompatíveis");
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + sub.getLine() + ", " + sub.getColumn() + ") " + e.getMessage());
        }
    }

    public void visit(Mul mul) {

        try {
            mul.getLeft().accept(this);

            // if mul.getLeft IdLValue -> get value from env
            if (mul.getLeft() instanceof IdLValue) {
                IdLValue idLValue = (IdLValue) mul.getLeft();
                String varName = idLValue.getId();
                Object varValue = env.peek().get(varName);
                operands.push(varValue);
            }

            Object left = operands.pop();

            mul.getRight().accept(this);

            // if mul.getRight IdLValue -> get value from env
            if (mul.getRight() instanceof IdLValue) {
                IdLValue idLValue = (IdLValue) mul.getRight();
                String varName = idLValue.getId();
                Object varValue = env.peek().get(varName);
                operands.push(varValue);
            }

            Object right = operands.pop();

            if (left instanceof Integer && right instanceof Integer) {
                int result = (Integer) left * (Integer) right;
                operands.push(result);

            } else if (left instanceof Float && right instanceof Float) {
                Float result = (Float) left * (Float) right;
                operands.push(result);

            } else {
                throw new RuntimeException(
                        "Operação Mul com operandos incompatíveis: left=" + left + ", right=" + right);
            }

        } catch (Exception e) {
            throw new RuntimeException(" (" + mul.getLine() + ", " + mul.getColumn() + ") " + e.getMessage());
        }
    }

    public void visit(Div div) {
        try {
            div.getLeft().accept(this);

            // if div.getLeft IdLValue -> get value from env
            if (div.getLeft() instanceof IdLValue) {
                IdLValue idLValue = (IdLValue) div.getLeft();
                String varName = idLValue.getId();
                Object varValue = env.peek().get(varName);
                operands.push(varValue);
            }

            Object left = operands.pop();

            div.getRight().accept(this);

            // if div.getRight IdLValue -> get value from env
            if (div.getRight() instanceof IdLValue) {
                IdLValue idLValue = (IdLValue) div.getRight();
                String varName = idLValue.getId();
                Object varValue = env.peek().get(varName);
                operands.push(varValue);
            }

            Object right = operands.pop();

            if (left instanceof Integer && right instanceof Integer) {
                int result = (Integer) left / (Integer) right;
                operands.push(result);
            } else if (left instanceof Float && right instanceof Float) {

                Float result = (Float) left / (Float) right;

                operands.push(result);

            } else {
                throw new RuntimeException("Operação Mul com operandos incompatíveis");
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + div.getLine() + ", " + div.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Param param) {
        System.out.println("Interpreter Param");
        try {
            String paramName = param.toString();
            Object paramValue = env.peek().get(paramName);
            operands.push(paramValue);
        } catch (Exception e) {
            throw new RuntimeException(" (" + param.getLine() + ", " + param.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Cmd cmd) {

        System.out.println("Interpreter Cmd: " + cmd.toString());

        cmd.accept(this);

    }

    @Override
    public void visit(Func func) {

        try {
            for (Cmd cmd : func.getCommands()) {

                System.out.println("Interpreter func: " + cmd.toString());

                cmd.accept(this);

            }
        } catch (Exception e) {

            throw new RuntimeException(" (" + func.getLine() + ", " + func.getColumn() + ") " + e.getMessage());
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
        try {

            System.out.println("Interpreter ArrayType in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + arrayType.getLine() + ", " + arrayType.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(BinOP binOP) {

        try {

            System.out.println("Interpreter BinOP in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + binOP.getLine() + ", " + binOP.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(BlockCmd blockCmd) {
        System.out.println("Interpreter BlockCmd in InterpretVisitor");
        try {
            System.out.println("Interpreter BlockCmd in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + blockCmd.getLine() + ", " + blockCmd.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(CharDexp charDexp) {

        try {
            String value = charDexp.getValue();
            System.out.println("Interpreter CharDexp in InterpretVisitor: " + value);
            operands.push(value);

        } catch (Exception e) {
            throw new RuntimeException(" (" + charDexp.getLine() + ", " + charDexp.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Equals equals) {

        try {
            System.out.println(equals.toString());

            equals.getLeft().accept(this);
            equals.getRight().accept(this);

            Object rightValue = operands.pop();
            Object leftValue = operands.pop();

            if (leftValue.getClass() == rightValue.getClass()) {
                boolean result;

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
        try {
            System.out.println("Interpreter Expr in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + expr.getLine() + ", " + expr.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(False false1) {
        try {
            System.out.println("Interpreter False in InterpretVisitor");
            // Adiciona o valor booleano false à pilha de operandos
            operands.push(false1.toString());
        } catch (Exception e) {
            throw new RuntimeException(" (" + false1.getLine() + ", " + false1.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(FloatDexp floatDexp) {
        try {
            System.out.println("Interpreter FloatDexp in InterpretVisitor");
            float value = floatDexp.getValue();
            operands.push(value);

        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + floatDexp.getLine() + ", " + floatDexp.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(FuncCallCmd funcCallCmd) {
        try {

            System.out.println("Interpreter FuncCallCmd in InterpretVisitor");

        } catch (Exception e) {

        }
    }

    @Override
    public void visit(IdType idType) {
        try {
            System.out.println("Interpreter IdType in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + idType.getLine() + ", " + idType.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(If if1) {

        try {
            System.out.println("Interpreter If in InterpretVisitor");
            if1.getCondition().accept(this);
            Object conditionValue = operands.pop(); // Obtém o valor da pilha de operandos

            // Verifica se o valor da condição é um booleano
            if (!(conditionValue instanceof Boolean)) {
                throw new RuntimeException(
                        " (" + if1.getLine() + ", " + if1.getColumn() + ") Condition must be a boolean expression.");
            }

            boolean condition = (Boolean) conditionValue;

            // Se a condição for verdadeira, visita o comando associado
            if (condition) {
                if1.getCmd().accept(this);
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + if1.getLine() + ", " + if1.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(IfElse ifElse) {
        try {
            System.out.println("Interpreter IfElse in InterpretVisitor");

            // Avalia a condição do if-else
            ifElse.getCondition().accept(this);
            Object conditionValue = operands.pop(); // Obtém o valor da pilha de operandos

            // Verifica se o valor da condição é um booleano
            if (!(conditionValue instanceof Boolean)) {
                throw new RuntimeException(" (" + ifElse.getLine() + ", " + ifElse.getColumn()
                        + ") Condition must be a boolean expression.");
            }

            boolean condition = (Boolean) conditionValue;

            // Se a condição for verdadeira, visita o comando verdadeiro
            if (condition) {
                ifElse.getTrueCmd().accept(this);
            } else {
                // Se a condição for falsa, visita o comando do else
                ifElse.getFalseCmd().accept(this);
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + ifElse.getLine() + ", " + ifElse.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(IntDexp intDexp) {

        try {
            System.out.println("Interpreter IntDexp in InterpretVisitor " + intDexp);
            int value = intDexp.getValue();
            operands.push(value);

        } catch (Exception e) {
            throw new RuntimeException(" (" + intDexp.getLine() + ", " + intDexp.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Iterate iterate) {

        try {

            iterate.getCondition().accept(this);
            Object condition = operands.pop();

            System.out.println("Interpreter Iterate in InterpretVisitor " + condition);

            if ((Integer) condition instanceof Integer) {

                int Interador = (Integer) condition;

                for (int i = 0; i < Interador; i++) {
                    iterate.getCmd().accept(this);
                }

            } else {
                throw new RuntimeException("Iterate condition must be an Integer");
            }

        } catch (Exception e) {
            throw new RuntimeException(" (" + iterate.getLine() + ", " + iterate.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(LessThan lessThan) {
        try {
            System.out.println("Interpreter LessThan in InterpretVisitor");
            lessThan.getLeft().accept(this);
            lessThan.getRight().accept(this);

            Object rightValue = operands.pop();
            Object leftValue = operands.pop();

            if (leftValue.getClass() == rightValue.getClass()) {
                boolean result;

                if (leftValue instanceof Integer) {
                    result = (Integer) leftValue < (Integer) rightValue;
                } else if (leftValue instanceof Float) {
                    result = (Float) leftValue < (Float) rightValue;
                } else if (leftValue instanceof Character) {
                    result = (Character) leftValue < (Character) rightValue;
                } else {
                    throw new RuntimeException("Tipo não suportado para comparação '<': " + leftValue.getClass());
                }

                operands.push(result);

                System.out.println("Interpreter LessThan in InterpretVisitor: Comparison result is " + result);

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
        try {
            System.out.println("Interpreter LValue in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + lValue.getLine() + ", " + lValue.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(LvalueCmd lvalueCmd) {
        try {
            System.out.println("Interpreter LvalueCmd in InterpretVisitor " + lvalueCmd.getExpr());

            // Avalia o lado direito da atribuição (expressão)
            lvalueCmd.getExpr().accept(this);
            Object value = operands.pop();

            // Processa o lado esquerdo da atribuição (lvalue)
            if (lvalueCmd.getLvalue() instanceof IdLValue) {
                IdLValue idLValue = (IdLValue) lvalueCmd.getLvalue();
                String varName = idLValue.getId();

                // Adiciona ou atualiza o valor da variável no ambiente
                setVariableValue(varName, value);
                System.out.println("Atribuição: " + varName + " = " + value);

            } else {
                throw new RuntimeException("Atribuição inválida para lvalue");
            }
        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + lvalueCmd.getLine() + ", " + lvalueCmd.getColumn() + ") " + e.getMessage());
        }
    }

    // Método para definir ou atualizar o valor de uma variável no ambiente
    private void setVariableValue(String varName, Object value) {
        // Adiciona ou atualiza no escopo atual (topo da pilha)
        if (!env.isEmpty()) {
            env.peek().put(varName, value); // Atualiza ou insere a variável no topo do ambiente
        } else {
            throw new RuntimeException("Ambiente vazio, não é possível definir variáveis.");
        }
    }

    @Override
    public void visit(Mod mod) {
        try {
            mod.getLeft().accept(this);

            // if mod.getLeft IdLValue -> get value from env
            if (mod.getLeft() instanceof IdLValue) {
                IdLValue idLValue = (IdLValue) mod.getLeft();
                String varName = idLValue.getId();
                Object varValue = env.peek().get(varName);
                operands.push(varValue);
            }

            Object leftValue = operands.pop();

            mod.getRight().accept(this);

            // if mod.getRight IdLValue -> get value from env
            if (mod.getRight() instanceof IdLValue) {
                IdLValue idLValue = (IdLValue) mod.getRight();
                String varName = idLValue.getId();
                Object varValue = env.peek().get(varName);
                operands.push(varValue);
            }

            Object rightValue = operands.pop();

            if (leftValue.getClass() == rightValue.getClass()) {
                Object result;

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

                operands.push(result);

                System.out.println(
                        "Interpreter Mod in InterpretVisitor: Result of " + leftValue + " % " + rightValue + " is "
                                + result);
            } else {
                throw new RuntimeException("Incompatibilidade de tipos: não é possível calcular o módulo de "
                        + leftValue.getClass() + " com " + rightValue.getClass());
            }
        } catch (Exception e) {
            System.err.println("Erro ao executar Mod: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void visit(NameType nameType) {
        try {
            System.out.println("Interpreter NameType in InterpretVisitor");
        } catch (Exception e) {
            throw new RuntimeException(" (" + nameType.getLine() + ", " + nameType.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Neg neg) {

        try {
            System.out.println("Interpreter Neg in InterpretVisitor");
            neg.getExpr().accept(this);
            Object value = operands.pop();

            if (value instanceof Integer) {
                operands.push((Integer) value * -1);

            } else if (value instanceof Float) {
                operands.push((Float) value * -1);

            } else {
                throw new RuntimeException(
                        "Operador de negação requer um operando Inteiro ou Float. Operando é de tipo inválido: "
                                + value);
            }

        } catch (Exception e) {
            throw new RuntimeException(" (" + neg.getLine() + ", " + neg.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Not not) {

        try {
            System.out.println("Interpreter Not in InterpretVisitor: " + not);
            System.out.println(not.getExpr().toString());
            not.getExpr().accept(this);

            Object value = operands.pop();

            if (!(value instanceof Boolean)) {
                throw new RuntimeException(
                        "Operador de negação requer um operando booleano. Operando é de tipo inválido: "
                                + value);
            }

            operands.push(!(Boolean) value);

        } catch (Exception e) {
            throw new RuntimeException(" (" + not.getLine() + ", " + not.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(NotEquals notEquals) {
        try {
            // Visitar as expressões da esquerda e da direita
            notEquals.getLeft().accept(this); // Empurra o valor da expressão esquerda para a pilha
            notEquals.getRight().accept(this); // Empurra o valor da expressão direita para a pilha

            // Obter os valores das expressões do topo da pilha
            Object rightValue = operands.pop();
            Object leftValue = operands.pop();

            // Verificar se ambos são do mesmo tipo para a operação de desigualdade
            if (leftValue.getClass() == rightValue.getClass()) {
                boolean result;

                // Realizar a comparação de desigualdade com base no tipo de valor
                if (leftValue instanceof Integer) {
                    result = !leftValue.equals(rightValue);
                } else if (leftValue instanceof Float) {
                    result = !leftValue.equals(rightValue);
                } else if (leftValue instanceof Boolean) {
                    result = !leftValue.equals(rightValue);
                } else {
                    throw new RuntimeException("Tipo não suportado para comparação '!=': " + leftValue.getClass());
                }

                // Empurrar o resultado para a pilha
                operands.push(result);

                // Mensagem opcional de depuração
                System.out.println("Visit NotEquals in InterpretVisitor: Result of " + leftValue + " != " + rightValue
                        + " is " + result);
            } else {
                throw new RuntimeException("Incompatibilidade de tipos: não é possível comparar " + leftValue.getClass()
                        + " com " + rightValue.getClass());
            }
        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + notEquals.getLine() + ", " + notEquals.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Null null1) {
        try {
            System.out.println("Interpreter Null in InterpretVisitor");
            // Adiciona o valor null à pilha de operandos
            operands.push(null);
        } catch (Exception e) {
            throw new RuntimeException(" (" + null1.getLine() + ", " + null1.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Paren paren) {

        try {
            System.out.println("Interpreter Paren in InterpretVisitor");
            paren.getExpr().accept(this);
        } catch (Exception e) {
            throw new RuntimeException(" (" + paren.getLine() + ", " + paren.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Print print) {
        try {
            System.out.println("Interpreter Print in InterpretVisitor " + print.getExpression().getClass());
            print.getExpression().accept(this);

            // if print IdLValue -> get value from env

            if (print.getExpression() instanceof IdLValue) {
                IdLValue idLValue = (IdLValue) print.getExpression();
                String varName = idLValue.getId();
                Object varValue = env.peek().get(varName);
                operands.push(varValue);
            }

            Object value = operands.pop();

            System.out.println(value);

        } catch (Exception e) {
            throw new RuntimeException(" (" + print.getLine() + ", " + print.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Read read) {
        try {
            System.out.println("Interpreter Read in InterpretVisitor");
            // Obtém a variável onde o valor será armazenado
            LValue lvalue = read.getLvalue();

            // Solicita ao usuário que insira um valor
            System.out.print("Enter value for " + lvalue + ": ");

            // Lê a entrada do usuário
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            // Acabar

        } catch (Exception e) {
            throw new RuntimeException(" (" + read.getLine() + ", " + read.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Return return1) {

        try {
            System.out.println("Interpreter Return in InterpretVisitor");
            // Obtemos a lista de expressões a serem retornadas
            List<Expr> exprs = return1.getEXExprs();
            // Avalia cada expressão e coloca o resultado na pilha de operandos
            for (Expr expr : exprs) {
                // Avalia a expressão e empurra o resultado na pilha de operandos
                expr.accept(this); // Isso deve chamar o método apropriado para a expressão específica
                System.out.println(expr.toString());
            }
            retMode = true;
        } catch (Exception e) {
            throw new RuntimeException(" (" + return1.getLine() + ", " + return1.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(True true1) {

        try {
            System.out.println("Interpreter True in InterpretVisitor");
            // Adiciona o valor booleano true à pilha de operandos
            operands.push(true1.toString());

        } catch (Exception e) {
            throw new RuntimeException(" (" + true1.getLine() + ", " + true1.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(TyBool tyBool) {

        try {
            System.out.println("Interpreter TyBool in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + tyBool.getLine() + ", " + tyBool.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(TyChar tyChar) {

        try {
            System.out.println("Interpreter TyChar in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + tyChar.getLine() + ", " + tyChar.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(TyFloat tyFloat) {

        try {
            System.out.println("Interpreter TyFloat in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + tyFloat.getLine() + ", " + tyFloat.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(TyInt tyInt) {
        try {
            System.out.println("Interpreter True in InterpretVisitor");
        } catch (Exception e) {
            throw new RuntimeException(" (" + tyInt.getLine() + ", " + tyInt.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Type type) {
        try {
            System.out.println("Interpreter Type in InterpretVisitor");
        } catch (Exception e) {
            throw new RuntimeException(" (" + type.getLine() + ", " + type.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(ArrayLValue arrayLValue) {

        try {
            System.out.println("Interpreter ArrayLValue in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + arrayLValue.getLine() + ", " + arrayLValue.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Data data) {

        try {
            System.out.println("Interpreter Data in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + data.getLine() + ", " + data.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Decl decl) {

        try {
            System.out.println("Interpreter Decl in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + decl.getLine() + ", " + decl.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Dot dot) {

        try {
            System.out.println("Interpreter Dot in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + dot.getLine() + ", " + dot.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Exprs exprs) {

        try {
            System.out.println("Interpreter Exprs in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + exprs.getLine() + ", " + exprs.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(FuncCall funcCall) {

        try {
            System.out.println("Interpreter FuncCall in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + funcCall.getLine() + ", " + funcCall.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(IdLValue idLValue) {
        try {
            // Aqui, ao visitar um IdLValue, não precisamos buscar o valor da variável para
            // atribuição
            // pois a atribuição já lida com a definição ou atualização da variável
            String varName = idLValue.getId();

            // Para outras operações que requerem o valor de `x`, o método
            // `getVariableValue` pode ser usado
            if (debug) {
                System.out.println("Visitando IdLValue: " + varName);
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + idLValue.getLine() + ", " + idLValue.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(NewExp newExp) {

        try {
            System.out.println("Interpreter NewExp in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + newExp.getLine() + ", " + newExp.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(FuncArgs funcArgs) {

        try {
            System.out.println("Interpreter FuncArgs in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + funcArgs.getLine() + ", " + funcArgs.getColumn() + ") " + e.getMessage());
        }
    }

}
