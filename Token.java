
public class Token {
      public int l, c;
      public TOKEN_TYPE t;
      public String lexeme;
      public Object info;

      public Token(TOKEN_TYPE t, String lex, Object o, int l, int c) {
            this.t = t;
            this.lexeme = lex;
            this.info = o;
            this.l = l;
            this.c = c;
      }

      public Token(TOKEN_TYPE t, String lex, int l, int c) {
            this.t = t;
            this.lexeme = lex;
            this.info = null;
            this.l = l;
            this.c = c;
      }

      public Token(TOKEN_TYPE t, Object o, int l, int c) {
            this.t = t;
            this.lexeme = "";
            this.info = o;
            this.l = l;
            this.c = c;
      }

      @Override
      public String toString() {
            if (lexeme.equals("")) {
                  return info.toString();
            } else {
                  return lexeme;
            }
      }

}
