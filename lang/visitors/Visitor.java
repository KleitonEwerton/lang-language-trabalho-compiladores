package lang.visitors;

import lang.ast.*;

public abstract class Visitor {

    public abstract void visit(Add a);

    public abstract void visit(And a);

    public abstract void visit(ArrayLValue a);

    public abstract void visit(ArrayType t);

    public abstract void visit(LvalueCmd a);

    public abstract void visit(BoolDexp b);

    public abstract void visit(CallParam f);

    public abstract void visit(CharDexp c);

    public abstract void visit(Cmd c);

    public abstract void visit(BlockCmd c);

    public abstract void visit(Data d);

    public abstract void visit(Decl d);

    public abstract void visit(Div d);

    public abstract void visit(Dot d);

    public abstract void visit(Equals e);

    public abstract void visit(ExpP e);

    public abstract void visit(FloatDexp p);

    public abstract void visit(FunctionCall f);

    public abstract void visit(FuncRet f);

    public abstract void visit(Func f);

    public abstract void visit(ID i);

    public abstract void visit(IDLvalue i);

    public abstract void visit(If i);

    public abstract void visit(IfElse i);

    public abstract void visit(IntDexp i);

    public abstract void visit(Iterate i);

    public abstract void visit(LessThan l);

    public abstract void visit(LValue l);

    public abstract void visit(Neg n);

    public abstract void visit(Mod m);

    public abstract void visit(Mul m);

    public abstract void visit(NameType i);

    public abstract void visit(NewExp t);

    public abstract void visit(Not n);

    public abstract void visit(NotEquals n);

    public abstract void visit(Null n);

    public abstract void visit(Param p);

    public abstract void visit(Print i);

    public abstract void visit(Prog p);

    public abstract void visit(Read r);

    public abstract void visit(Return r);

    public abstract void visit(Sub s);

    public abstract void visit(Type t);

    public abstract void visit(TyBool t);

    public abstract void visit(TyChar t);

    public abstract void visit(TyFloat t);

    public abstract void visit(TyInt t);
}
