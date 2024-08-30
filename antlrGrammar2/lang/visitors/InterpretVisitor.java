
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
    public void visit(TypeInt t) {
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
    public void visit(TypeChar t) {
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
    public void visit(TypeBool t) {
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
    public void visit(TypeFloat t) {
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
    public void visit(Type t) {

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
    public void visit(CmdsList c) {
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
            i.getExp().accept(this);

            // Desempilha os operandos com "parametro" do if
            if ((boolean) operands.pop()) {
                i.getCmd().accept(this); // Verifica se o corpo de comandos do if é aceito
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + i.getLine() + ", " + i.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(IfElse i) {
        try {
            i.getExp().accept(this);

            // Desempilha os operandos com "parametro" do if
            if ((boolean) operands.pop()) {
                i.getCmd().accept(this); // Verifica se o corpo de comandos do if é aceito
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

            i.getExp().accept(this);
            Object obj = operands.pop();
            if (obj instanceof Boolean) {
                do {
                    i.getCmd().accept(this);
                    i.getExp().accept(this);
                    obj = operands.pop();
                } while ((Boolean) obj);
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

            LValue lvalue = r.getLValue();
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (lvalue instanceof IDLvalue) {
                env.peek().put(((IDLvalue) lvalue).getId(), input);
            } else if (lvalue instanceof DotLvalue) {
                if (((DotLvalue) lvalue).getLValue() instanceof ArrayLValue) {
                    ArrayLValue arrayElement = ((ArrayLValue) ((DotLvalue) lvalue).getLValue());
                    arrayElement.getExp().accept(this);

                    String nomeAtributo = ((DotLvalue) lvalue).getId();
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
                    Object obj = env.peek().get(((IDLvalue) ((DotLvalue) lvalue).getLValue()).getId());
                    ((HashMap<String, Object>) obj).put(((DotLvalue) lvalue).getId(), input);

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
        for (Expression exp : r.getExps()) {
            exp.accept(this);
        }
        retMode = true;
    }

    @Override
    public void visit(Attr a) {
        try {

            a.getExp().accept(this);

            LValue lvalue = a.getLValue();

            if (lvalue instanceof DotLvalue) {

                if (((DotLvalue) lvalue).getLValue() instanceof ArrayLValue) {
                    ArrayLValue arrayElement = ((ArrayLValue) ((DotLvalue) lvalue).getLValue());
                    arrayElement.getExp().accept(this);

                    String nomeAtributo = ((DotLvalue) lvalue).getId();
                    String nomeObjeto = ((DotLvalue) lvalue).getDataId();
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
                    String nomeAtributo = ((DotLvalue) lvalue).getId();
                    String nomeObjeto = ((DotLvalue) lvalue).getDataId();

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
                ((ArrayLValue) lvalue).getExp().accept(this);
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
    public void visit(FunctionCall f) {
        try {

            Func function = funcs.get(f.getId());

            if (f != null) {

                if (f.getFCallParams() != null) {

                    for (Expression exp : f.getFCallParams().getExps()) {
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
                        + ") : Expressoes invalidas na operacao de comparacao menor com \'<\' !!");
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
                            + ") : Expressoes invalidas na operacao de igualdade de comparacao usando \'==\' !!");
                }
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + e.getLine() + ", " + e.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(NotEqual n) {
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
                            + ") : Expressoes invalidas na operacao de diferencao na comparacao usando \'!=\' !!");
                }
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + n.getLine() + ", " + n.getColumn() + ") " + x.getMessage());
        }
    }

    // Partem do aexp

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
                        + ") : Expressoes invalidas na operacao de adicao \'+\' !!");
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
            // Primeiro é empilhado da esquerda pra direita, logo, o topo da pilha
            // é o operando da direita
            Object right = operands.pop();
            Object left = operands.pop();
            if (left instanceof Float || right instanceof Float) {
                operands.push((Float) left - (Float) right);
            } else if (left instanceof Integer && right instanceof Integer) {
                operands.push((Integer) left - (Integer) right);
            } else {
                throw new RuntimeException(" (" + s.getLine() + ", " + s.getColumn()
                        + ") : Expressoes invalidas na operacao de subtracao \'-\' !!");
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + s.getLine() + ", " + s.getColumn() + ") " + x.getMessage());
        }
    }

    // Partem do mexp
    @Override
    public void visit(Mul m) {
        try {
            m.getLeft().accept(this);
            m.getRight().accept(this);
            // Primeiro é empilhado da esquerda pra direita, logo, o topo da pilha
            // é o operando da direita
            Object right = operands.pop();
            Object left = operands.pop();
            if (left instanceof Float || right instanceof Float) {
                operands.push((Float) left * (Float) right);
            } else if (left instanceof Integer && right instanceof Integer) {
                operands.push((Integer) left * (Integer) right);
            } else {
                throw new RuntimeException(" (" + m.getLine() + ", " + m.getColumn()
                        + ") : Expressoes invalidas na operacao de multiplicacao \'*\' !!");
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
            // Primeiro é empilhado da esquerda pra direita, logo, o topo da pilha
            // é o operando da direita
            Object right = operands.pop();
            Object left = operands.pop();
            if (left instanceof Float || right instanceof Float) {
                operands.push((Float) left / (Float) right);
            } else if (left instanceof Integer && right instanceof Integer) {
                operands.push((Integer) left / (Integer) right);
            } else {
                throw new RuntimeException(" (" + d.getLine() + ", " + d.getColumn()
                        + ") : Expressoes invalidas na operacao de divisao \'/\' !!");
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
                        + ") : Expressoes invalidas na operacao de divisao modular \'%\' !!");
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + m.getLine() + ", " + m.getColumn() + ") " + x.getMessage());
        }
    }

    // Partem do sexp

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
    public void visit(Min n) {
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

    // Partem do pexp

    @Override
    public void visit(PexpIdentifier i) {

    }

    @Override
    public void visit(ExpParenthesis e) {

    }

    @Override
    public void visit(NewExp t) {
        try {

            if (t.getType() != null) {
                if (t.getExp() != null) {
                    t.getType().accept(this);
                    t.getExp().accept(this);

                    if (t.getType() instanceof NameType) {

                        Integer i = (Integer) operands.pop();

                        Object obj = operands.pop();

                        List<Object> lista = new ArrayList<Object>(i);
                        for (int k = 0; k < i; k++) {
                            lista.add(obj);
                        }
                        operands.push(lista);
                    } else {

                        Integer i = (Integer) operands.pop();

                        Object obj = operands.pop();
                        List<Object> lista = new ArrayList<Object>(i);
                        for (int k = 0; k < i; k++) {
                            lista.add(obj);
                        }
                        operands.push(lista);
                    }
                } else {

                    Object valorPadrao = new Obj(t.getLine(), t.getColumn(), t.getType());
                    operands.push(valorPadrao);
                }
            } else {
                if (t.getExp() == null) {

                    String dataID = t.getDataName();

                    HashMap<String, Object> newVar = new HashMap<String, Object>();

                    for (Decl d : datas.get(dataID).getDeclarations()) {

                        d.getType().accept(this);

                        operands.pop();

                        Object valorPadrao = new Obj(t.getLine(), t.getColumn(),
                                d.getId(), d.getType());

                        newVar.put(d.getId(), valorPadrao);
                    }
                    operands.push(newVar);
                } else {
                    t.getExp().accept(this);

                    String dataID = t.getDataName();

                    Integer i = (Integer) operands.pop();

                    List<Object> lista = new ArrayList<Object>(i);

                    for (int k = 0; k < i; k++) {

                        HashMap<String, Object> newVar = new HashMap<String, Object>();
                        for (Decl d : datas.get(dataID).getDeclarations()) {

                            Object valorPadrao = new Obj(t.getLine(), t.getColumn(),
                                    d.getId(), d.getType());

                            newVar.put(d.getId(), valorPadrao);
                        }
                        lista.add(newVar);
                    }
                    operands.push(lista);
                }
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + t.getLine() + ", " + t.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(FunctionReturn f) {

        try {

            Func function = funcs.get(f.getId());

            if (f != null) {
                if (f.getFCallParams() != null) {

                    for (Expression exp : f.getFCallParams().getExps()) {
                        exp.accept(this);
                        Object obj = (Object) operands.pop();
                        parms.push(obj);

                    }
                }

                function.accept(this);
                IntDexp valueReturnedPos = (IntDexp) f.getExpIndex();

                if (function.getReturnTypes().size() == 2) {
                    if ((Integer) valueReturnedPos.getValue() == 0 ||
                            (Integer) valueReturnedPos.getValue() == 1) {
                        if ((Integer) valueReturnedPos.getValue() == 0) {
                            operands.pop();
                        }

                    } else {
                        throw new RuntimeException(" (" + f.getLine() + ", " + f.getColumn()
                                + ") Acesso a posicao invalida de elemento no retorno da funcao");
                    }
                } else if (function.getReturnTypes().size() == 1) {
                    if ((Integer) valueReturnedPos.getValue() == 0) {

                    } else {
                        throw new RuntimeException(" (" + f.getLine() + ", " + f.getColumn()
                                + ") Acesso a posicao invalida de elemento no retorno da funcao");
                    }
                } else {
                    throw new RuntimeException(" (" + f.getLine() + ", " + f.getColumn()
                            + ") A funcao nao apresenta tipos de retorno");
                }
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + f.getLine() + ", " + f.getColumn() + ") " + x.getMessage());
        }

    }

    // Partem do lvalue

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
    public void visit(DotLvalue d) {
        try {

            Object obj = env.peek().get(d.getLValue().getId());
            if (d.getLValue() instanceof ArrayLValue) {

                if (obj != null) {

                    ArrayLValue array = ((ArrayLValue) d.getLValue());
                    array.getExp().accept(this);
                    Integer position = (Integer) operands.pop();
                    String atributoDoObjeto = d.getId();
                    HashMap objeto = (HashMap) ((List) obj).get(position);

                    if (objeto.containsKey(atributoDoObjeto)) {
                        operands.push(objeto.get(atributoDoObjeto));
                    } else {
                        throw new RuntimeException(" (" + d.getLine() + ", " + d.getColumn() + ") Erro: DotLvalue "
                                + "\'" + d.getId() + "\'" + " obj nao existe " + "\"" + d.getLValue().getId()
                                + "\" !!!");
                    }
                } else {
                    throw new RuntimeException(" (" + d.getLine() + ", " + d.getColumn() + ") Erro: O Objeto " + "\""
                            + d.getLValue().getId() + "\" nao existe!!!");
                }
            } else {
                if (obj != null) {

                    if (((HashMap<String, Object>) obj).containsKey(d.getId())) {
                        operands.push(((HashMap<String, Object>) obj).get(d.getId()));

                    } else {

                        throw new RuntimeException(" (" + d.getLine() + ", " + d.getColumn() + ") Erro: Atributo "
                                + "\'" + d.getId() + "\'" + " eh inexistente no objeto " + "\"" + d.getLValue().getId()
                                + "\" !!!");
                    }
                } else {

                    throw new RuntimeException(" (" + d.getLine() + ", " + d.getColumn() + ") Erro: O Objeto " + "\""
                            + d.getLValue().getId() + "\" nao existe!!!");
                }
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + d.getLine() + ", " + d.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(ArrayLValue a) {
        try {

            Object obj = env.peek().get(a.getLValue().getId());
            if (obj != null) {
                a.getExp().accept(this);
                Integer position = (Integer) operands.pop();
                Integer tamanhoArray = ((List) obj).size();
                if ((position >= 0) && (position <= tamanhoArray - 1)) {
                    operands.push(((List) obj).get(position));
                } else {
                    throw new RuntimeException(" (" + a.getLine() + ", " + a.getColumn()
                            + ") Erro: Acesso a uma posicao invalida no array \'" + a.getLValue().getId() + "\'  !!!");
                }
            } else {

                throw new RuntimeException(" (" + a.getLine() + ", " + a.getColumn() + ") Erro: O array " + "\""
                        + a.getLValue().getId() + "\" nao existe!!!");
            }
        } catch (Exception x) {
            throw new RuntimeException(" (" + a.getLine() + ", " + a.getColumn() + ") " + x.getMessage());
        }
    }

    @Override
    public void visit(CallParam f) {
        try {
            for (Expression expression : f.getExps()) {
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
}