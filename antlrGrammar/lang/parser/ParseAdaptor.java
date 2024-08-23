package lang.parser;

import lang.ast.SuperNode;

public interface ParseAdaptor {
    public abstract SuperNode parseFile(String path);
}
