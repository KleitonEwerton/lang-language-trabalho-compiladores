package lang.visitors;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lang.parser.*;
import lang.ast.*;

public class MyVisitor extends langBaseVisitor<Node> {

    @Override
    public Node visitProgName(langParser.ProgNameContext ctx) {
        // Método visitChildren visita todos os filhos do nó prog
        System.out.println("Visitando ProgName");

        List<Node> defs = new ArrayList<>();
        for (langParser.DefContext defCtx : ctx.def()) {
            defs.add(visit(defCtx));
        }
        return new Prog(ctx.start.getLine(), ctx.start.getCharPositionInLine(), defs);
    }

    @Override
    public Node visitDataDef(langParser.DataDefContext ctx) {
        return visit(ctx.data());
    }

    @Override
    public Node visitFunDef(langParser.FunDefContext ctx) {
        System.out.println("Visitando FunDef visitor");
        return visit(ctx.fun());
    }

    @Override
    public Node visitDataName(langParser.DataNameContext ctx) {
        String name = ctx.NAME().getText();
        List<Decl> decls = new ArrayList<>();

        for (langParser.DeclContext declCtx : ctx.decl()) {
            decls.add((Decl) visit(declCtx));
        }
        return new Data(ctx.start.getLine(), ctx.start.getCharPositionInLine(), name, decls);
    }

    @Override
    public Node visitDeclName(langParser.DeclNameContext ctx) {
        String id = ctx.ID().getText();
        Type type = (Type) visit(ctx.type());
        return new Decl(ctx.start.getLine(), ctx.start.getCharPositionInLine(), id, type);
    }

    @Override
    public Node visitFunName(langParser.FunNameContext ctx) {

        // Acessa o ID através de getChild
        String id = ctx.getChild(0).getText(); // Ajuste o índice com base na estrutura real

        // Obtém a linha e a coluna da função
        int line = ctx.start.getLine();
        int col = ctx.start.getCharPositionInLine();

        // Inicializa os parâmetros e comandos
        Param params = null;
        List<Cmd> commands = new ArrayList<>();
        List<Type> additionalTypes = new ArrayList<>();

        // Verifica se há parâmetros e os extrai, se existirem
        if (ctx.params() != null) {

            params = (Param) visit(ctx.params());
        }

        // Verifica se há tipos adicionais e os extrai, se existirem
        if (ctx.type() != null) {
            for (int i = 1; i < ctx.type().size(); i++) {
                additionalTypes.add((Type) visit(ctx.type(i)));
            }
        }

        // Extrai e cria a lista de comandos
        if (ctx.cmd() != null) {
            for (langParser.CmdContext cmdCtx : ctx.cmd()) {
                commands.add((Cmd) visit(cmdCtx));
            }
        }

        // Cria a nova instância de Func com base nos dados extraídos
        Func func;
        if (params != null) {
            func = new Func(line, col, id, params);
        } else {
            func = new Func(line, col, id);
        }

        func.setAdditionalTypes(additionalTypes);
        func.setCommands(commands);

        System.out.println(func.toString());
        return func;
    }

    @Override
    public Node visitParamsName(langParser.ParamsNameContext ctx) {
        // Criação de listas para armazenar os IDs e tipos dos parâmetros
        List<String> ids = new ArrayList<>();
        List<Type> types = new ArrayList<>();

        // Itera sobre cada par ID TYPE_SRO type presente no contexto
        for (int i = 0; i < ctx.ID().size(); i++) {
            // Adiciona o ID à lista de IDs
            ids.add(ctx.ID(i).getText());

            // Visita o nó type correspondente e adiciona à lista de tipos
            Type type = (Type) visit(ctx.type(i));
            types.add(type);
        }
        // Cria um novo objeto Param usando as listas de IDs e tipos
        Param paramNode = new Param(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ids, types);

        // Retorna o objeto Param criado
        return paramNode;

    }

    @Override
    public Node visitTypeName(langParser.TypeNameContext ctx) {

        // Primeiro, visite o nó filho `type` para obter o tipo base
        Type baseType = (Type) visit(ctx.type());
        // Crie um novo objeto ArrayType, passando o tipo base
        ArrayType arrayType = new ArrayType(ctx.start.getLine(), ctx.start.getCharPositionInLine(), baseType);

        // Retorne o objeto ArrayType criado
        return arrayType;
    }

    @Override
    public Node visitBtypeName(langParser.BtypeNameContext ctx) {
        return super.visitBtypeName(ctx);
    }

    @Override
    public Node visitIntType(langParser.IntTypeContext ctx) {
        // Cria uma nova instância de IntType com as informações de linha e coluna
        return new TyInt(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Node visitCharType(langParser.CharTypeContext ctx) {
        return new TyChar(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Node visitBoolType(langParser.BoolTypeContext ctx) {
        return new TyBool(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Node visitFloatType(langParser.FloatTypeContext ctx) {
        return new TyFloat(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Node visitNameType(langParser.NameTypeContext ctx) {
        // Extrai o nome do contexto e cria uma instância de NameType
        String name = ctx.NAME().getText();
        return new NameType(ctx.start.getLine(), ctx.start.getCharPositionInLine(), name);
    }

    @Override
    public Node visitIdType(langParser.IdTypeContext ctx) {
        // Extrai o ID do contexto e cria uma instância de IdType
        String id = ctx.ID().getText();
        return new IdType(ctx.start.getLine(), ctx.start.getCharPositionInLine(), id);
    }

    @Override
    public Node visitBlockCmd(langParser.BlockCmdContext ctx) {
        // Cria uma lista para armazenar os comandos do bloco
        List<Cmd> cmds = new ArrayList<>();

        // Itera sobre cada comando filho no contexto
        for (langParser.CmdContext cmdCtx : ctx.cmd()) {
            // Visita o comando filho e adiciona o resultado à lista de comandos
            Cmd cmd = (Cmd) visit(cmdCtx);
            cmds.add(cmd);
        }

        // Cria e retorna uma nova instância de BlockCmd com a lista de comandos
        return new BlockCmd(ctx.start.getLine(), ctx.start.getCharPositionInLine(), cmds);
    }

    @Override
    public Node visitIfCmd(langParser.IfCmdContext ctx) {
        // Visitando a expressão condicional dentro do comando if
        Expr condition = (Expr) visit(ctx.exp());

        // Visitando o comando que será executado se a condição for verdadeira
        Cmd cmd = (Cmd) visit(ctx.cmd());

        // Criando uma nova instância de IfCmd com a expressão e o comando
        return new If(ctx.start.getLine(), ctx.start.getCharPositionInLine(), condition, cmd);
    }

    @Override
    public Node visitIfElseCmd(langParser.IfElseCmdContext ctx) {
        // Visitando a expressão condicional
        Expr condition = (Expr) visit(ctx.exp());

        // Visitando o comando a ser executado se a condição for verdadeira
        Cmd trueCmd = (Cmd) visit(ctx.cmd(0));

        // Visitando o comando a ser executado se a condição for falsa
        Cmd falseCmd = (Cmd) visit(ctx.cmd(1));

        // Criando uma nova instância de IfElseCmd com a expressão, comando verdadeiro e
        // comando falso
        return new IfElse(ctx.start.getLine(), ctx.start.getCharPositionInLine(), condition, trueCmd, falseCmd);
    }

    @Override
    public Node visitIterateCmd(langParser.IterateCmdContext ctx) {
        // Visitando a expressão condicional para o loop
        Expr condition = (Expr) visit(ctx.exp());

        // Visitando o comando a ser repetido enquanto a condição for verdadeira
        Cmd cmd = (Cmd) visit(ctx.cmd());

        // Criando uma nova instância de IterateCmd com a expressão e o corpo do loop
        return new Iterate(ctx.start.getLine(), ctx.start.getCharPositionInLine(), condition, cmd);
    }

    @Override
    public Node visitReadCmd(langParser.ReadCmdContext ctx) {
        // Visitando o lvalue onde o valor será armazenado
        LValue lvalue = (LValue) visit(ctx.lvalue());

        // Criando uma nova instância de ReadCmd com o lvalue
        return new Read(ctx.start.getLine(), ctx.start.getCharPositionInLine(), lvalue);

    }

    @Override
    public Node visitPrintCmd(langParser.PrintCmdContext ctx) {
        // Visitando a expressão que será impressa
        Expr expr = (Expr) visit(ctx.exp());

        // Criando uma nova instância de PrintCmd com a expressão
        return new Print(ctx.start.getLine(), ctx.start.getCharPositionInLine(), expr);
    }

    @Override
    public Node visitReturnCmd(langParser.ReturnCmdContext ctx) {
        // Criar uma lista para armazenar as expressões retornadas
        List<Expr> exprs = new ArrayList<Expr>();

        // Visitar a primeira expressão (obrigatória)
        exprs.add((Expr) visit(ctx.exp(0)));

        // Visitar as expressões adicionais (opcionais)
        for (int i = 1; i < ctx.exp().size(); i++) {
            exprs.add((Expr) visit(ctx.exp(i)));
        }

        // Criar uma nova instância de ReturnCmd com a lista de expressões
        return new Return(ctx.start.getLine(), ctx.start.getCharPositionInLine(), exprs);
    }

    @Override
    public Node visitLvalueCmd(langParser.LvalueCmdContext ctx) {
        // Visitar o lvalue
        LValue lvalue = (LValue) visit(ctx.lvalue());

        // Visitar a expressão que será atribuída
        Expr expr = (Expr) visit(ctx.exp());

        // Criar uma nova instância de LvalueCmd com o lvalue e a expressão
        return new LvalueCmd(ctx.start.getLine(), ctx.start.getCharPositionInLine(), lvalue, expr);
    }

    @Override
    public Node visitFuncCallCmd(langParser.FuncCallCmdContext ctx) {
        // Obter o identificador da função
        String id = ctx.ID().getText();

        // Criar a lista de argumentos
        List<Expr> exprs = new ArrayList<>();
        for (ParseTree child : ctx.exps().children) {
            if (child instanceof langParser.ExpContext) {
                exprs.add((Expr) visit(child));
            }
        }

        // Criar a lista de variáveis genéricas (se houver)
        List<LValue> lvalues = null;
        if (ctx.lvalue() != null) {
            lvalues = new ArrayList<>();
            for (langParser.LvalueContext lvalueCtx : ctx.lvalue()) {
                lvalues.add((LValue) visit(lvalueCtx));
            }
        }

        // Criar uma nova instância de FuncCallCmd com o identificador da função, a
        // lista de argumentos e as variáveis genéricas
        return new FuncCallCmd(ctx.start.getLine(), ctx.start.getCharPositionInLine(), id, exprs,
                lvalues);
    }

    @Override
    public Node visitAndExp(langParser.AndExpContext ctx) {
        // Visitar as expressões à esquerda e à direita do operador &&
        Expr left = (Expr) visit(ctx.exp(0));
        Expr right = (Expr) visit(ctx.exp(1));

        // Criar uma nova instância de AndExp com a linha e a coluna atuais
        return new And(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitCexprExp(langParser.CexprExpContext ctx) {
        // Implementação para visitCexprExp
        return super.visitCexprExp(ctx);
    }

    @Override
    public Node visitLessThanCexpr(langParser.LessThanCexprContext ctx) {
        // Visitar as expressões à esquerda e à direita do operador <
        Expr left = (Expr) visit(ctx.baexp(0));
        Expr right = (Expr) visit(ctx.baexp(1));

        // Criar uma nova instância de LessThanCexpr com a linha e a coluna atuais
        return new LessThan(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitEqualsCexpr(langParser.EqualsCexprContext ctx) {
        // Visitar a expressão à esquerda (cexpr)
        Expr left = (Expr) visit(ctx.cexpr());

        // Visitar a expressão à direita (baexp)
        Expr right = (Expr) visit(ctx.baexp());

        // Criar uma nova instância de EqualsCexpr com a linha e a coluna atuais
        return new Equals(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitNotEqualsCexpr(langParser.NotEqualsCexprContext ctx) {
        // Visitar a expressão à esquerda (cexpr)
        Expr left = (Expr) visit(ctx.cexpr());

        // Visitar a expressão à direita (baexp)
        Expr right = (Expr) visit(ctx.baexp());

        // Criar uma nova instância de NotEqualsCexpr com a linha e a coluna atuais
        return new NotEquals(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitBaexpCexpr(langParser.BaexpCexprContext ctx) {
        return super.visitBaexpCexpr(ctx);
    }

    @Override
    public Node visitAddBaexp(langParser.AddBaexpContext ctx) {

        Expr left = (Expr) visit(ctx.baexp());
        Expr right = (Expr) visit(ctx.opexp());
        System.out.println("Visitando AddBaexp´visitor " + left + " + " + right);

        return new Add(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitSubBaexp(langParser.SubBaexpContext ctx) {
        Expr left = (Expr) visit(ctx.baexp());
        Expr right = (Expr) visit(ctx.opexp());

        return new Sub(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitOpexpBaexp(langParser.OpexpBaexpContext ctx) {
        return super.visitOpexpBaexp(ctx);
    }

    @Override
    public Node visitMulOpexp(langParser.MulOpexpContext ctx) {
        Expr left = (Expr) visit(ctx.opexp());
        Expr right = (Expr) visit(ctx.dexp());

        System.out.println("Visitando MulOpexp´visitor " + left + " * " + right);

        return new Mul(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitDivOpexp(langParser.DivOpexpContext ctx) {
        Expr left = (Expr) visit(ctx.opexp());
        Expr right = (Expr) visit(ctx.dexp());

        return new Div(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitModOpexp(langParser.ModOpexpContext ctx) {
        // Visitar a expressão à esquerda (opexp)
        Expr left = (Expr) visit(ctx.opexp());

        // Visitar a expressão à direita (dexp)
        Expr right = (Expr) visit(ctx.dexp());

        // Criar uma nova instância de ModOpexp com a linha e a coluna atuais
        return new Mod(ctx.start.getLine(), ctx.start.getCharPositionInLine(), left, right);
    }

    @Override
    public Node visitDexpOpexp(langParser.DexpOpexpContext ctx) {
        // Implementação para visitDexpOpexp
        return super.visitDexpOpexp(ctx);
    }

    @Override
    public Node visitNotDexp(langParser.NotDexpContext ctx) {
        // Visitar a expressão que está sendo negada
        Expr expr = (Expr) visit(ctx.dexp());

        // Criar uma nova instância de NotDexp com a linha e a coluna atuais
        return new Not(ctx.start.getLine(), ctx.start.getCharPositionInLine(), expr);
    }

    @Override
    public Node visitNegDexp(langParser.NegDexpContext ctx) {
        // Obtém a expressão que está sendo negada
        Expr expr = (Expr) visit(ctx.dexp()); // Aqui você deve chamar o método visit() adequado para obter o nó da
                                              // expressão

        // Cria uma instância de NegDexp usando a expressão e as informações de linha e
        // coluna
        return new Neg(ctx.start.getLine(), ctx.start.getCharPositionInLine(), expr);
    }

    @Override
    public Node visitTrueDexp(langParser.TrueDexpContext ctx) {
        // Cria uma instância de TrueDexp usando as informações de linha e coluna
        return new True(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Node visitFalseDexp(langParser.FalseDexpContext ctx) {
        // Cria uma instância de TrueDexp usando as informações de linha e coluna
        return new False(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Node visitNullDexp(langParser.NullDexpContext ctx) {
        // Cria uma instância de TrueDexp usando as informações de linha e coluna
        return new Null(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Node visitIntDexp(langParser.IntDexpContext ctx) {
        // Obtém o valor do inteiro do contexto
        int value = Integer.parseInt(ctx.INT().getText());

        // Cria uma instância de IntDexp usando a linha e coluna do token
        return new IntDexp(ctx.start.getLine(), ctx.start.getCharPositionInLine(), value);
    }

    @Override
    public Node visitFloatDexp(langParser.FloatDexpContext ctx) {
        // Obtém o valor do float do contexto
        float value = Float.parseFloat(ctx.FLOAT().getText());

        // Cria uma instância de FloatDexp usando a linha e coluna do token
        return new FloatDexp(ctx.start.getLine(), ctx.start.getCharPositionInLine(), value);
    }

    @Override
    public Node visitCharDexp(langParser.CharDexpContext ctx) {
        // Obtém o texto do token CHAR e remove as aspas simples ao redor
        String charText = ctx.CHAR().getText();
        
        // Cria uma instância de CharDexp usando a linha e coluna do token
        return new CharDexp(ctx.start.getLine(), ctx.start.getCharPositionInLine(), charText);
    }

    @Override
    public Node visitRexpDexp(langParser.RexpDexpContext ctx) {
        // Implementação para visitRexpDexp
        return super.visitRexpDexp(ctx);
    }

    @Override
    public Node visitLvalueRexp(langParser.LvalueRexpContext ctx) {
        // Implementação para visitLvalueRexp
        return super.visitLvalueRexp(ctx);
    }

    @Override
    public Node visitParenRexp(langParser.ParenRexpContext ctx) {
        // Obtém a expressão dentro dos parênteses
        Expr expr = (Expr) visit(ctx.exp()); // A expressão dentro dos parênteses

        // Cria uma instância de ParenRexp usando a linha e coluna do token de abertura
        // dos parênteses
        return new Paren(ctx.start.getLine(), ctx.start.getCharPositionInLine(), expr);
    }

    @Override
    public Node visitNewRexp(langParser.NewRexpContext ctx) {
        // Obtendo o tipo a partir do contexto
        Type type = (Type) visit(ctx.type());

        // Verificando se há uma expressão de tamanho
        Expr expr = null;
        if (ctx.exp() != null) {
            expr = (Expr) visit(ctx.exp());
        }

        // Criando uma nova instância de NewExp
        return new NewExp(ctx.start.getLine(), ctx.start.getCharPositionInLine(), type, expr);
    }

    @Override
    public Node visitFuncCallRexp(langParser.FuncCallRexpContext ctx) {
        // Obtendo o nome da função
        String id = ctx.ID().getText();

        // Obtendo os argumentos (se houver)
        List<Expr> arguments = new ArrayList<>();
        if (ctx.exps() != null) {
            // Obtendo o contexto ExpsContext e iterando sobre as expressões
            for (ParseTree child : ctx.exps().children) {
                if (child instanceof langParser.ExpContext) {
                    langParser.ExpContext expCtx = (langParser.ExpContext) child;
                    Expr argument = (Expr) visit(expCtx);
                    arguments.add(argument);
                }
            }
        }

        // Obtendo o tamanho do array
        Expr expr = (Expr) visit(ctx.exp());

        // Criando e retornando uma nova instância de FuncCallExp
        return new FuncCall(ctx.start.getLine(), ctx.start.getCharPositionInLine(), id, arguments,
                expr);

    }

    @Override
    public Node visitIdLvalue(langParser.IdLvalueContext ctx) {
        // Obtendo o identificador do contexto
        String id = ctx.ID().getText();

        // Retornando o nó criado
        return new IdLValue(ctx.start.getLine(), ctx.start.getCharPositionInLine(), id);
    }

    @Override
    public Node visitArrayLvalue(langParser.ArrayLvalueContext ctx) {
        // Visitando o lvalue base (parte antes do [])
        LValue lValue = (LValue) visit(ctx.lvalue());

        // Visitando a expressão dentro dos colchetes (índice do array)
        Expr expr = (Expr) visit(ctx.exp());

        // Retornando o nó criado
        return new ArrayLValue(ctx.start.getLine(), ctx.start.getCharPositionInLine(), lValue, expr);
    }

    @Override
    public Node visitDotLvalue(langParser.DotLvalueContext ctx) {
        // Visitando o lvalue base (parte antes do .)
        LValue lValue = (LValue) visit(ctx.lvalue());

        // Obtendo o nome do campo (ID após o .)
        String name = ctx.ID().getText();

        // Retornando o nó criado
        return new Dot(ctx.start.getLine(), ctx.start.getCharPositionInLine(), lValue, name);
    }

    @Override
    public Node visitExpsName(langParser.ExpsNameContext ctx) {
        // Obtendo a linha e a coluna para o nó principal
        int line = ctx.start.getLine();
        int column = ctx.start.getCharPositionInLine();

        // Criando uma lista para armazenar as expressões
        List<Expr> exprList = new ArrayList<>();

        // Adicionando a primeira expressão
        exprList.add((Expr) visit(ctx.exp(0)));

        // Adicionando as expressões subsequentes
        for (int i = 1; i < ctx.exp().size(); i++) {
            exprList.add((Expr) visit(ctx.exp(i)));
        }

        // Criando uma instância de Exps com a lista de expressões
        Exprs exprs = new Exprs(line, column, exprList);

        // Retornando o nó criado
        return exprs;
    }

}
