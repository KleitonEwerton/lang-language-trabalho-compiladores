
/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.visitors;

import java.util.ArrayList;
import java.util.List;

import lang.ast.*;
import lang.parser.LangBaseVisitor;
import lang.parser.LangParser.*;

import org.antlr.v4.runtime.tree.ParseTree;

public class MyVisitor extends LangBaseVisitor<Node> {

    /*
     * prog: def* #progName;
     */
    @Override
    public Node visitProgName(ProgNameContext ctx) {

        // Criando um novo objeto Program, similar ao primeiro visitante
        Prog program = new Prog(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());

        // Itera sobre as definições (defs) e visita cada uma
        for (int i = 0; i < (ctx.def().size()) && this.shouldVisitNextChild(ctx, this.defaultResult()); i++) {
            ParseTree childTree = ctx.def(i);
            Node result = this.aggregateResult(this.defaultResult(), childTree.accept(this));

            // Identifica o tipo de Node (Data ou Function) e adiciona ao Program
            if (result instanceof Data) {
                program.addData((Data) result);
            } else if (result instanceof Func) {
                program.addFunction((Func) result);
            }
        }

        return program;
    }

    /*
     * def: data #dataDef
     * | fun #funDef
     * ;
     */
    @Override
    public Node visitDataDef(DataDefContext ctx) {
        return visit(ctx.data());
    }

    @Override
    public Node visitFunDef(FunDefContext ctx) {
        return visit(ctx.fun());
    }

    /*
     * data: TYPE_DATA NAME TYPE_OPEN_BRACE decl* TYPE_CLOSE_BRACE #dataName
     * ;
     */

    @Override
    public Node visitDataName(DataNameContext ctx) {

        String name = ctx.TYPE_NAME().getText();
        List<Decl> decls = new ArrayList<Decl>();

        for (int i = 0; i < ctx.decl().size(); i++) {
            Decl declarationAccept = (Decl) ctx.decl().get(i).accept(this);
            decls.add(declarationAccept);
        }

        return new Data(ctx.start.getLine(), ctx.start.getCharPositionInLine(), name, decls);
    }

    /*
     * decl: ID TYPE_SRO type TYPE_SEMI #declName
     * ;
     */
    @Override
    public Node visitDeclName(DeclNameContext ctx) {

        String id = ctx.ID().getText();
        Type type = (Type) ctx.type().accept(this);
        return new Decl(ctx.start.getLine(), ctx.start.getCharPositionInLine(), id, type);
    }

    /*
     * fun: ID TYPE_OPEN_PARENTHESIS params? TYPE_CLOSE_PARENTHESIS (TYPE_COLON type
     * (TYPE_COMMA type)*)? TYPE_OPEN_BRACE cmd* TYPE_CLOSE_BRACE #funName
     * ;
     */

    @Override
    public Node visitFunName(FunNameContext ctx) {

        // Acessa o ID através de getChild
        String id = ctx.getChild(0).getText(); // Ajuste o índice com base na estrutura real

        // Obtém a linha e a coluna da função
        int line = ctx.start.getLine();
        int col = ctx.start.getCharPositionInLine();

        Func func = new Func(line, col, id);

        // Inicializa os parâmetros e comandos
        Param params;

        if (ctx.params() != null) {
            params = (Param) ctx.params().accept(this);
            func.setParams(params);
        }

        for (int i = 0; i < (ctx.type().size()) && this.shouldVisitNextChild(ctx, this.defaultResult()); i++) {
            ParseTree childTree = ctx.type(i);
            func.addReturnTypes((Type) this.aggregateResult(this.defaultResult(), childTree.accept(this)));
        }

        for (int i = 0; i < (ctx.cmd().size()) && this.shouldVisitNextChild(ctx, this.defaultResult()); i++) {
            ParseTree childTree = ctx.cmd(i);
            func.addCommand((Cmd) this.aggregateResult(this.defaultResult(), childTree.accept(this)));
        }

        return func;
    }

    /*
     * params: ID TYPE_SRO type (TYPE_COMMA ID TYPE_SRO type)* #paramsName
     * ;
     */
    @Override
    public Node visitParamsName(ParamsNameContext ctx) {

        // Criação de listas para armazenar os IDs e tipos dos parâmetros
        List<String> ids = new ArrayList<>();
        List<Type> types = new ArrayList<>();

        // Itera sobre cada par ID TYPE_SRO type presente no contexto
        for (int i = 0; i < ctx.type().size(); i++) {
            ids.add(ctx.ID().get(i).getText());
            types.add((Type) ctx.type().get(i).accept(this));
        }

        // Cria um novo objeto Param usando as listas de IDs e tipos
        Param paramNode = new Param(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ids, types);
        // Retorna o objeto Param criado
        return paramNode;
    }

    /*
     * type: type TYPE_OPEN_BRACKET TYPE_CLOSE_BRACKET #typeName
     * | btype #btypeName
     * ;
     */
    @Override
    public Node visitTypeName(TypeNameContext ctx) {
        // Primeiro, visite o nó filho type para obter o tipo base
        Type baseType = (Type) ctx.type().accept(this);
        // Crie um novo objeto ArrayType, passando o tipo base
        ArrayType arrayType = new ArrayType(ctx.start.getLine(), ctx.start.getCharPositionInLine(), baseType);

        // Retorne o objeto ArrayType criado
        return arrayType;
    }

    @Override
    public Node visitBtypeName(BtypeNameContext ctx) {
        return super.visitBtypeName(ctx);
    }

    /*
     * btype: TYPE_INT #intType
     * | TYPE_CHAR #charType
     * | TYPE_BOOL #boolType
     * | TYPE_FLOAT #floatType
     * | NAME #nameType
     * | ID #idType
     * ;
     */
    @Override
    public Node visitIntType(IntTypeContext ctx) {
        // Cria uma nova instância de IntType com as informações de linha e coluna
        return new TyInt(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Node visitCharType(CharTypeContext ctx) {
        return new TyChar(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Node visitBoolType(BoolTypeContext ctx) {
        return new TyBool(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Node visitFloatType(FloatTypeContext ctx) {
        return new TyFloat(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Node visitNameType(NameTypeContext ctx) {
        // Extrai o nome do contexto e cria uma instância de NameType
        String name = ctx.TYPE_NAME().getText();
        return new NameType(ctx.start.getLine(), ctx.start.getCharPositionInLine(), name);
    }

    /*
     * cmd: TYPE_OPEN_BRACE cmd* TYPE_CLOSE_BRACE #blockCmd
     * | TYPE_IF TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS cmd #ifCmd
     * | TYPE_IF TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS cmd TYPE_ELSE cmd
     * #ifElseCmd
     * | TYPE_ITERATE TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS cmd
     * #iterateCmd
     * | TYPE_READ lvalue TYPE_SEMI #readCmd
     * | TYPE_PRINT exp TYPE_SEMI #printCmd
     * | TYPE_RETURN exp (TYPE_COMMA exp)* TYPE_SEMI #returnCmd
     * | lvalue TYPE_EQUAL exp TYPE_SEMI #lvalueCmd
     * | ID TYPE_OPEN_PARENTHESIS exps TYPE_CLOSE_PARENTHESIS (TYPE_LESS_THAN lvalue
     * (TYPE_COMMA lvalue)* TYPE_GREATER_THAN)? TYPE_SEMI #funcCallCmd
     * ;
     */

    @Override
    public Node visitBlockCmd(BlockCmdContext ctx) {

        // Cria uma lista para armazenar os comandos do bloco
        List<Cmd> cmds = new ArrayList<>();
        // Itera sobre cada comando filho no contexto
        for (int i = 0; i < ctx.cmd().size(); i++) {
            cmds.add((Cmd) ctx.cmd().get(i).accept(this));
        }

        // Cria e retorna uma nova instância de BlockCmd com a lista de comandos
        return new BlockCmd(ctx.start.getLine(), ctx.start.getCharPositionInLine(), cmds);
    }

    @Override
    public Node visitIfCmd(IfCmdContext ctx) {
        // Visitando a expressão condicional dentro do comando if
        Expr condition = (Expr) ctx.exp().accept(this);

        // Visitando o comando que será executado se a condição for verdadeira
        Cmd cmd = (Cmd) ctx.cmd().accept(this);

        // Criando uma nova instância de IfCmd com a expressão e o comando
        return new If(ctx.start.getLine(), ctx.start.getCharPositionInLine(), condition, cmd);
    }

    @Override
    public Node visitIfElseCmd(IfElseCmdContext ctx) {
        // Visitando a expressão condicional
        Expr condition = (Expr) ctx.exp().accept(this);

        // Visitando o comando a ser executado se a condição for verdadeira
        Cmd trueCmd = (Cmd) ctx.cmd(0).accept(this);

        // Visitando o comando a ser executado se a condição for falsa
        Cmd falseCmd = (Cmd) ctx.cmd(1).accept(this);

        // Criando uma nova instância de IfElseCmd com a expressão, comando verdadeiro e
        // comando falso
        return new IfElse(ctx.start.getLine(), ctx.start.getCharPositionInLine(), condition, trueCmd, falseCmd);
    }

    @Override
    public Node visitIterateCmd(IterateCmdContext ctx) {
        // Visitando a expressão condicional para o loop
        Expr condition = (Expr) ctx.exp().accept(this);

        // Visitando o comando a ser repetido enquanto a condição for verdadeira
        Cmd cmd = (Cmd) ctx.cmd().accept(this);

        // Criando uma nova instância de IterateCmd com a expressão e o corpo do loop
        return new Iterate(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.getChild(0).getText(), condition,
                cmd);
    }

    @Override
    public Node visitReadCmd(ReadCmdContext ctx) {
        // Visitando o lvalue onde o valor será armazenado
        LValue lvalue = (LValue) ctx.lvalue().accept(this);

        // Criando uma nova instância de ReadCmd com o lvalue
        return new Read(ctx.start.getLine(), ctx.start.getCharPositionInLine(), lvalue);
    }

    @Override
    public Node visitPrintCmd(PrintCmdContext ctx) {

        // Visitando a expressão que será impressa
        Expr expr = (Expr) ctx.exp().accept(this);

        // Criando uma nova instância de PrintCmd com a expressão
        return new Print(ctx.start.getLine(), ctx.start.getCharPositionInLine(), expr);
    }

    @Override
    public Node visitReturnCmd(ReturnCmdContext ctx) {
        // Criar uma lista para armazenar as expressões retornadas
        List<Expr> exprs = new ArrayList<Expr>();

        // Visitar as expressões adicionais (opcionais)
        for (int i = 0; i < ctx.exp().size(); i++) {
            exprs.add((Expr) ctx.exp(i).accept(this));
        }

        // Criar uma nova instância de ReturnCmd com a lista de expressões
        return new Return(ctx.start.getLine(), ctx.start.getCharPositionInLine(), exprs);
    }

    @Override
    public Node visitLvalueCmd(LvalueCmdContext ctx) {
        // Visitar o lvalue
        LValue lvalue = (LValue) ctx.lvalue().accept(this);

        // Visitar a expressão que será atribuída
        Expr expr = (Expr) ctx.exp().accept(this);

        // Criar uma nova instância de LvalueCmd com o lvalue e a expressão
        return new LvalueCmd(ctx.start.getLine(), ctx.start.getCharPositionInLine(), lvalue, expr);
    }

    @Override
    public Node visitFuncCallCmd(FuncCallCmdContext ctx) {

        // Obter o identificador da função
        String id = ctx.ID().getText();
        FuncCallCmd funcCallCmd = new FuncCallCmd(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                id);

        if (ctx.exps() != null) {
            FuncArgs exps = (FuncArgs) ctx.exps().accept(this);

            funcCallCmd = new FuncCallCmd(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                    id, exps);
        }

        for (int i = 0; i < ctx.lvalue().size() && this.shouldVisitNextChild(ctx, this.defaultResult()); i++) {
            ParseTree childTree = ctx.lvalue(i);
            funcCallCmd.addLValue((LValue) this.aggregateResult(this.defaultResult(), childTree.accept(this)));
        }
        return funcCallCmd;
    }

    /*
     * exp: exp TYPE_AND exp #andExp
     * | cexpr #cexprExp
     * ;
     */

    @Override
    public Node visitAndExp(AndExpContext ctx) {
        // Visitar as expressões à esquerda e à direita do operador &&
        Expr left = (Expr) ctx.getChild(0).accept(this);
        Expr right = (Expr) ctx.getChild(2).accept(this);

        // Criar uma nova instância de AndExp com a linha e a coluna atuais
        return new And(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitCexprExp(CexprExpContext ctx) {
        return super.visitCexprExp(ctx);
    }

    /*
     * cexpr: baexp TYPE_LESS_THAN baexp #lessThanCexpr
     * | cexpr TYPE_EQUAL_EQUAL baexp #equalsCexpr
     * | cexpr TYPE_NO_EQUAL baexp #notEqualsCexpr
     * | baexp #baexpCexpr
     * ;
     */
    @Override
    public Node visitLessThanCexpr(LessThanCexprContext ctx) {
        // Visitar as expressões à esquerda e à direita do operador <
        Expr left = (Expr) ctx.baexp(0).accept(this);
        Expr right = (Expr) ctx.baexp(1).accept(this);

        // Criar uma nova instância de LessThanCexpr com a linha e a coluna atuais
        return new LessThan(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitEqualsCexpr(EqualsCexprContext ctx) {

        // Visitar a expressão à esquerda (cexpr)
        Expr left = (Expr) ctx.cexpr().accept(this);

        // Visitar a expressão à direita (baexp)
        Expr right = (Expr) ctx.baexp().accept(this);

        // Criar uma nova instância de EqualsCexpr com a linha e a coluna atuais
        return new Equals(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitNotEqualsCexpr(NotEqualsCexprContext ctx) {
        // Visitar a expressão à esquerda (cexpr)
        Expr left = (Expr) ctx.cexpr().accept(this);

        // Visitar a expressão à direita (baexp)
        Expr right = (Expr) ctx.baexp().accept(this);

        // Criar uma nova instância de NotEqualsCexpr com a linha e a coluna atuais
        return new NotEquals(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitBaexpCexpr(BaexpCexprContext ctx) {
        return super.visitBaexpCexpr(ctx);
    }

    /*
     * baexp: baexp TYPE_PLUS opexp #addBaexp
     * | baexp TYPE_MINUS opexp #subBaexp
     * | opexp #opexpBaexp
     * ;
     */
    @Override
    public Node visitAddBaexp(AddBaexpContext ctx) {

        Expr left = (Expr) ctx.baexp().accept(this);
        Expr right = (Expr) ctx.opexp().accept(this);

        return new Add(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitSubBaexp(SubBaexpContext ctx) {

        Expr left = (Expr) ctx.baexp().accept(this);
        Expr right = (Expr) ctx.opexp().accept(this);

        return new Sub(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitOpexpBaexp(OpexpBaexpContext ctx) {
        return super.visitOpexpBaexp(ctx);
    }

    /*
     * opexp: opexp TYPE_ASTERISK dexp #mulOpexp
     * | opexp TYPE_DIV dexp #divOpexp
     * | opexp TYPE_MOD dexp #modOpexp
     * | dexp #dexpOpexp
     * ;
     */

    @Override
    public Node visitMulOpexp(MulOpexpContext ctx) {

        Expr left = (Expr) ctx.opexp().accept(this);
        Expr right = (Expr) ctx.dexp().accept(this);

        return new Mul(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitDivOpexp(DivOpexpContext ctx) {

        Expr left = (Expr) ctx.opexp().accept(this);
        Expr right = (Expr) ctx.dexp().accept(this);

        return new Div(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitModOpexp(ModOpexpContext ctx) {

        // Visitar a expressão à esquerda (opexp)
        Expr left = (Expr) ctx.opexp().accept(this);

        // Visitar a expressão à direita (dexp)
        Expr right = (Expr) ctx.dexp().accept(this);

        // Criar uma nova instância de ModOpexp com a linha e a coluna atuais

        return new Mod(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitDexpOpexp(DexpOpexpContext ctx) {

        return super.visitDexpOpexp(ctx);
    }

    /*
     * dexp: TYPE_EXCLAMATION dexp #notDexp
     * | TYPE_MINUS dexp #negDexp
     * | TYPE_TRUE #trueDexp
     * | TYPE_FALSE #falseDexp
     * | TYPE_NULL #nullDexp
     * | INT #intDexp
     * | FLOAT #floatDexp
     * | CHAR #charDexp
     * | rexp #rexpDexp
     * ;
     */
    @Override
    public Node visitNotDexp(NotDexpContext ctx) {

        // Visitar a expressão que está sendo negada
        Expr expr = (Expr) ctx.getChild(1).accept(this);

        // Criar uma nova instância de NotDexp com a linha e a coluna atuais
        return new Not(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), expr);
    }

    @Override
    public Node visitNegDexp(NegDexpContext ctx) {
        // Obtém a expressão que está sendo negada
        Expr expr = (Expr) ctx.getChild(1).accept(this);

        // Cria uma instância de NegDexp usando a expressão e as informações de linha e
        // coluna
        return new Neg(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), expr);
    }

    @Override
    public Node visitTrueDexp(TrueDexpContext ctx) {
        // Cria uma instância de TrueDexp usando as informações de linha e coluna
        return new True(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Node visitFalseDexp(FalseDexpContext ctx) {
        // Cria uma instância de TrueDexp usando as informações de linha e coluna
        return new False(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Node visitNullDexp(NullDexpContext ctx) {
        // Cria uma instância de TrueDexp usando as informações de linha e coluna
        return new Null(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Node visitIntDexp(IntDexpContext ctx) {
        // Obtém o valor do inteiro do contexto
        int value = Integer.parseInt(ctx.INT().getText());

        // Cria uma instância de IntDexp usando a linha e coluna do token
        return new IntDexp(ctx.start.getLine(), ctx.start.getCharPositionInLine(), value);
    }

    @Override
    public Node visitFloatDexp(FloatDexpContext ctx) {

        // Obtém o valor do float do contexto
        float value = Float.parseFloat(ctx.FLOAT().getText());

        // Cria uma instância de FloatDexp usando a linha e coluna do token
        return new FloatDexp(ctx.start.getLine(), ctx.start.getCharPositionInLine(), value);
    }

    @Override
    public Node visitCharDexp(CharDexpContext ctx) {

        // Obtém o texto do token CHAR e remove as aspas simples ao redor
        String charText = ctx.CHAR().getText();

        // Cria uma instância de CharDexp usando a linha e coluna do token
        return new CharDexp(ctx.start.getLine(), ctx.start.getCharPositionInLine(), charText);
    }

    @Override
    public Node visitRexpDexp(RexpDexpContext ctx) {

        return super.visitRexpDexp(ctx);
    }

    /*
     * rexp: lvalue #lvalueRexp
     * | TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS #parenRexp
     * | TYPE_NEW type (TYPE_OPEN_BRACKET exp TYPE_CLOSE_BRACKET)? #newRexp
     * | ID TYPE_OPEN_PARENTHESIS exps? TYPE_CLOSE_PARENTHESIS TYPE_OPEN_BRACKET exp
     * TYPE_CLOSE_BRACKET #funcCallRexp
     * ;
     */
    @Override
    public Node visitLvalueRexp(LvalueRexpContext ctx) {
        return super.visitLvalueRexp(ctx);
    }

    @Override
    public Node visitParenRexp(ParenRexpContext ctx) {
        Expr expr = (Expr) ctx.exp().accept(this);
        return expr;
    }

    @Override
    public Node visitNewRexp(NewRexpContext ctx) {

        if (ctx.type().accept(this) instanceof NameType) {

            if (ctx.exp() != null) {
                Expr exp = (Expr) ctx.exp().accept(this);

                return new NewExp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), exp,
                        ctx.type().getText());
            } else {
                return new NewExp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                        ctx.type().getText());
            }
        }

        if (ctx.exp() != null) {
            Expr exp = (Expr) ctx.exp().accept(this);
            Type type = (Type) ctx.type().accept(this);

            return new NewExp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), exp, type);
        } else {
            Type type = (Type) ctx.type().accept(this);
            return new NewExp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), type);
        }
    }

    @Override
    public Node visitFuncCallRexp(FuncCallRexpContext ctx) {
        // Obtendo o nome da função
        String id = ctx.ID().getText();

        FuncArgs funcArgs = (FuncArgs) ctx.exps().accept(this);

        // Obtendo o tamanho do array
        Expr expr = (Expr) ctx.exp().accept(this);

        // Criando e retornando uma nova instância de FuncCallExp
        return new FuncCall(ctx.start.getLine(), ctx.start.getCharPositionInLine(), id, funcArgs,
                expr);
    }

    /*
     * lvalue: ID #idLvalue
     * | lvalue TYPE_OPEN_BRACKET exp TYPE_CLOSE_BRACKET #arrayLvalue
     * | lvalue TYPE_DOT ID #dotLvalue
     * ;
     */

    @Override
    public Node visitIdLvalue(IdLvalueContext ctx) {

        // Obtendo o identificador do contexto
        String id = ctx.ID().getText();

        // Retornando o nó criado
        return new IdLValue(ctx.start.getLine(), ctx.start.getCharPositionInLine(), id);
    }

    @Override
    public Node visitArrayLvalue(ArrayLvalueContext ctx) {

        // Visitando o lvalue base (parte antes do [])
        LValue lValue = (LValue) ctx.lvalue().accept(this);

        // Visitando a expressão dentro dos colchetes (índice do array)
        Expr expr = (Expr) ctx.exp().accept(this);

        // Retornando o nó criado
        return new ArrayLValue(ctx.start.getLine(), ctx.start.getCharPositionInLine(), lValue, expr);
    }

    @Override
    public Node visitDotLvalue(DotLvalueContext ctx) {

        // Visitando o lvalue base (parte antes do .)
        LValue lValue = (LValue) ctx.lvalue().accept(this);

        // Obtendo o nome do campo (ID após o .)
        String name = ctx.ID().getText();

        String data = ctx.lvalue().getText();

        // Retornando o nó criado
        return new Dot(ctx.start.getLine(), ctx.start.getCharPositionInLine(), lValue, name, data);
    }

    /*
     * exps: exp (TYPE_COMMA exp)* #expsName
     * ;
     */
    @Override
    public Node visitExpsName(ExpsNameContext ctx) {

        FuncArgs funcArgs = new FuncArgs(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        List<Expr> exps = new ArrayList<>();

        for (int i = 0; i < ctx.exp().size(); i++) {
            exps.add((Expr) ctx.exp().get(i).accept(this));
        }
        funcArgs.setExprs(exps);
        return funcArgs;
    }
}