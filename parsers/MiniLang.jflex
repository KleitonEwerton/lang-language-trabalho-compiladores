
 /*  Esta seção é copiada antes da declaração da classe do analisador léxico.
  *  É nesta seção que se deve incluir imports e declaração de pacotes.
  *  Neste exemplo não temos nada a incluir nesta seção.
  */
  
package parsers;

import beaver.Symbol;
import beaver.Scanner;
import java.math.BigDecimal;

%%
%public
%class MiniLangLex
%extends Scanner
%function nextToken
%type Symbol
%yylexthrow Scanner.Exception
%eofval{
	return symbol(Terminals.EOF, "end-of-file");
%eofval}
%unicode
%line
%column
%{
	private Symbol symbol(short id)
	{
		return new Symbol(id, yyline + 1, yycolumn + 1, yylength());
	}

	private Symbol symbol(short id, Object value)
	{
		return new Symbol(id, yyline + 1, yycolumn + 1, yylength(), value);
	}
%}  
  
  /* Agora vamos definir algumas macros */
  FimDeLinha  = \r|\n|\r\n
  Brancos     = {FimDeLinha} | [ \t\f]
  int         = [:digit:] [:digit:]*
  float       = {int} "." {int}
  identificador = [:lowercase:] ([:lowercase:] | [:uppercase:] | [:digit:])*
  lineCmt       = "//" .* {FimDeLinha}
  
  
%state COMMENT

%%

<YYINITIAL>{
    
    
    
    
    "false"         { return newToken(Terminals.FALSE, false ); }
    "true"          { return newToken(Terminals.TRUE, true );   }
    "<-"            { return newToken(Terminals.ATTR);          }
    "$"             { return newToken(Terminals.INST);   }
    "@"             { return newToken(Terminals.RET);    }
    "?"             { return newToken(Terminals.IF);     }
    "?["            { return newToken(Terminals.WHILE);  }
    "#"             { return newToken(Terminals.PRINT);  }
    
    "=="            { return symbol(Terminals.EQ);     }
    ";"             { return symbol(Terminals.SEMI);   }
    ","             { return symbol(Terminals.COMMA);  }
    ":"             { return symbol(Terminals.COLON);  }
    "("             { return symbol(Terminals.AP);     }
    ")"             { return symbol(Terminals.FP);     }
    "["             { return symbol(Terminals.LB);     }
    "]"             { return symbol(Terminals.RB);     }
    "{"             { return symbol(Terminals.LBRACE); }
    "}"             { return symbol(Terminals.RBRACE); }
    
    "*"             { return symbol(Terminals.MULT);   }
    "/"             { return symbol(Terminals.DIV);    }
    "%"             { return symbol(Terminals.MOD);    }
    "&"             { return symbol(Terminals.AND);    }
    "!"             { return symbol(Terminals.NOT);    }
    "+"             { return symbol(Terminals.PLUS);   }
    "-"             { return symbol(Terminals.MINUS);  }
    "<"             { return symbol(Terminals.LT);     }
    
    
    "/*"            { yybegin(COMMENT);                  }
    "Int"           { return symbol(Terminals.TYINT);  }
    "Float"         { return symbol(Terminals.TYFLOAT);  } 
    "Bool"          { return symbol(Terminals.TYBOOL);  } 

    "Data"  { return symbol(Terminals.DATA);  } 
    
    {identificador} { return symbol(Terminals.ID, yytext());   }
    {float}         { return symbol(Terminals.FLOAT, Float.parseFloat(yytext()) );  }
    {int}           { return symbol(Terminals.INT, Integer.parseInt(yytext()) );  }
    {Brancos}       { /* Não faz nada  */                }
    {lineCmt}       { /* Não faz nada  */                }

}

<COMMENT>{
   "*/"     { yybegin(YYINITIAL); } 
   [^"*/"]* {                     }
}

[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }



