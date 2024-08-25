package lang.visitors;

import lang.ast.*;
import lang.parser.*;
import lang.visitors.*;

public abstract class Visitor {

    public abstract void visit(Add add);
    
    public abstract void visit(And and);

    public abstract void visit(ArrayType arrayType);

    public abstract void visit(BinOP binOP);

    public abstract void visit(BlockCmd blockCmd);

    public abstract void visit(CharDexp charDexp);

    public abstract void visit(Cmd cmd);

    public abstract void visit(Div div);

    public abstract void visit(Equals equals);

    public abstract void visit(Expr expr);

    public abstract void visit(False false1);

    public abstract void visit(FloatDexp floatDexp);

    public abstract void visit(Func func);

    public abstract void visit(FuncCallCmd funcCallCmd);

    public abstract void visit(IdType idType);

    public abstract void visit(If if1);

    public abstract void visit(IfElse ifElse);

    public abstract void visit(IntDexp intDexp);

    public abstract void visit(Iterate iterate);

    public abstract void visit(LessThan lessThan);

    public abstract void visit(LValue lValue);

    public abstract void visit(LvalueCmd lvalueCmd);

    public abstract void visit(Mod mod);

    public abstract void visit(Mul mul);

    public abstract void visit(NameType nameType);

    public abstract void visit(Neg neg);

    public abstract void visit(Not not);

    public abstract void visit(NotEquals notEquals);

    public abstract void visit(Null null1);

    public abstract void visit(Param param);

    public abstract void visit(Paren paren);

    public abstract void visit(Print print);

    public abstract void visit(Read read);

    public abstract void visit(Return return1);

    public abstract void visit(Sub sub);

    public abstract void visit(True true1);

    public abstract void visit(TyBool tyBool);

    public abstract void visit(TyChar tyChar);

    public abstract void visit(TyFloat tyFloat);

    public abstract void visit(TyInt tyInt);

    public abstract void visit(Type type);    

}
