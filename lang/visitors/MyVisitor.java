
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
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public class MyVisitor extends LangBaseVisitor<Node> {

    @Override
    public Node visitFunName(FunNameContext ctx) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        // Cria uma nova função
        Func function = createFunction(ctx, line, column);

        // Processa parâmetros, se existirem
        if (ctx.params() != null) {
            Param parameters = (Param) ctx.params().accept(this);
            function.setParameters(parameters);
        }

        // Adiciona tipos de retorno
        processReturnTypes(ctx, function);

        // Adiciona comandos
        processCommands(ctx, function);

        return function;
    }

    @Override
    public Node visitParamsName(ParamsNameContext ctx) {
        return createParameters(ctx);
    }

    // Métodos auxiliares

    private Func createFunction(FunNameContext ctx, int line, int column) {
        String functionName = ctx.getChild(0).getText();
        return new Func(line, column, functionName);
    }

    private void processReturnTypes(FunNameContext ctx, Func function) {
        for (int i = 0; i < ctx.type().size() && this.shouldVisitNextChild(ctx, this.defaultResult()); i++) {
            ParseTree typeTree = ctx.type(i);
            Type returnType = (Type) this.aggregateResult(this.defaultResult(), typeTree.accept(this));
            function.addReturnTypes(returnType);
        }
    }

    private void processCommands(FunNameContext ctx, Func function) {
        for (int i = 0; i < ctx.cmd().size() && this.shouldVisitNextChild(ctx, this.defaultResult()); i++) {
            ParseTree cmdTree = ctx.cmd(i);
            Cmd command = (Cmd) this.aggregateResult(this.defaultResult(), cmdTree.accept(this));
            function.addCommand(command);
        }
    }

    private Param createParameters(ParamsNameContext ctx) {
        List<String> identifiers = new ArrayList<>();
        List<Type> typeList = new ArrayList<>();

        for (int i = 0; i < ctx.type().size(); i++) {
            identifiers.add(ctx.ID().get(i).getText());
            typeList.add((Type) ctx.type().get(i).accept(this));
        }

        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new Param(line, column, identifiers, typeList);
    }

    @Override
    public Node visitBtypeName(BtypeNameContext ctx) {
        // Delegação para o método base
        return processBtypeName(ctx);
    }

    @Override
    public Node visitTypeName(TypeNameContext ctx) {
        return createArrayType(ctx);
    }

    @Override
    public Node visitIntType(IntTypeContext ctx) {
        return createPrimitiveType(ctx, TyInt.class);
    }

    @Override
    public Node visitCharType(CharTypeContext ctx) {
        return createPrimitiveType(ctx, TyChar.class);
    }

    @Override
    public Node visitBoolType(BoolTypeContext ctx) {
        return createPrimitiveType(ctx, TyBool.class);
    }

    @Override
    public Node visitFloatType(FloatTypeContext ctx) {
        return createPrimitiveType(ctx, TyFloat.class);
    }

    @Override
    public Node visitIdType(IdTypeContext ctx) {
        return createNameType(ctx);
    }

    @Override
    public Node visitBlockCmd(BlockCmdContext ctx) {
        return createBlockCmd(ctx);
    }

    private Node processBtypeName(BtypeNameContext ctx) {
        // Processa BtypeNameContext com a lógica padrão
        return super.visitBtypeName(ctx);
    }

    private Node createArrayType(TypeNameContext ctx) {
        Type baseType = (Type) ctx.type().accept(this);
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new ArrayType(line, column, baseType);
    }

    private Node createPrimitiveType(ParserRuleContext ctx, Class<? extends Type> typeClass) {
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();

        try {
            // Cria uma instância do tipo primitivo usando reflexão
            return typeClass.getConstructor(int.class, int.class).newInstance(line, column);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create primitive type", e);
        }
    }

    private Node createNameType(IdTypeContext ctx) {
        String typeName = ctx.getChild(0).getText();
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new NameType(line, column, typeName);
    }

    private Node createBlockCmd(BlockCmdContext ctx) {
        List<Cmd> commands = new ArrayList<>();
        for (int i = 0; i < ctx.cmd().size(); i++) {
            commands.add((Cmd) ctx.cmd().get(i).accept(this));
        }
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new BlockCmd(line, column, commands);
    }

    @Override
    public Node visitIfCmd(IfCmdContext ctx) {
        return createIfNode(ctx);
    }

    @Override
    public Node visitIfElseCmd(IfElseCmdContext ctx) {
        return createIfElseNode(ctx);
    }

    @Override
    public Node visitIterateCmd(IterateCmdContext ctx) {
        return createIterateNode(ctx);
    }

    @Override
    public Node visitReadCmd(ReadCmdContext ctx) {
        return createReadNode(ctx);
    }

    @Override
    public Node visitPrintCmd(PrintCmdContext ctx) {
        return createPrintNode(ctx);
    }

    // Método auxiliar para criar um nó de If
    private Node createIfNode(IfCmdContext ctx) {
        Expr condition = extractExpression(ctx, 2);
        Cmd command = extractCommand(ctx, 4);
        return new If(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), condition, command);
    }

    // Método auxiliar para criar um nó de If-Else
    private Node createIfElseNode(IfElseCmdContext ctx) {
        Expr condition = extractExpression(ctx, 2);
        Cmd thenCommand = extractCommand(ctx, 4);
        Cmd elseCommand = extractCommand(ctx, 6);
        return new IfElse(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), condition, thenCommand,
                elseCommand);
    }

    // Método auxiliar para criar um nó de Iterate
    private Node createIterateNode(IterateCmdContext ctx) {
        Expr condition = extractExpression(ctx, 2);
        Cmd command = extractCommand(ctx, 4);
        String iteratorName = ctx.getChild(0).getText();
        return new Iterate(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), iteratorName, condition,
                command);
    }

    // Método auxiliar para criar um nó de Read
    private Node createReadNode(ReadCmdContext ctx) {
        LValue lValue = (LValue) ctx.getChild(1).accept(this);
        int line = ctx.getStart().getLine();
        int column = ctx.getStart().getCharPositionInLine();
        return new Read(line, column, lValue);
    }

    // Método auxiliar para criar um nó de Print
    private Node createPrintNode(PrintCmdContext ctx) {
        Expr expression = (Expr) ctx.exp().accept(this);
        return new Print(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), expression);
    }

    // Métodos auxiliares para extrair informações dos contextos
    private Expr extractExpression(ParserRuleContext ctx, int childIndex) {
        return (Expr) ctx.getChild(childIndex).accept(this);
    }

    private Cmd extractCommand(ParserRuleContext ctx, int childIndex) {
        return (Cmd) ctx.getChild(childIndex).accept(this);
    }

    @Override
    public Node visitReturnCmd(ReturnCmdContext ctx) {
        // Inicializa uma lista para armazenar as expressões
        List<Expr> expressions = new ArrayList<>();

        // Processa cada expressão no contexto e adiciona à lista
        for (int index = 0; index < ctx.exp().size(); index++) {
            expressions.add((Expr) ctx.exp().get(index).accept(this));
        }

        // Cria e retorna um novo objeto Return com as expressões coletadas
        return new Return(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), expressions);
    }

    @Override
    public Node visitLvalueCmd(LvalueCmdContext ctx) {
        // Processa o LValue e a expressão associados e cria um novo objeto LvalueCmd
        LValue lvalue = (LValue) ctx.lvalue().accept(this);
        Expr expression = (Expr) ctx.exp().accept(this);

        return new LvalueCmd(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), lvalue, expression);
    }

    @Override
    public Node visitFuncCallCmd(FuncCallCmdContext ctx) {
        // Cria um novo objeto FuncCall com o nome da função
        FuncCall funcCall = new FuncCall(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                ctx.getChild(0).getText());

        // Adiciona parâmetros de chamada de função se estiverem presentes
        if (ctx.exps() != null) {
            CallParam params = (CallParam) ctx.exps().accept(this);
            funcCall = new FuncCall(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                    ctx.getChild(0).getText(), params);
        }

        // Adiciona LValues associados à chamada de função
        for (int index = 0; index < ctx.lvalue().size()
                && this.shouldVisitNextChild(ctx, this.defaultResult()); index++) {
            ParseTree childTree = ctx.lvalue(index);
            funcCall.addLValue((LValue) this.aggregateResult(this.defaultResult(), childTree.accept(this)));
        }

        // Retorna o objeto FuncCall construído
        return funcCall;
    }

    //

    @Override
    public Node visitCexprExp(CexprExpContext ctx) {
        // Chama o método base para tratamento padrão
        return super.visitCexprExp(ctx);
    }

    @Override
    public Node visitAndExp(AndExpContext ctx) {
        return createBinaryOperationNode(ctx, And.class);
    }

    @Override
    public Node visitLessThanCexpr(LessThanCexprContext ctx) {
        return createBinaryOperationNode(ctx, LessThan.class);
    }

    @Override
    public Node visitEqualsCexpr(EqualsCexprContext ctx) {
        return createBinaryOperationNode(ctx, Equals.class);
    }

    @Override
    public Node visitNotEqualsCexpr(NotEqualsCexprContext ctx) {
        return createBinaryOperationNode(ctx, NotEquals.class);
    }

    @Override
    public Node visitAddBaexp(AddBaexpContext ctx) {
        return createBinaryOperationNode(ctx, Add.class);
    }

    @Override
    public Node visitSubBaexp(SubBaexpContext ctx) {
        return createBinaryOperationNode(ctx, Sub.class);
    }

    // Método auxiliar para criar um nó de operação binária
    private Node createBinaryOperationNode(ParserRuleContext ctx, Class<? extends Expr> operationClass) {
        // Obtém os operandos da expressão
        Expr leftOperand = (Expr) ctx.getChild(0).accept(this);
        Expr rightOperand = (Expr) ctx.getChild(2).accept(this);

        // Cria o nó de operação binária com base na classe fornecida
        if (operationClass == And.class) {
            return new And(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), leftOperand, rightOperand);
        } else if (operationClass == LessThan.class) {
            return new LessThan(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), leftOperand,
                    rightOperand);
        } else if (operationClass == Equals.class) {
            return new Equals(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), leftOperand,
                    rightOperand);
        } else if (operationClass == NotEquals.class) {
            return new NotEquals(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), leftOperand,
                    rightOperand);
        } else if (operationClass == Add.class) {
            return new Add(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), leftOperand, rightOperand);
        } else if (operationClass == Sub.class) {
            return new Sub(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), leftOperand, rightOperand);
        } else {
            throw new IllegalArgumentException("Unsupported operation class: " + operationClass);
        }
    }

    @Override
    public Node visitModOpexp(ModOpexpContext ctx) {
        // Avalia as expressões à esquerda e à direita da operação de módulo
        Expr leftExpression = (Expr) ctx.getChild(0).accept(this);
        Expr rightExpression = (Expr) ctx.getChild(2).accept(this);

        // Cria um novo objeto Mod para a operação de módulo
        return new Mod(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), leftExpression,
                rightExpression);
    }

    @Override
    public Node visitBaexpCexpr(BaexpCexprContext ctx) {
        // Usa o comportamento padrão da superclasse para BaexpCexpr
        return super.visitBaexpCexpr(ctx);
    }

    @Override
    public Node visitOpexpBaexp(OpexpBaexpContext ctx) {
        // Usa o comportamento padrão da superclasse para OpexpBaexp
        return super.visitOpexpBaexp(ctx);
    }

    @Override
    public Node visitDivOpexp(DivOpexpContext ctx) {
        // Processa as expressões à esquerda e à direita da operação de divisão
        Expr leftExpression = (Expr) ctx.getChild(0).accept(this);
        Expr rightExpression = (Expr) ctx.getChild(2).accept(this);

        // Cria um novo objeto Div para a operação de divisão
        return new Div(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), leftExpression,
                rightExpression);
    }

    @Override
    public Node visitDexpOpexp(DexpOpexpContext ctx) {
        // Usa o comportamento padrão da superclasse para DexpOpexp
        return super.visitDexpOpexp(ctx);
    }

    @Override
    public Node visitMulOpexp(MulOpexpContext ctx) {
        // Processa as expressões à esquerda e à direita da operação de multiplicação
        Expr leftExpression = (Expr) ctx.getChild(0).accept(this);
        Expr rightExpression = (Expr) ctx.getChild(2).accept(this);

        // Cria um novo objeto Mul para a operação de multiplicação
        return new Mul(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), leftExpression,
                rightExpression);
    }

    @Override
    public Node visitNotDexp(NotDexpContext ctx) {
        // Avalia a expressão a ser negada
        Expr innerExpression = (Expr) ctx.getChild(1).accept(this);

        // Cria um novo objeto Not para a operação de negação
        return new Not(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), innerExpression);
    }

    @Override
    public Node visitNegDexp(NegDexpContext ctx) {
        // Processa a expressão para a operação de negação
        Expr negatedExpression = (Expr) ctx.getChild(1).accept(this);
        return new Neg(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), negatedExpression);
    }

    @Override
    public Node visitTrueDexp(TrueDexpContext ctx) {
        // Cria um objeto BoolDexp representando o valor booleano 'true'
        boolean trueValue = Boolean.parseBoolean(ctx.getChild(0).getText());
        return new BoolDexp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), trueValue);
    }

    @Override
    public Node visitFalseDexp(FalseDexpContext ctx) {
        // Cria um objeto BoolDexp representando o valor booleano 'false'
        boolean falseValue = Boolean.parseBoolean(ctx.getChild(0).getText());
        return new BoolDexp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), falseValue);
    }

    @Override
    public Node visitDotLvalue(DotLvalueContext ctx) {
        // Processa o valor da expressão LValue associada e os dados necessários para o
        // objeto Dot
        LValue lvalueInstance = (LValue) ctx.lvalue().accept(this);
        String attributeName = ctx.getChild(2).getText();
        String identifier = ctx.lvalue().getText();
        return new Dot(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), lvalueInstance, attributeName,
                identifier);
    }

    @Override
    public Node visitNullDexp(NullDexpContext ctx) {
        // Cria um objeto Null para representar um valor nulo
        return new Null(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Node visitIntDexp(IntDexpContext ctx) {
        // Cria um objeto IntDexp com o valor inteiro fornecido
        int integerValue = Integer.parseInt(ctx.getChild(0).getText());
        return new IntDexp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), integerValue);
    }

    @Override
    public Node visitNewRexp(NewRexpContext ctx) {
        // Verifica se o tipo é NameType
        Node typeNode = ctx.type().accept(this);

        if (typeNode instanceof NameType) {
            // Caso o contexto contenha uma expressão
            if (ctx.exp() != null) {
                Expr expression = (Expr) ctx.exp().accept(this);
                return new NewExp(
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine(),
                        expression,
                        ctx.type().getText());
            } else {
                // Cria um novo NewExp com apenas o tipo de texto
                return new NewExp(
                        ctx.getStart().getLine(),
                        ctx.getStart().getCharPositionInLine(),
                        ctx.type().getText());
            }
        }

        // Tratamento para outros tipos
        if (ctx.exp() != null) {
            Expr expression = (Expr) ctx.exp().accept(this);
            Type typeInstance = (Type) typeNode;

            return new NewExp(
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine(),
                    expression,
                    typeInstance);
        } else {
            Type typeInstance = (Type) typeNode;
            return new NewExp(
                    ctx.getStart().getLine(),
                    ctx.getStart().getCharPositionInLine(),
                    typeInstance);
        }
    }

    @Override
    public Node visitIdLvalue(IdLvalueContext ctx) {
        // Cria um novo IDLvalue usando a linha, coluna e o texto do identificador
        return new IDLvalue(
                ctx.getStart().getLine(),
                ctx.getStart().getCharPositionInLine(),
                ctx.ID().getText());
    }

    @Override
    public Node visitProgName(ProgNameContext ctx) {
        // Cria um novo objeto Prog para o programa, incluindo informações de linha e
        // coluna
        Prog program = new Prog(
                ctx.getStart().getLine(),
                ctx.getStart().getCharPositionInLine());

        // Itera sobre todas as declarações de dados presentes no contexto
        for (int i = 0; i < ctx.data().size() && shouldVisitNextChild(ctx, defaultResult()); i++) {
            ParseTree dataNode = ctx.data(i);
            Data dataResult = (Data) aggregateResult(defaultResult(), dataNode.accept(this));
            program.addData(dataResult);
        }

        // Itera sobre todas as funções presentes no contexto
        for (int j = 0; j < ctx.func().size() && shouldVisitNextChild(ctx, defaultResult()); j++) {
            ParseTree funcNode = ctx.func(j);
            Func funcResult = (Func) aggregateResult(defaultResult(), funcNode.accept(this));
            program.addFunction(funcResult);
        }

        return program;
    }

    @Override
    public Node visitFuncCallRexp(FuncCallRexpContext ctx) {

        String str = ctx.ID().getText();
        CallParam fCallPar = (CallParam) ctx.exps().accept(this);
        Expr exp = (Expr) ctx.exp().accept(this);
        return new FuncRet(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), str, fCallPar, exp);
    }

    @Override
    public Node visitArrayLvalue(ArrayLvalueContext ctx) {
        // Processa o valor da expressão do lado esquerdo (LValue) do array
        LValue leftValue = (LValue) ctx.getChild(0).accept(this);

        // Processa a expressão associada ao índice do array
        Expr indexExpression = (Expr) ctx.getChild(2).accept(this);

        // Cria um novo objeto ArrayLValue com as informações de posição e os elementos
        // processados
        return new ArrayLValue(
                ctx.getStart().getLine(),
                ctx.getStart().getCharPositionInLine(),
                leftValue,
                indexExpression);
    }

    @Override
    public Node visitDeclName(DeclNameContext ctx) {
        // Cria uma nova Decl usando informações de linha, coluna, nome e tipo
        return new Decl(
                ctx.getStart().getLine(),
                ctx.getStart().getCharPositionInLine(),
                ctx.getChild(0).getText(),
                (Type) ctx.type().accept(this));
    }

    @Override
    public Node visitDataName(DataNameContext context) {

        // Obtenha o tipo de nome a partir do contexto
        String typeName = context.NAME_TYPE().getText();
        List<Decl> declarations = new ArrayList<>();

        // Itere sobre as declarações e aceite cada uma delas
        for (int index = 0; index < context.decl().size(); index++) {
            Decl declNode = (Decl) context.decl().get(index).accept(this);
            declarations.add(declNode);
        }

        // Retorne um novo objeto Data com as informações coletadas
        return new Data(context.getStart().getLine(), context.getStart().getCharPositionInLine(), typeName,
                declarations);
    }

    @Override
    public Node visitFloatDexp(FloatDexpContext ctx) {
        // Cria um novo objeto FloatDexp com o valor de ponto flutuante extraído do
        // contexto
        float floatValue = Float.parseFloat(ctx.FLOAT().getText());
        return new FloatDexp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), floatValue);
    }

    @Override
    public Node visitCharDexp(CharDexpContext ctx) {
        // Cria um novo objeto CharDexp usando o valor de caractere fornecido no
        // contexto
        String charValue = ctx.CHAR().getText();
        return new CharDexp(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), charValue);
    }

    @Override
    public Node visitRexpDexp(RexpDexpContext ctx) {
        // Utiliza o comportamento padrão da superclasse para processar RexpDexp
        return super.visitRexpDexp(ctx);
    }

    @Override
    public Node visitLvalueRexp(LvalueRexpContext ctx) {
        // Utiliza o comportamento padrão da superclasse para processar LvalueRexp
        return super.visitLvalueRexp(ctx);
    }

    @Override
    public Node visitExpsName(ExpsNameContext ctx) {
        // Cria um novo CallParam com informações de linha e coluna
        CallParam functionCall = new CallParam(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        List<Expr> expressionList = new ArrayList<>();

        // Processa cada expressão no contexto e adiciona à lista de expressões
        for (int i = 0; i < ctx.exp().size(); i++) {
            Expr expr = (Expr) ctx.exp().get(i).accept(this);
            expressionList.add(expr);
        }

        // Define a lista de expressões processadas no objeto functionCall
        functionCall.setExps(expressionList);
        return functionCall;
    }

    @Override
    public Node visitParenRexp(ParenRexpContext ctx) {
        // Retorna a expressão contida dentro dos parênteses
        return (Expr) ctx.getChild(1).accept(this);
    }
}
