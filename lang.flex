
 /*  Esta seção é copiada antes da declaração da classe do analisador léxico.
  *  É nesta seção que se deve incluir imports e declaração de pacotes.
  *  Neste exemplo não temos nada a incluir nesta seção.
  */
  
%%

%unicode
%line
%column
%class Lext
%function nextToken
%type Token

%{
    
    /* Código arbitrário pode ser inserido diretamente no analisador dessa forma. 
     * Aqui podemos declarar variáveis e métodos adicionais que julgarmos necessários. 
     */
    private int ntk;
    
    public int readedTokens(){
       return ntk;
    }
    private Token symbol(TOKEN_TYPE t) {
        ntk++;
        return new Token(t, yytext(), yyline+1, yycolumn+1);
        
    }
    private Token symbol(TOKEN_TYPE t, Object value) {
        ntk++;
        return new Token(t, value, yyline+1, yycolumn+1);
    }
    
    private void incTks() { ++ntk; }
    
    private int numTokens() { return ntk; }
%}

%init{
    ntk = 0; // Isto é copiado direto no construtor do lexer. 
%init}

  
/* Agora vamos definir algumas macros */
identificador = [:lowercase:] ([:letter:] | [:digit:] | "_" )*
tipo = [:uppercase:] ([:letter:] | [:digit:] | "_" )*
literal_int = [:digit:] [:digit:]* | "-"[:digit:] [:digit:]*
literal_float = [:digit:]* "." ([:digit:] [:digit:]*)
literal_caractere = \n | \t | \b | \r // verificar utilização das barras
literal_logico_true = "true"
literal_logico_false = "false"
literal_logico = {literal_logico_true} | {literal_logico_false}
literal_nulo = "null"
FimDeLinha  = \r | \n | \r\n
LineComment = "--" (.)* {FimDeLinha}
Brancos     = {FimDeLinha} | [ \t\f]
  
%state COMMENT

%%

<YYINITIAL>{
    {identificador} { return symbol(TOKEN_TYPE.ID);                                 }

    {literal_float} {return symbol(TOKEN_TYPE.FLOAT, Float.parseFloat(yytext()) );  }
    {literal_int}   { return symbol(TOKEN_TYPE.INT, Integer.parseInt(yytext()) );   }
    {Brancos}       {                                                               }
    {LineComment}   {                                                               }
    {literal_logico_true} {return symbol(TOKEN_TYPE.TRUE);                           }
    {literal_logico_true} {return symbol(TOKEN_TYPE.FALSE);                          }
    "Int" {return symbol(TOKEN_TYPE.MINT);                                           }
    "return" {return symbol(TOKEN_TYPE.RET);}
    "if" {return symbol(TOKEN_TYPE.IF);                                              }
    "="             { return symbol(TOKEN_TYPE.EQ);                                 }
    ";"             { return symbol(TOKEN_TYPE.SEMI);                               }
    "*"             { return symbol(TOKEN_TYPE.TIMES);                              }
    "/"             { return symbol(TOKEN_TYPE.DIV);                                }
    "%"             { return symbol(TOKEN_TYPE.MOD);                                }
    "+"             { return symbol(TOKEN_TYPE.PLUS);                               }
    "-"             { return symbol(TOKEN_TYPE.MINUS);                              }
    "("             { return symbol(TOKEN_TYPE.OPT);                                }
    ")"             { return symbol(TOKEN_TYPE.CPT);                                }
    "["             { return symbol(TOKEN_TYPE.OCT);                                }
    "]"             { return symbol(TOKEN_TYPE.CCT);                                }
    "{"             { return symbol(TOKEN_TYPE.OCV);                                }
    "}"             { return symbol(TOKEN_TYPE.CCV);                                }
    ">"             { return symbol(TOKEN_TYPE.BT);                                 }
    "<"             { return symbol(TOKEN_TYPE.LT);                                 }
    ":"             { return symbol(TOKEN_TYPE.DDOT);                               }
    "::"            { return symbol(TOKEN_TYPE.DDDOT);                              }
    "."             { return symbol(TOKEN_TYPE.DOT);                                }
    ","             { return symbol(TOKEN_TYPE.CMA);                                }
    "="             { return symbol(TOKEN_TYPE.EQ);                                 }
    "=="            { return symbol(TOKEN_TYPE.EQEQ);                               }
    "!="            { return symbol(TOKEN_TYPE.NEQ);                                }

}

<COMMENT>{
   "{-"     { yybegin(YYINITIAL); } 
   [^"-}"]  { /* Ignora os caracteres dentro do bloco de comentário */ }
   "-}"     { yybegin(YYINITIAL); } // Termina o bloco de comentário
}

// erros
[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }


