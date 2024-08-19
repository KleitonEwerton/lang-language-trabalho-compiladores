package ast;

import java.util.Map;

public abstract class Node {

      private int line, col;

      public Node(int l, int c) {
            line = l;
            col = c;
      }

      public int getLine() {
            return line;
      }

      public int getCol() {
            return col;
      }

      public abstract int interpret(Map<String, Integer> m);

}
