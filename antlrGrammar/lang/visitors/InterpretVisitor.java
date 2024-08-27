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
        retMode = false;
    }

    @Override
    public void visit(Prog prog) {

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
            // [ x ] Implementar o método visit para Prog

            System.out.println("Visit Add in InterpretVisitor");

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

            System.out.println("Visit Mul in InterpretVisitor");

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

        System.out.println("Visiting Cmd: " + cmd.toString());
    }

    @Override
    public void visit(Func func) {

        try {
            for (Cmd cmd : func.getCommands()) {

                System.out.println("Visiting func: " + cmd.toString());

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

            System.out.println("Visit ArrayType in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + arrayType.getLine() + ", " + arrayType.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(BinOP binOP) {

        try {

            System.out.println("Visit BinOP in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + binOP.getLine() + ", " + binOP.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(BlockCmd blockCmd) {
        try {
            System.out.println("Visit BlockCmd in InterpretVisitor");

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
            System.out.println("Visit Expr in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + expr.getLine() + ", " + expr.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(False false1) {
        try {
            System.out.println("Visit False in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + false1.getLine() + ", " + false1.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(FloatDexp floatDexp) {
        try {
            System.out.println("Visit FloatDexp in InterpretVisitor");
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
            System.out.println("Visit FuncCallCmd in InterpretVisitor");

        } catch (Exception e) {

        }
    }

    @Override
    public void visit(IdType idType) {
        try {
            System.out.println("Visit IdType in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + idType.getLine() + ", " + idType.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(If if1) {

        try {
            System.out.println("Visit If in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + if1.getLine() + ", " + if1.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(IfElse ifElse) {
        try {
            System.out.println("Visit IfElse in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + ifElse.getLine() + ", " + ifElse.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(IntDexp intDexp) {

        try {
            System.out.println("Visit IntDexp in InterpretVisitor " + intDexp);
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

            System.out.println("Visit Iterate in InterpretVisitor " + condition);

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
            System.out.println("Visit LessThan in InterpretVisitor");
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
        try {
            System.out.println("Visit LValue in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + lValue.getLine() + ", " + lValue.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(LvalueCmd lvalueCmd) {
        try {
            System.out.println("Visit LvalueCmd in InterpretVisitor " + lvalueCmd);
            lvalueCmd.getLvalue().accept(this);
            lvalueCmd.getExpr().accept(this);

        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + lvalueCmd.getLine() + ", " + lvalueCmd.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Mod mod) {
        try {
            System.out.println("Visit Mod in InterpretVisitor");
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
                        "Visit Mod in InterpretVisitor: Result of " + leftValue + " % " + rightValue + " is " + result);
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
            System.out.println("Visit NameType in InterpretVisitor");
        } catch (Exception e) {
            throw new RuntimeException(" (" + nameType.getLine() + ", " + nameType.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Neg neg) {

        try {
            System.out.println("Visit Neg in InterpretVisitor");
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
            System.out.println("Visit Not in InterpretVisitor");
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
            System.out.println("Visit NotEquals in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + notEquals.getLine() + ", " + notEquals.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Null null1) {
        try {
            System.out.println("Visit Null in InterpretVisitor");
        } catch (Exception e) {
            throw new RuntimeException(" (" + null1.getLine() + ", " + null1.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Paren paren) {

        try {
            System.out.println("Visit Paren in InterpretVisitor");
            paren.getExpr().accept(this);
        } catch (Exception e) {
            throw new RuntimeException(" (" + paren.getLine() + ", " + paren.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Print print) {
        try {
            System.out.println("Visit Print in InterpretVisitor");
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
            System.out.println("Visit Read in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + read.getLine() + ", " + read.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Return return1) {

        try {
            System.out.println("Visit Return in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + return1.getLine() + ", " + return1.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(True true1) {

        try {
            System.out.println("Visit True in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + true1.getLine() + ", " + true1.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(TyBool tyBool) {

        try {
            System.out.println("Visit TyBool in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + tyBool.getLine() + ", " + tyBool.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(TyChar tyChar) {

        try {
            System.out.println("Visit TyChar in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + tyChar.getLine() + ", " + tyChar.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(TyFloat tyFloat) {

        try {
            System.out.println("Visit TyFloat in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + tyFloat.getLine() + ", " + tyFloat.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(TyInt tyInt) {
        try {
            System.out.println("Visit True in InterpretVisitor");
        } catch (Exception e) {
            throw new RuntimeException(" (" + tyInt.getLine() + ", " + tyInt.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Type type) {
        try {
            System.out.println("Visit Type in InterpretVisitor");
        } catch (Exception e) {
            throw new RuntimeException(" (" + type.getLine() + ", " + type.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(ArrayLValue arrayLValue) {

        try {
            System.out.println("Visit ArrayLValue in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + arrayLValue.getLine() + ", " + arrayLValue.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Data data) {

        try {
            System.out.println("Visit Data in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + data.getLine() + ", " + data.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Decl decl) {

        try {
            System.out.println("Visit Decl in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + decl.getLine() + ", " + decl.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Dot dot) {

        try {
            System.out.println("Visit Dot in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + dot.getLine() + ", " + dot.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(Exprs exprs) {

        try {
            System.out.println("Visit Exprs in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + exprs.getLine() + ", " + exprs.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(FuncCall funcCall) {

        try {
            System.out.println("Visit FuncCall in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + funcCall.getLine() + ", " + funcCall.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(IdLValue idLValue) {

        try {
            System.out.println("Visit IdLValue in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(
                    " (" + idLValue.getLine() + ", " + idLValue.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(NewExp newExp) {

        try {
            System.out.println("Visit NewExp in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + newExp.getLine() + ", " + newExp.getColumn() + ") " + e.getMessage());
        }

    }

    @Override
    public void visit(FuncArgs funcArgs) {

        try {
            System.out.println("Visit FuncArgs in InterpretVisitor");

        } catch (Exception e) {
            throw new RuntimeException(" (" + funcArgs.getLine() + ", " + funcArgs.getColumn() + ") " + e.getMessage());
        }
    }

}
