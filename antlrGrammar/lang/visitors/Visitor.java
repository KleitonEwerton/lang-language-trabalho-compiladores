package lang.visitors;

import lang.ast.*;
import lang.parser.*;
import lang.visitors.*;

public abstract class Visitor {

    public abstract void visit(Func func);

    public abstract void visit(Cmd cmd);

    public abstract void visit(Param param);

    public abstract void visit(Add add);

    public abstract void visit(Sub sub);

    public abstract void visit(Mul mul);

    public abstract void visit(Div div);

}
