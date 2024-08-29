package lang.visitors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import lang.ast.*;

public class InterpretVisitor extends Visitor {

    private Stack<HashMap<String, Object>> env; // escopo
    private HashMap<String, Func> funcs; // funções
    private HashMap<String, Data> datas; // tipo data
    private Map<String, Object> context; // contexto
    private Stack<Object> params; // parametros de funções
    private Stack<Object> operands; // operandos
    private boolean retMode, debug;
    Node main;

    public InterpretVisitor() {
        env = new Stack<HashMap<String, Object>>();

        env.push(new HashMap<String, Object>());
        funcs = new HashMap<String, Func>();
        datas = new HashMap<String, Data>();
        context = new HashMap<String, Object>();
        operands = new Stack<Object>();
        params = new Stack<Object>();
        retMode = false;
        debug = true;
    }

    // Método de depuração para imprimir o estado de todas as variáveis
    public void debugPrint() {
        System.out.println("=== Debug Information ===");

        System.out.println("Environment Stack (env):");
        for (int i = 0; i < env.size(); i++) {
            System.out.println("  Level " + i + ": " + env.get(i));
        }

        System.out.println("\nFunctions (funcs):");
        for (Map.Entry<String, Func> entry : funcs.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nData Types (datas):");
        for (Map.Entry<String, Data> entry : datas.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue().toString());
        }

        System.out.println("\nParameters Stack (params):");
        System.out.println(params);

        System.out.println("\nOperands Stack (operands):");
        System.out.println(operands);

        System.out.println("\nReturn Mode (retMode): " + retMode);
        System.out.println("Debug Mode (debug): " + debug);

        System.out.println("=========================");
    }

    // Método genérico para imprimir qualquer HashMap
    private <K, V> void printHashMap(HashMap<K, V> map) {
        System.out.println("HashMap");
       

        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
        System.out.println("=========================");
    }

    @Override
    public void visit(Prog prog) {
        System.out.println("Interpretando Program");
        try {
            for (Node def : prog.getDefs()) {
                if (def instanceof Func) {

                    Func func = (Func) def;
                    funcs.put(func.getId(), func);
                    printHashMap(funcs);
                    if (func.getId().equals("main")) {
                        main = def;
                    }

                } else if (def instanceof Data) {
                    def.accept(this); // Visita o nó Data para armazená-lo
                    // Data data = (Data) def;
                    // datas.put(data.getName(), data);

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
            // [ x ] Implementar o método visit para Prog

            System.out.println("Interpreter Add in InterpretVisitor: " + add.toString());

            add.getLeft().accept(this);
            Object left = operands.pop();

            add.getRight().accept(this);
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
            Object left = operands.pop();

            sub.getRight().accept(this);
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
            Object left = operands.pop();

            System.out.println("Interpreter Mul in InterpretVisitor");

            mul.getRight().accept(this);
            Object right = operands.pop();

            if (left instanceof Integer && right instanceof Integer) {
                int result = (Integer) left * (Integer) right;
                operands.push(result);
            } else if (left instanceof Float && right instanceof Float) {

                Float result = (Float) left * (Float) right;

                operands.push(result);

            } else {
                throw new RuntimeException("Operação Mul com operandos incompatíveis");
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + mul.getLine() + ", " + mul.getColumn() + ") " + e.getMessage());
        }
    }

    public void visit(Div div) {
        try {
            div.getLeft().accept(this);
            Object left = operands.pop();

            div.getRight().accept(this);
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
        System.out.println("Interpreter Param: " + param.toString());
        try {
            // Obtém a lista de tipos dos parâmetros
            List<Type> types = param.getType();

            // Itera sobre cada tipo de parâmetro
            for (Type type : types) {
                // Aceita o tipo do parâmetro para processar seu valor
                type.accept(this);
            }

            System.out.println("Interpreter Param: " + param.toString());
            printOperands();

        } catch (Exception e) {
            throw new RuntimeException(" (" + param.getLine() + ", " + param.getColumn() + ") " + e.getMessage());
        }

    }

    public void printOperands() {
        System.out.println("Pilha de Operand:");
        Stack<Object> tempStack = new Stack<>();

        // Copia os elementos da pilha para uma pilha temporária para não alterar a
        // pilha original
        while (!operands.isEmpty()) {
            Object operand = operands.pop();
            tempStack.push(operand);
            System.out.println(operand);
        }

        // Restaura a pilha original
        while (!tempStack.isEmpty()) {
            operands.push(tempStack.pop());
        }

        System.out.println("================================");
    }

    @Override
    public void visit(Cmd cmd) {

        System.out.println("Interpreter Cmd: " + cmd.toString());
    }

    @Override
    public void visit(Func func) {
        System.out.println("Interpreter Func: " + func.toString());

        // Crie um novo ambiente para a função e empurre para a pilha
        HashMap<String, Object> funcEnv = new HashMap<>();

        // Adicionar parâmetros ao ambiente da função
        Param params = func.getParam();
        List<String> paramIds = func.getParam().getId();
        List<Type> paramTypes = func.getParam().getType();
        // Adiciona os parâmetros ao ambiente
        if (params != null) {
            params.accept(this);

            for (int i = 0; i < params.getId().size(); i++) {
                System.out.println("Dentro do for do params");
                String paramId = paramIds.get(i);
                Type paramType = paramTypes.get(i);
                System.out.println(paramId + ": " + paramType);
                printOperands();
                funcEnv.put(paramId, operands.pop());
            }
        }

        env.push(funcEnv);
        // Executa todos os comandos da função
        for (Cmd cmd : func.getCommands()) {
            cmd.accept(this); // Interpretar cada comando dentro da função
        }

        // Após a execução dos comandos, remova o ambiente da função da pilha
        env.pop();
        System.out.println("Aqui");
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
            boolean ehParametro = false;
            if (params.size() != 0) {
                operands.push(params.pop());
                ehParametro = true;
            }
            if (ehParametro == false) {
                operands.push(arrayType);
            }
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
            System.out.println("Interpreter LvalueCmd in InterpretVisitor " + lvalueCmd);
            // Passo 1: Visitar a expressão e avaliar o valor
            lvalueCmd.getExpr().accept(this);
            Object exprValue = operands.pop();

            System.out.println("ERRO - AQUI");
            // Passo 2: Visitar o LValue para determinar o
            lvalueCmd.getLvalue().accept(this);
            Object lvalueIdentifier = operands.pop();

            if (lvalueIdentifier instanceof Decl) {
                // Se o identificador é uma declaração, obtemos o nome do id
                Decl decl = (Decl) lvalueIdentifier;
                String id = decl.getId();

                // Passo 3: Atualizar o ambiente com o novo valor
                // Procure no ambiente atual e atualize o valor da variável
                boolean updated = false;
                for (int i = env.size() - 1; i >= 0; i--) {
                    HashMap<String, Object> currentEnv = env.get(i);
                    if (currentEnv.containsKey(id)) {
                        currentEnv.put(id, exprValue);
                        updated = true;
                        break;
                    }
                }

                // Se o identificador não foi encontrado no ambiente atual, adiciona-o
                if (!updated) {
                    env.peek().put(id, exprValue);
                    System.out.println("Valor: " + exprValue);
                }

                // Debugging
                System.out.println("Variável '" + id + "' atualizada com valor: " + exprValue);
            } else {
                throw new RuntimeException("LValue não resolvido para atribuição: " + lvalueIdentifier);
            }
        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + lvalueCmd.getLine() + ", " + lvalueCmd.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Mod mod) {
        try {
            System.out.println("Interpreter Mod in InterpretVisitor");
            mod.getLeft().accept(this);
            mod.getRight().accept(this);

            Object rightValue = operands.pop();
            Object leftValue = operands.pop();

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
            System.out.println("Interpreter NameType in InterpretVisitor: " + nameType.toString());
            boolean parametros = false;
            if (!params.isEmpty()) {
                operands.push(params.pop()); // Empilha o tipo que está no topo
                parametros = true;
            }

            if (parametros == false) {
                System.out.println("parametros == false");
                operands.push(nameType);
            }

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
            System.out.println("Interpreter Print in InterpretVisitor");
            print.getExpression().accept(this);
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
            // Imprime a expressão de retorno para depuração
            System.out.println("Interpreter Return in InterpretVisitor: " + return1);

            // Cria uma lista para armazenar os valores de retorno
            List<Object> returnValues = new ArrayList<>();

            // Itera sobre as expressões de retorno
            for (Expr expr : return1.getEXExprs()) {
                // Avalia a expressão e adiciona o resultado à lista de valores de retorno
                expr.accept(this); // Avalia a expressão
                Object result = operands.pop(); // Pega o resultado da pilha de operandos

                // Verifica se o resultado é do tipo esperado
                if (result == null) {
                    throw new RuntimeException("Resultado da expressão é null.");
                }
                returnValues.add(result);
            }

            // Adiciona os valores de retorno à pilha de operandos
            // O primeiro valor a ser retornado é o último na lista
            for (int i = returnValues.size() - 1; i >= 0; i--) {
                operands.push(returnValues.get(i));
            }
            System.out.println("Retorno");
            printOperands();
            // Marca que a função retornou
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

            boolean parametros = false;
            if (!params.isEmpty()) {
                operands.push(params.pop()); // Empilha o tipo que está no topo
                parametros = true;
            }

            if (parametros == false) {
                operands.push(tyBool);
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + tyBool.getLine() + ", " + tyBool.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(TyChar tyChar) {

        try {
            System.out.println("Interpreter TyChar in InterpretVisitor");
            boolean parametros = false;
            if (!params.isEmpty()) {
                operands.push(params.pop()); // Empilha o tipo que está no topo
                parametros = true;
            }

            if (parametros == false) {
                operands.push(tyChar);
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + tyChar.getLine() + ", " + tyChar.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(TyFloat tyFloat) {

        try {
            System.out.println("Interpreter TyFloat in InterpretVisitor");
            boolean parametros = false;
            if (!params.isEmpty()) {
                operands.push(params.pop()); // Empilha o tipo que está no topo
                parametros = true;
            }

            if (parametros == false) {
                operands.push(tyFloat);
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + tyFloat.getLine() + ", " + tyFloat.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(TyInt tyInt) {
        try {
            System.out.println("Interpreter True in InterpretVisitor");
            boolean parametros = false;
            if (!params.isEmpty()) {
                operands.push(params.pop()); // Empilha o tipo que está no topo
                parametros = true;
            }

            if (parametros == false) {
                operands.push(tyInt);
            }
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
            // Armazena a definição de tipo de dado no mapa 'datas'
            datas.put(data.getName(), data);
            if (debug) {
                System.out.println("Tipo de dado '" + data.getName() + "' registrado com os seguintes campos:");
                for (Decl decl : data.getDecls()) {
                    System.out.println(" - " + decl);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + data.getLine() + ", " + data.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Decl decl) {

        try {
            System.out.println("Interpreter Decl in InterpretVisitor");
            // Obter o nome e tipo do identificador
            String id = decl.getId();
            Type type = decl.getType();

            // Inicializa a variável no ambiente de execução, conforme necessário
            // Dependendo da sua implementação, isso pode significar apenas definir um valor
            // padrão
            Object initialValue = null; // Defina um valor inicial padrão, se necessário

            if (!env.isEmpty()) {
                env.peek().put(id, initialValue); // Adiciona ao ambiente atual
            }

            if (debug) {
                System.out.println("Declaração: " + id + " :: " + type.toString() + " adicionada ao ambiente.");
            }

        } catch (Exception e) {
            throw new RuntimeException(" (" + decl.getLine() + ", " + decl.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Dot dot) {
        try {
            System.out.println("Interpreter Dot in InterpretVisitor");

            // Passo 1: Visite a expressão base
            dot.getlValue().accept(this);

            // Passo 2: Recuperar o valor base da pilha
            Object baseValue = operands.pop();

            // Passo 3: Obter o nome do atributo
            String attributeName = dot.getName();

            // Passo 4: Acessar o valor do atributo no valor base
            Object attributeValue = null;

            if (baseValue instanceof HashMap) {
                // Se o valor base é um HashMap, acessa o atributo diretamente
                attributeValue = ((HashMap<String, Object>) baseValue).get(attributeName);
            } else if (baseValue instanceof Data) {
                // Se o valor base é um tipo de dado, deve ser acessado com base no nome do
                // campo
                Data dataType = (Data) baseValue;
                for (Decl decl : dataType.getDecls()) {
                    if (decl.getId().equals(attributeName)) {
                        // Se a declaração corresponde ao nome do atributo
                        attributeValue = decl; // Retorna a declaração, já que o valor não está na Decl
                        break;
                    }
                }
            } else if (baseValue instanceof NameType) {
                // Se baseValue é um NameType, procure no mapa de datas para encontrar o tipo
                // real
                NameType nameType = (NameType) baseValue;
                Data dataType = datas.get(nameType.getName());
                if (dataType != null) {
                    for (Decl decl : dataType.getDecls()) {
                        if (decl.getId().equals(attributeName)) {
                            attributeValue = decl;
                            break;
                        }
                    }
                }
            } else {
                throw new RuntimeException(
                        "Tipo não suportado para acesso de atributos: " + baseValue.getClass().getName());
            }

            // Passo 5: Empurrar o valor do atributo para a pilha de operandos
            operands.push(attributeValue);

            // Debugging
            System.out.println("Valor do atributo '" + attributeName + "': " + attributeValue);
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
            System.out.println("Interpreter FuncCall in InterpretVisitor: " + funcCall);

            String funcName = funcCall.getFuncName();
            List<Expr> arguments = funcCall.getArguments();
            Expr indexExpr = funcCall.getExpr(); // Obtém a expressão que representa o índice para acesso ao retorno

            Func func = funcs.get(funcName);
            if (func == null) {
                throw new RuntimeException("Função não encontrada: " + funcName);
            }

            // Avalia os argumentos da função
            List<Object> evaluatedArgs = new ArrayList<>();
            for (Expr argExpr : arguments) {
                argExpr.accept(this);
                Object argValue = operands.pop();
                evaluatedArgs.add(argValue);
            }

            // Cria um novo ambiente para a execução da função
            HashMap<String, Object> funcEnv = new HashMap<>();
            List<String> paramIds = func.getParam().getId();
            List<Type> paramTypes = func.getParam().getType();

            if (paramIds.size() != evaluatedArgs.size()) {
                throw new RuntimeException("Número de argumentos não corresponde ao número de parâmetros.");
            }
            for (int i = 0; i < paramIds.size(); i++) {
                funcEnv.put(paramIds.get(i), evaluatedArgs.get(i));
            }

            env.push(funcEnv);

            // Executa os comandos da função
            for (Cmd cmd : func.getCommands()) {
                cmd.accept(this);
                if (retMode) {
                    break;
                }
            }

            env.pop();

            if (retMode) {
                // Obtemos os valores retornados
                List<Object> returnValues = new ArrayList<>();
                while (!operands.isEmpty()) {
                    returnValues.add(operands.pop());
                }

                // Se há um índice para acessar o valor retornado
                if (indexExpr != null) {
                    indexExpr.accept(this);
                    int index = (int) operands.pop(); // Obtemos o índice da pilha de operandos

                    // Verifica se o índice está dentro dos limites
                    if (index < 0 || index >= returnValues.size()) {
                        throw new RuntimeException("Índice fora dos limites: " + index);
                    }

                    Object returnValue = returnValues.get(index);
                    operands.push(returnValue); // Opcional: mantém o valor na pilha se necessário
                    System.out
                            .println("Resultado da função '" + funcName + "' no índice " + index + ": " + returnValue);
                } else {
                    // Se não há índice, imprime o último valor retornado
                    Object returnValue = returnValues.isEmpty() ? null : returnValues.get(returnValues.size() - 1);
                    operands.push(returnValue); // Opcional: mantém o valor na pilha se necessário
                    System.out.println("Resultado da função '" + funcName + "': " + returnValue);
                }

                retMode = false;
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + funcCall.getLine() + ", " + funcCall.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(IdLValue idLValue) {
        try {
            System.out.println("Interpreter IdLvalue in InterpretVisitor: " + idLValue);
            String id = idLValue.getId();
            Object value = null;

            // Iterar sobre os ambientes para encontrar o valor associado ao identificador
            for (int i = env.size() - 1; i >= 0; i--) {
                HashMap<String, Object> currentEnv = env.get(i);
                System.out.println(env.get(i));
                if (currentEnv.containsKey(id)) {
                    value = currentEnv.get(id);
                    break;
                }
            }

            if (value == null) {
                throw new RuntimeException("Identificador não encontrado: " + id);
            }

            // Empurrar o valor do identificador para a pilha de operandos
            operands.push(value);

            // Debugging
            System.out.println("Identificador: " + id);
            System.out.println("Valor associado ao identificador '" + id + "': " + value);
        } catch (Exception e) {
            throw new RuntimeException(" (" + idLValue.getLine() + ", " + idLValue.getColumn() + ") " + e.getMessage());
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
