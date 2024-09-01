
package lang.visitors;

import lang.ast.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class InterpretVisitor extends Visitor {

    private HashMap<String, Data> datas;
    private Stack<HashMap<String, Object>> env;
    private HashMap<String, Func> funcs;
    private Stack<Object> operands;
    private Stack<Object> parms;
    private boolean retMode;

    public InterpretVisitor() {
        datas = new HashMap<String, Data>();
        env = new Stack<HashMap<String, Object>>();
        env.push(new HashMap<String, Object>());
        funcs = new HashMap<String, Func>();
        operands = new Stack<Object>();
        parms = new Stack<Object>();
        retMode = false;

    }

    @Override
    public void visit(Prog p) {
        Node main = null;

        if (p.getDatas() != null) {
            for (Data data : p.getDatas()) {
                datas.put(data.getId(), data);
            }
        }

        for (Func f : p.getFunctions()) {
            funcs.put(f.getId(), f);
            if (f.getId().equals("main")) {
                main = f;
            }
        }

        if (main == null) {
            throw new RuntimeException("Main não encontrado");
        }

        main.accept(this);
    }

    @Override
    public void visit(Func f) {

        HashMap<String, Object> localEnv = new HashMap<String, Object>();
        if (f.getParameters() != null) {
            Param params = f.getParameters();
            params.accept(this);

            for (int i = 0; i < f.getParameters().size(); i++) {
                localEnv.put(params.getSingleId(i), operands.pop());
            }
        }
        env.push(localEnv);

        for (Cmd command : f.getCommands()) {
            command.accept(this);
            if (retMode) {
                break; // return das funções !evitar loop infinito
            }
        }

        env.pop();
        retMode = false;
    }

    @Override
    public void visit(Param p) {
        try {

            for (Type type : p.getType()) {
                type.accept(this);
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + p.getLine() + ", " + p.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(ArrayType t) {
        try {
            boolean isParam = false;
            if (parms.size() != 0) {
                operands.push(parms.pop());
                isParam = true;
            }
            if (isParam == false) {
                operands.push(t);
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + t.getLine() + ", " + t.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(TyInt t) {
        try {
            boolean isParam = false;
            if (parms.size() != 0) {
                operands.push(parms.pop());
                isParam = true;
            }
            if (isParam == false) {
                operands.push(t);
            }

        } catch (Exception x) {
            throw new RuntimeException(" (" + t.getLine() + ", " + t.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(TyChar t) {
        try {
            boolean isParam = false;
            if (parms.size() != 0) {
                operands.push(parms.pop());
                isParam = true;
            }
            if (isParam == false) {
                operands.push(t);
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + t.getLine() + ", " + t.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(TyBool t) {
        try {
            boolean isParam = false;
            if (parms.size() != 0) {
                operands.push(parms.pop());
                isParam = true;
            }
            if (isParam == false) {
                operands.push(t);
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + t.getLine() + ", " + t.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(TyFloat t) {
        try {
            boolean isParam = false;
            if (parms.size() != 0) {

                operands.push(parms.pop());
                isParam = true;
            }
            if (isParam == false) {
                operands.push(t);
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + t.getLine() + ", " + t.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(NameType n) {
        try {

            boolean isParam = false;
            if (parms.size() != 0) {

                operands.push(parms.pop());
                isParam = true;
            }
            if (isParam == false) {
                operands.push(n);
            }

        } catch (Exception x) {
            throw new RuntimeException(" (" + n.getLine() + ", " + n.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Cmd c) {
        try {

            c.accept(this);
        } catch (Exception x) {
            throw new RuntimeException(" (" + c.getLine() + ", " + c.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(BlockCmd c) {
        if (retMode) {
            return;
        }
        try {
            for (Cmd command : c.getCommands()) {
                command.accept(this);

                if (retMode) {
                    return;
                }
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + c.getLine() + ", " + c.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(If i) {
        try {
            i.getExpr().accept(this);

            if ((boolean) operands.pop()) {
                i.getCmd().accept(this);
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + i.getLine() + ", " + i.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(IfElse i) {
        try {
            i.getExpr().accept(this);

            if ((boolean) operands.pop()) {
                i.getCmd().accept(this);
            } else {
                i.getElseCmd().accept(this);
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + i.getLine() + ", " + i.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Iterate i) {

        try {
            i.getExpr().accept(this);
            Object obj = operands.pop();

            if (obj instanceof Boolean) {

                while ((Boolean) obj) {

                    i.getCmd().accept(this);
                    i.getExpr().accept(this);
                    obj = operands.pop();

                }

            } else if (obj instanceof Integer) {
                for (int j = 0; j < (Integer) obj; j++) {
                    i.getCmd().accept(this);
                }
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + i.getLine() + ", " + i.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Read r) {
        try {

            LValue lvalue = r.getlValue();
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (lvalue instanceof IDLvalue) {
                env.peek().put(((IDLvalue) lvalue).getId(), input);
            } else if (lvalue instanceof Dot) {
                if (((Dot) lvalue).getlValue() instanceof ArrayLValue) {
                    ArrayLValue arrayElement = ((ArrayLValue) ((Dot) lvalue).getlValue());
                    arrayElement.getExpr().accept(this);

                    String nomeAtributo = ((Dot) lvalue).getId();
                    Integer position = (Integer) operands.pop();

                    String nomeArray = arrayElement.getId();

                    List<Object> objetoArray = ((List<Object>) env.peek().get(nomeArray));
                    Integer tamanhoArray = ((List) objetoArray).size();

                    if ((position >= 0) && (position <= tamanhoArray - 1)) {
                        Object elemento = objetoArray.get(position);
                        ((HashMap<String, Object>) elemento).put(nomeAtributo, input);
                    } else {
                        throw new RuntimeException(" (" + r.getLine() + ", " + r.getColumn()
                                + ") Erro: Acesso a uma posicao invalida no array \'" + nomeArray + "\'  !!!");
                    }
                } else {
                    Object obj = env.peek().get(((IDLvalue) ((Dot) lvalue).getlValue()).getId());
                    ((HashMap<String, Object>) obj).put(((Dot) lvalue).getId(), input);

                }
            }
            sc.close();
        } catch (Exception x) {
            throw new RuntimeException(" (" + r.getLine() + ", " + r.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Print i) {
        try {

            i.getExpression().accept(this);

            Object obj = operands.pop();
            System.out.print(obj);
        } catch (Exception e) {
            throw new RuntimeException(" (" + i.getLine() + ", " + i.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Return r) {
        for (Expr exp : r.getExps()) {
            exp.accept(this);
        }
        retMode = true;
    }

    @Override
    public void visit(LvalueCmd a) {
        try {

            a.getExpr().accept(this);

            LValue lvalue = a.getlValue();

            if (lvalue instanceof Dot) {

                if (((Dot) lvalue).getlValue() instanceof ArrayLValue) {
                    ArrayLValue arrayElement = ((ArrayLValue) ((Dot) lvalue).getlValue());
                    arrayElement.getExpr().accept(this);

                    String nomeAtributo = ((Dot) lvalue).getId();
                    String nomeObjeto = ((Dot) lvalue).getDataId();
                    Integer position = (Integer) operands.pop();
                    Integer valorAtribuicao = (Integer) operands.pop();
                    String nomeArray = arrayElement.getId();

                    List<Object> objetoArray = ((List<Object>) env.peek().get(nomeArray));
                    Integer tamanhoArray = ((List) objetoArray).size();

                    if ((position >= 0) && (position <= tamanhoArray - 1)) {
                        Object elemento = objetoArray.get(position);
                        ((HashMap<String, Object>) elemento).put(nomeAtributo, valorAtribuicao);

                    } else {
                        throw new RuntimeException(" (" + a.getLine() + ", " + a.getColumn()
                                + ") Erro: Acesso a uma posicao invalida no array \'" + nomeArray + "\'  !!!");
                    }
                } else {
                    String nomeAtributo = ((Dot) lvalue).getId();
                    String nomeObjeto = ((Dot) lvalue).getDataId();

                    Object atributo = operands.pop();

                    HashMap<String, Object> objetoDinamico = ((HashMap<String, Object>) env.peek().get(nomeObjeto));

                    if (objetoDinamico.get(nomeAtributo) != null) {
                        objetoDinamico.put(nomeAtributo, atributo);
                    } else {

                        throw new RuntimeException(" (" + a.getLine() + ", " + a.getColumn() + ") Erro: Atributo "
                                + "\'" + nomeAtributo + "\'" + " eh inexistente no objeto " + "\"" + nomeObjeto + "\"");
                    }
                }
            } else if (lvalue instanceof IDLvalue) {

                env.peek().put(((IDLvalue) lvalue).getId(), operands.pop());
            } else if (lvalue instanceof ArrayLValue) {

                String nomeArray = ((ArrayLValue) lvalue).getId();
                ((ArrayLValue) lvalue).getExpr().accept(this);
                Integer position = (Integer) operands.pop();

                List<Object> objetoArray = ((List<Object>) env.peek().get(nomeArray));
                Integer tamanhoArray = ((List) objetoArray).size();

                if ((position >= 0) && (position <= tamanhoArray - 1)) {

                    ((List) objetoArray).set(position, operands.pop());
                } else {
                    throw new RuntimeException(" (" + a.getLine() + ", " + a.getColumn()
                            + ") Erro: Acesso a uma posicao invalida no array \'" + nomeArray + "\'  !!!");
                }
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + a.getLine() + ", " + a.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(FuncCall f) {
        try {

            Func function = funcs.get(f.getId());

            if (f != null) {

                if (f.getFCallParams() != null) {

                    for (Expr exp : f.getFCallParams().getExps()) {
                        exp.accept(this);
                        Object obj = (Object) operands.pop();
                        parms.push(obj);

                    }
                }
                function.accept(this);

                if (f.getLValues() != null) {
                    List<LValue> ret = f.getLValues();
                    int it = ret.size() - 1;

                    for (LValue l : ret) {
                        env.peek().put(ret.get(it).getId(), operands.pop());
                        it--;
                    }
                }
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + f.getLine() + ", " + f.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(And a) {
        try {
            a.getLeft().accept(this);
            a.getRight().accept(this);
            boolean right = (Boolean) operands.pop();
            boolean left = (Boolean) operands.pop();
            operands.push(left && right);
        } catch (Exception x) {
            throw new RuntimeException(" (" + a.getLine() + ", " + a.getColumn() + ") " + x.getMessage());
        }
    }

    // Partem do rexp

    @Override
    public void visit(LessThan l) {
        try {
            l.getLeft().accept(this);
            l.getRight().accept(this);
            Object right = operands.pop();
            Object left = operands.pop();
            if (left instanceof Float && right instanceof Float) {
                if (((Float) left) < ((Float) right)) {
                    operands.push(true);
                } else {
                    operands.push(false);
                }
            } else if (left instanceof Integer && right instanceof Integer) {
                if (((Integer) left) < ((Integer) right)) {
                    operands.push(true);
                } else {
                    operands.push(false);
                }
            } else {
                throw new RuntimeException(" (" + l.getLine() + ", " + l.getColumn()
                        + ") : Error: operacao de comparacao menor com \'<\' !!");
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + l.getLine() + ", " + l.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Equals e) {
        try {
            e.getLeft().accept(this);
            e.getRight().accept(this);
            Object right = operands.pop();
            Object left = operands.pop();
            if (left instanceof Boolean && right instanceof Boolean) {
                if (left == right) {
                    operands.push(true);
                } else {
                    operands.push(false);
                }
            } else {
                if (left instanceof Float && right instanceof Float) {
                    if (((Float) left) == ((Float) right)) {
                        operands.push(true);
                    } else {
                        operands.push(false);
                    }
                } else if (left instanceof Integer && right instanceof Integer) {
                    if (((Integer) left) == ((Integer) right)) {
                        operands.push(true);
                    } else {
                        operands.push(false);
                    }
                } else {
                    throw new RuntimeException(" (" + e.getLine() + ", " + e.getColumn()
                            + ") : Error: operacao de igualdade de comparacao usando \'==\' !!");
                }
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + e.getLine() + ", " + e.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(NotEquals n) {
        try {
            n.getLeft().accept(this);
            n.getRight().accept(this);
            Object right = operands.pop();
            Object left = operands.pop();
            if (left instanceof Boolean && right instanceof Boolean) {
                if (left != right) {
                    operands.push(true);
                } else {
                    operands.push(false);
                }
            } else {
                if (left instanceof Float && right instanceof Float) {
                    if (((Float) left) != ((Float) right)) {
                        operands.push(true);
                    } else {
                        operands.push(false);
                    }
                } else if (left instanceof Integer && right instanceof Integer) {
                    if (((Integer) left) != ((Integer) right)) {
                        operands.push(true);
                    } else {
                        operands.push(false);
                    }
                } else {
                    throw new RuntimeException(" (" + n.getLine() + ", " + n.getColumn()
                            + ") : Error: operacao de diferencao na comparacao usando \'!=\' !!");
                }
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + n.getLine() + ", " + n.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Add a) {
        try {
            a.getLeft().accept(this);
            a.getRight().accept(this);
            Object right = operands.pop();
            Object left = operands.pop();

            if (left instanceof Float || right instanceof Float) {
                operands.push((Float) left + (Float) right);

            } else if (left instanceof Integer && right instanceof Integer) {
                operands.push((Integer) left + (Integer) right);

            } else {
                throw new RuntimeException(" (" + a.getLine() + ", " + a.getColumn()
                        + ") : Error: operacao de adicao \'+\' !!");
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + a.getLine() + ", " + a.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Sub s) {
        try {
            s.getLeft().accept(this);
            s.getRight().accept(this);

            Object right = operands.pop();
            Object left = operands.pop();

            if (left instanceof Float || right instanceof Float) {
                operands.push((Float) left - (Float) right);

            } else if (left instanceof Integer && right instanceof Integer) {
                operands.push((Integer) left - (Integer) right);

            } else {
                throw new RuntimeException(" (" + s.getLine() + ", " + s.getColumn()
                        + ") : Error: operacao de subtracao \'-\' !!");
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + s.getLine() + ", " + s.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Mul m) {
        try {
            m.getLeft().accept(this);
            m.getRight().accept(this);

            Object right = operands.pop();
            Object left = operands.pop();

            if (left instanceof Float || right instanceof Float) {
                operands.push((Float) left * (Float) right);

            } else if (left instanceof Integer && right instanceof Integer) {
                operands.push((Integer) left * (Integer) right);

            } else {
                throw new RuntimeException(" (" + m.getLine() + ", " + m.getColumn()
                        + ") : Error: operacao de multiplicacao \'*\' !!");
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + m.getLine() + ", " + m.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Div d) {
        try {
            d.getLeft().accept(this);
            d.getRight().accept(this);

            Object right = operands.pop();
            Object left = operands.pop();
            if (left instanceof Float || right instanceof Float) {
                operands.push((Float) left / (Float) right);
            } else if (left instanceof Integer && right instanceof Integer) {
                operands.push((Integer) left / (Integer) right);
            } else {
                throw new RuntimeException(" (" + d.getLine() + ", " + d.getColumn()
                        + ") : Error: operacao de divisao \'/\' !!");
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + d.getLine() + ", " + d.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Mod m) {
        try {
            m.getLeft().accept(this);
            m.getRight().accept(this);
            Object right = operands.pop();
            Object left = operands.pop();
            if (left instanceof Float || right instanceof Float) {
                operands.push((Float) left % (Float) right);
            } else if (left instanceof Integer && right instanceof Integer) {
                operands.push((Integer) left % (Integer) right);
            } else {
                throw new RuntimeException(" (" + m.getLine() + ", " + m.getColumn()
                        + ") : Error: operacao de divisao modular \'%\' !!");
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + m.getLine() + ", " + m.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Not n) {
        try {
            n.getExpression().accept(this);
            Object valor = operands.pop();
            if (valor instanceof Boolean) {
                operands.push(!(boolean) valor);
            } else {
                throw new RuntimeException(" (" + n.getLine() + ", " + n.getColumn()
                        + ") : Expressao invalida na operacao \'!\' em tipos logicos !!");
            }
        } catch (Exception e) {
            throw new RuntimeException(" (" + n.getLine() + ", " + n.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Neg n) {
        try {
            n.getExpression().accept(this);
            Object valor = operands.pop();
            if (valor instanceof Float) {
                operands.push((Float) valor * -1);
            } else if (valor instanceof Integer) {
                operands.push((Integer) valor * -1);
            } else {
                throw new RuntimeException(" (" + n.getLine() + ", " + n.getColumn()
                        + ") : Expressao invalida na operacao de inversao de sinal numerico \'-\' !!");
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + n.getLine() + ", " + n.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(BoolDexp b) { // True e False
        try {
            operands.push(b.getValue());
        } catch (Exception e) {
            throw new RuntimeException(" (" + b.getLine() + ", " + b.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(Null n) {
        try {
            operands.push(n.getValue());
        } catch (Exception x) {
            throw new RuntimeException(" (" + n.getLine() + ", " + n.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(IntDexp i) {
        try {
            operands.push(i.getValue());
        } catch (Exception e) {
            throw new RuntimeException(" (" + i.getLine() + ", " + i.getColumn() + ") " + e.getMessage());
        }
    }

    @Override
    public void visit(FloatDexp p) {
        try {
            operands.push(p.getValue());
        } catch (Exception x) {
            throw new RuntimeException(" (" + p.getLine() + ", " + p.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(CharDexp c) {
        try {
            operands.push(c.getValue());
        } catch (Exception x) {
            throw new RuntimeException(" (" + c.getLine() + ", " + c.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(NewExp newExp) {
        try {
            if (newExp.getType() != null) {
                if (newExp.getExpr() != null) {
                    newExp.getType().accept(this);
                    newExp.getExpr().accept(this);

                    if (newExp.getType() instanceof NameType) {
                        Integer count = (Integer) operands.pop();
                        Object value = operands.pop();

                        List<Object> objectList = createListWithValues(count, value);
                        operands.push(objectList);
                    } else {
                        Integer count = (Integer) operands.pop();
                        Object value = operands.pop();

                        List<Object> objectList = createListWithValues(count, value);
                        operands.push(objectList);
                    }
                } else {
                    Object defaultValue = new Obj(newExp.getLine(), newExp.getColumn(), newExp.getType());
                    operands.push(defaultValue);
                }
            } else {
                if (newExp.getExpr() == null) {
                    String dataName = newExp.getDataName();
                    HashMap<String, Object> newVariableMap = new HashMap<>();

                    for (Decl declaration : datas.get(dataName).getDeclarations()) {
                        declaration.getType().accept(this);
                        operands.pop();

                        Object defaultObject = new Obj(newExp.getLine(), newExp.getColumn(),
                                declaration.getId(), declaration.getType());
                        newVariableMap.put(declaration.getId(), defaultObject);
                    }
                    operands.push(newVariableMap);
                } else {
                    newExp.getExpr().accept(this);

                    String dataName = newExp.getDataName();
                    Integer count = (Integer) operands.pop();
                    List<Object> objectList = new ArrayList<>(count);

                    for (int i = 0; i < count; i++) {
                        HashMap<String, Object> newVariableMap = new HashMap<>();
                        for (Decl declaration : datas.get(dataName).getDeclarations()) {
                            Object defaultObject = new Obj(newExp.getLine(), newExp.getColumn(),
                                    declaration.getId(), declaration.getType());
                            newVariableMap.put(declaration.getId(), defaultObject);
                        }
                        objectList.add(newVariableMap);
                    }
                    operands.push(objectList);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format(" (%d, %d) %s", newExp.getLine(), newExp.getColumn(), e.getMessage()));
        }
    }

    @Override
    public void visit(FuncRet funcRet) {
        try {

            Func funcao = funcs.get(funcRet.getId());

            if (funcRet != null && funcRet.getFCallParams() != null) {
                for (Expr exp : funcRet.getFCallParams().getExps()) {
                    exp.accept(this);
                    parms.push(operands.pop());
                }
            }

            if (funcao != null) {
                funcao.accept(this);
                IntDexp indiceRetorno = (IntDexp) funcRet.getExpIndex();
                Integer posicaoRetorno = (Integer) indiceRetorno.getValue();
                int numTiposRetorno = funcao.getReturnTypes().size();

                if (numTiposRetorno == 2) {
                    if (posicaoRetorno == 0 || posicaoRetorno == 1) {
                        if (posicaoRetorno == 0) {
                            operands.pop();
                        }
                    } else {
                        throw new RuntimeException(
                                String.format(" (%d, %d) Acesso a uma posição inválida", funcRet.getLine(),
                                        funcRet.getColumn()));
                    }
                }

                else if (numTiposRetorno == 1) {
                    if (posicaoRetorno != 0) {
                        throw new RuntimeException(
                                String.format(" (%d, %d) Acesso a uma posição inválida", funcRet.getLine(),
                                        funcRet.getColumn()));
                    }
                }

                else {
                    throw new RuntimeException(
                            String.format(" (%d, %d) A função não possui tipos de retorno válidos", funcRet.getLine(),
                                    funcRet.getColumn()));
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(
                    String.format(" (%d, %d) %s", funcRet.getLine(), funcRet.getColumn(), ex.getMessage()));
        }
    }

    @Override
    public void visit(LValue l) {

    }

    @Override
    public void visit(ID i) {

    }

    @Override
    public void visit(IDLvalue i) {
        try {

            Object r = env.peek().get(i.getId());
            if (r != null || (r == null && env.peek().containsKey(i.getId()))) {
                operands.push(r);
            } else {

                throw new RuntimeException(
                        " (" + i.getLine() + ", " + i.getColumn() + ") " + ": Erro no IDLvalue !!");
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + i.getLine() + ", " + i.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Dot d) {
        try {

            Object obj = env.peek().get(d.getlValue().getId());
            if (d.getlValue() instanceof ArrayLValue) {

                if (obj != null) {

                    ArrayLValue array = ((ArrayLValue) d.getlValue());
                    array.getExpr().accept(this);
                    Integer position = (Integer) operands.pop();
                    String atributoDoObjeto = d.getId();
                    HashMap objeto = (HashMap) ((List) obj).get(position);

                    if (objeto.containsKey(atributoDoObjeto)) {
                        operands.push(objeto.get(atributoDoObjeto));
                    } else {
                        throw new RuntimeException(" (" + d.getLine() + ", " + d.getColumn() + ") Erro: DotLvalue "
                                + "\'" + d.getId() + "\'" + " obj nao existe " + "\"" + d.getlValue().getId()
                                + "\" !!!");
                    }
                } else {
                    throw new RuntimeException(" (" + d.getLine() + ", " + d.getColumn() + ") Erro: O Objeto " + "\""
                            + d.getlValue().getId() + "\" nao existe!!!");
                }
            } else {
                if (obj != null) {

                    if (((HashMap<String, Object>) obj).containsKey(d.getId())) {
                        operands.push(((HashMap<String, Object>) obj).get(d.getId()));

                    } else {

                        throw new RuntimeException(" (" + d.getLine() + ", " + d.getColumn() + ") Erro: Atributo "
                                + "\'" + d.getId() + "\'" + " eh inexistente no objeto " + "\"" + d.getlValue().getId()
                                + "\" !!!");
                    }
                } else {

                    throw new RuntimeException(" (" + d.getLine() + ", " + d.getColumn() + ") Erro: O Objeto " + "\""
                            + d.getlValue().getId() + "\" nao existe!!!");
                }
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + d.getLine() + ", " + d.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(ArrayLValue a) {
        try {

            Object obj = env.peek().get(a.getlValue().getId());
            if (obj != null) {
                a.getExpr().accept(this);
                Integer position = (Integer) operands.pop();
                Integer tamanhoArray = ((List) obj).size();
                if ((position >= 0) && (position <= tamanhoArray - 1)) {
                    operands.push(((List) obj).get(position));
                } else {
                    throw new RuntimeException(" (" + a.getLine() + ", " + a.getColumn()
                            + ") Erro: Acesso a uma posicao invalida no array \'" + a.getlValue().getId() + "\'  !!!");
                }
            } else {

                throw new RuntimeException(" (" + a.getLine() + ", " + a.getColumn() + ") Erro: O array " + "\""
                        + a.getlValue().getId() + "\" nao existe!!!");
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + a.getLine() + ", " + a.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(CallParam f) {
        try {
            for (Expr expression : f.getExps()) {
                expression.accept(this);
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + f.getLine() + ", " + f.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(Data d) {

    }

    @Override
    public void visit(Decl d) {

    }

    @Override
    public void visit(Type t) {

    }

    private List<Object> createListWithValues(int count, Object value) {
        List<Object> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(value);
        }
        return list;
    }

}