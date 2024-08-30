
package lang.visitors;

import java.io.*;
import lang.ast.SuperNode;
import lang.parser.*;
import java.util.List;

// Adaptador para classe de interpretador. a Função parseFile deve retornar null caso o parser resulte em erro. 

public interface InterpreterAdaptor {
   public abstract SuperNode interpretFile(String path);
}
