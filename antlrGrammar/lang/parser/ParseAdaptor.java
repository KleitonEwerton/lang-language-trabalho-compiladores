package antlrGrammar.lang.parser;

import antlrGrammar.lang.ast.SuperNode;

public interface ParseAdaptor {
    public abstract SuperNode parseFile(String path);
}
