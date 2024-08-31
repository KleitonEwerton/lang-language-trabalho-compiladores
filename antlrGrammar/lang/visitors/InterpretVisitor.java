/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.visitors;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Function;

import lang.ast.*;

public class InterpretVisitor extends Visitor {

    private Stack<HashMap<String, Object>> env; // escopo
    private HashMap<String, Func> funcs; // funções
    private HashMap<String, Data> datas; // tipo data
    private Map<String, Object> context; // contexto
    private Stack<Object> params; // parametros de funções
    private Stack<Object> operands; // operandos
    private boolean retMode, debug;
    Node main = null;

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

    @Override
    public void visit(Prog prog) {
        if (debug) {
            System.out.println("Interpretando Program"); // Exibe uma mensagem indicando que a interpretação começou
        }
        try {
            // Todas as definições
            for (Node def : prog.getDefs()) {// Se a definição for uma função
                if (def instanceof Func) {
                    Func func = (Func) def;
                    funcs.put(func.getId(), func); // Armazena a função
                    if (func.getId().equals("main")) {
                        main = def;
                    }

                } else if (def instanceof Data) {// Se a definição for um tipo de dado (Data)
                    def.accept(this); // Visita o nó Data para armazená-lo
                } else {
                    throw new RuntimeException("Tipo de definição desconhecido: " + def.getClass().getName());
                }
            }

            // Verifica se a função 'main' foi encontrada
            if (main != null) {
                main.accept(this); // Visita o nó 'main' para iniciar a execução do programa
            } else {
                throw new RuntimeException("Função main não encontrada");
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + prog.getLine() + ", " + prog.getColumn() + ") " + e.getMessage());
        }

    }

    public void visit(Add add) {
        if (debug) {
            System.out.println("Interpreter Add in InterpretVisitor: " + add.toString());
        }

        try {
            // Avalia a expressão da esquerda e armazena na pilha de operandos
            add.getLeft().accept(this);
            Object left = operands.pop();

            // Avalia a expressão da direita e armazena na pilha de operandos
            add.getRight().accept(this);
            Object right = operands.pop();

            // Verifica se as expressões são da mesma classe
            if (left.getClass().equals(right.getClass())) {
                // Se ambas são inteiros, realiza a adição inteira
                if (left instanceof Integer) {
                    int result = (Integer) left + (Integer) right;
                    operands.push(result);
                }
                // Se ambas são floats, realiza a adição de ponto flutuante
                else if (left instanceof Float) {
                    Float result = (Float) left + (Float) right;
                    operands.push(result);
                } else {
                    throw new RuntimeException(
                            "Operação Add com tipos de operandos não suportados: " + left.getClass());
                }
            } else {
                throw new RuntimeException("Operação Add com operandos de tipos diferentes: " + left.getClass() + " e "
                        + right.getClass());
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + add.getLine() + ", " + add.getColumn() + ") " + e.getMessage());
        }
    }

    public void visit(Sub sub) {
        if (debug) {
            System.out.println("Interpreter Sub in InterpretVisitor: " + sub.toString());
        }

        try {
            // Avalia a expressão da esquerda e armazena na pilha de operandos
            sub.getLeft().accept(this);
            Object left = operands.pop();

            // Avalia a expressão da direita e armazena na pilha de operandos
            sub.getRight().accept(this);
            Object right = operands.pop();

            // Verifica se as expressões são da mesma classe
            if (left.getClass().equals(right.getClass())) {
                // Se ambas são inteiros, realiza a subtração inteira
                if (left instanceof Integer) {
                    int result = (Integer) left - (Integer) right;
                    operands.push(result);
                }
                // Se ambas são floats, realiza a subtração de ponto flutuante
                else if (left instanceof Float) {
                    Float result = (Float) left - (Float) right;
                    operands.push(result);
                } else {
                    throw new RuntimeException(
                            "Operação Sub com tipos de operandos não suportados: " + left.getClass());
                }
            } else {
                throw new RuntimeException("Operação Sub com operandos de tipos diferentes: " + left.getClass() + " e "
                        + right.getClass());
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + sub.getLine() + ", " + sub.getColumn() + ") " + e.getMessage());
        }
    }

    public void visit(Mul mul) {
        if (debug) {
            System.out.println("Interpreter Mul in InterpretVisitor: " + mul.toString());
        }

        try {
            // Avalia a expressão da esquerda e armazena na pilha de operandos
            mul.getLeft().accept(this);
            Object left = operands.pop();

            // Avalia a expressão da direita e armazena na pilha de operandos
            mul.getRight().accept(this);
            Object right = operands.pop();

            // Verifica se as expressões são da mesma classe
            if (left.getClass().equals(right.getClass())) {
                // Se ambas são inteiros, realiza a multiplicação inteira
                if (left instanceof Integer) {
                    int result = (Integer) left * (Integer) right;
                    operands.push(result);
                }
                // Se ambas são floats, realiza a multiplicação de ponto flutuante
                else if (left instanceof Float) {
                    Float result = (Float) left * (Float) right;
                    operands.push(result);
                } else {
                    throw new RuntimeException(
                            "Operação Mul com tipos de operandos não suportados: " + left.getClass());
                }
            } else {
                throw new RuntimeException("Operação Mul com operandos de tipos diferentes: " + left.getClass() + " e "
                        + right.getClass());
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + mul.getLine() + ", " + mul.getColumn() + ") " + e.getMessage());
        }
    }

    public void visit(Div div) {
        if (debug) {
            System.out.println("Interpreter Div in InterpretVisitor: " + div.toString());
        }

        try {
            // Avalia a expressão da esquerda e armazena na pilha de operandos
            div.getLeft().accept(this);
            Object left = operands.pop();

            // Avalia a expressão da direita e armazena na pilha de operandos
            div.getRight().accept(this);
            Object right = operands.pop();

            // Verifica se as expressões são da mesma classe
            if (left.getClass().equals(right.getClass())) {
                // Se ambas são inteiros, realiza a divisão inteira
                if (left instanceof Integer) {
                    int result = (Integer) left / (Integer) right;
                    operands.push(result);
                }
                // Se ambas são floats, realiza a divisão de ponto flutuante
                else if (left instanceof Float) {
                    Float result = (Float) left / (Float) right;
                    operands.push(result);
                } else {
                    throw new RuntimeException(
                            "Operação Div com tipos de operandos não suportados: " + left.getClass());
                }
            } else {
                throw new RuntimeException("Operação Div com operandos de tipos diferentes: " + left.getClass() + " e "
                        + right.getClass());
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + div.getLine() + ", " + div.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Param param) {
        if (debug) {
            System.out.println("Interpreter Param: " + param.toString());
        }

        try {
            // Obtém a lista de tipos dos parâmetros
            List<Type> types = param.getType();

            // Itera sobre cada tipo de parâmetro
            for (Type type : types) {
                // Aceita o tipo do parâmetro para processar seu valor
                type.accept(this);
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + param.getLine() + ", " + param.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Cmd cmd) {
        if (debug) {
            System.out.println("Interpreter Cmd: " + cmd.toString());
        }
        try {
            cmd.accept(this);
        } catch (Exception x) {
            throw new RuntimeException(" (" + cmd.getLine() + ", " + cmd.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Func func) {
        // Exibe o nome da função
        if (debug) {
            System.out.println("Interpreter Func: " + func.toString());
        }

        // Crie um novo ambiente para a função e empurre para a pilha
        HashMap<String, Object> funcEnv = new HashMap<String, Object>();

        // Se a função possui parâmetros, processa-os
        if (func.getParam() != null) {
            Param parameters = func.getParam();
            parameters.accept(this); // Avalia os parâmetros e empilha seus valores

            // Insere os parâmetros no escopo local da função
            for (int i = 0; i < parameters.size(); i++) {
                funcEnv.put(parameters.getSingleId(i), operands.pop());
            }
        }

        // Empilha o novo escopo de função no ambiente de execução
        env.push(funcEnv);

        // Interpreta e executa cada comando dentro da função
        for (Cmd command : func.getCommands()) {
            command.accept(this);
        }

        // Remove o escopo da função da pilha de ambientes
        env.pop();

        retMode = false; // Reseta o modo de retorno para falso após a execução da função
    }

    @Override
    public void visit(And and) {
        // Exibe o nome da função
        if (debug) {
            System.out.println("Interpreter And: " + and.toString());
        }

        try {
            // Avalia o lado esquerdo da expressão
            and.getLeft().accept(this);
            Object leftValue = operands.pop();

            // Verifica se o valor à esquerda é um booleano
            if (!(leftValue instanceof Boolean)) {
                throw new RuntimeException(
                        "Erro: Operador && requer operandos booleanos. Operando à esquerda é de tipo inválido: "
                                + leftValue);
            }

            // Avalia o lado direito da expressão
            and.getRight().accept(this);
            Object rightValue = operands.pop();

            // Verifica se o valor à direita é um booleano
            if (!(rightValue instanceof Boolean)) {
                throw new RuntimeException(
                        "Erro: Operador && requer operandos booleanos. Operando à direita é de tipo inválido: "
                                + rightValue);
            }

            // Computa o resultado final da operação lógica '&&'
            Boolean finalResult = (Boolean) leftValue && (Boolean) rightValue;
            operands.push(finalResult);

        } catch (Exception e) {
            throw new RuntimeException(" (" + and.getLine() + ", " + and.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(ArrayType arrayType) {
        if (debug) {
            System.out.println("Interpreter ArrayType in InterpretVisitor: " + arrayType.toString());
        }

        try {
            // Verifica se há parâmetros na pilha
            boolean isParameter = !params.isEmpty();

            if (isParameter) {
                // Se houver, empilha o próximo parâmetro na pilha de operandos
                operands.push(params.pop());
            } else {
                // Caso contrário, empilha o próprio tipo de array
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
        if (debug) {
            System.out.println("Interpreter BlockCmd in InterpretVisitor: " + blockCmd.toString());
        }

        if (retMode) {
            return;
        }
        try {
            // Itera sobre cada comando no bloco de comandos
            for (Cmd cmd : blockCmd.getCmds()) {
                cmd.accept(this); // Interpreta o comando atual

                // Se o modo de retorno for ativado, interrompe a execução do bloco
                if (retMode) {
                    break;
                }
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + blockCmd.getLine() + ", " + blockCmd.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(CharDexp charDexp) {
        if (debug) {
            System.out.println("Interpreter CharDexp in InterpretVisitor: " + charDexp.toString());
        }
        try {
            // Obtém o valor associado ao CharDexp
            String value = charDexp.getValue();
            operands.push(value); // Empilha o valor do CharDexp na pilha de operandos
        } catch (Exception e) {
            throw new RuntimeException(" (" + charDexp.getLine() + ", " + charDexp.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Equals equals) {
        if (debug) {
            System.out.println("Interpreter Equals in InterpretVisitor: " + equals.toString());
        }
        try {
            equals.getLeft().accept(this); // Avalia o lado esquerdo da expressão
            equals.getRight().accept(this); // Avalia o lado direito da expressão

            // Desempilha os valores avaliados
            Object rightValue = operands.pop();
            Object leftValue = operands.pop();

            // Verifica se os tipos dos valores são iguais
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
                // Empilha o resultado da comparação (true ou false) na pilha de operandos
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
        if (debug) {
            System.out.println("Interpreter False in InterpretVisitor: " + false1.toString());
        }
        try {
            // Adiciona o valor booleano false à pilha de operandos
            operands.push(false1.toString());
        } catch (Exception e) {
            throw new RuntimeException(" (" + false1.getLine() + ", " + false1.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(FloatDexp floatDexp) {
        if (debug) {
            System.out.println("Interpreter FloatDexp in InterpretVisitor: " + floatDexp.toString());
        }
        try {
            float value = floatDexp.getValue(); // Obtém o valor do número de ponto flutuante
            operands.push(value); // Empilha o valor na pilha de operandos
        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + floatDexp.getLine() + ", " + floatDexp.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(FuncCallCmd funcCallCmd) {
        if (debug) {
            System.out.println("Interpreter FuncCallCmd in InterpretVisitor: " + funcCallCmd.toString());
        }
        try {

            // Localiza a função correspondente
            Func func = funcs.get(funcCallCmd.getId());

            // Verifica se a função foi encontrada
            if (func != null) {
                // Processa os argumentos da função, se houver
                if (funcCallCmd.getFuncArgs() != null) {
                    for (Expr arg : funcCallCmd.getFuncArgs().getExprs()) {
                        arg.accept(this); // Avalia cada argumento
                        params.push(operands.pop()); // Empilha o resultado na pilha de parâmetros
                    }
                }

                // Executa a função
                func.accept(this);

                // Processa os valores de retorno, se houver
                if (funcCallCmd.getLvalues() != null) {
                    List<LValue> lvalues = funcCallCmd.getLvalues();
                    // Armazena os valores de retorno nas variáveis correspondentes
                    for (int i = lvalues.size() - 1; i >= 0; i--) {
                        LValue lvalue = lvalues.get(i);
                        env.peek().put(lvalue.getId(), operands.pop()); // Associa o valor à variável no escopo atual
                    }
                }
            } else {
                throw new RuntimeException("Função " + funcCallCmd.getId() + " não encontrada.");
            }
        } catch (Exception x) {
            throw new RuntimeException(
                    " (" + funcCallCmd.getLine() + ", " + funcCallCmd.getColumn() + ") " + x.getMessage());
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
        if (debug) {
            System.out.println("Interpreter If in InterpretVisitor: " + if1.toString());
        }
        try {
            // Avalia a condição do if e empilha o resultado na pilha de operandos
            if1.getCondition().accept(this);
            Object conditionValue = operands.pop();

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
        if (debug) {
            System.out.println("Interpreter IfElse in InterpretVisitor: " + ifElse.toString());
        }

        try {
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
        if (debug) {
            System.out.println("Interpreter IntDexp in InterpretVisitor " + intDexp);
        }
        try {
            // Obtém o valor inteiro da expressão
            int value = intDexp.getValue();
            operands.push(value); // Empilha o valor na pilha de operandos

        } catch (Exception e) {
            throw new RuntimeException(" (" + intDexp.getLine() + ", " + intDexp.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Iterate iterate) {
        if (debug) {
            System.out.println("Interpreter Iterate in InterpretVisitor " + iterate.toString());
        }

        try {
            // Avalia a condição inicial do loop e desempilha o valor para verificação
            iterate.getCondition().accept(this);
            Object conditionValue = operands.pop();

            // Se a condição for um booleano, executa o loop enquanto a condição for
            // verdadeira
            if (conditionValue instanceof Boolean) {
                while ((Boolean) conditionValue) {
                    // Executa o comando associado ao loop
                    iterate.getCmd().accept(this);
                    // Reavalia a condição do loop para a próxima iteração
                    iterate.getCondition().accept(this);
                    conditionValue = operands.pop(); // Desempilha o valor atualizado da condição
                }
            }
            // Se a condição for um inteiro, executa o loop um número específico de vezes
            else if (conditionValue instanceof Integer) {
                int iterations = (Integer) conditionValue;
                for (int i = 0; i < iterations; i++) {
                    iterate.getCmd().accept(this);
                }
            } else {
                throw new RuntimeException(
                        "Tipo de condição inválido para Iterate: " + conditionValue.getClass().getName());
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + iterate.getLine() + ", " + iterate.getColumn() + ") " + x.getMessage());
        }

    }

    @Override
    public void visit(LessThan lessThan) {
        if (debug) {
            System.out.println("Interpreter LessThan in InterpretVisitor: " + lessThan.toString());
        }
        try {
            // Avalia o lado esquerdo da expressão
            lessThan.getLeft().accept(this);
            // Avalia o lado direito da expressão
            lessThan.getRight().accept(this);

            // Desempilha os valores da pilha de operandos para comparação
            Object rightValue = operands.pop();
            Object leftValue = operands.pop();

            // Verifica se os tipos dos operandos são iguais
            if (leftValue.getClass() == rightValue.getClass()) {
                boolean result;

                if (leftValue instanceof Integer) {
                    result = (Integer) leftValue < (Integer) rightValue;
                }

                else if (leftValue instanceof Float) {
                    result = (Float) leftValue < (Float) rightValue;
                }

                else if (leftValue instanceof Character) {
                    result = (Character) leftValue < (Character) rightValue;
                }

                else {
                    throw new RuntimeException("Tipo não suportado para comparação '<': " + leftValue.getClass());
                }

                // Empilha o resultado da comparação na pilha de operandos
                operands.push(result);

                // Imprime o resultado da comparação para depuração
                if (debug) {
                    System.out.println("Resultado da comparação LessThan no InterpretVisitor: " + result);
                }

            } else {
                // Lança uma exceção se os operandos forem de tipos diferentes
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
        if (debug) {
            System.out.println("Interpreter LvalueCmd in InterpretVisitor: " + lvalueCmd.toString());
        }
        try {
            // Avalia a expressão
            lvalueCmd.getExpr().accept(this);

            // Obtém a referência
            LValue lvalue = lvalueCmd.getLvalue();

            // Verifica se o LValue é uma referência ao Dot
            if (lvalue instanceof Dot) {

                // Verifica se o LValue é uma referência a um elemento de array
                if (((Dot) lvalue).getlValue() instanceof ArrayLValue) {
                    ArrayLValue arrayAccess = (ArrayLValue) ((Dot) lvalue).getlValue();
                    arrayAccess.getExpr().accept(this); // Avalia a expressão para a posição do array

                    String fieldName = ((Dot) lvalue).getId();
                    String objectName = ((Dot) lvalue).getData();
                    Integer index = (Integer) operands.pop(); // Obtém a posição no array
                    Integer valueToAssign = (Integer) operands.pop(); // Obtém o valor a ser atribuído

                    // Busca o array no ambiente atual
                    List<Object> arrayObject = (List<Object>) env.peek().get(arrayAccess.getId());

                    // Verifica se a posição é válida dentro do array
                    if (index >= 0 && index < arrayObject.size()) {
                        Object arrayElement = arrayObject.get(index); // Obtém o elemento na posição especificada
                        ((HashMap<String, Object>) arrayElement).put(fieldName, valueToAssign); // Atribui o valor ao
                                                                                                // campo do objeto
                    } else {
                        throw new RuntimeException("Erro: Posição inválida no array '" + arrayAccess.getId() + "'");
                    }

                } else {
                    String fieldName = ((Dot) lvalue).getId();
                    String objectName = ((Dot) lvalue).getData();

                    Object value = operands.pop(); // Obtém o valor a ser atribuído
                    HashMap<String, Object> object = (HashMap<String, Object>) env.peek().get(objectName);

                    // Verifica se o campo existe no objeto
                    if (object.containsKey(fieldName)) {
                        object.put(fieldName, value); // Atribui o valor ao campo do objeto
                    } else {
                        throw new RuntimeException(
                                "Erro: O campo '" + fieldName + "' não existe no objeto '" + objectName + "'");
                    }
                }

            } else if (lvalue instanceof IdLValue) {
                String varName = ((IdLValue) lvalue).getId();
                env.peek().put(varName, operands.pop()); // Atribui o valor à variável no ambiente atual

            } else if (lvalue instanceof ArrayLValue) {
                String arrayName = ((ArrayLValue) lvalue).getId();
                ((ArrayLValue) lvalue).getExpr().accept(this); // Avalia a expressão para a posição do array
                Integer index = (Integer) operands.pop(); // Obtém a posição do array

                List<Object> array = (List<Object>) env.peek().get(arrayName);

                // Verifica se a posição é válida dentro do array
                if (index >= 0 && index < array.size()) {
                    array.set(index, operands.pop()); // Atribui o valor à posição do array
                } else {
                    throw new RuntimeException("Erro: Posição inválida no array '" + arrayName + "'");
                }
            }
        } catch (Exception x) {
            throw new RuntimeException(
                    " (" + lvalueCmd.getLine() + ", " + lvalueCmd.getColumn() + ") " + x.getMessage());
        }

    }

    @Override
    public void visit(Mod mod) {
        if (debug) {
            System.out.println("Interpreter Mod in InterpretVisitor: " + mod.toString());
        }
        try {

            // Avalia a expressão do lado esquerdo
            mod.getLeft().accept(this);

            // Avalia a expressão do lado direito
            mod.getRight().accept(this);

            // Desempilha os valores dos operandos para realizar a operação
            Object rightValue = operands.pop();
            Object leftValue = operands.pop();

            // Verifica se ambos os operandos são do mesmo tipo
            if (leftValue.getClass() == rightValue.getClass()) {
                Object result;

                if (leftValue instanceof Integer) {
                    if ((Integer) rightValue == 0) {// Verifica e lança uma exceção se a divisão por zero for tentada
                        throw new ArithmeticException("Divisão por zero ao calcular módulo.");
                    }
                    result = (Integer) leftValue % (Integer) rightValue;
                } else if (leftValue instanceof Float) {
                    if ((Float) rightValue == 0.0f) {// Verifica e lança uma exceção se a divisão por zero for tentada
                        throw new ArithmeticException("Divisão por zero ao calcular módulo.");
                    }
                    result = (Float) leftValue % (Float) rightValue;
                } else {
                    throw new RuntimeException("Tipo não suportado para operação '%': " + leftValue.getClass());
                }

                // Empilha o resultado do módulo
                operands.push(result);

                if (debug) {
                    System.out.println(
                            "Interpreter Mod in InterpretVisitor: Result of " + leftValue + " % " + rightValue + " is "
                                    + result);
                }
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
        if (debug) {
            System.out.println("Interpreter NameType in InterpretVisitor: " + nameType.toString());
        }
        try {

            // Verifica se há parâmetros disponíveis na pilha de parâmetros
            if (!params.isEmpty()) {
                // Se houver, desempilha o parâmetro do topo e o empilha na pilha de operandos
                operands.push(params.pop());
            } else {
                // Se não houver, empilha o próprio NameType na pilha de operandos
                operands.push(nameType);
            }

        } catch (Exception e) {
            throw new RuntimeException(" (" + nameType.getLine() + ", " + nameType.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Neg neg) {
        if (debug) {
            System.out.println("Interpreter Neg in InterpretVisitor: " + neg.toString());
        }

        try {

            // Avalia a expressão
            neg.getExpr().accept(this);
            Object value = operands.pop();// empilha o resultado

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
        if (debug) {
            System.out.println("Interpreter Not in InterpretVisitor: " + not.toString());
        }
        try {

            // Avalia a expressão
            not.getExpr().accept(this);

            // Desempilha o valor
            Object value = operands.pop();

            // Verifica se o valor é do tipo Boolean
            if (!(value instanceof Boolean)) {
                throw new RuntimeException(
                        "Operador de negação requer um operando booleano. Operando é de tipo inválido: "
                                + value);
            }

            // Aplica a negação lógica ao valor booleano e empilha o resultado
            operands.push(!(Boolean) value);

        } catch (Exception e) {
            throw new RuntimeException(" (" + not.getLine() + ", " + not.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(NotEquals notEquals) {
        if (debug) {
            System.out.println("Interpreter NotEquals in InterpretVisitor: " + notEquals.toString());
        }

        try {
            // Avalia as expressões à esquerda e à direita da operação de diferença
            notEquals.getLeft().accept(this);
            notEquals.getRight().accept(this);

            // Desempilha os resultados das expressões
            Object right = operands.pop();
            Object left = operands.pop();

            // Verifica se ambos os operandos são booleanos
            if (left instanceof Boolean && right instanceof Boolean) {
                operands.push(!left.equals(right));
            }
            // Verifica se ambos os operandos são do tipo Float
            else if (left instanceof Float && right instanceof Float) {
                operands.push(!left.equals(right));
            }

            // Verifica se ambos os operandos são do tipo Integer
            else if (left instanceof Integer && right instanceof Integer) {

                operands.push(!left.equals(right));
            }
            // Lança uma exceção se os operandos forem de tipos incompatíveis
            else {
                throw new RuntimeException("Erro: Tipos incompatíveis na operação de diferença na linha "
                        + notEquals.getLine() + ", coluna " + notEquals.getColumn());
            }
        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + notEquals.getLine() + ", " + notEquals.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Null null1) {
        if (debug) {
            System.out.println("Interpreter Null in InterpretVisitor: " + null1.toString());
        }
        try {
            // Adiciona o valor null à pilha de operandos
            operands.push(null);
        } catch (Exception e) {
            throw new RuntimeException(" (" + null1.getLine() + ", " + null1.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Print print) {
        if (debug) {
            System.out.println("Interpreter Print in InterpretVisitor");
        }
        try {

            // Avalia a expressão
            print.getExpression().accept(this);

            // Desempilha o resultado
            Object value = operands.pop();

            // Imprime o valor da expressão
            System.out.println(value);
        } catch (Exception e) {
            throw new RuntimeException(" (" + print.getLine() + ", " + print.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Read read) {
        if (debug) {
            System.out.println("Interpreter Read in InterpretVisitor");
        }
        try {

            // Obtém o LValue onde o valor lido será armazenado
            LValue lvalue = read.getLvalue();

            // Cria um Scanner para ler a entrada do usuário via teclado
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine(); // Lê a linha de entrada do usuário

            // Verifica se o LValue é um identificador
            if (lvalue instanceof IdLValue) {
                // Armazena o valor digitado pelo usuário no ambiente atual
                env.peek().put(((IdLValue) lvalue).getId(), userInput);
            }

            // Verifica se o LValue é um campo de um objeto (Dot)
            else if (lvalue instanceof Dot) {
                // Se o campo do objeto for parte de um array
                if (((Dot) lvalue).getlValue() instanceof ArrayLValue) {
                    ArrayLValue arrayAccess = (ArrayLValue) ((Dot) lvalue).getlValue();
                    arrayAccess.getExpr().accept(this); // Avalia a expressão para determinar a posição no array

                    String attributeName = ((Dot) lvalue).getId();
                    Integer index = (Integer) operands.pop(); // Obtém a posição do array

                    // Obtém o array do ambiente
                    List<Object> arrayObject = (List<Object>) env.peek().get(arrayAccess.getId());

                    // Verifica se o índice está dentro dos limites do array
                    if (index >= 0 && index < arrayObject.size()) {
                        Object element = arrayObject.get(index); // Obtém o elemento na posição especificada
                        ((HashMap<String, Object>) element).put(attributeName, userInput); // Atribui o valor lido ao
                                                                                           // atributo do objeto
                    } else {
                        throw new RuntimeException(
                                "Erro: Posição inválida no array '" + arrayAccess.getId() + "' na linha "
                                        + read.getLine() + ", coluna " + read.getColumn());
                    }
                }
                // Se o LValue for um campo simples de um objeto (não parte de um array)
                else {
                    Object object = env.peek().get(((IdLValue) ((Dot) lvalue).getlValue()).getId());
                    ((HashMap<String, Object>) object).put(((Dot) lvalue).getId(), userInput);
                }
            }
            // Fecha o scanner após a leitura
            scanner.close();
        } catch (Exception x) {
            throw new RuntimeException(" (" + read.getLine() + ", " + read.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Return return1) {
        if (debug) {
            // Imprime a expressão de retorno para depuração
            System.out.println("Interpreter Return in InterpretVisitor: " + return1);
        }
        try {

            // Itera sobre cada expressão
            for (Expr expr : return1.getEXExprs()) {
                expr.accept(this); // Avalia a expressão
            }

            // Sinaliza que o modo de retorno foi ativado
            retMode = true;

        } catch (Exception e) {
            throw new RuntimeException(" (" + return1.getLine() + ", " + return1.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(True true1) {
        if (debug) {
            System.out.println("Interpreter True in InterpretVisitor");
        }
        try {
            // Adiciona o valor booleano true à pilha de operandos
            operands.push(true1.toString());
        } catch (Exception e) {
            throw new RuntimeException(" (" + true1.getLine() + ", " + true1.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(TyBool tyBool) {
        if (debug) {
            System.out.println("Interpreter TyBool in InterpretVisitor");
        }
        try {
            // Verifica se há parâmetros na pilha de parâmetros
            if (!params.isEmpty()) {
                // Se houver, desempilha o parâmetro do topo e o coloca na pilha de operandos
                operands.push(params.pop());
            } else {
                // Se não houver parâmetros, empilha o próprio TyBool na pilha de operandos
                operands.push(tyBool);
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + tyBool.getLine() + ", " + tyBool.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(TyChar tyChar) {
        if (debug) {
            System.out.println("Interpreter TyChar in InterpretVisitor");
        }
        try {
            // Verifica se há parâmetros na pilha
            if (!params.isEmpty()) {
                // Se houver, desempilha o parâmetro e o empilha na pilha de operandos
                operands.push(params.pop());
            } else {
                // Se não houver parâmetros, empilha o próprio TyChar na pilha de operandos
                operands.push(tyChar);
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + tyChar.getLine() + ", " + tyChar.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(TyFloat tyFloat) {
        if (debug) {
            System.out.println("Interpreter TyFloat in InterpretVisitor");
        }
        try {
            // Verifica se há parâmetros disponíveis na pilha de parâmetros
            if (!params.isEmpty()) {
                // Se houver, desempilha o parâmetro do topo e o empilha na pilha de operandos
                operands.push(params.pop());
            } else {
                // Caso contrário, empilha o próprio objeto TyChar na pilha de operandos
                operands.push(tyFloat);
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + tyFloat.getLine() + ", " + tyFloat.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(TyInt tyInt) {
        if (debug) {
            System.out.println("Interpreter True in InterpretVisitor");
        }
        try {

            // Verifica se há parâmetros disponíveis na pilha de parâmetros
            if (!params.isEmpty()) {
                // Se houver, desempilha o parâmetro do topo e o empilha na pilha de operandos
                operands.push(params.pop());
            } else {
                // Caso contrário, empilha o próprio objeto TyChar na pilha de operandos
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
        if (debug) {
            System.out.println("Interpreter ArrayLValue in InterpretVisitor: " + arrayLValue.toString());
        }
        try {
            // Obtém o objeto associado ao identificador
            Object arrayObject = env.peek().get(arrayLValue.getlValue().getId());

            // Verifica se o array existe no ambiente
            if (arrayObject != null) {
                // Avalia a expressão para obter a posição no array
                arrayLValue.getExpr().accept(this);
                Integer index = (Integer) operands.pop(); // Desempilha a posição calculada

                // Verifica se o índice está dentro dos limites do array
                int arraySize = ((List<?>) arrayObject).size();
                if (index >= 0 && index < arraySize) {
                    // Empilha o valor localizado na posição especificada do array
                    operands.push(((List<?>) arrayObject).get(index));
                } else {
                    // Lança uma exceção se o índice estiver fora dos limites do array
                    throw new RuntimeException("Erro na linha " + arrayLValue.getLine() + ", coluna "
                            + arrayLValue.getColumn() + ": Acesso inválido à posição " + index
                            + " no array '" + arrayLValue.getlValue().getId() + "'");
                }
            } else {
                // Lança uma exceção se o array não existir no ambiente
                throw new RuntimeException("Erro na linha " + arrayLValue.getLine() + ", coluna "
                        + arrayLValue.getColumn() + ": O array '"
                        + arrayLValue.getlValue().getId() + "' não existe");
            }
        } catch (Exception x) {
            throw new RuntimeException(
                    " (" + arrayLValue.getLine() + ", " + arrayLValue.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Data data) {
        if (debug) {
            System.out.println("Interpreter Data in InterpretVisitor");
        }
        try {
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

        } catch (Exception e) {
            throw new RuntimeException(" (" + decl.getLine() + ", " + decl.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Dot dot) {
        if (debug) {
            System.out.println("Interpreter Dot in InterpretVisitor: " + dot);
        }
        try {
            // Obtém o objeto associado ao identificador do lado esquerdo do ponto
            Object leftObject = env.peek().get(dot.getlValue().getId());

            // Verifica se o objeto existe no ambiente
            if (leftObject == null) {
                throw new RuntimeException("Erro na linha " + dot.getLine() + ", coluna "
                        + dot.getColumn() + ": O objeto '" + dot.getlValue().getId() + "' não existe.");
            }

            // Verifica se o LValue do Dot é uma referência a um array
            if (dot.getlValue() instanceof ArrayLValue) {
                ArrayLValue arrayAccess = (ArrayLValue) dot.getlValue();
                arrayAccess.getExpr().accept(this); // Avalia a expressão

                Integer index = (Integer) operands.pop(); // Desempilha a posição do array
                List<?> arrayList = (List<?>) leftObject; // Converte o objeto para uma lista

                // Verifica se o índice está dentro dos limites do array
                if (index >= 0 && index < arrayList.size()) {
                    HashMap<String, Object> element = (HashMap<String, Object>) arrayList.get(index);
                    String attributeName = dot.getId();

                    // Verifica se o atributo existe no elemento do array
                    if (element.containsKey(attributeName)) {
                        operands.push(element.get(attributeName)); // Empilha o valor do atributo
                    } else {
                        throw new RuntimeException("Erro na linha " + dot.getLine() + ", coluna "
                                + dot.getColumn() + ": O atributo '" + attributeName
                                + "' não existe no objeto do array.");
                    }
                } else {
                    throw new RuntimeException("Erro na linha " + dot.getLine() + ", coluna "
                            + dot.getColumn() + ": Índice " + index + " fora dos limites do array.");
                }
            } else {
                // Se não for um array, trata como um objeto simples
                HashMap<String, Object> objectMap = (HashMap<String, Object>) leftObject;
                String attributeName = dot.getId();

                // Verifica se o atributo existe no objeto
                if (objectMap.containsKey(attributeName)) {
                    operands.push(objectMap.get(attributeName)); // Empilha o valor do atributo
                } else {
                    throw new RuntimeException("Erro na linha " + dot.getLine() + ", coluna "
                            + dot.getColumn() + ": O atributo '" + attributeName
                            + "' não existe no objeto '" + dot.getlValue().getId() + "'.");
                }
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + dot.getLine() + ", " + dot.getColumn() + ") " + x.getMessage());
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
        if (debug) {
            System.out.println("Interpreter FuncCall in InterpretVisitor: " + funcCall.toString());
        }
        try {
            // Recupera a função correspondente pelo nome
            Func func = funcs.get(funcCall.getFuncName());

            // Verifica se a função existe
            if (func == null) {
                throw new RuntimeException("Erro na linha " + funcCall.getLine() + ", coluna "
                        + funcCall.getColumn() + ": Função '" + funcCall.getFuncName() + "' não encontrada.");
            }

            // Processa os argumentos da função, se houver
            if (funcCall.getArgs() != null) {
                for (Expr expr : funcCall.getArgs().getExprs()) {
                    expr.accept(this); // Avalia cada argumento
                    Object argumentValue = operands.pop(); // Desempilha o resultado da avaliação
                    params.push(argumentValue); // Armazena o argumento na pilha de parâmetros
                }
            }

            // Executa a função
            func.accept(this);

            // Avalia a expressão que determina qual valor de retorno o usuário deseja
            IntDexp returnIndexExpr = (IntDexp) funcCall.getExpr();
            int returnIndex = returnIndexExpr.getValue();

            // Verifica o número de valores de retorno da função e trata conforme necessário
            int returnCount = func.getAdditionalTypes().size();
            if (returnCount == 2) { // Função com dois retornos
                if (returnIndex == 0) {
                    operands.pop(); // Desempilha o segundo retorno, mantendo apenas o primeiro
                } else if (returnIndex != 1) {
                    throw new RuntimeException("Erro na linha " + funcCall.getLine() + ", coluna "
                            + funcCall.getColumn() + ": Índice de retorno inválido para a função.");
                }
            } else if (returnCount == 1) { // Função com um único retorno
                if (returnIndex != 0) {
                    throw new RuntimeException("Erro na linha " + funcCall.getLine() + ", coluna "
                            + funcCall.getColumn() + ": Índice de retorno inválido para a função.");
                }
            } else {
                throw new RuntimeException("Erro na linha " + funcCall.getLine() + ", coluna "
                        + funcCall.getColumn() + ": A função não tem valores de retorno.");
            }

        } catch (Exception x) {
            throw new RuntimeException(" (" + funcCall.getLine() + ", " + funcCall.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(IdLValue idLValue) {
        if (debug) {
            System.out.println("Interpreter IdLValue in InterpretVisitor: " + idLValue.toString());
        }
        try {

            // Recupera o valor associado ao identificador no ambiente atual
            Object value = env.peek().get(idLValue.getId());

            // Verifica se o identificador existe no ambiente, mesmo que o valor seja null
            if (value != null || env.peek().containsKey(idLValue.getId())) {
                // Se o identificador existe, empilha o valor correspondente na pilha de
                // operandos
                operands.push(value);
            } else {
                // Lança uma exceção se o identificador não for encontrado no ambiente
                throw new RuntimeException(
                        "Erro na linha " + idLValue.getLine() + ", coluna " + idLValue.getColumn() + ": Identificador '"
                                + idLValue.getId() + "' não encontrado no ambiente.");
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + idLValue.getLine() + ", " + idLValue.getColumn() + ") " + x.getMessage());
        }

    }

    @Override
    public void visit(NewExp newExp) {
        if (debug) {
            System.out.println("Interpreter NewExp in InterpretVisitor: " + newExp.toString());
        }
        try {
            // Verifica se o tipo não é um Data
            if (newExp.getType() != null) {
                // Avalia o tipo e a expressão associada, se houver
                newExp.getType().accept(this);

                if (newExp.getExpr() != null) {
                    newExp.getExpr().accept(this);

                    // Trata a criação de um array
                    Integer arraySize = (Integer) operands.pop();
                    Object arrayType = operands.pop();

                    // Cria uma lista (array) com o tamanho especificado
                    List<Object> arrayList = new ArrayList<>(arraySize);
                    for (int i = 0; i < arraySize; i++) {
                        arrayList.add(arrayType);
                    }
                    operands.push(arrayList);
                } else {
                    // Criação de um tipo de dado
                    Object defaultValue = new Obj(newExp.getLine(), newExp.getColumn(), newExp.getType());
                    operands.push(defaultValue);
                }
            } else {
                // Caso o tipo seja Data
                if (newExp.getExpr() == null) {
                    // Criação de uma instância
                    String dataName = newExp.getDataName();
                    HashMap<String, Object> dataInstance = new HashMap<>();

                    for (Decl decl : datas.get(dataName).getDecls()) {
                        decl.getType().accept(this);
                        operands.pop();

                        Object defaultValue = new Obj(newExp.getLine(), newExp.getColumn(), decl.getId(),
                                decl.getType());
                        dataInstance.put(decl.getId(), defaultValue);
                    }
                    operands.push(dataInstance);
                } else {
                    // Criação de um array Data
                    newExp.getExpr().accept(this);
                    Integer arraySize = (Integer) operands.pop();

                    List<Object> dataArray = new ArrayList<>(arraySize);
                    String dataName = newExp.getDataName();

                    for (int i = 0; i < arraySize; i++) {
                        HashMap<String, Object> dataInstance = new HashMap<>();

                        for (Decl decl : datas.get(dataName).getDecls()) {
                            Object defaultValue = new Obj(newExp.getLine(), newExp.getColumn(), decl.getId(),
                                    decl.getType());
                            dataInstance.put(decl.getId(), defaultValue);
                        }
                        dataArray.add(dataInstance);
                    }
                    operands.push(dataArray);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + newExp.getLine() + ", " + newExp.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(FuncArgs funcArgs) {
        if (debug) {
            System.out.println("Interpreter FuncArgs in InterpretVisitor: " + funcArgs.toString());
        }
        try {
            // Itera sobre cada expressão nos argumentos da função
            for (Expr expr : funcArgs.getExprs()) {
                expr.accept(this); // Avalia a expressão atual
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + funcArgs.getLine() + ", " + funcArgs.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Decls decls) {

    }

    /*
     * Funções auxiliares
     */
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

}
