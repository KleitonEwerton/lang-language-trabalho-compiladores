package lang.visitors;

import lang.ast.SuperNode;

public interface InterpreterAdaptor {
    public abstract SuperNode interpretFile(String path);
}
